package com.multipz.mcc.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.multipz.mcc.R;

/**
 * Created by Admin on 27-11-2017.
 */

public class ActivityInquiryReq extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry_req);

        initReferences();
        initialize();
    }

    private void initReferences() {

    }

    private void initialize() {
        findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}