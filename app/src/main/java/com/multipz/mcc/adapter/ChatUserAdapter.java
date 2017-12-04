package com.multipz.mcc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.multipz.mcc.R;
import com.multipz.mcc.model.ChatUserModel;
import com.multipz.mcc.model.NotificationModel;

import java.util.List;

/**
 * Created by Admin on 25-11-2017.
 */

public class ChatUserAdapter extends RecyclerView.Adapter<ChatUserAdapter.MyViewHolder> {

    private List<ChatUserModel> data;

    private ClickListener clickListener;

    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtTitle, txtTime;
        public ImageView imgDp;

        public MyViewHolder(View view) {
            super(view);
            txtTitle = (TextView) view.findViewById(R.id.txt_expert_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public ChatUserAdapter(List<ChatUserModel> data) {
        this.data = data;
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat_user, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ChatUserModel chatUserModel = data.get(position);
        holder.txtTitle.setText(chatUserModel.getExpertName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
