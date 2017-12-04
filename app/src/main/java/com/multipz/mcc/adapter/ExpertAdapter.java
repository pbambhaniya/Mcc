package com.multipz.mcc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.multipz.mcc.R;
import com.multipz.mcc.model.ExpertModel;
import com.multipz.mcc.model.NotificationModel;

import java.util.List;

/**
 * Created by Admin on 25-11-2017.
 */

public class ExpertAdapter extends RecyclerView.Adapter<ExpertAdapter.MyViewHolder> {

    private List<ExpertModel> expertsList;

    private ClickListener clickListener;

    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtName, txtExpertIn, txtExperiense, txtFollow;
        public ImageView imgProfile;

        public MyViewHolder(View view) {
            super(view);
            txtName = (TextView) view.findViewById(R.id.txt_expert_name);
            txtExpertIn = (TextView) view.findViewById(R.id.txt_expert_in);
            txtExperiense = (TextView) view.findViewById(R.id.txt_experiense);
            txtFollow = (TextView) view.findViewById(R.id.txt_follow);
            imgProfile = (ImageView) view.findViewById(R.id.img_dp);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public ExpertAdapter(List<ExpertModel> expertsList) {
        this.expertsList = expertsList;
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_expert_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ExpertModel notification = expertsList.get(position);
        holder.txtName.setText(notification.getName());
        holder.txtExpertIn.setText(notification.getExpertIn());
        holder.txtExperiense.setText(notification.getExperiense());
    }

    @Override
    public int getItemCount() {
        return expertsList.size();
    }
}
