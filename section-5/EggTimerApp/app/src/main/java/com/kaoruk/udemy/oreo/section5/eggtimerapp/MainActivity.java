package com.kaoruk.udemy.oreo.section5.eggtimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.kaoruk.udemy.oreo.section5.eggtimerapp.boundedviews.SecondsSliderView;
import com.kaoruk.udemy.oreo.section5.eggtimerapp.boundedviews.TimerDisplayView;
import com.kaoruk.udemy.oreo.section5.eggtimerapp.models.DataState;
import com.kaoruk.udemy.oreo.section5.eggtimerapp.models.GlobalStore;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GlobalStore globalStore = new GlobalStore();

        TextView timerView = findViewById(R.id.timerView);
        globalStore.registerView(new TimerDisplayView(timerView));

        SeekBar timerBar = findViewById(R.id.timeScaleSeekBar);
        new SecondsSliderView(globalStore, timerBar).setup();
    }
}