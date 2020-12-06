package it.faire.ai.weather.openweatherforecast.beans.forecast.openweather;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonPropertyOrder({
        "dt",
        "temp",
        "feels_like",
        "pressure",
        "humidity",
        "dew_point",
        "uvi",
        "clouds",
        "visibility",
        "wind_speed",
        "wind_deg",
        "weather",
        "pop",
        "rain"
})
public class Hourly implements Serializable
{

    @JsonProperty("dt")
    private Long dt;
    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("feels_like")
    private Double feels_like;
    @JsonProperty("pressure")
    private Long pressure;
    @JsonProperty("humidity")
    private Long humidity;
    @JsonProperty("dew_point")
    private Double dew_point;
    @JsonProperty("uvi")
    private Double uvi;
    @JsonProperty("clouds")
    private Long clouds;
    @JsonProperty("visibility")
    private Long visibility;
    @JsonProperty("wind_speed")
    private Double wind_speed;
    @JsonProperty("wind_deg")
    private Long wind_deg;
    @JsonProperty("weather")
    private List<Weather_> weather = null;
    @JsonProperty("pop")
    private Double pop;
    @JsonProperty("rain")
    private Rain rain;
    private final static long serialVersionUID = -2726208751106753628L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Hourly() {
    }

    /**
     *
     * @param rain
     * @param temp
     * @param visibility
     * @param uvi
     * @param pressure
     * @param clouds
     * @param feels_like
     * @param dt
     * @param pop
     * @param wind_deg
     * @param dew_point
     * @param weather
     * @param humidity
     * @param wind_speed
     */
    public Hourly(Long dt, Double temp, Double feels_like, Long pressure, Long humidity, Double dew_point, Double uvi, Long clouds, Long visibility, Double wind_speed, Long wind_deg, List<Weather_> weather, Double pop, Rain rain) {
        super();
        this.dt = dt;
        this.temp = temp;
        this.feels_like = feels_like;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dew_point = dew_point;
        this.uvi = uvi;
        this.clouds = clouds;
        this.visibility = visibility;
        this.wind_speed = wind_speed;
        this.wind_deg = wind_deg;
        this.weather = weather;
        this.pop = pop;
        this.rain = rain;
    }

    @JsonProperty("dt")
    public Long getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Hourly withDt(Long dt) {
        this.dt = dt;
        return this;
    }

    @JsonProperty("temp")
    public Double getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Hourly withTemp(Double temp) {
        this.temp = temp;
        return this;
    }

    @JsonProperty("feels_like")
    public Double getFeels_like() {
        return feels_like;
    }

    @JsonProperty("feels_like")
    public void setFeels_like(Double feels_like) {
        this.feels_like = feels_like;
    }

    public Hourly withFeels_like(Double feels_like) {
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

    public Hourly withPressure(Long pressure) {
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

    public Hourly withHumidity(Long humidity) {
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

    public Hourly withDew_point(Double dew_point) {
        this.dew_point = dew_point;
        return this;
    }

    @JsonProperty("uvi")
    public Double getUvi() {
        return uvi;
    }

    @JsonProperty("uvi")
    public void setUvi(Double uvi) {
        this.uvi = uvi;
    }

    public Hourly withUvi(Double uvi) {
        this.uvi = uvi;
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

    public Hourly withClouds(Long clouds) {
        this.clouds = clouds;
        return this;
    }

    @JsonProperty("visibility")
    public Long getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    public Hourly withVisibility(Long visibility) {
        this.visibility = visibility;
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

    public Hourly withWind_speed(Double wind_speed) {
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

    public Hourly withWind_deg(Long wind_deg) {
        this.wind_deg = wind_deg;
        return this;
    }

    @JsonProperty("weather")
    public List<Weather_> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(List<Weather_> weather) {
        this.weather = weather;
    }

    public Hourly withWeather(List<Weather_> weather) {
        this.weather = weather;
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

    public Hourly withPop(Double pop) {
        this.pop = pop;
        return this;
    }

    @JsonProperty("rain")
    public Rain getRain() {
        return rain;
    }

    @JsonProperty("rain")
    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Hourly withRain(Rain rain) {
        this.rain = rain;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("dt", dt).append("temp", temp).append("feels_like", feels_like).append("pressure", pressure).append("humidity", humidity).append("dew_point", dew_point).append("uvi", uvi).append("clouds", clouds).append("visibility", visibility).append("wind_speed", wind_speed).append("wind_deg", wind_deg).append("weather", weather).append("pop", pop).append("rain", rain).toString();
    }

}