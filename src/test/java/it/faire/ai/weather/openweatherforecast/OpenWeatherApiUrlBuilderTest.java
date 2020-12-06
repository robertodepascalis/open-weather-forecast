package it.faire.ai.weather.openweatherforecast;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.faire.ai.weather.openweatherforecast.util.OpenWeatherApiUrlBuilder;

@SpringBootTest
class OpenWeatherApiUrlBuilderTest {

    @Autowired
    private OpenWeatherApiUrlBuilder openWeatherApiUrlBuilder;

    @Test
    void openWeatherApiUrlBuilder_shouldBuildUrlCorrectly() {
        final String url = "https://api.openweathermap.org/data/2.5/onecall?lat=1&lon=2&appid=123&exclude=current,minutely,daily,alerts&units=metric";
        final String expectedUrl = openWeatherApiUrlBuilder.build("1", "2");

        assertEquals(url, expectedUrl);
    }

}
