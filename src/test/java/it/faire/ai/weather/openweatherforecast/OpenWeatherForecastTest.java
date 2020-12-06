package it.faire.ai.weather.openweatherforecast;

import static it.faire.ai.weather.openweatherforecast.util.LocalDateUtils.isHourInRange;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import it.faire.ai.weather.openweatherforecast.beans.forecast.custom.Day;
import it.faire.ai.weather.openweatherforecast.beans.forecast.custom.DaysWithHoursRangeAvgMaxMinTempHum;
import it.faire.ai.weather.openweatherforecast.beans.forecast.custom.In_range;
import it.faire.ai.weather.openweatherforecast.beans.forecast.custom.Out_range;
import it.faire.ai.weather.openweatherforecast.beans.forecast.openweather.Forecast;
import it.faire.ai.weather.openweatherforecast.beans.response.OpenWeatherResponseBuilder;
import it.faire.ai.weather.openweatherforecast.service.ForecastError;
import it.faire.ai.weather.openweatherforecast.service.OpenWeatherForecastService;
import it.faire.ai.weather.openweatherforecast.service.OpenWeatherClient;


@SpringBootTest
public class OpenWeatherForecastTest {

    @MockBean
    private OpenWeatherClient openWeatherServiceClient;

    @Autowired
    private OpenWeatherForecastService openWeatherForecastService;

    @Test
    public void test() throws IOException, ForecastError {

        final String city = "Lecce";

        final InputStream resource = getClass().getClassLoader().getResourceAsStream("sample_forecast.json");
        ObjectMapper mapper = new ObjectMapper();
        Forecast forecast = mapper.readValue(resource, Forecast.class);
        OpenWeatherResponseBuilder openWeatherResponseBuilder = new OpenWeatherResponseBuilder();

        Mockito.when(openWeatherServiceClient.getForecast(city)).thenReturn(openWeatherResponseBuilder.withForecast(forecast).build());

        DaysWithHoursRangeAvgMaxMinTempHum daysWithHoursRangeAvgMaxMinTempHum = openWeatherForecastService.getAverageMeasuresForWorkingHours(
                city,
                9,
                18,
                LocalDateTime.ofInstant(Instant.ofEpochSecond(1607151600), ZoneId.of("Europe/Rome")));
        assertEquals(city, daysWithHoursRangeAvgMaxMinTempHum.getCity());
        assertEquals(40.36, daysWithHoursRangeAvgMaxMinTempHum.getLat());
        assertEquals(18.17, daysWithHoursRangeAvgMaxMinTempHum.getLon());
        assertEquals("Europe/Rome", daysWithHoursRangeAvgMaxMinTempHum.getTimezone());
        assertEquals(3600, daysWithHoursRangeAvgMaxMinTempHum.getTimezone_offset());

        List<Long> listOfHourlyForecasts = forecast.getHourly().stream().map(h -> h.getDt()).collect(Collectors.toList());
        List<Long> inRange = forecast.getHourly().stream().filter(h -> isHourInRange(9, 18, h.getDt(), forecast.getTimezone())).map(h -> h.getDt()).collect(Collectors.toList());
        List<Long> outRange = forecast.getHourly().stream().filter(h -> ! isHourInRange(9, 18, h.getDt(), forecast.getTimezone())).map(h -> h.getDt()).collect(Collectors.toList());

        assertEquals(listOfHourlyForecasts.size(), inRange.size() + outRange.size());

        for( Long dt: inRange) {
            final LocalDateTime hourOfForecast = Instant.ofEpochSecond(dt).atZone(ZoneId.of(forecast.getTimezone())).toLocalDateTime();
            System.out.println(hourOfForecast.format(DateTimeFormatter.ISO_DATE_TIME));
            assertTrue(9 <= hourOfForecast.getHour() && hourOfForecast.getHour() <= 18);
        }

        for( Long dt: outRange) {
            final LocalDateTime hourOfForecast = Instant.ofEpochSecond(dt).atZone(ZoneId.of(forecast.getTimezone())).toLocalDateTime();
            System.out.println(hourOfForecast.format(DateTimeFormatter.ISO_DATE_TIME));
            assertTrue(hourOfForecast.getHour() < 9 || hourOfForecast.getHour() > 18);
        }

        int hoursInRange = 0;
        int hoursOutRange = 0;
        List<Long> hoursInRangeList = new ArrayList<>();
        List<Long> hoursOutRangeList = new ArrayList<>();

        List<Day> days = daysWithHoursRangeAvgMaxMinTempHum.getDays();
        assertEquals(4, days.size());

        for (Day day: days) {
            In_range in_range = day.getIn_range();

            hoursInRange += in_range.getHours_in_range().length;
            hoursInRangeList.addAll(Arrays.asList(in_range.getHours_in_range()));

            for( Long dt: in_range.getHours_in_range()) {
                final LocalDateTime hourOfForecast = Instant.ofEpochSecond(dt).atZone(ZoneId.of(forecast.getTimezone())).toLocalDateTime();
                System.out.println(hourOfForecast.format(DateTimeFormatter.ISO_DATE_TIME));
                assertTrue(9 <= hourOfForecast.getHour() && hourOfForecast.getHour() <= 18);
            }


            /* TO DO: test the values */

//            assertEquals(4, in_range.getAvg_temp());
//            assertEquals(4, in_range.getMax_temp());
//            assertEquals(4, in_range.getMin_temp());
//            assertEquals(4, in_range.getAvg_hum());
//            assertEquals(4, in_range.getMax_hum());
//            assertEquals(4, in_range.getMin_hum());

            Out_range out_range = day.getOut_range();

            hoursOutRange += out_range.getHours_out_range().length;
            hoursOutRangeList.addAll(Arrays.asList(out_range.getHours_out_range()));

            for( Long dt: out_range.getHours_out_range()) {
                final LocalDateTime hourOfForecast = Instant.ofEpochSecond(dt).atZone(ZoneId.of(forecast.getTimezone())).toLocalDateTime();
                assertTrue(hourOfForecast.getHour() < 9 || hourOfForecast.getHour() > 18);
            }

            /* TO DO: test the values */

//            assertEquals(4, out_range.getAvg_temp());
//            assertEquals(4, out_range.getMax_temp());
//            assertEquals(4, out_range.getMin_temp());
//            assertEquals(4, out_range.getAvg_hum());
//            assertEquals(4, out_range.getMax_hum());
//            assertEquals(4, out_range.getMin_hum());
        }

        assertEquals(inRange.size(), hoursInRange);
        assertEquals(outRange.size(), hoursOutRange);
        assertTrue(inRange.containsAll(hoursInRangeList));
        assertTrue(outRange.containsAll(hoursOutRangeList));
    }

}
