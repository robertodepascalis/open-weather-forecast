package it.faire.ai.weather.openweatherforecast.service;

/**
 * The exception raised when the city is not found.
 *
 * @author Roberto De Pascalis
 */
public class CityNotFoundException extends Throwable {

    public CityNotFoundException(String message) {
        super(message);
    }
}
