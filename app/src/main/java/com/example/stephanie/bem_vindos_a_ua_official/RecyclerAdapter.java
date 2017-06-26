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
                if (arrayList.get(position).getName().equals("Department of Communication and the Arts")) {
                    Intent launchVforum = new Intent(ctx, detailsEdificios.class);
                    launchVforum.putExtra("name", arrayList.get(position).getName());

                    String textTitle = "Department of Communication and the Arts";
                    double latitude =  40.629100;
                    double longitude = -8.656365;
                    int number = 234370389;
                    String numberShow = "234 370 389";
                    String website = "https://www.ua.pt/deca";
                    String email = "cris@ca.ua.pt";
                    String horario = "08:00-21:00";
                    String textoDebaixoDoHorario = "";

                    launchVforum.putExtra("title", textTitle);
                    launchVforum.putExtra("lat", latitude);
                    launchVforum.putExtra("long", longitude);
                    launchVforum.putExtra("num", number);
                    launchVforum.putExtra("numberShow", numberShow);
                    launchVforum.putExtra("website", website);
                    launchVforum.putExtra("email", email);
                    launchVforum.putExtra("horario",  horario);
                    launchVforum.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);
                    ctx.startActivity(launchVforum);
                }

                if (arrayList.get(position).getName().equals("Science Communication and Image Complex")) {
                    Intent launchVforum = new Intent(ctx, detailsEdificios.class);
                    launchVforum.putExtra("name", arrayList.get(position).getName());
                    String textTitle = "Science Communication and Image Complex";
                    double latitude =  40.629100;
                    double longitude = -8.656365;
                    int number = 234370389;
                    String numberShow = "234 370 389";
                    String website = "https://www.ua.pt/deca";
                    String email = "cris@ca.ua.pt";
                    String horario = "08:00-21:00";
                    String textoDebaixoDoHorario = "";

                    launchVforum.putExtra("title", textTitle);
                    launchVforum.putExtra("lat", latitude);
                    launchVforum.putExtra("long", longitude);
                    launchVforum.putExtra("num", number);
                    launchVforum.putExtra("numberShow", numberShow);
                    launchVforum.putExtra("website", website);
                    launchVforum.putExtra("email", email);
                    launchVforum.putExtra("horario",  horario);
                    launchVforum.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);
                    ctx.startActivity(launchVforum);
                }

                if (arrayList.get(position).getName().equals("Department of Physics")) {
                    Intent launchVforum = new Intent(ctx, detailsEdificios.class);
                    launchVforum.putExtra("name", arrayList.get(position).getName());

                    String textTitle = "Department of Physics";
                    double latitude = 40.6302109;
                    double longitude = -8.656709;
                    int number = 234370356;
                    String numberShow = "234 370 356";
                    String website = "www.ua.pt/fis";
                    String email = "fisica@ua.pt";
                    String tituloservico = "";
                    String horario = "08:00-21:00";
                    String textoDebaixoDoHorario = "";


                    launchVforum.putExtra("title", textTitle);
                    launchVforum.putExtra("lat", latitude);
                    launchVforum.putExtra("long", longitude);
                    launchVforum.putExtra("num", number);
                    launchVforum.putExtra("numberShow", numberShow);
                    launchVforum.putExtra("website", website);
                    launchVforum.putExtra("email", email);
                    launchVforum.putExtra("tituloservico", tituloservico);
                    launchVforum.putExtra("horario",  horario);
                    launchVforum.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);

                    ctx.startActivity(launchVforum);
                }

                if (arrayList.get(position).getName().equals("University's Restaurant")) {
                    Intent launchVforum = new Intent(ctx, detailsEdificios.class);
                    launchVforum.putExtra("name", arrayList.get(position).getName());

                    String textTitle = "University's Restaurant";
                    double latitude = 40.631243;
                    double longitude = -8.655514;
                    int number = 234370763;
                    String numberShow = "234 370 356";
                    String website = "http://www2.sas.ua.pt/site/temp/alim_ementas_rest_V1.1.asp";
                    String email = "sas@ua.pt";
                    String tituloservico = "Services";
                    String horario = "12h00 – 14h30";
                    String textoDebaixoDoHorario = "";


                    launchVforum.putExtra("title", textTitle);
                    launchVforum.putExtra("lat", latitude);
                    launchVforum.putExtra("long", longitude);
                    launchVforum.putExtra("num", number);
                    launchVforum.putExtra("numberShow", numberShow);
                    launchVforum.putExtra("website", website);
                    launchVforum.putExtra("email", email);
                    launchVforum.putExtra("tituloservico", tituloservico);
                    launchVforum.putExtra("horario",  horario);
                    launchVforum.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);

                    ctx.startActivity(launchVforum);
                }

                if (arrayList.get(position).getName().equals("Department of Mathematics")) {
                    Intent launchVforum = new Intent(ctx, detailsEdificios.class);
                    launchVforum.putExtra("name", arrayList.get(position).getName());

                    String textTitle = "Department of Mathematics";
                    double latitude = 40.6303459;
                    double longitude = -8.6582087;
                    int number =  234372545;
                    String numberShow = "234 372 545";
                    String website = "https://www.ua.pt/dmat";
                    String email = "dmat.secretaria@ua.pt";
                    String tituloservico = "Services";
                    String horario = "08:00-21:00";
                    String textoDebaixoDoHorario = "";


                    launchVforum.putExtra("title", textTitle);
                    launchVforum.putExtra("lat", latitude);
                    launchVforum.putExtra("long", longitude);
                    launchVforum.putExtra("num", number);
                    launchVforum.putExtra("numberShow", numberShow);
                    launchVforum.putExtra("website", website);
                    launchVforum.putExtra("email", email);
                    launchVforum.putExtra("tituloservico", tituloservico);
                    launchVforum.putExtra("horario",  horario);
                    launchVforum.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);

                    ctx.startActivity(launchVforum);
                }

                if (arrayList.get(position).getName().equals("Department of Social, Legal and Political Sciences")) {
                    Intent launchVforum = new Intent(ctx, detailsEdificios.class);
                    launchVforum.putExtra("name", arrayList.get(position).getName());

                    String textTitle = "Department of Social, Legal and Political Sciences";
                    double latitude = 40.6298911;
                    double longitude = -8.6582347;
                    int number =  234372588;
                    String numberShow = "234 372 588";
                    String website = "https://www.ua.pt/dcspt/";
                    String email = "dcspt.secretaria@ua.pt";
                    String tituloservico = "Services";
                    String horario = "08:00-21:00";
                    String textoDebaixoDoHorario = "";


                    launchVforum.putExtra("title", textTitle);
                    launchVforum.putExtra("lat", latitude);
                    launchVforum.putExtra("long", longitude);
                    launchVforum.putExtra("num", number);
                    launchVforum.putExtra("numberShow", numberShow);
                    launchVforum.putExtra("website", website);
                    launchVforum.putExtra("email", email);
                    launchVforum.putExtra("tituloservico", tituloservico);
                    launchVforum.putExtra("horario",  horario);
                    launchVforum.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);

                    ctx.startActivity(launchVforum);
                }



                if (arrayList.get(position).getName().equals("Technological Laboratories Centre")) {
                    Intent launchVforum = new Intent(ctx, detailsEdificios.class);
                    launchVforum.putExtra("name", arrayList.get(position).getName());

                    String textTitle = "Technological Laboratories Centre";
                    double latitude = 40.629984;
                    double longitude = -8.656331;
                    int number =  234370200;
                    String numberShow = "234 370 200 (Geral)";
                    String website = "http://www.ciceco.ua.pt/";
                    String email = "ciceco@ua.pt";
                    String tituloservico = "Services";
                    String horario = "08:00-21:00";
                    String textoDebaixoDoHorario = "";


                    launchVforum.putExtra("title", textTitle);
                    launchVforum.putExtra("lat", latitude);
                    launchVforum.putExtra("long", longitude);
                    launchVforum.putExtra("num", number);
                    launchVforum.putExtra("numberShow", numberShow);
                    launchVforum.putExtra("website", website);
                    launchVforum.putExtra("email", email);
                    launchVforum.putExtra("tituloservico", tituloservico);
                    launchVforum.putExtra("horario",  horario);
                    launchVforum.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);

                    ctx.startActivity(launchVforum);
                }

                if (arrayList.get(position).getName().equals("Department of Economics, Management and Industrial Engineering")) {
                    Intent launchVforum = new Intent(ctx, detailsEdificios.class);
                    launchVforum.putExtra("name", arrayList.get(position).getName());

                    String textTitle = "Department of Economics, Management and Industrial Engineering";
                    double latitude = 40.63058327;
                    double longitude = -8.65731105;
                    int number =  234370361;
                    String numberShow = "234 370 361";
                    String website = "https://www.ua.pt/degeit/";
                    String email = "degei@ua.pt";
                    String tituloservico = "Services";
                    String horario = "08:00-21:00";
                    String textoDebaixoDoHorario = "";


                    launchVforum.putExtra("title", textTitle);
                    launchVforum.putExtra("lat", latitude);
                    launchVforum.putExtra("long", longitude);
                    launchVforum.putExtra("num", number);
                    launchVforum.putExtra("numberShow", numberShow);
                    launchVforum.putExtra("website", website);
                    launchVforum.putExtra("email", email);
                    launchVforum.putExtra("tituloservico", tituloservico);
                    launchVforum.putExtra("horario",  horario);
                    launchVforum.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);

                    ctx.startActivity(launchVforum);
                }

                if (arrayList.get(position).getName().equals("Pedagogical, Scientific and Technological Complex")) {
                    Intent launchVforum = new Intent(ctx, detailsEdificios.class);
                    launchVforum.putExtra("name", arrayList.get(position).getName());

                    String textTitle = "Pedagogical, Scientific and Technological Complex";
                    double latitude = 40.62940058;
                    double longitude = -8.65565076;
                    int number =  234370200;
                    String numberShow = "234 370 200 (Geral)";
                    String website = "https://www.ua.pt/";
                    String email = "geral@ua.pt";
                    String tituloservico = "Services";
                    String horario = "08:00-21:00";
                    String textoDebaixoDoHorario = "";


                    launchVforum.putExtra("title", textTitle);
                    launchVforum.putExtra("lat", latitude);
                    launchVforum.putExtra("long", longitude);
                    launchVforum.putExtra("num", number);
                    launchVforum.putExtra("numberShow", numberShow);
                    launchVforum.putExtra("website", website);
                    launchVforum.putExtra("email", email);
                    launchVforum.putExtra("tituloservico", tituloservico);
                    launchVforum.putExtra("horario",  horario);
                    launchVforum.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);

                    ctx.startActivity(launchVforum);
                }

                if (arrayList.get(position).getName().equals("Central Analysis Laboratory")) {
                    Intent launchVforum = new Intent(ctx, detailsEdificios.class);
                    launchVforum.putExtra("name", arrayList.get(position).getName());

                    String textTitle = "Central Analysis Laboratory";
                    double latitude = 40.62922755;
                    double longitude = -8.65618989;
                    int number =  234370990;
                    String numberShow = "234 370 990";
                    String website = "http://www.ua.pt/lca";
                    String email = "lca@lca.ua.pt";
                    String tituloservico = "Services";
                    String horario = "08:00-21:00";
                    String textoDebaixoDoHorario = "";


                    launchVforum.putExtra("title", textTitle);
                    launchVforum.putExtra("lat", latitude);
                    launchVforum.putExtra("long", longitude);
                    launchVforum.putExtra("num", number);
                    launchVforum.putExtra("numberShow", numberShow);
                    launchVforum.putExtra("website", website);
                    launchVforum.putExtra("email", email);
                    launchVforum.putExtra("tituloservico", tituloservico);
                    launchVforum.putExtra("horario",  horario);
                    launchVforum.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);

                    ctx.startActivity(launchVforum);
                }

                if (arrayList.get(position).getName().equals("Department of Geosciences")) {
                    Intent launchVforum = new Intent(ctx, detailsEdificios.class);
                    launchVforum.putExtra("name", arrayList.get(position).getName());

                    String textTitle = "Department of Geosciences";
                    double latitude = 40.62949014;
                    double longitude = -8.65697309;
                    int number =  234370357;
                    String numberShow = "234 370 357";
                    String website = "https://www.ua.pt/geo/";
                    String email = "geo.secretaria@ua.pt";
                    String tituloservico = "Services";
                    String horario = "08:00-21:00";
                    String textoDebaixoDoHorario = "";


                    launchVforum.putExtra("title", textTitle);
                    launchVforum.putExtra("lat", latitude);
                    launchVforum.putExtra("long", longitude);
                    launchVforum.putExtra("num", number);
                    launchVforum.putExtra("numberShow", numberShow);
                    launchVforum.putExtra("website", website);
                    launchVforum.putExtra("email", email);
                    launchVforum.putExtra("tituloservico", tituloservico);
                    launchVforum.putExtra("horario",  horario);
                    launchVforum.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);

                    ctx.startActivity(launchVforum);
                }

                if (arrayList.get(position).getName().equals("Department of Civil Engineering")) {
                    Intent launchVforum = new Intent(ctx, detailsEdificios.class);
                    launchVforum.putExtra("name", arrayList.get(position).getName());

                    String textTitle = "Department of Civil Engineering";
                    double latitude = 40.62974867;
                    double longitude = -8.65724936;
                    int number =  234370049 ;
                    String numberShow = "234 370 049";
                    String website = "http://www.ua.pt/decivil/";
                    String email = "sec@civil.ua.pt";
                    String tituloservico = "Services";
                    String horario = "08:00-21:00";
                    String textoDebaixoDoHorario = "";


                    launchVforum.putExtra("title", textTitle);
                    launchVforum.putExtra("lat", latitude);
                    launchVforum.putExtra("long", longitude);
                    launchVforum.putExtra("num", number);
                    launchVforum.putExtra("numberShow", numberShow);
                    launchVforum.putExtra("website", website);
                    launchVforum.putExtra("email", email);
                    launchVforum.putExtra("tituloservico", tituloservico);
                    launchVforum.putExtra("horario",  horario);
                    launchVforum.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);

                    ctx.startActivity(launchVforum);
                }

                if (arrayList.get(position).getName().equals("Department of Mechanical Engineering")) {
                    Intent launchVforum = new Intent(ctx, detailsEdificios.class);
                    launchVforum.putExtra("name", arrayList.get(position).getName());

                    String textTitle = "Department of Mechanical Engineering";
                    double latitude = 40.62992984;
                    double longitude = -8.65759939;
                    int number =  234370830;
                    String numberShow = "234 370 830";
                    String website = "https://www.ua.pt/dem/";
                    String email = "dem.secretaria@ua.pt";
                    String tituloservico = "Services";
                    String horario = "08:00-21:00";
                    String textoDebaixoDoHorario = "";


                    launchVforum.putExtra("title", textTitle);
                    launchVforum.putExtra("lat", latitude);
                    launchVforum.putExtra("long", longitude);
                    launchVforum.putExtra("num", number);
                    launchVforum.putExtra("numberShow", numberShow);
                    launchVforum.putExtra("website", website);
                    launchVforum.putExtra("email", email);
                    launchVforum.putExtra("tituloservico", tituloservico);
                    launchVforum.putExtra("horario",  horario);
                    launchVforum.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);

                    ctx.startActivity(launchVforum);
                }

                if (arrayList.get(position).getName().equals("Department of Ceramics and Glass Engineering")) {
                    Intent launchVforum = new Intent(ctx, detailsEdificios.class);
                    launchVforum.putExtra("name", arrayList.get(position).getName());

                    String textTitle = "Department of Ceramics and Glass Engineering";
                    double latitude = 40.63394801;
                    double longitude = -8.65843087;
                    int number =  234370354;
                    String numberShow = "234 370 354";
                    String website = "https://www.ua.pt/demac/";
                    String email = "demac-secretaria@ua.pt";
                    String tituloservico = "Services";
                    String horario = "08:00-21:00";
                    String textoDebaixoDoHorario = "";


                    launchVforum.putExtra("title", textTitle);
                    launchVforum.putExtra("lat", latitude);
                    launchVforum.putExtra("long", longitude);
                    launchVforum.putExtra("num", number);
                    launchVforum.putExtra("numberShow", numberShow);
                    launchVforum.putExtra("website", website);
                    launchVforum.putExtra("email", email);
                    launchVforum.putExtra("tituloservico", tituloservico);
                    launchVforum.putExtra("horario",  horario);
                    launchVforum.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);

                    ctx.startActivity(launchVforum);
                }

                if (arrayList.get(position).getName().equals("Rectory")) {
                    Intent launchVforum = new Intent(ctx, detailsEdificios.class);
                    launchVforum.putExtra("name", arrayList.get(position).getName());

                    String textTitle = "Rectory";
                    double latitude = 40.63117969;
                    double longitude = -8.65752429;
                    int number =  234370606;
                    String numberShow = "234 370 606";
                    String website = "https://www.ua.pt/reitoria/";
                    String email = "reitoria@ua.pt";
                    String tituloservico = "Services";
                    String horario = "08:00-21:00";
                    String textoDebaixoDoHorario = "";


                    launchVforum.putExtra("title", textTitle);
                    launchVforum.putExtra("lat", latitude);
                    launchVforum.putExtra("long", longitude);
                    launchVforum.putExtra("num", number);
                    launchVforum.putExtra("numberShow", numberShow);
                    launchVforum.putExtra("website", website);
                    launchVforum.putExtra("email", email);
                    launchVforum.putExtra("tituloservico", tituloservico);
                    launchVforum.putExtra("horario",  horario);
                    launchVforum.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);

                    ctx.startActivity(launchVforum);
                }
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
