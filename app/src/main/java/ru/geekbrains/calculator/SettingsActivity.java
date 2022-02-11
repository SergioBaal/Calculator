package ru.geekbrains.calculator;

import static ru.geekbrains.calculator.R.style.myThemeDefault;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {


    private RadioButton radioDef;
    private RadioButton radioRed;
    private RadioButton radioGreen;
    private Button btn;
    public static int currentTheme = R.style.myThemeDefault;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(currentTheme);
        setContentView(R.layout.activity_settings);
        init();
        setListeners();


    }

    private void init() {
        radioDef = findViewById(R.id.radioDef);
        radioRed = findViewById(R.id.radioRed);
        radioGreen = findViewById(R.id.radioGreen);
        btn = findViewById(R.id.settings);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.radioRed:
                currentTheme = R.style.myThemeRed;
                recreate();
                break;
            case R.id.radioDef:
                currentTheme = R.style.myThemeDefault;
                recreate();
                break;

            case R.id.radioGreen:
                currentTheme = R.style.myThemeGreen;
                recreate();
                break;
            default:
                setTheme(myThemeDefault);

        }
    }

    private void setListeners() {
        radioDef.setOnClickListener(this);
        radioRed.setOnClickListener(this);
        radioGreen.setOnClickListener(this);
        btn.setText("Применить");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.PREF_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(MainActivity.PREF_NAME, currentTheme);
                editor.apply();
                finish();


            }
        });


    }


}


