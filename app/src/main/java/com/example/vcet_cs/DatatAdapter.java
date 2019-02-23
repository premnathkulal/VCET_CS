package com.example.vcet_cs;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class DatatAdapter extends RecyclerView.Adapter<DatatAdapter.ProductViewHolder> {
    private Context mCtx;
    private List<pro_data> productList;
    public TextView textv;
    public String topic;

    public DatatAdapter(Context mCtx, List<pro_data> productList ,String str) {
        this.mCtx = mCtx;
        this.productList = productList;
        this.topic = str;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.data_list, null);

        textv = view.findViewById(R.id.textViewRating);

        return new ProductViewHolder(view);

    }


    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        pro_data product = productList.get(position);

        if(topic.equals("notes")) {
            holder.textViewTitle.setText(" MODULE - " + product.getSem());
        }else{
            holder.textViewTitle.setText(" YEAR : " + product.getSem());
        }

        holder.textViewShortDesc.setText("SUBJECT-CODE : "+product.getPdfName());
        holder.textViewRating.setText(String.valueOf(product.getPdfURL()));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);

        }
    }


}
