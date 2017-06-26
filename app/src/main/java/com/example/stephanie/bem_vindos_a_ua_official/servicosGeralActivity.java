package com.example.stephanie.bem_vindos_a_ua_official;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Stephanie on 30/05/2017.
 */

public class servicosGeralActivity extends AppCompatActivity {
    TextView banco, farmacia, correios, papelaria, stic, centrosaude, gesp, fotocopias;
    FloatingActionButton fotocopia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicos_geral);

        ActionBar actionBar = this.getSupportActionBar();

        // Set the action bar back button to look like an up button
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

//        TextView papelaria = (TextView) findViewById(R.id.textView7);
//        TextView gesp = (TextView) findViewById(R.id.textView8);
//        TextView stic = (TextView) findViewById(R.id.stic);
//        TextView centrosaude = (TextView) findViewById(R.id.textView9);
//        TextView centrosaude = (TextView) findViewById(R.id.textView9);
        FloatingActionButton fotocopias = (FloatingActionButton) findViewById(R.id.coffee);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // When the home button is pressed, take the user back to the VisualizerActivity
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }

    public void getActionFotocopia(View view) {
        String textTitle = "Print center";
        double latitude = 40.630561;
        double longitude = -8.658942;
        int number = 234370348;
        String numberShow = "(SASUA) 234 370 348";
        String website = "https://www.ua.pt/PageText.aspx?id=14908";
        String email = "sas@ua.pt";
        String tituloservico = "";
        String horario = "08h30 - 19h00";
        String textoDebaixoDoHorario = "";

        Context context = servicosGeralActivity.this;
        Class destinationActivity = DecaActivity.class;

        Intent startChildActivityIntent = new Intent(context, destinationActivity);
        startChildActivityIntent.putExtra(Intent.EXTRA_TEXT, textTitle);
        startChildActivityIntent.putExtra("lat", latitude);
        startChildActivityIntent.putExtra("long", longitude);
        startChildActivityIntent.putExtra("num", number);
        startChildActivityIntent.putExtra("numberShow", numberShow);
        startChildActivityIntent.putExtra("website", website);
        startChildActivityIntent.putExtra("email", email);
        startChildActivityIntent.putExtra("tituloservico", tituloservico);
        startChildActivityIntent.putExtra("horario",  horario);
        startChildActivityIntent.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);
        startActivity(startChildActivityIntent);
    }

    public void getActionBanco(View view) {
        String textTitle = "Bank";
        double latitude = 40.630561;
        double longitude = -8.658942;
        int number = 234370348;
        String numberShow = "(SASUA) 234 370 348";
        String website = "https://www.ua.pt/PageText.aspx?id=14908";
        String email = "sas@ua.pt";
        String tituloservico = "";
        String horario = "09h30 - 16h00";
        String textoDebaixoDoHorario = "";

        Context context = servicosGeralActivity.this;
        Class destinationActivity = DecaActivity.class;

        Intent startChildActivityIntent = new Intent(context, destinationActivity);
        startChildActivityIntent.putExtra(Intent.EXTRA_TEXT, textTitle);
        startChildActivityIntent.putExtra("lat", latitude);
        startChildActivityIntent.putExtra("long", longitude);
        startChildActivityIntent.putExtra("num", number);
        startChildActivityIntent.putExtra("numberShow", numberShow);
        startChildActivityIntent.putExtra("website", website);
        startChildActivityIntent.putExtra("email", email);
        startChildActivityIntent.putExtra("tituloservico", tituloservico);
        startChildActivityIntent.putExtra("horario",  horario);
        startChildActivityIntent.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);
        startActivity(startChildActivityIntent);
    }

    public void getActionFarmacia(View view) {
        String textTitle = "Drugstore";
        double latitude = 40.630561;
        double longitude = -8.658942;
        int number = 234370348;
        String numberShow = "(SASUA) 234 370 348";
        String website = "https://www.ua.pt/PageText.aspx?id=14908";
        String email = "sas@ua.pt";
        String tituloservico = "";
        String horario = "9h30 - 18h30";
        String textoDebaixoDoHorario = "";

        Context context = servicosGeralActivity.this;
        Class destinationActivity = DecaActivity.class;

        Intent startChildActivityIntent = new Intent(context, destinationActivity);
        startChildActivityIntent.putExtra(Intent.EXTRA_TEXT, textTitle);
        startChildActivityIntent.putExtra("lat", latitude);
        startChildActivityIntent.putExtra("long", longitude);
        startChildActivityIntent.putExtra("num", number);
        startChildActivityIntent.putExtra("numberShow", numberShow);
        startChildActivityIntent.putExtra("website", website);
        startChildActivityIntent.putExtra("email", email);
        startChildActivityIntent.putExtra("tituloservico", tituloservico);
        startChildActivityIntent.putExtra("horario",  horario);
        startChildActivityIntent.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);
        startActivity(startChildActivityIntent);
    }

    public void getActionCorreios(View view) {
        String textTitle = "Post Office";
        double latitude = 40.630561;
        double longitude = -8.658942;
        int number = 234370348;
        String numberShow = "(SASUA) 234 370 348";
        String website = "https://www.ua.pt/PageText.aspx?id=14908";
        String email = "sas@ua.pt";
        String tituloservico = "";
        String horario = "10h00 - 17h30";
        String textoDebaixoDoHorario = "";
        Context context = servicosGeralActivity.this;
        Class destinationActivity = DecaActivity.class;

        Intent startChildActivityIntent = new Intent(context, destinationActivity);
        startChildActivityIntent.putExtra(Intent.EXTRA_TEXT, textTitle);
        startChildActivityIntent.putExtra("lat", latitude);
        startChildActivityIntent.putExtra("long", longitude);
        startChildActivityIntent.putExtra("num", number);
        startChildActivityIntent.putExtra("numberShow", numberShow);
        startChildActivityIntent.putExtra("website", website);
        startChildActivityIntent.putExtra("email", email);
        startChildActivityIntent.putExtra("tituloservico", tituloservico);
        startChildActivityIntent.putExtra("horario",  horario);
        startChildActivityIntent.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);
        startActivity(startChildActivityIntent);
    }

    public void getActionPapelaria(View view) {
        String textTitle = "Stationer's";
        double latitude = 40.630561;
        double longitude = -8.658942;
        int number = 234370348;
        String numberShow = "(SASUA) 234 370 348";
        String website = "https://www.ua.pt/PageText.aspx?id=14908";
        String email = "sas@ua.pt";
        String tituloservico = "";
        String horario = "9h00 - 18h00";
        String textoDebaixoDoHorario = "";

        Context context = servicosGeralActivity.this;
        Class destinationActivity = DecaActivity.class;

        Intent startChildActivityIntent = new Intent(context, destinationActivity);
        startChildActivityIntent.putExtra(Intent.EXTRA_TEXT, textTitle);
        startChildActivityIntent.putExtra("lat", latitude);
        startChildActivityIntent.putExtra("long", longitude);
        startChildActivityIntent.putExtra("num", number);
        startChildActivityIntent.putExtra("numberShow", numberShow);
        startChildActivityIntent.putExtra("website", website);
        startChildActivityIntent.putExtra("email", email);
        startChildActivityIntent.putExtra("tituloservico", tituloservico);
        startChildActivityIntent.putExtra("horario",  horario);
        startChildActivityIntent.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);
        startActivity(startChildActivityIntent);
    }

    public void getActionCentroSaude(View view) {
        String textTitle = "Health Care Center";
        double latitude = 40.630561;
        double longitude = -8.658942;
        int number = 234370348;
        String numberShow = "(SASUA) 234 370 348";
        String website = "https://www.ua.pt/sas/page/11765?ref=ID0EHCA";
        String email = "sas@ua.pt";
        String tituloservico = "Services";
        String horario = "Unknown";
        String textoDebaixoDoHorario = "";

        Context context = servicosGeralActivity.this;
        Class destinationActivity = DecaActivity.class;

        Intent startChildActivityIntent = new Intent(context, destinationActivity);
        startChildActivityIntent.putExtra(Intent.EXTRA_TEXT, textTitle);
        startChildActivityIntent.putExtra("lat", latitude);
        startChildActivityIntent.putExtra("long", longitude);
        startChildActivityIntent.putExtra("num", number);
        startChildActivityIntent.putExtra("numberShow", numberShow);
        startChildActivityIntent.putExtra("website", website);
        startChildActivityIntent.putExtra("email", email);
        startChildActivityIntent.putExtra("tituloservico", tituloservico);
        startChildActivityIntent.putExtra("horario",  horario);
        startChildActivityIntent.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);
        startActivity(startChildActivityIntent);
    }

    public void getActionReitoria(View view) {
        String textTitle = "Rectory";
        double latitude = 40.63117969;
        double longitude = -8.65752429;
        int number =  234370606;
        String numberShow = "234 370 606";
        String website = "https://www.ua.pt/sga/page/3113";
        String email = "reitoria@ua.pt";
        String tituloservico = "";
        String horario = "9h00 - 16h00 (Customer Service, may vary according the service)";
        String textoDebaixoDoHorario = "";

        Context context = servicosGeralActivity.this;
        Class destinationActivity = DecaActivity.class;

        Intent startChildActivityIntent = new Intent(context, destinationActivity);
        startChildActivityIntent.putExtra(Intent.EXTRA_TEXT, textTitle);
        startChildActivityIntent.putExtra("lat", latitude);
        startChildActivityIntent.putExtra("long", longitude);
        startChildActivityIntent.putExtra("num", number);
        startChildActivityIntent.putExtra("numberShow", numberShow);
        startChildActivityIntent.putExtra("website", website);
        startChildActivityIntent.putExtra("email", email);
        startChildActivityIntent.putExtra("tituloservico", tituloservico);
        startChildActivityIntent.putExtra("horario",  horario);
        startChildActivityIntent.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);
        startActivity(startChildActivityIntent);
    }

    public void getActionStic(View view) {
        String textTitle = "STIC";
        double latitude = 40.630019;
        double longitude = -8.658696;
        int number =  234370099;
        String numberShow = "234 370 099";
        String website = "https://www.ua.pt/stic/";
        String email = "stic-helpdesk@ua.pt";
        String tituloservico = "";
        String horario = "9h00-12h30 and 14h00-17h30";
        String textoDebaixoDoHorario = "";

        Context context = servicosGeralActivity.this;
        Class destinationActivity = DecaActivity.class;

        Intent startChildActivityIntent = new Intent(context, destinationActivity);
        startChildActivityIntent.putExtra(Intent.EXTRA_TEXT, textTitle);
        startChildActivityIntent.putExtra("lat", latitude);
        startChildActivityIntent.putExtra("long", longitude);
        startChildActivityIntent.putExtra("num", number);
        startChildActivityIntent.putExtra("numberShow", numberShow);
        startChildActivityIntent.putExtra("website", website);
        startChildActivityIntent.putExtra("email", email);
        startChildActivityIntent.putExtra("tituloservico", tituloservico);
        startChildActivityIntent.putExtra("horario",  horario);
        startChildActivityIntent.putExtra("textoDebaixoDoHorario",  textoDebaixoDoHorario);
        startActivity(startChildActivityIntent);
    }

}


