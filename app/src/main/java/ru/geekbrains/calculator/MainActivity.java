package ru.geekbrains.calculator;

import static ru.geekbrains.calculator.R.style.myThemeDefault;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String PREF_NAME = "key_pref";
    public static final String PREF_THEME_KEY = "key_pref_theme";
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnZero;
    private Button btnC;
    private Button btnPercent;
    private Button btnDiv;
    private Button btnDel;
    private Button btnX;
    private Button btnMinus;
    private Button btnPlus;
    private Button btnPlusOrMinus;
    private Button btnPoint;
    private Button btnEqual;
    private TextView textView;
    private Button settings;
    public static int REQUEST_CODE = 777;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        setTheme(sharedPreferences.getInt(PREF_NAME, R.style.myThemeDefault));
        setContentView(R.layout.activity_main);
        init();
        setListeners();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("s", textView.getText().toString());
        outState.putString("ss", input);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString("s"));
        input = savedInstanceState.getString("ss");

    }

    private void init() {
        settings = findViewById(R.id.settings);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnZero = findViewById(R.id.btnZero);
        btnC = findViewById(R.id.btnC);
        btnPercent = findViewById(R.id.btnPercent);
        btnDiv = findViewById(R.id.btnDel);
        btnDel = findViewById(R.id.btnDel);
        btnX = findViewById(R.id.btnX);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnPlusOrMinus = findViewById(R.id.btnPlusOrMinus);
        btnPoint = findViewById(R.id.btnPoint);
        btnEqual = findViewById(R.id.btnEqual);
        textView = findViewById(R.id.textView);


    }


    private void setListeners() {
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnPercent.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnX.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnPlusOrMinus.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnEqual.setOnClickListener(this);

    }

    double first = 0.0d;
    double second = 0.0d;
    int operation = 0;
    String input = "";


    @Override
    public void onClick(View view) {

        Button btn = (Button) view;
        textView.setText(textView.getText().toString() + "" + btn.getText().toString());
        switch (view.getId()) {
            case R.id.btnOne:
            case R.id.btnTwo:
            case R.id.btnThree:
            case R.id.btnFour:
            case R.id.btnFive:
            case R.id.btnSix:
            case R.id.btnSeven:
            case R.id.btnEight:
            case R.id.btnNine:
            case R.id.btnZero:
            case R.id.btnPoint:
                input += btn.getText().toString();
                break;
            case R.id.btnPlus:

                second = first;
                first = Double.parseDouble(input);
                operation = 1;
                input = "";
                break;
            case R.id.btnMinus:
                second = first;
                first = Double.parseDouble(input);
                operation = 2;
                input = "";
                break;
            case R.id.btnEqual:
                second = first;
                first = Double.parseDouble(input);
                result();
                break;
            case R.id.btnC:
                first = 0d;
                second = 0d;
                input = "";
                textView.setText("");

        }
    }

    void result() {
        switch (operation) {
            case 1:
                textView.setText(String.format("%.2f", second + first));
                break;
            case 2:
                textView.setText(String.format("%.2f", second - first));
                break;
        }
    }


}