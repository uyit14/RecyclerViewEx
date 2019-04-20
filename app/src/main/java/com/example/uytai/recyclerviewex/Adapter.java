package com.example.uytai.recyclerviewex;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by uytai on 11/7/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList<Data> data;
    Context context;

    public Adapter(ArrayList<Data> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public void RemoveItem(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(data.get(position).getName());
        holder.image.setImageResource(data.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_item);
            image = itemView.findViewById(R.id.img_item);
        }

    }
}
