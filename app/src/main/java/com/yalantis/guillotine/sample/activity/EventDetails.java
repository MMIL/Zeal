package com.yalantis.guillotine.sample.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;


import com.yalantis.guillotine.sample.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by my hp on 3/31/2016.
 */
public class EventDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventdetails);
        Toolbar t=(Toolbar)findViewById(R.id.toolbar_eventdetails);
        setSupportActionBar(t);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toast.makeText(EventDetails.this, "position"+getIntent().getExtras().getInt("pos",0), Toast.LENGTH_SHORT).show();
        TextView name=(TextView)findViewById(R.id.text_event_details_name);
        TextView description=(TextView)findViewById(R.id.text_event_details_description);
        TextView first=(TextView)findViewById(R.id.text_event_details_firstprize);
        TextView second=(TextView)findViewById(R.id.text_event_details_secondprize);
        TextView contact=(TextView)findViewById(R.id.text_event_details_contact);
        SharedPreferences sf=getSharedPreferences("events",0);
        int position=getIntent().getExtras().getInt("pos",0);
        try {
            JSONArray ja=new JSONArray(sf.getString("eventsjson","none"));
            JSONObject jo=ja.getJSONObject(position);
            name.setText(jo.getString("event_name"));
            description.setText(jo.getString("event_description"));
            first.setText(jo.getString("1st_place"));
            second.setText(jo.getString("2nd_place"));
            contact.setText(jo.getString("contact"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
