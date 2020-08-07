package com.alex.cov19.tracker.model;

import lombok.Data;

/**
 * @author Alex CHEN
 * @version 1.0
 * @since 2020-08-06 17:45
 */
@Data
public class WorldSummary {

    private long totalConfirmed;
    private long totalDeaths;
    private long totalRecovered;
}
