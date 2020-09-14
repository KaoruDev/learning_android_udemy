package com.kaoruk.udemy.oreo.section5.eggtimerapp.models;

import com.kaoruk.udemy.oreo.section5.eggtimerapp.boundedviews.BoundedView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GlobalStore {
    private DataState dataState = new DataState(0, 0, false);
    private final List<BoundedView> listeners = new ArrayList<>();

    public void setSelectedSeconds(String action, int newSeconds) {
        dataState = new DataState(newSeconds, dataState.getCurrentSeconds(), dataState.isRunning());
        delegate(action);
    }

    public void setCurrentSeconds(String action, int newSeconds) {
        dataState = new DataState(dataState.getSelectedSeconds(), newSeconds, dataState.isRunning());
        delegate(action);
    }

    public void setRunning(String action, boolean isRunning) {
        dataState = new DataState(dataState.getSelectedSeconds(), dataState.getSelectedSeconds(), isRunning);
        delegate(action);
    }

    public void registerView(BoundedView view) {
        listeners.add(view);
    }

    private void delegate(String action) {
        for (int idx = 0; idx < listeners.size(); idx++) {
            listeners.get(0).onChange(action, dataState);
        }
    }
}
