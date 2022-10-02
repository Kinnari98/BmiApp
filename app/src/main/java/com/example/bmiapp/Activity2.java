package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
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

    public void BackToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("WEIGHT_UNIT", "lbs");
        startActivity( intent );


    }
}