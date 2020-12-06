package it.faire.ai.weather.openweatherforecast.beans.forecast.openweather;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonPropertyOrder({
        "dt",
        "precipitation"
})
public class Minutely implements Serializable
{

    @JsonProperty("dt")
    private Long dt;
    @JsonProperty("precipitation")
    private Long precipitation;
    private final static long serialVersionUID = -175814957092788105L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Minutely() {
    }

    /**
     *
     * @param dt
     * @param precipitation
     */
    public Minutely(Long dt, Long precipitation) {
        super();
        this.dt = dt;
        this.precipitation = precipitation;
    }

    @JsonProperty("dt")
    public Long getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Minutely withDt(Long dt) {
        this.dt = dt;
        return this;
    }

    @JsonProperty("precipitation")
    public Long getPrecipitation() {
        return precipitation;
    }

    @JsonProperty("precipitation")
    public void setPrecipitation(Long precipitation) {
        this.precipitation = precipitation;
    }

    public Minutely withPrecipitation(Long precipitation) {
        this.precipitation = precipitation;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("dt", dt).append("precipitation", precipitation).toString();
    }

}