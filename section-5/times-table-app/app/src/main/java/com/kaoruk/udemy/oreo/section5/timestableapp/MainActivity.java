package com.kaoruk.udemy.oreo.section5.timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {
    final static List<Integer> multipliers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar baseNumberScale = findViewById(R.id.baseNumberScale);
        final ListView listView = findViewById(R.id.timesTableListView);
        final Context context = this;

        baseNumberScale.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("INFO", "Real SeekBar Changed to: " + i);
                List<Integer> result = new ArrayList<>();
                for (int idx = 0; idx < multipliers.size(); idx ++) {
                    // Adding 2 to the idx so we can scale from 2 - 20, feels hacky, wish the
                    // slider itself would take care of this via a min attribute, but I don't think
                    // min was introduced until later versions, boo
                    result.add(multipliers.get(idx) * (i + 2));
                }

                ArrayAdapter<Integer> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, result);
                listView.setAdapter(adapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}