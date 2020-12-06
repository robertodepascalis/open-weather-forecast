package it.faire.ai.weather.openweatherforecast.beans.forecast.openweather;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "day",
        "min",
        "max",
        "night",
        "eve",
        "morn"
})
public class Temp implements Serializable
{

    @JsonProperty("day")
    private Double day;
    @JsonProperty("min")
    private Double min;
    @JsonProperty("max")
    private Double max;
    @JsonProperty("night")
    private Double night;
    @JsonProperty("eve")
    private Double eve;
    @JsonProperty("morn")
    private Double morn;
    private final static long serialVersionUID = -2169863172247806210L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Temp() {
    }

    /**
     *
     * @param min
     * @param max
     * @param eve
     * @param night
     * @param day
     * @param morn
     */
    public Temp(Double day, Double min, Double max, Double night, Double eve, Double morn) {
        super();
        this.day = day;
        this.min = min;
        this.max = max;
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

    public Temp withDay(Double day) {
        this.day = day;
        return this;
    }

    @JsonProperty("min")
    public Double getMin() {
        return min;
    }

    @JsonProperty("min")
    public void setMin(Double min) {
        this.min = min;
    }

    public Temp withMin(Double min) {
        this.min = min;
        return this;
    }

    @JsonProperty("max")
    public Double getMax() {
        return max;
    }

    @JsonProperty("max")
    public void setMax(Double max) {
        this.max = max;
    }

    public Temp withMax(Double max) {
        this.max = max;
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

    public Temp withNight(Double night) {
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

    public Temp withEve(Double eve) {
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

    public Temp withMorn(Double morn) {
        this.morn = morn;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("day", day).append("min", min).append("max", max).append("night", night).append("eve", eve).append("morn", morn).toString();
    }

}