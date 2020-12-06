package it.faire.ai.weather.openweatherforecast.beans.response;

import it.faire.ai.weather.openweatherforecast.beans.forecast.openweather.Forecast;

/**
 *
 * @author Roberto De Pascalis
 */
public class OpenWeatherResponseBuilder {

    private String errorMessage;
    private Forecast forecast;
    private Throwable throwable;

    public OpenWeatherResponseBuilder withError(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public OpenWeatherResponseBuilder withForecast(Forecast forecast) {
        this.forecast = forecast;
        return this;
    }

    public OpenWeatherResponseBuilder withThrowable(Throwable throwable) {
        this.throwable = throwable;
        return this;
    }

    public OpenWeatherResponse build() {
        OpenWeatherResponse response = new OpenWeatherResponse();
        response.setErrorMessage(this.errorMessage);
        response.setForecast(this.forecast);
        response.setThrowable(this.throwable);
        return response;
    }
}
