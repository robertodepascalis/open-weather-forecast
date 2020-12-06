package it.faire.ai.weather.openweatherforecast;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import it.faire.ai.weather.openweatherforecast.beans.cities.Coord;
import it.faire.ai.weather.openweatherforecast.service.CitiesInfoHolder;
import it.faire.ai.weather.openweatherforecast.service.CityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CitiesInfoHolderTests {

    @Autowired
    private CitiesInfoHolder citiesInfoHolder;

    @Test
    void citiesInfoHolder_shouldRetrieveCitiesCorrectly() {
        List<String> cities = Arrays.asList(new String[]{"San Donato di Lecce", "San Donà di Piave", "San Donaci"});
        assertEquals(citiesInfoHolder.getCityNames().size(), 3);
        assertTrue(cities.containsAll(citiesInfoHolder.getCityNames()));
    }

    @Test
    void citiesInfoHolder_shouldRetrieveCoordinatesCorrectly() throws CityNotFoundException {
        Coord coord = citiesInfoHolder.getCoordinates("San Donà di Piave");
        assertEquals(coord.getLat(), 45.631672);
        assertEquals(coord.getLon(), 12.56944);
    }

    @Test
    void citiesInfoHolder_shouldFail_whenCityNotFound() {
        assertThrows(CityNotFoundException.class, () -> {
            citiesInfoHolder.getCoordinates("S");
        });
    }
}
