package com.yalantis.guillotine.sample.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.yalantis.guillotine.sample.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by my hp on 3/30/2016.
 */
public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        requestjson();
    }

    private void requestjson() {
        final String url="http://zealbo.hackncs.com/events/";

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
       //Coderz
       final StringRequest stringRequestcoderz = new StringRequest(Request.Method.GET, url+"0",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.v("MyApp", response);
                        SharedPreferences s=getSharedPreferences("events",0);
                        s.edit().putString("coderz",response).apply();
Intent in =new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(in);


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        Log.v("MyApp",error.toString());
                        Intent in=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(in);
                    }
                });
//Playiton
       final StringRequest stringRequestplayiton = new StringRequest(Request.Method.GET, url+"1",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.v("MyApp", response);
                        SharedPreferences s=getSharedPreferences("events",0);
                        s.edit().putString("playiton",response).apply();
                        requestQueue.add(stringRequestcoderz);


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        Log.v("MyApp",error.toString());
                        Intent in=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(in);
                    }
                });
//Mechavoltz
        final StringRequest stringRequestmechavoltz = new StringRequest(Request.Method.GET, url+"2",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.v("MyApp", response);
                        SharedPreferences s=getSharedPreferences("events",0);
                        s.edit().putString("mechavoltz",response).apply();
                        requestQueue.add(stringRequestplayiton);


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        Log.v("MyApp",error.toString());
                        Intent in=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(in);
                    }
                });
//robotiles
        final StringRequest stringRequestrobotiles = new StringRequest(Request.Method.GET, url+"3",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.v("MyApp", response);
                        SharedPreferences s=getSharedPreferences("events",0);
                        s.edit().putString("robotiles",response).apply();
                        requestQueue.add(stringRequestmechavoltz);


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        Log.v("MyApp",error.toString());
                        Intent in=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(in);
                    }
                });
        //coloralo
        final StringRequest stringRequestcoloralo = new StringRequest(Request.Method.GET, url+"4",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.v("MyApp", response);
                        SharedPreferences s=getSharedPreferences("events",0);
                        s.edit().putString("coloralo",response).apply();
                        requestQueue.add(stringRequestrobotiles);


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        Log.v("MyApp",error.toString());
                        Intent in=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(in);
                    }
                });
        //Z-Wars
      final StringRequest stringRequestzwars = new StringRequest(Request.Method.GET, url+"5",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.v("MyApp", response);
                        SharedPreferences s=getSharedPreferences("events",0);
                        s.edit().putString("zwars",response).apply();
                        requestQueue.add(stringRequestcoloralo);


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        Log.v("MyApp",error.toString());
                        Intent in=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(in);
                    }
                });
        //Adding the string request to the queue






        requestQueue.add(stringRequestzwars);

        int socketTimeout = 20000;//20 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequestcoderz.setRetryPolicy(policy);
        stringRequestplayiton.setRetryPolicy(policy);
        stringRequestmechavoltz.setRetryPolicy(policy);
        stringRequestrobotiles.setRetryPolicy(policy);
        stringRequestcoloralo.setRetryPolicy(policy);
        stringRequestzwars.setRetryPolicy(policy);

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
