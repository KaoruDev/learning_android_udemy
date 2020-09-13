package com.kaoruk.udemy.oreo.section2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickFunction(View view) {
        Log.i("Info", "Button pressed");
        EditText nameEditText = findViewById(R.id.nameEditText);

        Toast.makeText(this, "Hello " + nameEditText.getText(), Toast.LENGTH_SHORT).show();
    }
}