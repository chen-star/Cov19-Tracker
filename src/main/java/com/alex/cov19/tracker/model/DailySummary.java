package com.alex.cov19.tracker.model;

import lombok.Data;

/**
 * @author Alex CHEN
 * @version 1.0
 * @since 2020-08-05 22:33
 */
@Data
public class DailySummary {

    private String country;
    private String countryCode;
    private long totalConfirmed;
    private int totalDeaths;
}
