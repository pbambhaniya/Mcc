package com.multipz.mcc.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.multipz.mcc.R;
import com.multipz.mcc.utils.BasicMethods;

/**
 * Created by Admin on 25-11-2017.
 */

public class ActivityPost extends AppCompatActivity implements BasicMethods, View.OnClickListener{

    Context context;

    BottomSheetBehavior behavior;
    CoordinatorLayout coordinatorLayout;

    ImageView imgOpen;

    String TAG = "Bottom Menu";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        context = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initReferences();
        initialize();
        initBottomSheet();
    }

    private void initBottomSheet() {
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);


        View bottomSheet = findViewById(R.id.bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                // React to state change
                switch (newState) {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        Log.d(TAG, "State Collapsed");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        Log.d(TAG, "State Dragging");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        Log.d(TAG, "State Expanded");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        Log.d(TAG, "State Hidden");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        Log.d(TAG, "State Settling");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // React to dragging events
            }
        });
    }

    @Override
    public void initReferences() {

        imgOpen = (ImageView) findViewById(R.id.img_open_menu);

        findViewById(R.id.img_close_menu).setOnClickListener(this);
        findViewById(R.id.lnr_feeling).setOnClickListener(this);
    }

    @Override
    public void initialize() {

        imgOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.img_close_menu:

                break;

            case R.id.lnr_photo:
                Toast.makeText(context, "Photo", Toast.LENGTH_SHORT).show();
                break;

            case R.id.lnr_feeling:
                Toast.makeText(context, "Feeling", Toast.LENGTH_SHORT).show();
                break;
        }

        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }
}
