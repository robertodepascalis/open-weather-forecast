package it.faire.ai.weather.openweatherforecast.beans.forecast.openweather;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "day",
        "night",
        "eve",
        "morn"
})
public class Feels_like implements Serializable
{

    @JsonProperty("day")
    private Double day;
    @JsonProperty("night")
    private Double night;
    @JsonProperty("eve")
    private Double eve;
    @JsonProperty("morn")
    private Double morn;
    private final static long serialVersionUID = -8426592564853564656L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Feels_like() {
    }

    /**
     *
     * @param eve
     * @param night
     * @param day
     * @param morn
     */
    public Feels_like(Double day, Double night, Double eve, Double morn) {
        super();
        this.day = day;
        this.night = night;
        this.eve = eve;
        this.morn = morn;
    }

    @JsonProperty("day")
    public Double getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(Double day) {
        this.day = day;
    }

    public Feels_like withDay(Double day) {
        this.day = day;
        return this;
    }

    @JsonProperty("night")
    public Double getNight() {
        return night;
    }

    @JsonProperty("night")
    public void setNight(Double night) {
        this.night = night;
    }

    public Feels_like withNight(Double night) {
        this.night = night;
        return this;
    }

    @JsonProperty("eve")
    public Double getEve() {
        return eve;
    }

    @JsonProperty("eve")
    public void setEve(Double eve) {
        this.eve = eve;
    }

    public Feels_like withEve(Double eve) {
        this.eve = eve;
        return this;
    }

    @JsonProperty("morn")
    public Double getMorn() {
        return morn;
    }

    @JsonProperty("morn")
    public void setMorn(Double morn) {
        this.morn = morn;
    }

    public Feels_like withMorn(Double morn) {
        this.morn = morn;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("day", day).append("night", night).append("eve", eve).append("morn", morn).toString();
    }

}