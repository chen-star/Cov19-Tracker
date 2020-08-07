package com.alex.cov19.tracker.controller;

import com.alex.cov19.tracker.model.CountryDetail;
import com.alex.cov19.tracker.model.DailyStates;
import com.alex.cov19.tracker.model.DailySummary;
import com.alex.cov19.tracker.model.WorldSummary;
import com.alex.cov19.tracker.service.FetchMainPageDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Alex CHEN
 * @version 1.0
 * @since 2020-08-05 18:20
 */
@Slf4j
@Controller
@RequestMapping("/")
public class MainPageController {

    @Autowired
    private FetchMainPageDataService fetchMainPageDataService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ModelAndView getMainPage() {
        List<DailySummary> sortedSummary = fetchMainPageDataService.fetchDataDailySummary();
        List<DailyStates> sortedSates = fetchMainPageDataService.fetchDataDailyStates();
        WorldSummary worldSummary = fetchMainPageDataService.fetchDataWorldSummary();
        List<CountryDetail> countryDetails = fetchMainPageDataService.fetchDataCountryDetail();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("summary", sortedSummary);
        modelAndView.addObject("states", sortedSates);
        modelAndView.addObject("worldSummary", worldSummary);
        modelAndView.addObject("countryDetails", countryDetails);
        return modelAndView;
    }
}
