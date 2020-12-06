package it.faire.ai.weather.openweatherforecast.util;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Roberto De Pascalis
 */
public class FilterUtils {

    public static String[] startWith(String[] list, String q) {
        return Arrays.asList(list).stream().filter(c -> c.toLowerCase().startsWith(q.toLowerCase())).toArray(String[]::new);
    }
    public static String[] startWith(List<String> list, String q) {
        return list.stream().filter(c -> c.toLowerCase().startsWith(q.toLowerCase())).toArray(String[]::new);
    }

}
