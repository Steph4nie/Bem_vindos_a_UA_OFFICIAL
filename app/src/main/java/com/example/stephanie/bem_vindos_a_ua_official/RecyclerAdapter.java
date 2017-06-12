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
    Context ctx;

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
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.c_name.setText(arrayList.get(position).getName());
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView c_name;
    ArrayList<Edificio> arrayList;
    Context ctx;

        public MyViewHolder(View itemView, Context ctx, ArrayList<Edificio> arrayList) {
            super(itemView);
            this.arrayList = arrayList;
            this.ctx = ctx;
            c_name = (TextView) itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        int position = getAdapterPosition();
        Edificio edificio = this.arrayList.get(position);
        Intent intent = new Intent(this.ctx, detailsEdificios.class);
        intent.putExtra("name", edificio.getName());
        this.ctx.startActivity(intent);
        }
    }

    public void setFilter(ArrayList<Edificio> newList) {
        arrayList = new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();
    }


}
