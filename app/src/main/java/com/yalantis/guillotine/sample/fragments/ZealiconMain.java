package com.yalantis.guillotine.sample.fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yalantis.guillotine.sample.R;

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

        TextView tv_extravaganza=(TextView)v.findViewById(R.id.tv_extravaganza);
        Typeface custom_font_extravaganza = Typeface.createFromAsset(getActivity().getAssets(), "huggable.ttf");
        tv_extravaganza.setTypeface(custom_font_extravaganza);

        return v;
    }
}
