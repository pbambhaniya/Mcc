package com.multipz.mcc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.multipz.mcc.R;

/**
 * Created by Admin on 22-11-2017.
 */

public class ActivitySplash extends AppCompatActivity{

    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        context = this;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(context, ActivityLogin.class));
                finish();
            }
        }, 1000);
    }
}
