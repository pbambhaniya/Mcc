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
import com.multipz.mcc.activity.ActivityProduct;
import com.multipz.mcc.adapter.ExpertInAdapter;
import com.multipz.mcc.adapter.ShopAdapter;
import com.multipz.mcc.model.ExpertInModel;
import com.multipz.mcc.model.ShopModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 27-11-2017.
 */

public class ShopFragment extends Fragment{

    Context context;
    RecyclerView recyclerProduct, recyclerView;
    ShopAdapter adapter;
    ExpertInAdapter productAdapter;
    private List<ShopModel> data = new ArrayList<>();
    private List<ExpertInModel> expertInList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shop, container, false);

        context = getActivity();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerProduct = (RecyclerView) rootView.findViewById(R.id.recycler_product);

        initProduct();
        initShop();


        return rootView;
    }

    private void initProduct() {
        productAdapter = new ExpertInAdapter(expertInList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerProduct.setLayoutManager(mLayoutManager);
        recyclerProduct.setItemAnimator(new DefaultItemAnimator());
        recyclerProduct.setAdapter(productAdapter);
        productAdapter.setClickListener(new itemInClickListener());
        prepareProduct();
    }

    private void prepareProduct() {
        expertInList.add(new ExpertInModel(1, "Doctore", true));
        expertInList.add(new ExpertInModel(2, "Nutriouist", false));
        expertInList.add(new ExpertInModel(3, "Dieticion", false));

        productAdapter.notifyDataSetChanged();
    }

    private void initShop() {
        adapter = new ShopAdapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(new itemClickListener());
        prepareNotificationData();
    }

    class itemInClickListener implements ExpertInAdapter.ClickListener {

        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
        }
    }

    class itemClickListener implements ShopAdapter.ClickListener {

        @Override
        public void onItemClick(View view, int position) {
            //Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(context, ActivityProduct.class));
        }
    }

    private void prepareNotificationData() {

        data.add(new ShopModel("Product","","desc",1.5));
        data.add(new ShopModel("Product","","desc",2.5));
        data.add(new ShopModel("Product","","desc",1));
        data.add(new ShopModel("Product","","desc",3.5));


        adapter.notifyDataSetChanged();
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
