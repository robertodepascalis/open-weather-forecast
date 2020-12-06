package it.faire.ai.weather.openweatherforecast;

import static  it.faire.ai.weather.openweatherforecast.util.FilterUtils.startWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FilterTest {

    @Test
    void filter() {
        String[] list = startWith(new String[]{"Bab","Baba","Caba", "xBaba"}, "ba");

        assertEquals(list[0], "Bab");
        assertEquals(list[1], "Baba");
        assertEquals(list.length, 2);

    }
}
