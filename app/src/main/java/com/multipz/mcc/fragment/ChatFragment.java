package com.multipz.mcc.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.multipz.mcc.R;
import com.multipz.mcc.adapter.ChatUserAdapter;
import com.multipz.mcc.model.ChatUserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 27-11-2017.
 */

public class ChatFragment extends Fragment{

    Context context;
    RecyclerView recyclerView;
    ChatUserAdapter adapter;
    private List<ChatUserModel> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chat_user, container, false);

        context = getActivity();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        adapter = new ChatUserAdapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(new itemClickListener());

        prepareNotificationData();


        return rootView;
    }

    class itemClickListener implements ChatUserAdapter.ClickListener{

        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
        }
    }

    private void prepareNotificationData() {

        data.add(new ChatUserModel("Hello"));
        data.add(new ChatUserModel("Hello"));
        data.add(new ChatUserModel("Hello"));
        data.add(new ChatUserModel("Hello"));
        data.add(new ChatUserModel("Hello"));

        adapter.notifyDataSetChanged();
    }
}
