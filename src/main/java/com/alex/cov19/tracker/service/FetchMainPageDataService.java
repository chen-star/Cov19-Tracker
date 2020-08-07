package com.alex.cov19.tracker.service;

import com.alex.cov19.tracker.model.CountryDetail;
import com.alex.cov19.tracker.model.DailyStates;
import com.alex.cov19.tracker.model.DailySummary;
import com.alex.cov19.tracker.model.WorldSummary;

import java.util.List;

/**
 * @author Jiaxin CHEN
 * @version 1.0
 * @since 2020-08-05-18-34
 */
public interface FetchMainPageDataService {

    List<DailySummary> fetchDataDailySummary();

    List<DailyStates> fetchDataDailyStates();

    WorldSummary fetchDataWorldSummary();

    List<CountryDetail> fetchDataCountryDetail();
}
