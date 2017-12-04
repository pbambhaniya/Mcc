package com.multipz.mcc.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.multipz.mcc.R;
import com.multipz.mcc.utils.BasicMethods;

public class ActivityUserType extends AppCompatActivity implements BasicMethods{

    Context context;

    RelativeLayout rltUser, rltSpecialist, rltSeller;
    TextView txtSignin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);

        context = this;

        initReferences();
        initialize();
    }

    @Override
    public void initReferences() {

        rltSeller = (RelativeLayout) findViewById(R.id.rlt_seller);
        rltSpecialist = (RelativeLayout) findViewById(R.id.rlt_specialist);
        rltUser = (RelativeLayout) findViewById(R.id.rlt_user);
        txtSignin = (TextView) findViewById(R.id.txt_signin);
    }

    @Override
    public void initialize() {

        rltUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, ActivitySignup.class));
            }
        });

        rltSpecialist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, ActivitySignup.class));
            }
        });

        rltSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, ActivitySignup.class));
            }
        });


        findViewById(R.id.img_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        txtSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
