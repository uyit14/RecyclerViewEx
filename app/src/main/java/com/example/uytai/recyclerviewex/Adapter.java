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
    ArrayList<Data> mDatas;
    Context context;
    private OnItemClickListener listener;

    public Adapter(ArrayList<Data> mDatas, Context context) {
        this.mDatas = mDatas;
        this.context = context;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void RemoveItem(int position){
        mDatas.remove(position);
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
        holder.txtName.setText(mDatas.get(position).getName());
        holder.image.setImageResource(mDatas.get(position).getImage());
        Data mData = mDatas.get(position);
        holder.setOnClick(listener, mData);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_item);
            image = itemView.findViewById(R.id.img_item);
        }

        public void setOnClick(final OnItemClickListener onClick, final Data data) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onClick != null) {
                        onClick.onItemClick(data, getAdapterPosition());
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Data data, int position);
    }
}
