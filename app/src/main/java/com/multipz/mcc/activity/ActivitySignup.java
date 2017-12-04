package com.multipz.mcc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.mukesh.countrypicker.fragments.CountryPicker;
import com.mukesh.countrypicker.interfaces.CountryPickerListener;
import com.multipz.mcc.R;
import com.multipz.mcc.utils.BasicMethods;

/**
 * Created by Admin on 23-11-2017.
 */

public class ActivitySignup extends AppCompatActivity implements BasicMethods{

    Context context;

    Spinner spn_prefix;
    EditText edt_name, edt_mobile_no, edt_otp;
    TextView txt_verify;
    Button btn_signup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        context = this;

        initReferences();
        initialize();
        initCountry();
    }

    private void initCountry() {

        final CountryPicker picker = CountryPicker.newInstance("Select Country");  // dialog title

        findViewById(R.id.lnr_country).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picker.show(getSupportFragmentManager(), "COUNTRY_PICKER");
            }
        });

        final TextView txt_country_code = (TextView) findViewById(R.id.txt_country_code);
        final AppCompatImageView img_country_flag = (AppCompatImageView) findViewById(R.id.img_country_flag);


        picker.setListener(new CountryPickerListener() {
            @Override
            public void onSelectCountry(String name, String code, String dialCode, int flagDrawableResID) {
                // Implement your code here
                txt_country_code.setText(dialCode);
                img_country_flag.setImageResource(flagDrawableResID);
                picker.dismiss();
            }
        });
    }

    @Override
    public void initReferences() {

        btn_signup = (Button) findViewById(R.id.btn_signup);
    }

    @Override
    public void initialize() {

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, ActivityRegistration.class));
            }
        });

        findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
