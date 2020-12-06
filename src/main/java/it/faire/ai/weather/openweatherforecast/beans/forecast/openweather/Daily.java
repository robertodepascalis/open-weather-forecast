package it.faire.ai.weather.openweatherforecast.beans.forecast.openweather;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonPropertyOrder({
        "dt",
        "sunrise",
        "sunset",
        "temp",
        "feels_like",
        "pressure",
        "humidity",
        "dew_point",
        "wind_speed",
        "wind_deg",
        "weather",
        "clouds",
        "pop",
        "rain",
        "uvi"
})
public class Daily implements Serializable
{

    @JsonProperty("dt")
    private Long dt;
    @JsonProperty("sunrise")
    private Long sunrise;
    @JsonProperty("sunset")
    private Long sunset;
    @JsonProperty("temp")
    private Temp temp;
    @JsonProperty("feels_like")
    private Feels_like feels_like;
    @JsonProperty("pressure")
    private Long pressure;
    @JsonProperty("humidity")
    private Long humidity;
    @JsonProperty("dew_point")
    private Double dew_point;
    @JsonProperty("wind_speed")
    private Double wind_speed;
    @JsonProperty("wind_deg")
    private Long wind_deg;
    @JsonProperty("weather")
    private List<Weather__> weather = null;
    @JsonProperty("clouds")
    private Long clouds;
    @JsonProperty("pop")
    private Double pop;
    @JsonProperty("rain")
    private Double rain;
    @JsonProperty("uvi")
    private Long uvi;
    private final static long serialVersionUID = -4150136671108475108L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Daily() {
    }

    /**
     *
     * @param rain
     * @param sunrise
     * @param temp
     * @param uvi
     * @param pressure
     * @param clouds
     * @param feels_like
     * @param dt
     * @param pop
     * @param wind_deg
     * @param dew_point
     * @param sunset
     * @param weather
     * @param humidity
     * @param wind_speed
     */
    public Daily(Long dt, Long sunrise, Long sunset, Temp temp, Feels_like feels_like, Long pressure, Long humidity, Double dew_point, Double wind_speed, Long wind_deg, List<Weather__> weather, Long clouds, Double pop, Double rain, Long uvi) {
        super();
        this.dt = dt;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.temp = temp;
        this.feels_like = feels_like;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dew_point = dew_point;
        this.wind_speed = wind_speed;
        this.wind_deg = wind_deg;
        this.weather = weather;
        this.clouds = clouds;
        this.pop = pop;
        this.rain = rain;
        this.uvi = uvi;
    }

    @JsonProperty("dt")
    public Long getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Daily withDt(Long dt) {
        this.dt = dt;
        return this;
    }

    @JsonProperty("sunrise")
    public Long getSunrise() {
        return sunrise;
    }

    @JsonProperty("sunrise")
    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Daily withSunrise(Long sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    @JsonProperty("sunset")
    public Long getSunset() {
        return sunset;
    }

    @JsonProperty("sunset")
    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    public Daily withSunset(Long sunset) {
        this.sunset = sunset;
        return this;
    }

    @JsonProperty("temp")
    public Temp getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public Daily withTemp(Temp temp) {
        this.temp = temp;
        return this;
    }

    @JsonProperty("feels_like")
    public Feels_like getFeels_like() {
        return feels_like;
    }

    @JsonProperty("feels_like")
    public void setFeels_like(Feels_like feels_like) {
        this.feels_like = feels_like;
    }

    public Daily withFeels_like(Feels_like feels_like) {
        this.feels_like = feels_like;
        return this;
    }

    @JsonProperty("pressure")
    public Long getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(Long pressure) {
        this.pressure = pressure;
    }

    public Daily withPressure(Long pressure) {
        this.pressure = pressure;
        return this;
    }

    @JsonProperty("humidity")
    public Long getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public Daily withHumidity(Long humidity) {
        this.humidity = humidity;
        return this;
    }

    @JsonProperty("dew_point")
    public Double getDew_point() {
        return dew_point;
    }

    @JsonProperty("dew_point")
    public void setDew_point(Double dew_point) {
        this.dew_point = dew_point;
    }

    public Daily withDew_point(Double dew_point) {
        this.dew_point = dew_point;
        return this;
    }

    @JsonProperty("wind_speed")
    public Double getWind_speed() {
        return wind_speed;
    }

    @JsonProperty("wind_speed")
    public void setWind_speed(Double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public Daily withWind_speed(Double wind_speed) {
        this.wind_speed = wind_speed;
        return this;
    }

    @JsonProperty("wind_deg")
    public Long getWind_deg() {
        return wind_deg;
    }

    @JsonProperty("wind_deg")
    public void setWind_deg(Long wind_deg) {
        this.wind_deg = wind_deg;
    }

    public Daily withWind_deg(Long wind_deg) {
        this.wind_deg = wind_deg;
        return this;
    }

    @JsonProperty("weather")
    public List<Weather__> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(List<Weather__> weather) {
        this.weather = weather;
    }

    public Daily withWeather(List<Weather__> weather) {
        this.weather = weather;
        return this;
    }

    @JsonProperty("clouds")
    public Long getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(Long clouds) {
        this.clouds = clouds;
    }

    public Daily withClouds(Long clouds) {
        this.clouds = clouds;
        return this;
    }

    @JsonProperty("pop")
    public Double getPop() {
        return pop;
    }

    @JsonProperty("pop")
    public void setPop(Double pop) {
        this.pop = pop;
    }

    public Daily withPop(Double pop) {
        this.pop = pop;
        return this;
    }

    @JsonProperty("rain")
    public Double getRain() {
        return rain;
    }

    @JsonProperty("rain")
    public void setRain(Double rain) {
        this.rain = rain;
    }

    public Daily withRain(Double rain) {
        this.rain = rain;
        return this;
    }

    @JsonProperty("uvi")
    public Long getUvi() {
        return uvi;
    }

    @JsonProperty("uvi")
    public void setUvi(Long uvi) {
        this.uvi = uvi;
    }

    public Daily withUvi(Long uvi) {
        this.uvi = uvi;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("dt", dt).append("sunrise", sunrise).append("sunset", sunset).append("temp", temp).append("feels_like", feels_like).append("pressure", pressure).append("humidity", humidity).append("dew_point", dew_point).append("wind_speed", wind_speed).append("wind_deg", wind_deg).append("weather", weather).append("clouds", clouds).append("pop", pop).append("rain", rain).append("uvi", uvi).toString();
    }

}
