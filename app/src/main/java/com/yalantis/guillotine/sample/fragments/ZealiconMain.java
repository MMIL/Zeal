package com.yalantis.guillotine.sample.fragments;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yalantis.guillotine.sample.R;
import com.yalantis.guillotine.sample.activity.Register;
import com.yalantis.guillotine.sample.activity.RegisterTry;

/**
 * Created by my hp on 3/30/2016.
 */
public class ZealiconMain extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.homepage,container,false);
        TextView tv=(TextView)v.findViewById(R.id.text_about);
        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(), "playsir.otf");
        tv.setTypeface(custom_font);
v.findViewById(R.id.imageview_register).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), Register.class);
        startActivity(intent);
    }
});
        TextView tv_extravaganza=(TextView)v.findViewById(R.id.tv_extravaganza);
        Typeface custom_font_extravaganza = Typeface.createFromAsset(getActivity().getAssets(), "huggable.ttf");
        tv_extravaganza.setTypeface(custom_font_extravaganza);
        LinearLayout ll=(LinearLayout)v.findViewById(R.id.zealid_linear);
        String s=getActivity().getSharedPreferences("zealiconid",0).getString("zealid","hp");
        if(s.equals("hp")){
            ll.setVisibility(View.INVISIBLE);
        }
        else {
            TextView tvzeal=(TextView)v.findViewById(R.id.main_zealid);
            tvzeal.setText("Your Zealicon Id is "+s);
            tvzeal.setTypeface(custom_font_extravaganza);
            ll.setVisibility(View.VISIBLE);
        }

        return v;
    }
}
