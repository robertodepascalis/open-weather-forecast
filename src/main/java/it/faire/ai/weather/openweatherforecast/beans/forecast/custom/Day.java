package it.faire.ai.weather.openweatherforecast.beans.forecast.custom;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "formatted_day",
        "in_range",
        "out_range"
})
public class Day implements Serializable
{

    @JsonProperty("formatted_day")
    private String formatted_day;
    @JsonProperty("in_range")
    private In_range in_range;
    @JsonProperty("out_range")
    private Out_range out_range;
    private final static long serialVersionUID = -1342683872937247782L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Day() {
    }

    /**
     *
     * @param formatted_day
     * @param out_range
     * @param in_range
     */
    public Day(String formatted_day, In_range in_range, Out_range out_range) {
        super();
        this.formatted_day = formatted_day;
        this.in_range = in_range;
        this.out_range = out_range;
    }

    @JsonProperty("formatted_day")
    public String getFormatted_day() {
        return formatted_day;
    }

    @JsonProperty("formatted_day")
    public void setFormatted_day(String formatted_day) {
        this.formatted_day = formatted_day;
    }

    public Day withFormatted_day(String formatted_day) {
        this.formatted_day = formatted_day;
        return this;
    }

    @JsonProperty("in_range")
    public In_range getIn_range() {
        return in_range;
    }

    @JsonProperty("in_range")
    public void setIn_range(In_range in_range) {
        this.in_range = in_range;
    }

    public Day withIn_range(In_range in_range) {
        this.in_range = in_range;
        return this;
    }

    @JsonProperty("out_range")
    public Out_range getOut_range() {
        return out_range;
    }

    @JsonProperty("out_range")
    public void setOut_range(Out_range out_range) {
        this.out_range = out_range;
    }

    public Day withOut_range(Out_range out_range) {
        this.out_range = out_range;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("formatted_day", formatted_day).append("in_range", in_range).append("out_range", out_range).toString();
    }

}