package com.multipz.mcc.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.multipz.mcc.R;
import com.multipz.mcc.adapter.ImgPagerAdapter;

/**
 * Created by Admin on 27-11-2017.
 */

public class ActivityProduct extends AppCompatActivity{

    ImgPagerAdapter adapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        adapter = new ImgPagerAdapter(this);

        viewPager = (ViewPager) findViewById(R.id.img_pager);
        viewPager.setAdapter(adapter);


        findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
