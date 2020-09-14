package com.kaoruk.udemy.oreo.section5.eggtimerapp.boundedviews;

import android.widget.TextView;

import com.kaoruk.udemy.oreo.section5.eggtimerapp.actions.CountDownActions;
import com.kaoruk.udemy.oreo.section5.eggtimerapp.actions.UserActions;
import com.kaoruk.udemy.oreo.section5.eggtimerapp.models.DataState;

import java.util.Locale;

public class TimerDisplayView implements BoundedView {
    private static final int secondsInMinute = 60;

    private final TextView timerView;

    public TimerDisplayView(TextView timerView) {
        this.timerView = timerView;
    }

    @Override
    public void onChange(String action, DataState dataState) {
        switch(action) {
            case UserActions.UPDATE_TIMER:
                handleUpdatedSeconds(dataState.getSelectedSeconds());
                break;
            case CountDownActions.UPDATED_COUNTDOWN:
                handleUpdatedSeconds(dataState.getCurrentSeconds());
                break;
            default:
        }
    }

    private void handleUpdatedSeconds(int updatedSeconds) {
        String display = String.format(
                Locale.US,
                "%02d:%02d",
                updatedSeconds / secondsInMinute,
                updatedSeconds % secondsInMinute
        );

        timerView.setText(display);
    }
}
