package it.faire.ai.weather.openweatherforecast.beans.forecast.openweather;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lat",
        "lon",
        "timezone",
        "timezone_offset",
        "current",
        "minutely",
        "hourly",
        "daily"
})
public class Forecast implements Serializable
{

    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lon")
    private Double lon;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("timezone_offset")
    private Long timezone_offset;
    @JsonProperty("current")
    private Current current;
    @JsonProperty("minutely")
    private List<Minutely> minutely = null;
    @JsonProperty("hourly")
    private List<Hourly> hourly = null;
    @JsonProperty("daily")
    private List<Daily> daily = null;
    private final static long serialVersionUID = 2496642692043129774L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Forecast() {
    }

    /**
     *
     * @param current
     * @param timezone
     * @param timezone_offset
     * @param daily
     * @param lon
     * @param hourly
     * @param minutely
     * @param lat
     */
    public Forecast(Double lat, Double lon, String timezone, Long timezone_offset, Current current, List<Minutely> minutely, List<Hourly> hourly, List<Daily> daily) {
        super();
        this.lat = lat;
        this.lon = lon;
        this.timezone = timezone;
        this.timezone_offset = timezone_offset;
        this.current = current;
        this.minutely = minutely;
        this.hourly = hourly;
        this.daily = daily;
    }

    @JsonProperty("lat")
    public Double getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Forecast withLat(Double lat) {
        this.lat = lat;
        return this;
    }

    @JsonProperty("lon")
    public Double getLon() {
        return lon;
    }

    @JsonProperty("lon")
    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Forecast withLon(Double lon) {
        this.lon = lon;
        return this;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Forecast withTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    @JsonProperty("timezone_offset")
    public Long getTimezone_offset() {
        return timezone_offset;
    }

    @JsonProperty("timezone_offset")
    public void setTimezone_offset(Long timezone_offset) {
        this.timezone_offset = timezone_offset;
    }

    public Forecast withTimezone_offset(Long timezone_offset) {
        this.timezone_offset = timezone_offset;
        return this;
    }

    @JsonProperty("current")
    public Current getCurrent() {
        return current;
    }

    @JsonProperty("current")
    public void setCurrent(Current current) {
        this.current = current;
    }

    public Forecast withCurrent(Current current) {
        this.current = current;
        return this;
    }

    @JsonProperty("minutely")
    public List<Minutely> getMinutely() {
        return minutely;
    }

    @JsonProperty("minutely")
    public void setMinutely(List<Minutely> minutely) {
        this.minutely = minutely;
    }

    public Forecast withMinutely(List<Minutely> minutely) {
        this.minutely = minutely;
        return this;
    }

    @JsonProperty("hourly")
    public List<Hourly> getHourly() {
        return hourly;
    }

    @JsonProperty("hourly")
    public void setHourly(List<Hourly> hourly) {
        this.hourly = hourly;
    }

    public Forecast withHourly(List<Hourly> hourly) {
        this.hourly = hourly;
        return this;
    }

    @JsonProperty("daily")
    public List<Daily> getDaily() {
        return daily;
    }

    @JsonProperty("daily")
    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }

    public Forecast withDaily(List<Daily> daily) {
        this.daily = daily;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("lat", lat).append("lon", lon).append("timezone", timezone).append("timezone_offset", timezone_offset).append("current", current).append("minutely", minutely).append("hourly", hourly).append("daily", daily).toString();
    }

}
