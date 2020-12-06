package it.faire.ai.weather.openweatherforecast.util;

import static it.faire.ai.weather.openweatherforecast.util.ApplicationConstants.HOURS_PATTERN;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Pattern;

/**
 *
 * @author Roberto De Pascalis
 */
public class NumberUtils {

    public static Double scale(Double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public static boolean isValidNumber(String strNum) {
        final Pattern pattern = Pattern.compile(HOURS_PATTERN);

        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
