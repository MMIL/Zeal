package com.yalantis.guillotine.sample.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
        int position=getIntent().getExtras().getInt("pos", 0);
        String token=getIntent().getExtras().getString("token","coderz");
        try {
            JSONArray ja=new JSONArray(sf.getString(token,"coderz"));
            JSONObject jo=ja.getJSONObject(position);
            String contact_number=null;
            if(jo.getString("contact").equals("")){
                contact_number="No contacts";

            }
            else {
                JSONArray contact_array = new JSONArray(jo.getString("contact"));
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < contact_array.length(); i++) {
                    JSONObject contact_details = contact_array.getJSONObject(i);
                    sb.append(contact_details.getString("name") + " : " + "\n");
                    sb.append("    " + contact_details.getString("number") + "\n");
                }
                contact_number=sb.toString();
            }
            Log.v("PRIZE_MONEY",jo.getString("prize_money"));
                String firstprize="No Idea";
                String secondprize="No Idea";
                if(jo.getString("prize_money").equals("null")){
                    firstprize="No Idea";
                    secondprize="No Idea";
                }
                else {
                    JSONArray prizearray=new JSONArray(jo.getString("prize_money"));
                    firstprize=prizearray.getString(0);
                    secondprize=prizearray.getString(1);
                }



            name.setText(jo.getString("event_name"));
            description.setText(jo.getString("event_description"));
            first.setText(firstprize);
            second.setText(secondprize);
            contact.setText(contact_number);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
