package it.faire.ai.weather.openweatherforecast.controller;

import java.time.LocalDateTime;

import static it.faire.ai.weather.openweatherforecast.util.NumberUtils.isValidNumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.faire.ai.weather.openweatherforecast.beans.forecast.custom.DaysWithHoursRangeAvgMaxMinTempHum;
import it.faire.ai.weather.openweatherforecast.service.ForecastError;
import it.faire.ai.weather.openweatherforecast.service.OpenWeatherForecastService;

@Controller
public class ForecastController {

    private OpenWeatherForecastService openWeatherForecastService;

    @Autowired
    public ForecastController(OpenWeatherForecastService openWeatherForecastService) {
        this.openWeatherForecastService = openWeatherForecastService;
    }

    /**
     *
     * @param city - The parameter is in this format: city name [state=] [country=].
     * @param startHour - The parameter is into the range of 0-23.
     * @param endHour- The parameter is into the range of 0-23.
     * @return
     */
    @GetMapping("/forecast")
    public ModelAndView getHomepage(@RequestParam("city") String city,
                                    @RequestParam("startHour") String startHour,
                                    @RequestParam("endHour")String endHour) {
        ModelAndView modelAndView = new ModelAndView();
        if (! isValidNumber(startHour) || ! isValidNumber(endHour)) {
            modelAndView.addObject("error", "Hours not correct!");
            modelAndView.setViewName("show-error");
            return modelAndView;
        }
        try {
            DaysWithHoursRangeAvgMaxMinTempHum daysWithHoursRangeAvgMaxMinTempHum =
                    openWeatherForecastService.getAverageMeasuresForWorkingHours(city, Integer.valueOf(startHour), Integer.valueOf(endHour),  LocalDateTime.now());

            modelAndView.addObject("forecast", daysWithHoursRangeAvgMaxMinTempHum);
            modelAndView.setViewName("show-forecast");
        }
        catch (ForecastError forecastError) {
            forecastError.printStackTrace();
            modelAndView.addObject("error", forecastError.getMessage());
            modelAndView.setViewName("show-error");
        }

        return modelAndView;
    }

}
