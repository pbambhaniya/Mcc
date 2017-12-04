package com.multipz.mcc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.multipz.mcc.R;
import com.multipz.mcc.model.ExpertModel;
import com.multipz.mcc.model.ShopModel;

import java.util.List;

/**
 * Created by Admin on 25-11-2017.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder> {

    private List<ShopModel> data;

    private ClickListener clickListener;

    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtName, txtDesc;
        public RatingBar ratingBar;
        public ImageView imgProduct, impCart;

        public MyViewHolder(View view) {
            super(view);
            txtName = (TextView) view.findViewById(R.id.txt_product_name);
            txtDesc = (TextView) view.findViewById(R.id.txt_product_desc);
            ratingBar = (RatingBar) view.findViewById(R.id.rating);
            impCart = (ImageView) view.findViewById(R.id.img_cart);
            imgProduct = (ImageView) view.findViewById(R.id.img_product);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public ShopAdapter(List<ShopModel> data) {
        this.data = data;
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shop, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ShopModel shopModel = data.get(position);
        holder.txtName.setText(shopModel.getName());
        holder.txtDesc.setText(shopModel.getDesc());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
