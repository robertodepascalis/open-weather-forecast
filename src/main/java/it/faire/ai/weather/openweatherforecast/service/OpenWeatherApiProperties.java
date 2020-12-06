package it.faire.ai.weather.openweatherforecast.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Open Weather API property holder.
 *
 * @author Roberto De Pascalis
 */
@Service
public class OpenWeatherApiProperties {

    // Fields

    @Value("${open.weather.api.resource}")
    private String openWeatherApiResource;

    @Value("${open.weather.api.resource.appid.parameter}")
    private String appIdParameter;

    @Value("${open.weather.api.resource.coordinates.parameters}")
    private String coordinatesParameters;

    @Value("${open.weather.api.resource.parameter.for.daily.forecast}")
    private String parameterForDailyForecast;

    @Value("${open.weather.api.resource.parameter.for.units}")
    private String parameterForUnits;


    // Methods


    public String getOpenWeatherApiResource() {
        return openWeatherApiResource;
    }

    public String getAppIdParameter() {
        return appIdParameter;
    }

    public String getCoordinatesParameters() {
        return coordinatesParameters;
    }

    public String getParameterForDailyForecast() {
        return parameterForDailyForecast;
    }

    public String getParameterForUnits() {
        return parameterForUnits;
    }
}
