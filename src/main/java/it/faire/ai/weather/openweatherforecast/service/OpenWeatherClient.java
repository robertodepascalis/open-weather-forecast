package it.faire.ai.weather.openweatherforecast.service;

import static org.apache.commons.lang3.Validate.notNull;
import it.faire.ai.weather.openweatherforecast.util.OpenWeatherApiUrlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import it.faire.ai.weather.openweatherforecast.beans.cities.Coord;
import it.faire.ai.weather.openweatherforecast.beans.forecast.openweather.Forecast;
import it.faire.ai.weather.openweatherforecast.beans.response.OpenWeatherResponseBuilder;
import it.faire.ai.weather.openweatherforecast.beans.response.OpenWeatherResponse;


/**
 * Open Weather API rest client.
 *
 * @author Roberto De Pascalis
 */
@Service
public class OpenWeatherClient {

    private final RestTemplate restTemplate;
    private final CitiesInfoHolder citiesInfoHolder;
    private final OpenWeatherApiUrlBuilder openWeatherApiUrlBuilder;

    @Autowired
    OpenWeatherClient(RestTemplate restTemplate, CitiesInfoHolder citiesInfoHolder, OpenWeatherApiUrlBuilder openWeatherApiUrlBuilder) {
        this.restTemplate = restTemplate;
        this.citiesInfoHolder = citiesInfoHolder;
        this.openWeatherApiUrlBuilder = openWeatherApiUrlBuilder;
    }

    public OpenWeatherResponse getForecast(String city) {
        notNull(city);
        final OpenWeatherResponseBuilder responseBuilder = new OpenWeatherResponseBuilder();
        final Coord coordinates;
        final String url;
        try {
            coordinates = citiesInfoHolder.getCoordinates(city);
        } catch (Exception | CityNotFoundException e) {
            responseBuilder.withError("City retrieval error: " + e.getMessage());
            responseBuilder.withThrowable(e);
            return responseBuilder.build();
        }

        ResponseEntity<Forecast> responseEntity = null;
        try {
            url = openWeatherApiUrlBuilder.build(coordinates.getLat().toString(), coordinates.getLon().toString());
            responseEntity = restTemplate.getForEntity(url, Forecast.class);
        } catch (RestClientException e) {
            responseBuilder.withError("Service unavailable or faulty url");
            responseBuilder.withThrowable(e);
            return responseBuilder.build();
        }

        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            responseBuilder.withForecast(responseEntity.getBody());
        }
        else {
            responseBuilder.withError("Service status is: " + responseEntity.getStatusCodeValue());
        }
        return responseBuilder.build();
    }

}
