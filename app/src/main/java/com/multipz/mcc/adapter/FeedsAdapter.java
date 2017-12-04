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
import com.multipz.mcc.model.ExpertModel;
import com.multipz.mcc.model.FeedsModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Admin on 25-11-2017.
 */

public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.MyViewHolder> {

    private List<FeedsModel> data;
    private Context context;
    private ClickListener clickListener;

    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtName, txtTime, txtLike;
        public ImageView imgProfile, imgFeed;
        public LinearLayout lnrLike, lnrComment, lnrShare;

        public MyViewHolder(View view) {
            super(view);
            txtName = (TextView) view.findViewById(R.id.txt_name);
            txtTime = (TextView) view.findViewById(R.id.txt_time);
            txtLike = (TextView) view.findViewById(R.id.txt_like);
            imgProfile = (ImageView) view.findViewById(R.id.img_dp);
            imgFeed = (ImageView) view.findViewById(R.id.img_feed);
            lnrLike = (LinearLayout) view.findViewById(R.id.lnr_like);
            lnrComment = (LinearLayout) view.findViewById(R.id.lnr_comment);
            lnrShare = (LinearLayout) view.findViewById(R.id.lnr_share);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public FeedsAdapter(List<FeedsModel> data, Context context) {
        this.data= data;
        this.context = context;
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_feeds, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FeedsModel itemData = data.get(position);
        holder.txtName.setText(itemData.getName());

        Picasso.with(context).load(R.drawable.ic_def_dp).into(holder.imgProfile);
        Picasso.with(context).load(R.drawable.ic_def_feed).into(holder.imgFeed);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
