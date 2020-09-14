package com.kaoruk.udemy.oreo.section5.eggtimerapp.boundedviews;

import com.kaoruk.udemy.oreo.section5.eggtimerapp.models.DataState;

public interface BoundedView {
    void onChange(String action, DataState dataState);
}
