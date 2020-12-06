package it.faire.ai.weather.openweatherforecast.service;

import static org.apache.commons.lang3.Validate.notNull;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import it.faire.ai.weather.openweatherforecast.beans.cities.City;
import it.faire.ai.weather.openweatherforecast.beans.cities.Coord;

/**
 * The present class builds an index of cities. To be used for autocomplete into the front end.
 * Any city carries the information on the state and the country: city name [state=] [country=]
 *
 * @author Roberto De Pascalis
 */
@Service
public class CitiesInfoHolder {

    private City[] cities;
    private List<String> cityNames;

    @PostConstruct
    private void init() throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final InputStream resource = getClass().getClassLoader().getResourceAsStream("city.list.json");
        cities = mapper.readValue(resource, City[].class);
        cityNames = Arrays.stream(cities).map(city -> city.getName() + " [state=" + city.getState() + "] [country=" + city.getCountry()  + "]").collect(Collectors.toList());
    }

    public Coord getCoordinates(String cityName) throws CityNotFoundException {
        notNull(cityName);
        String substringOfCityInfo = cityName.substring(0, cityName.indexOf(" ["));
        final City cityInfo = Arrays.stream(cities).filter(city -> city.getName().equals(substringOfCityInfo)).findFirst().orElse(null);
        if (cityInfo != null ) {
            return cityInfo.getCoord();
        }
        throw new CityNotFoundException("City " + cityName + " not found!");
    }

    public List<String> getCityNames() {
        return cityNames;
    }

}
