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
import android.widget.TextView;
import android.widget.Toast;

import com.multipz.mcc.R;
import com.multipz.mcc.activity.ActivityAddInquiry;
import com.multipz.mcc.activity.ActivityPost;
import com.multipz.mcc.activity.ActivityStoryView;
import com.multipz.mcc.adapter.ExpertAdapter;
import com.multipz.mcc.adapter.ExpertInAdapter;
import com.multipz.mcc.adapter.FeedsAdapter;
import com.multipz.mcc.adapter.StoryAdapter;
import com.multipz.mcc.model.ExpertInModel;
import com.multipz.mcc.model.ExpertModel;
import com.multipz.mcc.model.FeedsModel;
import com.multipz.mcc.model.StoryModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 24-11-2017.
 */

public class FeedsFragment extends Fragment {

    Context context;
    TextView txtCreatePost;
    RecyclerView recyclerStory, recyclerFeeds;
    FeedsAdapter feedsAdapter;
    StoryAdapter storyAdapter;
    private List<FeedsModel> dataFeed = new ArrayList<>();
    private List<StoryModel> dataStory = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_feed, container, false);

        context = getActivity();

        txtCreatePost = rootView.findViewById(R.id.txt_whatinmind);
        recyclerFeeds = (RecyclerView) rootView.findViewById(R.id.recycler_feeds);
        recyclerStory = (RecyclerView) rootView.findViewById(R.id.recycler_stories);

        initStory();
        initFeed();

        txtCreatePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, ActivityPost.class));
            }
        });

        return rootView;
    }

    private void initStory() {
        storyAdapter = new StoryAdapter(dataStory, context);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerStory.setLayoutManager(mLayoutManager);
        recyclerStory.setItemAnimator(new DefaultItemAnimator());
        recyclerStory.setAdapter(storyAdapter);
        storyAdapter.setClickListener(new itemStoryClickListener());
        prepareStory();
    }

    private void initFeed() {
        feedsAdapter = new FeedsAdapter(dataFeed, context);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerFeeds.setLayoutManager(mLayoutManager);
        recyclerFeeds.setItemAnimator(new DefaultItemAnimator());
        recyclerFeeds.setAdapter(feedsAdapter);
        //recyclerFeeds.setNestedScrollingEnabled(false);
        feedsAdapter.setClickListener(new itemFeedClickListener());
        prepareFeeds();
    }

    class itemFeedClickListener implements FeedsAdapter.ClickListener {

        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(context, "" + position, Toast.LENGTH_SHORT).show();
        }
    }

    class itemStoryClickListener implements StoryAdapter.ClickListener {

        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(context, "" + position, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(context, ActivityStoryView.class));
        }
    }

    private void prepareStory() {
        for (int i=0; i<15; i++) {
            dataStory.add(new StoryModel(""));
        }
        storyAdapter.notifyDataSetChanged();
    }

    private void prepareFeeds() {

        dataFeed.add(new FeedsModel(1, "", "", "Ashish", "1 hour Ago", "1000"));
        dataFeed.add(new FeedsModel(2, "", "", "Class", "3 hour Ago", "200"));
        dataFeed.add(new FeedsModel(3, "", "", "Boy", "2 hour Ago", "100"));
        dataFeed.add(new FeedsModel(3, "", "", "Boy", "2 hour Ago", "100"));
        dataFeed.add(new FeedsModel(3, "", "", "Boy", "2 hour Ago", "100"));
        dataFeed.add(new FeedsModel(3, "", "", "Boy", "2 hour Ago", "100"));
        dataFeed.add(new FeedsModel(3, "", "", "Boy", "2 hour Ago", "100"));
        dataFeed.add(new FeedsModel(3, "", "", "Boy", "2 hour Ago", "100"));

        feedsAdapter.notifyDataSetChanged();
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
