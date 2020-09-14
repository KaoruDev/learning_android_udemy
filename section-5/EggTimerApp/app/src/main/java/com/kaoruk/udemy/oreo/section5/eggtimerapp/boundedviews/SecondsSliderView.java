package com.kaoruk.udemy.oreo.section5.eggtimerapp.boundedviews;

import android.widget.SeekBar;

import com.kaoruk.udemy.oreo.section5.eggtimerapp.actions.UserActions;
import com.kaoruk.udemy.oreo.section5.eggtimerapp.models.DataState;
import com.kaoruk.udemy.oreo.section5.eggtimerapp.models.GlobalStore;

import java.util.concurrent.TimeUnit;

public class SecondsSliderView implements  BoundedView {
    private final GlobalStore globalStore;
    private final SeekBar view;
    private boolean setup = false;

    public SecondsSliderView(GlobalStore globalStore, SeekBar view) {
        this.globalStore = globalStore;
        this.view = view;
        view.setMax((int) TimeUnit.MINUTES.toSeconds(5));
    }

    public void setup() {
        if (setup) return;

        view.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                globalStore.setSelectedSeconds(UserActions.UPDATE_TIMER, progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onChange(String action, DataState dataState) {
    }
}
