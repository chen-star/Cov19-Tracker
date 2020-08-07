package com.alex.cov19.tracker.model;

import lombok.Data;

/**
 * @author Alex CHEN
 * @version 1.0
 * @since 2020-08-05 23:47
 */
@Data
public class DailyStates {

    private String stateCode;
    private long positive;
}
