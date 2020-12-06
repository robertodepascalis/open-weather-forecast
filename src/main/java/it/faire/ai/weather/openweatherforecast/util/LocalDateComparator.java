package it.faire.ai.weather.openweatherforecast.util;

import java.time.LocalDate;
import java.util.Comparator;

/**
 *
 * @author Roberto De Pascalis
 */
public class LocalDateComparator implements Comparator<LocalDate> {

    @Override
    public int compare(LocalDate o1, LocalDate o2) {
        return o1.compareTo(o2);
    }
}

