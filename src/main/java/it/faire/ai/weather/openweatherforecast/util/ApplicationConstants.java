package it.faire.ai.weather.openweatherforecast.util;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Roberto De Pascalis
 */
public final class ApplicationConstants {

    public final static String HOURS_PATTERN = "([01]?[0-9]|2[0-3])";

    public final static DateTimeFormatter ISO_DATE_FORMATTER = DateTimeFormatter.ISO_DATE;
    public final static DateTimeFormatter ISO_TIME_FORMATTER = DateTimeFormatter.ISO_TIME;

}
