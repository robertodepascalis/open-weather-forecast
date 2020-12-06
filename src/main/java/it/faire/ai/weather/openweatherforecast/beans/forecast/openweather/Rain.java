package it.faire.ai.weather.openweatherforecast.beans.forecast.openweather;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "1h"
})
public class Rain implements Serializable
{

    @JsonProperty("1h")
    private Double _1h;
    private final static long serialVersionUID = -8826680248291657501L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Rain() {
    }

    /**
     *
     * @param _1h
     */
    public Rain(Double _1h) {
        super();
        this._1h = _1h;
    }

    @JsonProperty("1h")
    public Double get1h() {
        return _1h;
    }

    @JsonProperty("1h")
    public void set1h(Double _1h) {
        this._1h = _1h;
    }

    public Rain with_1h(Double _1h) {
        this._1h = _1h;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("_1h", _1h).toString();
    }

}