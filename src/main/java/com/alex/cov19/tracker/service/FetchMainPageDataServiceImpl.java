package com.alex.cov19.tracker.service;

import com.alex.cov19.tracker.model.DailyStates;
import com.alex.cov19.tracker.model.DailySummary;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Alex CHEN
 * @version 1.0
 * @since 2020-08-05 18:35
 */
@Slf4j
@Service
@Data
public class FetchMainPageDataServiceImpl implements FetchMainPageDataService {

    @Value("${us.current.url}")
    private String US_CURRENT_URL;

    @Value("${daily.summary.url}")
    private String DAILY_SUMMARY_URL;

    @Value("${daily.states.url}")
    private String DAILY_STATES_URL;

    private RestTemplate restTemplate;
    JsonParser parser;

    @PostConstruct
    public void init() {
        restTemplate = new RestTemplate();
        parser = new JsonParser();
    }

    @Override
    public List<DailySummary> fetchDataDailySummary() {
        return fetchDailySummary();
    }

    @Override
    public List<DailyStates> fetchDataDailyStates() {
        return fetchDailyStates();
    }

    private List<DailySummary> fetchDailySummary() {
        String result = restTemplate.getForObject(DAILY_SUMMARY_URL, String.class);

        JsonObject object = (JsonObject) parser.parse(result);
        JsonArray jsonArray = object.getAsJsonArray("Countries");

        return sortByConfirmed(jsonArray);
    }

    private List<DailyStates> fetchDailyStates() {
        String result = restTemplate.getForObject(DAILY_STATES_URL, String.class);

        JsonArray jsonArray = (JsonArray) parser.parse(result);
        return sortByPositive(jsonArray);
    }

    private List<DailySummary> sortByConfirmed(JsonArray jsonArray) {
        List<DailySummary> sortedDailySummaries = new ArrayList<>();

        List<JsonObject> jsonValues = new ArrayList<JsonObject>();
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonValues.add(jsonArray.get(i).getAsJsonObject());
        }

        jsonValues.sort(createComparator("TotalConfirmed"));

        for (int i = 0; i < 5; i++) {
            JsonObject cur = jsonValues.get(i);
            DailySummary dailySummary = createDailySummary(cur);
            sortedDailySummaries.add(dailySummary);
        }

        return sortedDailySummaries;
    }

    private List<DailyStates> sortByPositive(JsonArray jsonArray) {
        List<DailyStates> sortedDailyStates = new ArrayList<>();

        List<JsonObject> jsonValues = new ArrayList<JsonObject>();
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonValues.add(jsonArray.get(i).getAsJsonObject());
        }

        jsonValues.sort(createComparator("positive"));

        for (int i = 0; i < 5; i++) {
            JsonObject cur = jsonValues.get(i);
            DailyStates dailyStates = createDailyStates(cur);
            sortedDailyStates.add(dailyStates);
        }

        System.out.println(sortedDailyStates);
        return sortedDailyStates;
    }

    private DailySummary createDailySummary(JsonObject cur) {
        DailySummary dailySummary = new DailySummary();
        dailySummary.setCountry(cur.getAsJsonPrimitive("Country").getAsString());
        dailySummary.setCountryCode(cur.getAsJsonPrimitive("CountryCode").getAsString());
        dailySummary.setTotalConfirmed(cur.getAsJsonPrimitive("TotalConfirmed").getAsLong());
        dailySummary.setTotalDeaths(cur.getAsJsonPrimitive("TotalDeaths").getAsInt());
        return dailySummary;
    }

    private DailyStates createDailyStates(JsonObject cur) {
        DailyStates dailyStates = new DailyStates();
        dailyStates.setStateCode(cur.getAsJsonPrimitive("state").getAsString());
        dailyStates.setPositive(cur.getAsJsonPrimitive("positive").getAsInt());
        return dailyStates;
    }

    private Comparator<JsonObject> createComparator(String key) {
        return new Comparator<JsonObject>() {
            @Override
            public int compare(JsonObject a, JsonObject b) {
                long valA = Long.parseLong(a.get(key).getAsString());
                long valB = Long.parseLong(b.get(key).getAsString());
                return Long.compare(valB, valA);
            }
        };
    }

}
