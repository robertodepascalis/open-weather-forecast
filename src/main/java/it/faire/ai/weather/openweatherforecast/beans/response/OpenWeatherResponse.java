package it.faire.ai.weather.openweatherforecast.beans.response;

import it.faire.ai.weather.openweatherforecast.beans.forecast.openweather.Forecast;

public class OpenWeatherResponse {

    private Forecast forecast;
    private String errorMessage;
    private Throwable throwable;

    public boolean isResponseValid() {
        return (errorMessage == null && throwable == null) && forecast != null;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
