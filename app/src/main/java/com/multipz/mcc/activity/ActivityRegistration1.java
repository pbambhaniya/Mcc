package com.multipz.mcc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.multipz.mcc.R;
import com.multipz.mcc.utils.BasicMethods;

/**
 * Created by Admin on 23-11-2017.
 */

public class ActivityRegistration1 extends AppCompatActivity implements BasicMethods {

    Context context;

    EditText edt_regi_no;
    Button btnNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration1);

        context = this;

        initReferences();
        initialize();
    }

    @Override
    public void initReferences() {

        btnNext = (Button) findViewById(R.id.btn_next_step);
    }

    @Override
    public void initialize() {

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,ActivityRegistration2.class));
            }
        });
    }
}
