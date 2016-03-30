package com.yalantis.guillotine.sample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yalantis.guillotine.sample.R;

/**
 * Created by my hp on 3/30/2016.
 */
public class Tryit extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.tryitnew,container,false);

        return v;
    }
}
