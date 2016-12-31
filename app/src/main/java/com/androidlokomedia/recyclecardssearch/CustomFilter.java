package com.androidlokomedia.recyclecardssearch;

import android.widget.Filter;

import java.util.ArrayList;

/**
 * Created by ahmad on 24/12/2016.
 */
public class CustomFilter extends Filter {

    MyAdapter adapter;
    ArrayList<Tokoh> filterList;


    public CustomFilter(ArrayList<Tokoh> filterList, MyAdapter adapter) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        //CHECK CONSTRAIN VALIDITY
        if (constraint != null && constraint.length() > 0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<Tokoh> filterTokoh = new ArrayList<>();

            for (int i = 0; i < filterList.size();i++){
                //CHECK
                if (filterList.get(i).getNama().toUpperCase().contains(constraint)){
//                    Tokoh t = new Tokoh();
                    //tambah tokoh ke filter tokoh
                    filterTokoh.add(filterList.get(i));
                }
            }

            results.count = filterTokoh.size();
            results.values = filterTokoh;
        } else {
            results.count = filterList.size();
            results.values = filterList;
        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.tokohs = (ArrayList<Tokoh>) results.values;

        //REFRESH
        adapter.notifyDataSetChanged();
    }
}
