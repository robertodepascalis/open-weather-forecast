package it.faire.ai.weather.openweatherforecast.beans.forecast.custom;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "formatted_from",
        "formatted_to",
        "avg_temp",
        "max_temp",
        "min_temp",
        "avg_hum",
        "max_hum",
        "min_hum"
})
public class Out_range implements Serializable
{
    @JsonProperty("formatted_from")
    private String formatted_from;
    @JsonProperty("formatted_to")
    private String formatted_to;
    @JsonProperty("hours_out_range")
    private Long[] hours_out_range;
    @JsonProperty("avg_temp")
    private Double avg_temp;
    @JsonProperty("max_temp")
    private Double max_temp;
    @JsonProperty("min_temp")
    private Double min_temp;
    @JsonProperty("avg_hum")
    private Double avg_hum;
    @JsonProperty("max_hum")
    private Double max_hum;
    @JsonProperty("min_hum")
    private Double min_hum;
    private final static long serialVersionUID = 8979388765239539080L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Out_range() {
    }

    /**
     *
     * @param formatted_from
     * @param formatted_to
     * @param hours_out_range
     * @param avg_temp
     * @param max_temp
     * @param min_temp
     * @param avg_hum
     * @param max_hum
     * @param min_hum
     */
    public Out_range(String formatted_from, String formatted_to, Long[] hours_out_range,
                     Double avg_temp, Double max_temp, Double min_temp,
                     Double avg_hum, Double max_hum, Double min_hum) {
        super();
        this.formatted_from = formatted_from;
        this.formatted_to = formatted_to;
        this.hours_out_range = hours_out_range;
        this.avg_temp = avg_temp;
        this.max_temp = max_temp;
        this.min_temp = min_temp;
        this.avg_hum = avg_hum;
        this.max_hum = max_hum;
        this.min_hum = min_hum;
    }

    @JsonProperty("formatted_from")
    public String getFormatted_from() {
        return formatted_from;
    }

    @JsonProperty("formatted_from")
    public void setFormatted_from(String formatted_from) {
        this.formatted_from = formatted_from;
    }

    public Out_range withFormatted_from(String formatted_from) {
        this.formatted_from = formatted_from;
        return this;
    }

    @JsonProperty("formatted_to")
    public String getFormatted_to() {
        return formatted_to;
    }

    @JsonProperty("formatted_to")
    public void setFormatted_to(String formatted_to) {
        this.formatted_to = formatted_to;
    }

    public Out_range withFormatted_to(String formatted_to) {
        this.formatted_to = formatted_to;
        return this;
    }

    @JsonProperty("hours_out_range")
    public Long[] getHours_out_range() {
        return hours_out_range;
    }

    @JsonProperty("hours_out_range")
    public void setHours_out_range(Long[] hours_out_range) {
        this.hours_out_range = hours_out_range;
    }

    public Out_range withHours_out_range(Long[] hours_out_range) {
        this.hours_out_range = hours_out_range;
        return this;
    }

    @JsonProperty("avg_temp")
    public Double getAvg_temp() {
        return avg_temp;
    }

    @JsonProperty("avg_temp")
    public void setAvg_temp(Double avg_temp) {
        this.avg_temp = avg_temp;
    }

    public Out_range withAvg_temp(Double avg_temp) {
        this.avg_temp = avg_temp;
        return this;
    }

    @JsonProperty("max_temp")
    public Double getMax_temp() {
        return max_temp;
    }

    @JsonProperty("max_temp")
    public void setMax_temp(Double max_temp) {
        this.max_temp = max_temp;
    }

    public Out_range withMax_temp(Double max_temp) {
        this.max_temp = max_temp;
        return this;
    }

    @JsonProperty("min_temp")
    public Double getMin_temp() {
        return min_temp;
    }

    @JsonProperty("min_temp")
    public void setMin_temp(Double min_temp) {
        this.min_temp = min_temp;
    }

    public Out_range withMin_temp(Double min_temp) {
        this.min_temp = min_temp;
        return this;
    }

    @JsonProperty("avg_hum")
    public Double getAvg_hum() {
        return avg_hum;
    }

    @JsonProperty("avg_hum")
    public void setAvg_hum(Double avg_hum) {
        this.avg_hum = avg_hum;
    }

    public Out_range withAvg_hum(Double avg_hum) {
        this.avg_hum = avg_hum;
        return this;
    }

    @JsonProperty("max_hum")
    public Double getMax_hum() {
        return max_hum;
    }

    @JsonProperty("max_hum")
    public void setMax_hum(Double max_hum) {
        this.max_hum = max_hum;
    }

    public Out_range withMax_hum(Double max_hum) {
        this.max_hum = max_hum;
        return this;
    }

    @JsonProperty("min_hum")
    public Double getMin_hum() {
        return min_hum;
    }

    @JsonProperty("min_hum")
    public void setMin_hum(Double min_hum) {
        this.min_hum = min_hum;
    }

    public Out_range withMin_hum(Double min_hum) {
        this.min_hum = min_hum;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("avg_temp", avg_temp).append("max_temp", max_temp).append("min_temp", min_temp).append("avg_hum", avg_hum).append("max_hum", max_hum).append("min_hum", min_hum).toString();
    }

}