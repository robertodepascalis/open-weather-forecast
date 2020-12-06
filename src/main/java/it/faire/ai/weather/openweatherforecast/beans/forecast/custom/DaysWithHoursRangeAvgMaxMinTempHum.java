package it.faire.ai.weather.openweatherforecast.beans.forecast.custom;


import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "forecast_type",
        "city",
        "timezone",
        "days"
})
public class DaysWithHoursRangeAvgMaxMinTempHum implements Serializable
{

    @JsonProperty("forecast_type")
    private String forecast_type;
    @JsonProperty("city")
    private String city;
    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lon")
    private Double lon;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("timezone_offset")
    private Long timezone_offset;
    @JsonProperty("days")
    private List<Day> days = null;
    private final static long serialVersionUID = 3499518564389289880L;

    /**
     * No args constructor for use in serialization
     *
     */
    public DaysWithHoursRangeAvgMaxMinTempHum() {
    }

    /**
     *
     * @param days
     * @param forecast_type
     */
    public DaysWithHoursRangeAvgMaxMinTempHum(String forecast_type, List<Day> days, String city,
                                              Double lat, Double lon, String timezone, Long timezone_offset) {
        super();
        this.forecast_type = forecast_type;
        this.days = days;
        this.city = city;
        this.lat = lat;
        this.lon = lon;
        this.timezone = timezone;
        this.timezone_offset = timezone_offset;
    }

    @JsonProperty("forecast_type")
    public String getForecast_type() {
        return forecast_type;
    }

    @JsonProperty("forecast_type")
    public void setForecast_type(String forecast_type) {
        this.forecast_type = forecast_type;
    }

    public DaysWithHoursRangeAvgMaxMinTempHum withForecast_type(String forecast_type) {
        this.forecast_type = forecast_type;
        return this;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    public DaysWithHoursRangeAvgMaxMinTempHum withCity(String city) {
        this.city = city;
        return this;
    }

    @JsonProperty("lat")
    public Double getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(Double lat) {
        this.lat = lat;
    }

    public DaysWithHoursRangeAvgMaxMinTempHum withLat(Double lat) {
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

    public DaysWithHoursRangeAvgMaxMinTempHum withLon(Double lon) {
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

    public DaysWithHoursRangeAvgMaxMinTempHum withTimezone(String timezone) {
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

    public DaysWithHoursRangeAvgMaxMinTempHum withTimezone_offset(Long timezone_offset) {
        this.timezone_offset = timezone_offset;
        return this;
    }
    @JsonProperty("days")
    public List<Day> getDays() {
        return days;
    }

    @JsonProperty("days")
    public void setDays(List<Day> days) {
        this.days = days;
    }

    public DaysWithHoursRangeAvgMaxMinTempHum withDays(List<Day> days) {
        this.days = days;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("forecast_type", forecast_type)
                .append("city", city)
                .append("timezone", timezone)
                .append("days", days)
                .toString();
    }

}