package com.multipz.mcc.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.multipz.mcc.R;
import com.multipz.mcc.activity.ActivityExpertDetail;
import com.multipz.mcc.adapter.ExpertAdapter;
import com.multipz.mcc.adapter.ExpertInAdapter;
import com.multipz.mcc.adapter.NotificationAdapter;
import com.multipz.mcc.model.ExpertInModel;
import com.multipz.mcc.model.ExpertModel;
import com.multipz.mcc.model.NotificationModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 25-11-2017.
 */

public class ExpertFragment extends Fragment{

    Context context;
    RecyclerView recyclerExperts, recyclerIn;
    ExpertAdapter mExpertAdapter;
    ExpertInAdapter mExpertInAdapter;
    private List<ExpertModel> expertList = new ArrayList<>();
    private List<ExpertInModel> expertInList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_expert, container, false);

        context = getActivity();

        recyclerExperts = (RecyclerView) rootView.findViewById(R.id.recycler_experts);
        recyclerIn = (RecyclerView) rootView.findViewById(R.id.recycler_expert_in);

        initExpertIn();
        initExperts();


        return rootView;
    }

    private void initExpertIn() {
        mExpertInAdapter = new ExpertInAdapter(expertInList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerIn.setLayoutManager(mLayoutManager);
        recyclerIn.setItemAnimator(new DefaultItemAnimator());
        recyclerIn.setAdapter(mExpertInAdapter);
        mExpertInAdapter.setClickListener(new itemInClickListener());
        prepareExpertIn();
    }

    private void prepareExpertIn() {
        expertInList.add(new ExpertInModel(1, "Doctore", true));
        expertInList.add(new ExpertInModel(2, "Nutriouist", false));
        expertInList.add(new ExpertInModel(3, "Dieticion", false));

        mExpertInAdapter.notifyDataSetChanged();
    }

    private void initExperts() {
        mExpertAdapter = new ExpertAdapter(expertList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerExperts.setLayoutManager(mLayoutManager);
        recyclerExperts.setItemAnimator(new DefaultItemAnimator());
        recyclerExperts.setAdapter(mExpertAdapter);
        mExpertAdapter.setClickListener(new itemClickListener());
        prepareNotificationData();
    }

    class itemInClickListener implements ExpertInAdapter.ClickListener {

        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
        }
    }

    class itemClickListener implements ExpertAdapter.ClickListener {

        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(context, ActivityExpertDetail.class));
        }
    }

    private void prepareNotificationData() {

        expertList.add(new ExpertModel(1,"","Test1","Doc","1Year",false));
        expertList.add(new ExpertModel(1,"","Test2","Doc","1Year",false));
        expertList.add(new ExpertModel(2,"","Test3","Doc","1Year",false));
        expertList.add(new ExpertModel(3,"","Test4","Doc","1Year",true));
        expertList.add(new ExpertModel(3,"","Test5","Doc","1Year",true));


        expertList.add(new ExpertModel(2,"","Test3","Doc","1Year",false));
        expertList.add(new ExpertModel(3,"","Test4","Doc","1Year",true));
        expertList.add(new ExpertModel(3,"","Test5","Doc","1Year",true));
        expertList.add(new ExpertModel(2,"","Test3","Doc","1Year",false));
        expertList.add(new ExpertModel(3,"","Test4","Doc","1Year",true));
        expertList.add(new ExpertModel(3,"","Test5","Doc","1Year",true));
        expertList.add(new ExpertModel(2,"","Test3","Doc","1Year",false));
        expertList.add(new ExpertModel(3,"","Test4","Doc","1Year",true));
        expertList.add(new ExpertModel(3,"","Test5","Doc","1Year",true));
        expertList.add(new ExpertModel(2,"","Test3","Doc","1Year",false));
        expertList.add(new ExpertModel(3,"","Test4","Doc","1Year",true));
        expertList.add(new ExpertModel(3,"","Test5","Doc","1Year",true));

        mExpertAdapter.notifyDataSetChanged();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);  // Use filter.xml from step 1
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_search){
            //Do whatever you want to do
            Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
