package com.example.stephanie.bem_vindos_a_ua_official;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Stephanie on 09/06/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    ArrayList<Edificio> arrayList = new ArrayList<>();
    private Context ctx;

    RecyclerAdapter(ArrayList<Edificio> arrayList, Context ctx) {
        this.arrayList = arrayList;
        this.ctx = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view, ctx, arrayList);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.c_name.setText(arrayList.get(position).getName());

        //implement click listener
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
//        //        Snackbar.make(v, arrayList.get(position).getName(), Snackbar.LENGTH_SHORT).show();
                Intent launchVforum = new Intent(ctx, detailsEdificios.class);
                launchVforum.putExtra("name", arrayList.get(position).getName());
                ctx.startActivity(launchVforum);
            }
        });
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView c_name;
    ArrayList<Edificio> arrayList, newlist;
    Context ctx;
    ItemClickListener itemClickListener;

        public MyViewHolder(View itemView, Context ctx, ArrayList<Edificio> arrayList) {
            super(itemView);
            this.arrayList = arrayList;
            this.ctx = ctx;
            c_name = (TextView) itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
//        int position = getAdapterPosition();
//        Edificio edificio = this.arrayList.get(position);
//        Intent intent = new Intent(this.ctx, detailsEdificios.class);
//        intent.putExtra("name", edificio.getName());
//        this.ctx.startActivity(intent);
        this.itemClickListener.onItemClick(v, getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener ic) {
            this.itemClickListener = ic;
        }
    }

    public void setFilter(ArrayList<Edificio> newList){
        arrayList = new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();

    }


}
