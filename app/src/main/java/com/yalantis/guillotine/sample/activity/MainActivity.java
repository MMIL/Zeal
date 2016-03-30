package com.yalantis.guillotine.sample.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.yalantis.guillotine.animation.GuillotineAnimation;
import com.yalantis.guillotine.sample.R;
import com.yalantis.guillotine.sample.fragments.ZealiconMain;
import com.yalantis.guillotine.sample.fragments.Events;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Dmytro Denysenko on 5/4/15.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final long RIPPLE_DURATION = 250;


    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.root)
    FrameLayout root;
    @InjectView(R.id.content_hamburger)
    View contentHamburger;

    GuillotineAnimation g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        ButterKnife.inject(this);


        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }

        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        guillotineMenu.findViewById(R.id.profile_group).setOnClickListener(this);
        root.addView(guillotineMenu);
        ZealiconMain p=new ZealiconMain();
        FragmentManager f=getSupportFragmentManager();
        f.beginTransaction().add(R.id.fragment_container,p).commit();
        g=new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();
    }

    @Override
    public void onClick(View v) {
        Events p=new Events();
android.support.v4.app.FragmentTransaction f=getSupportFragmentManager().beginTransaction();
       f .replace(R.id.fragment_container, p);
        f.addToBackStack(null);
        f.commit();
        g.close();
    }
}
