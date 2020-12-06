package it.faire.ai.weather.openweatherforecast;

import static it.faire.ai.weather.openweatherforecast.util.ApplicationConstants.HOURS_PATTERN;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;


public class PatternTest {

    @Test
    void pattern() {
        Pattern pattern = Pattern.compile(HOURS_PATTERN);

        assertTrue(pattern.matcher("00").matches());
        assertTrue(pattern.matcher("22").matches());
        assertTrue(pattern.matcher("23").matches());

        assertFalse(pattern.matcher("24").matches());

    }
}
