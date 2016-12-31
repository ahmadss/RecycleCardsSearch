package com.androidlokomedia.recyclecardssearch;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ahmad on 24/12/2016.
 */
public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView imageView;
    TextView namaText, perText;

    ItemClickListener itemClickListener;

    public MyHolder(View itemView) {
        super(itemView);

        this.imageView = (ImageView) itemView.findViewById(R.id.tokohImage);
        this.namaText = (TextView)itemView.findViewById(R.id.namaText);
        this.perText = (TextView)itemView.findViewById(R.id.perText);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener = ic;
    }
}
