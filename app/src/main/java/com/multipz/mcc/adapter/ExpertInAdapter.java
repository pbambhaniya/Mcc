package com.multipz.mcc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.multipz.mcc.R;
import com.multipz.mcc.model.ExpertInModel;
import com.multipz.mcc.model.ExpertModel;

import java.util.List;

/**
 * Created by Admin on 25-11-2017.
 */

public class ExpertInAdapter extends RecyclerView.Adapter<ExpertInAdapter.MyViewHolder> {

    private List<ExpertInModel> expertInList;

    private ClickListener clickListener;

    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtExpertIn;

        public MyViewHolder(View view) {
            super(view);
            txtExpertIn = (TextView) view.findViewById(R.id.txt_expert_in);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public ExpertInAdapter(List<ExpertInModel> expertInList) {
        this.expertInList = expertInList;
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_expert_in_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ExpertInModel expert = expertInList.get(position);
        holder.txtExpertIn.setText(expert.getExpertIn());

    }

    @Override
    public int getItemCount() {
        return expertInList.size();
    }
}
