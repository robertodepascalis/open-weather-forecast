package it.faire.ai.weather.openweatherforecast.service;

import static it.faire.ai.weather.openweatherforecast.util.LocalDateUtils.isHourInRange;
import static it.faire.ai.weather.openweatherforecast.util.LocalDateUtils.isSameDay;
import static it.faire.ai.weather.openweatherforecast.util.NumberUtils.scale;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.faire.ai.weather.openweatherforecast.beans.forecast.custom.Day;
import it.faire.ai.weather.openweatherforecast.beans.forecast.custom.DaysWithHoursRangeAvgMaxMinTempHum;
import it.faire.ai.weather.openweatherforecast.beans.forecast.custom.ForecastType;
import it.faire.ai.weather.openweatherforecast.beans.forecast.custom.In_range;
import it.faire.ai.weather.openweatherforecast.beans.forecast.custom.Out_range;
import it.faire.ai.weather.openweatherforecast.beans.forecast.openweather.Forecast;
import it.faire.ai.weather.openweatherforecast.beans.forecast.openweather.Hourly;
import it.faire.ai.weather.openweatherforecast.beans.response.OpenWeatherResponse;
import it.faire.ai.weather.openweatherforecast.util.ApplicationConstants;
import it.faire.ai.weather.openweatherforecast.util.LocalDateComparator;

/**
 * This is the business class where the measures are aggregated.
 *
 * @author Roberto De Pascalis
 */
@Service
public class OpenWeatherForecastService {

    private final OpenWeatherClient openWeatherServiceClient;
    private final CitiesInfoHolder citiesInfoHolder;


    @Autowired
    public OpenWeatherForecastService(OpenWeatherClient openWeatherServiceClient, CitiesInfoHolder citiesInfoHolder) {
        this.openWeatherServiceClient = openWeatherServiceClient;
        this.citiesInfoHolder = citiesInfoHolder;

    }

    /**
     * This method returns the forecast of three days from today.
     *
     * @param city
     * @param startOfDay
     * @param endOfDay
     * @return
     * @throws ForecastError
     */
    public DaysWithHoursRangeAvgMaxMinTempHum getAverageMeasuresForWorkingHours(String city, Integer startOfDay, Integer endOfDay, LocalDateTime now) throws ForecastError {

        try {
            OpenWeatherResponse openWeatherResponse = openWeatherServiceClient.getForecast(city);
            if (openWeatherResponse.isResponseValid()) {
                LocalDate currentDate = now.toLocalDate();
                Forecast forecast = openWeatherResponse.getForecast();
                List<Day> days = new ArrayList<>();
                SortedMap<LocalDate, List<Hourly>> dayMap = new TreeMap<>(new LocalDateComparator());
                for (int i = 0; i < 4; i++) {
                    LocalDate finalCurrentDate = currentDate.plusDays(i);
                    dayMap.put(
                            finalCurrentDate,
                            forecast.getHourly().stream().filter(
                                    h -> isSameDay(finalCurrentDate, h.getDt(), forecast.getTimezone())
                            ).collect(Collectors.toList())
                    );
                }
                Day day;
                In_range in_range;
                Out_range out_range;
                LocalDateTime startHourOfDay = now.atZone(ZoneId.of(forecast.getTimezone())).toLocalDate().atTime(startOfDay, 0);
                LocalDateTime endHourOfDay = now.atZone(ZoneId.of(forecast.getTimezone())).toLocalDate().atTime(endOfDay, 0);
                for (Map.Entry<LocalDate, List<Hourly>> item: dayMap.entrySet()) {
                    List<Hourly> inRange = item.getValue().stream().filter(h -> isHourInRange(startOfDay, endOfDay, h.getDt(), forecast.getTimezone())).collect(Collectors.toList());
                    List<Hourly> outRange = item.getValue().stream().filter(h -> ! isHourInRange(startOfDay, endOfDay, h.getDt(), forecast.getTimezone())).collect(Collectors.toList());

                    day = new Day();

                    day.withFormatted_day(item.getKey().format(ApplicationConstants.ISO_DATE_FORMATTER));

                    in_range = new In_range();
                    in_range.withFormatted_from(startHourOfDay.format(ApplicationConstants.ISO_TIME_FORMATTER));
                    in_range.withFormatted_to(endHourOfDay.format(ApplicationConstants.ISO_TIME_FORMATTER));
                    in_range.withHours_in_range(inRange.stream().map(h -> h.getDt()).toArray(Long[]::new));
                    in_range.setMax_temp(scale(inRange.stream().mapToDouble(h -> h.getTemp()).max().orElse(0d)));
                    in_range.setAvg_temp(scale(inRange.stream().mapToDouble(h -> h.getTemp()).average().orElse(0d)));
                    in_range.setMin_temp(scale(inRange.stream().mapToDouble(h -> h.getTemp()).min().orElse(0d)));
                    in_range.setMax_hum(scale(inRange.stream().mapToDouble(h -> h.getHumidity()).max().orElse(0d)));
                    in_range.setAvg_hum(scale(inRange.stream().mapToDouble(h -> h.getHumidity()).average().orElse(0d)));
                    in_range.setMin_hum(scale(inRange.stream().mapToDouble(h -> h.getHumidity()).min().orElse(0d)));
                    day.withIn_range(in_range);

                    out_range = new Out_range();
                    out_range.withFormatted_from(endHourOfDay.format(ApplicationConstants.ISO_TIME_FORMATTER));
                    out_range.withFormatted_to(startHourOfDay.format(ApplicationConstants.ISO_TIME_FORMATTER));
                    out_range.withHours_out_range(outRange.stream().map(h -> h.getDt()).toArray(Long[]::new));
                    out_range.setMax_temp(scale(outRange.stream().mapToDouble(h -> h.getTemp()).max().orElse(0d)));
                    out_range.setAvg_temp(scale(outRange.stream().mapToDouble(h -> h.getTemp()).average().orElse(0d)));
                    out_range.setMin_temp(scale(outRange.stream().mapToDouble(h -> h.getTemp()).min().orElse(0d)));
                    out_range.setMax_hum(scale(outRange.stream().mapToDouble(h -> h.getHumidity()).max().orElse(0d)));
                    out_range.setAvg_hum(scale(outRange.stream().mapToDouble(h -> h.getHumidity()).average().orElse(0d)));
                    out_range.setMin_hum(scale(outRange.stream().mapToDouble(h -> h.getHumidity()).min().orElse(0d)));
                    day.withOut_range(out_range);

                    days.add(day);
                }

                DaysWithHoursRangeAvgMaxMinTempHum daysWithHoursRangeAvgMaxMinTempHum = new DaysWithHoursRangeAvgMaxMinTempHum();
                daysWithHoursRangeAvgMaxMinTempHum.withCity(city);
                daysWithHoursRangeAvgMaxMinTempHum.withLat(forecast.getLat());
                daysWithHoursRangeAvgMaxMinTempHum.withLon(forecast.getLon());
                daysWithHoursRangeAvgMaxMinTempHum.withTimezone_offset(forecast.getTimezone_offset());
                daysWithHoursRangeAvgMaxMinTempHum.withTimezone(forecast.getTimezone());
                daysWithHoursRangeAvgMaxMinTempHum.withForecast_type(ForecastType.days_with_hours_range_avg_max_min_temp_hum.name());
                daysWithHoursRangeAvgMaxMinTempHum.withDays(days);

                return daysWithHoursRangeAvgMaxMinTempHum;
            }
            throw new ForecastError(openWeatherResponse.getErrorMessage());
        } catch (Exception e) {
            throw new ForecastError(e);
        }
    }

}
