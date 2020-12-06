package it.faire.ai.weather.openweatherforecast.controller;

import static it.faire.ai.weather.openweatherforecast.util.FilterUtils.startWith;

import it.faire.ai.weather.openweatherforecast.service.CitiesInfoHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CityController {

    private CitiesInfoHolder citiesInfoHolder;

    @Autowired
    public CityController(CitiesInfoHolder citiesInfoHolder) {
        this.citiesInfoHolder = citiesInfoHolder;
    }

    /**
     * The following service is called by the Bootstrap utility in order to implement the autocomplete.
     * @param q - This is the conventional parameter used to search the city or reduce the set of available cities.
     * @return
     */
    @GetMapping("/cities")
    public ResponseEntity<String[]> getCityNames(@RequestParam("q") String q) {
        if (StringUtils.isBlank(q)) {
            return ResponseEntity.ok(new String[0]);
        }
        return ResponseEntity.ok(startWith(citiesInfoHolder.getCityNames(), q));
    }
}
