package it.faire.ai.weather.openweatherforecast.util;


import static org.apache.commons.lang3.Validate.notNull;

import java.text.MessageFormat;
import org.springframework.stereotype.Service;

import it.faire.ai.weather.openweatherforecast.service.OpenWeatherApiProperties;

/**
 * Weather API url builder.
 *
 * @author Roberto De Pascalis
 */
@Service
public final class OpenWeatherApiUrlBuilder {

    private final OpenWeatherApiProperties openWeatherApiProperties;

    public OpenWeatherApiUrlBuilder(OpenWeatherApiProperties openWeatherApiProperties) {
        this.openWeatherApiProperties = openWeatherApiProperties;
    }

    public String build(String lat, String lon) {
        notNull(lat);
        final StringBuilder builder = new StringBuilder();
        builder.append(openWeatherApiProperties.getOpenWeatherApiResource());

        builder.append('?');
        builder.append(MessageFormat.format(openWeatherApiProperties.getCoordinatesParameters(), lat, lon));
        builder.append('&');
        builder.append(openWeatherApiProperties.getAppIdParameter());
        builder.append('&');
        builder.append(openWeatherApiProperties.getParameterForDailyForecast());
        builder.append('&');
        builder.append(openWeatherApiProperties.getParameterForUnits());
        return  builder.toString();
    }
}
