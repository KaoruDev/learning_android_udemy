package com.kaoruk.udemy.oreo.section5.eggtimerapp.models;

public class DataState {
    private final int selectedSeconds;
    private final int currentSeconds;
    private final boolean running;

    public DataState(int selectedSeconds, int currentSeconds, boolean running) {
        this.selectedSeconds = selectedSeconds;
        this.currentSeconds = currentSeconds;
        this.running = running;
    }

    public int getSelectedSeconds() {
        return selectedSeconds;
    }

    public int getCurrentSeconds() {
        return currentSeconds;
    }

    public boolean isRunning() {
        return running;
    }
}
