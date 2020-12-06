package it.faire.ai.weather.openweatherforecast.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 *
 * @author Roberto De Pascalis
 */
public class LocalDateUtils {

    public static boolean isSameDay(LocalDate date, Long epochUTC, String zoneId) {
        final LocalDate dayOfForecast = Instant.ofEpochSecond(epochUTC).atZone(ZoneId.of(zoneId)).toLocalDate();
        return dayOfForecast.getDayOfMonth() == date.getDayOfMonth();
    }

    public static boolean isHourInRange(Integer startOfDay, Integer endOfDay, Long epochUTC, String zoneId) {
        final LocalDateTime hourOfForecast = Instant.ofEpochSecond(epochUTC).atZone(ZoneId.of(zoneId)).toLocalDateTime();
        final LocalDateTime startHourOfDay = Instant.ofEpochSecond(epochUTC).atZone(ZoneId.of(zoneId)).toLocalDate().atTime(startOfDay, 0);
        final LocalDateTime endHourOfDay = Instant.ofEpochSecond(epochUTC).atZone(ZoneId.of(zoneId)).toLocalDate().atTime(endOfDay, 0);
        return startHourOfDay.getHour() <= hourOfForecast.getHour() && hourOfForecast.getHour() <= endHourOfDay.getHour();
    }
}
