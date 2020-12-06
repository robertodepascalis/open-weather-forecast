package it.faire.ai.weather.openweatherforecast.service;

/**
 * The exception raised for any error during the forecast calculation.
 *
 * @author Roberto De Pascalis
 */
public class ForecastError extends Throwable{

    public ForecastError(String message) {
        super(message);
    }

    public ForecastError(Throwable cause) {
        super(cause);
    }
}
