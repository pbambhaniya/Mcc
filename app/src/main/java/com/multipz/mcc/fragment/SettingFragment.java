package com.multipz.mcc.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.multipz.mcc.R;
import com.multipz.mcc.activity.ActivityDevelopment;
import com.multipz.mcc.activity.ActivityNewsPreferences;

/**
 * Created by Admin on 27-11-2017.
 */

public class SettingFragment extends Fragment{

    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_setting, container, false);

        context = getActivity();

        rootView.findViewById(R.id.rlt_profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, ActivityDevelopment.class));
            }
        });

        rootView.findViewById(R.id.rlt_preferences).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, ActivityNewsPreferences.class));
            }
        });

        rootView.findViewById(R.id.rlt_policy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, ActivityDevelopment.class));
            }
        });

        rootView.findViewById(R.id.rlt_terms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, ActivityDevelopment.class));
            }
        });

        rootView.findViewById(R.id.rlt_about).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, ActivityDevelopment.class));
            }
        });

        return rootView;
    }
}
