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
import com.multipz.mcc.activity.ActivityAddInquiry;
import com.multipz.mcc.adapter.NotificationAdapter;
import com.multipz.mcc.model.NotificationModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 25-11-2017.
 */

public class InquiryFragment extends Fragment{

    Context context;
    RecyclerView recyclerView;
    NotificationAdapter mAdapter;
    private List<NotificationModel> movieList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notification, container, false);

        context = getActivity();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        mAdapter = new NotificationAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.setClickListener(new itemClickListener());

        prepareNotificationData();


        return rootView;
    }

    class itemClickListener implements NotificationAdapter.ClickListener{

        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
        }
    }

    private void prepareNotificationData() {

        movieList.add(new NotificationModel("","Hello","5 hour ago"));
        movieList.add(new NotificationModel("","Hello2","2 hour ago"));
        movieList.add(new NotificationModel("","Hello3      ","4 hour ago"));

        mAdapter.notifyDataSetChanged();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add_inquiry, menu);  // Use filter.xml from step 1
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_add_inquiry){
            //Do whatever you want to do
            startActivity(new Intent(context, ActivityAddInquiry.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
