package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherActivity extends AppCompatActivity  {

   private String mUrl = "https://api.openweathermap.org/data/2.5/weather?lat=61&lon=23&appid=40bb658a709ebb7b1c210655e7f5cfe6&units=metric";
   private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        mQueue = Volley.newRequestQueue(this);

    }


    public void fetchWeatherData(View view) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, mUrl, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                        parseJsonAndUpdateUi(response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        mQueue.add(jsonObjectRequest);

    }
    private void parseJsonAndUpdateUi(JSONObject weatherObject) {
        TextView TemperatureTextView = (TextView) findViewById(R.id.TemperatureTextView);
        TextView WindTextView = (TextView) findViewById(R.id.WindTextView);
        TextView WeatherTextView = (TextView) findViewById(R.id.CurrentWeatherView);
        try {
            double temperature = weatherObject.getJSONObject("main").getDouble("temp");
            TemperatureTextView.setText("" + temperature + " C");
            double wind = weatherObject.getJSONObject("wind").getDouble("speed");
            WindTextView.setText("" + wind + " m/s");
            Double humidity = weatherObject.getJSONObject("main").getDouble("humidity");
            WeatherTextView.setText("" + humidity + "" );
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}