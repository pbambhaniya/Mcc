package com.multipz.mcc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.multipz.mcc.R;
import com.multipz.mcc.model.FeedsModel;
import com.multipz.mcc.model.StoryModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Admin on 25-11-2017.
 */

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.MyViewHolder> {

    private List<StoryModel> data;
    private Context context;
    private ClickListener clickListener;

    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView imgProfile;
        public View viewDivider;

        public MyViewHolder(View view) {
            super(view);
            imgProfile = (ImageView) view.findViewById(R.id.img_dp);
            viewDivider = view.findViewById(R.id.view_divider);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public StoryAdapter(List<StoryModel> data, Context context) {
        this.data= data;
        this.context = context;
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_story, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        StoryModel itemData = data.get(position);
        //holder.txtName.setText(itemData.getName());

        if (position == 0){
            holder.viewDivider.setVisibility(View.VISIBLE);
        }else{
            holder.viewDivider.setVisibility(View.GONE);
        }

        Picasso.with(context).load(R.drawable.ic_def_story).into(holder.imgProfile);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
