package com.multipz.mcc.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.multipz.mcc.R;
import com.multipz.mcc.adapter.PreferencesAdapter;
import com.multipz.mcc.model.PreferencesModel;

import java.util.ArrayList;

/**
 * Created by Admin on 27-11-2017.
 */

public class ActivityNewsPreferences extends AppCompatActivity{

    ArrayList<PreferencesModel> data = new ArrayList<>();
    Context context;
    RecyclerView recyclerView;
    PreferencesAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_preferences);

        context = this;

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        adapter = new PreferencesAdapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(new itemClickListener());

        prepareNotificationData();


        findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    class itemClickListener implements PreferencesAdapter.ClickListener {

        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
        }
    }

    private void prepareNotificationData() {

        data.add(new PreferencesModel("Doctore", true));
        data.add(new PreferencesModel("Doctore", false));
        data.add(new PreferencesModel("Doctore", false));
        data.add(new PreferencesModel("Doctore", true));

        adapter.notifyDataSetChanged();
    }
}
