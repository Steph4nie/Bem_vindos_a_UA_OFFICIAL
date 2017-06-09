package com.example.stephanie.bem_vindos_a_ua_official;

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
    RecyclerAdapter(ArrayList<Edificio> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.c_name.setText(arrayList.get(position).getName());
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {
    TextView c_name;

        public MyViewHolder(View itemView) {
            super(itemView);

            c_name = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
