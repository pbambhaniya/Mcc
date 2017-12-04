package com.multipz.mcc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.multipz.mcc.R;
import com.multipz.mcc.utils.BasicMethods;

/**
 * Created by Admin on 23-11-2017.
 */

public class ActivityRegistration extends AppCompatActivity implements BasicMethods{

    Context context;

    ImageView img_profile, img_profile_upload;
    Spinner spn_specialization, spn_sub_category, spn_qualification, spn_experience;
    EditText edt_regi_no, edt_hospital_name, edt_hospital_address;
    Button btnNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        context = this;

        initReferences();
        initialize();
    }

    @Override
    public void initReferences() {

        img_profile = (ImageView) findViewById(R.id.img_profile);
        img_profile_upload = (ImageView) findViewById(R.id.img_profile_upload);

        spn_specialization = (Spinner) findViewById(R.id.spn_specialization);
        spn_sub_category = (Spinner) findViewById(R.id.spn_sub_category);
        spn_qualification = (Spinner) findViewById(R.id.spn_qualification);
        spn_experience = (Spinner) findViewById(R.id.spn_experience);

        edt_regi_no = (EditText) findViewById(R.id.edt_regi_no);
        edt_hospital_name = (EditText) findViewById(R.id.edt_hospital_name);
        edt_hospital_address = (EditText) findViewById(R.id.edt_hospital_address);

        btnNext = (Button) findViewById(R.id.btn_next_step);
    }

    @Override
    public void initialize() {

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,ActivityRegistration1.class));
            }
        });
    }
}
