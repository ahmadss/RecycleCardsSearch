package com.androidlokomedia.recyclecardssearch;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;

/**
 * Created by ahmad on 24/12/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> implements Filterable {
    Context ctx;
    ArrayList<Tokoh> tokohs, filterList;
    CustomFilter customFilter;

    public MyAdapter(Context context, ArrayList<Tokoh> tokohs) {
        this.ctx = context;
        this.tokohs = tokohs;
        this.filterList = tokohs;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //CONVER XML KE VIEW OBJ
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model, null);

        //HOLDER
        MyHolder holder = new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        //BIND DATA
        holder.perText.setText(tokohs.get(position).getPer());
        holder.namaText.setText(tokohs.get(position).getNama());
        holder.imageView.setImageResource(tokohs.get(position).getImg());

        //IMPLEMENT CLICK LISTENER
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int per) {
                Snackbar.make(view, tokohs.get(per).getNama(), Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    //GET TOTAL NUM OF TOKOH
    @Override
    public int getItemCount() {
        return tokohs.size();
    }

    //RETURN FILTER
    @Override
    public Filter getFilter() {
        if (customFilter == null){
            customFilter = new CustomFilter(filterList, this);
        }
        return customFilter;
    }
}
