package com.multipz.mcc.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.multipz.mcc.R;
import com.multipz.mcc.model.NotificationModel;
import com.multipz.mcc.model.PreferencesModel;

import java.util.List;

/**
 * Created by Admin on 25-11-2017.
 */

public class PreferencesAdapter extends RecyclerView.Adapter<PreferencesAdapter.MyViewHolder> {

    private List<PreferencesModel> data;

    private ClickListener clickListener;

    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtTitle;
        public SwitchCompat swtch;

        public MyViewHolder(View view) {
            super(view);
            txtTitle = (TextView) view.findViewById(R.id.txt);
            swtch = view.findViewById(R.id.swtch);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public PreferencesAdapter(List<PreferencesModel> data) {
        this.data = data;
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_preferences, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PreferencesModel item = data.get(position);
        holder.txtTitle.setText(item.getTitle());
        holder.swtch.setChecked(item.isChecked());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
