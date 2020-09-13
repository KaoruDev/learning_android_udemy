package com.kaoruk.udemy.oreo.section5.listviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = findViewById(R.id.myListView);

        final List<String> whitePeopleNames = Arrays.asList("John", "Sarah", "Pete", "Erin");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, whitePeopleNames);

        myListView.setAdapter(adapter);

        final Context context = this;

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;

                String personName = textView.getText().toString();
//                String personName = whitePeopleNames.get(i); // This is what the course suggested

                Log.i("INFO", "New from TextView " + textView.getText());
                Toast.makeText(context, textView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}