package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    String mWeightUnit = "kg";
    float mLatestBmiResult = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState !=null){
            mLatestBmiResult = savedInstanceState.getFloat("LATEST_BMI", 0.0f);
            mWeightUnit = savedInstanceState.getString("WEIGHT_UNIT", "kg");

        }


        if (getIntent().getStringExtra("WEIGHT_UNIT") != null) {
            mWeightUnit = getIntent().getStringExtra("WEIGHT_UNIT");
        }

        TextView WeightTextView = findViewById(R.id.WeightTextView);
        WeightTextView.setText("Paino (" + mWeightUnit + ")");
        TextView bmiTextView = findViewById(R.id.bmiTextView);
        bmiTextView.setText("" + mLatestBmiResult);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Tallennetaan olion tila
        savedInstanceState.putString("WEIGHT_UNIT", mWeightUnit);
        savedInstanceState.putFloat("LATEST_BMI", mLatestBmiResult);


        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }



    @Override
    protected void onStart() {

        super.onStart();
        // Aktiviteetti on tulossa näkyviin
    }

    @Override
    protected void onResume() {

        super.onResume();
        // Aktiviteetti on tullut näkyviin
    }

    @Override
    protected void onStop() {

        super.onStop();
        // Aktiviteetti on pois näkyvistä
    }

    @Override
    protected void onPause() {

        super.onPause();
        // Aktiviteetti on menossa pois näkyvistä
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        // Aktiviteetti on tuhottu
    }





    public void calculateBMI(View view) {


        EditText heightEditText = findViewById(R.id.heightEditText);
        EditText weightEditText = findViewById(R.id.weightEditText);

        float height = Float.parseFloat(heightEditText.getText().toString());
        float weight = Float.parseFloat(weightEditText.getText().toString());
        mLatestBmiResult = weight / (height/100 * height/100);
        TextView bmiTextView = findViewById(R.id.bmiTextView);
        bmiTextView.setText("" + mLatestBmiResult);

    }


    public void goToSettings(View view) {
        Intent intent = new Intent(this, WeatherActivity.class);
        startActivity( intent);
    }

    public void goToInfo(View view) {
        Intent intent3 = new Intent(this, Activity3.class);
        startActivity(intent3);
    }
}