package com.alex.cov19.tracker.model;

import lombok.Data;

/**
 * @author Alex CHEN
 * @version 1.0
 * @since 2020-08-06 18:14
 */
@Data
public class CountryDetail {

    private String country;
    private int newConfirmed;
    private int totalConfirmed;
    private int newRecovered;
    private int totalRecovered;
}
