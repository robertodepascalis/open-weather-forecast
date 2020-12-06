package it.faire.ai.weather.openweatherforecast;

import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import it.faire.ai.weather.openweatherforecast.util.LocalDateUtils;
import org.junit.jupiter.api.Test;

/**
 * Epoch timestamp: 1607199140
 * Timestamp in milliseconds: 1607199140000
 * Date and time (GMT): Saturday, 5 December 2020 20:12:20
 * Date and time (your time zone): Saturday, 5 December 2020 21:12:20 GMT+01:00
 */
public class DateTest {

    @Test
    void test_isSameDay() {
        assertFalse(LocalDateUtils.isSameDay(LocalDate.now(), 1607199140l, "Europe/Rome"));
        assertTrue(LocalDateUtils.isSameDay(LocalDate.now(), LocalDate.now().atStartOfDay(ZoneId.of("Europe/Rome")).toEpochSecond(), "Europe/Rome"));
    }

    @Test
    void test_isHourInRange() {
        assertFalse(LocalDateUtils.isHourInRange(9,18,1607199140l, "Europe/Rome"));
        assertFalse(LocalDateUtils.isHourInRange(19,20,1607199140l, "Europe/Rome"));
        assertTrue(LocalDateUtils.isHourInRange(21,22,1607199140l, "Europe/Rome"));
    }
}
