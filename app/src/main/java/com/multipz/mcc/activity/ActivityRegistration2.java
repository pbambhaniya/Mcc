package com.multipz.mcc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.multipz.mcc.R;
import com.multipz.mcc.utils.BasicMethods;

/**
 * Created by Admin on 23-11-2017.
 */

public class ActivityRegistration2 extends AppCompatActivity implements BasicMethods {

    Context context;

    Button btnUploadDoc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);

        context = this;

        initReferences();
        initialize();
    }

    @Override
    public void initReferences() {

        btnUploadDoc = (Button) findViewById(R.id.btn_upload_doc);
    }

    @Override
    public void initialize() {

        btnUploadDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,ActivityMenu.class));
            }
        });
    }
}