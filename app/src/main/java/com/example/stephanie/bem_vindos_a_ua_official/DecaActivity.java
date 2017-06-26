package com.example.stephanie.bem_vindos_a_ua_official;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

/**
 * Created by Stephanie on 13/04/2017.
 */
//por setinha de voltar para trás

public class DecaActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    TextView mTextViewNum;
    private TextView mDisplayText, Lat, Website, servico;
    ImageView myImgView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deca_details);
        mDisplayText = (TextView) findViewById(R.id.tituloText);


        ActionBar actionBar = this.getSupportActionBar();

        Intent intentThatStartedThisActivity = getIntent();
        // Set the action bar back button to look like an up button
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        buildGoogleApiClient();

        TextView textViewNum = (TextView) findViewById(R.id.telefone_numero);
        TextView Website = (TextView) findViewById(R.id.website_link);
        TextView Email = (TextView) findViewById(R.id.email_link);
        TextView horas = (TextView) findViewById(R.id.horario_deca_horas);
        TextView Serviços = (TextView) findViewById(R.id.serviços);
            // COMPLETED (5) If the Intent contains the correct extra, retrieve the text
            /*
             * Now that we've checked to make sure the extra we are looking for is contained within
             * the Intent, we can extract the extra. To do that, we simply call the getStringExtra
             * method on the Intent. There are various other get*Extra methods you can call for
             * different types of data. Please feel free to explore those yourself.
             */
            String textEntered = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);

            String NumberCall = intentThatStartedThisActivity.getStringExtra("numberShow");
            // COMPLETED (6) If the Intent contains the correct extra, use it to set the TextView text
            /*
             * Finally, we can set the text of our TextView (using setText) to the text that was
             * passed to this Activity.
             */
            textViewNum.setText(NumberCall);
            mDisplayText.setText(textEntered);
            String horasAbertas = getIntent().getStringExtra("horario");
            Email.setText(getIntent().getStringExtra("email"));
            Website.setText(getIntent().getStringExtra("website"));
            horas.setText(horasAbertas);
            //sublinhado
            textViewNum.setPaintFlags(textViewNum.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
            Website.setPaintFlags(Website.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
            Email.setPaintFlags(Email.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);



            String tituloservico = intentThatStartedThisActivity.getStringExtra("tituloservico");
            Serviços.setText(tituloservico);

            if (textEntered.equals("Department of Communication and the Arts")) {
                // get ahold of an instance of your layout
                LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
                // assuming your Wizard content is in content_wizard.xml
                View wizard = getLayoutInflater().inflate(R.layout.servicos_deca, null);

                // add the inflated View to the layout
                dynamicContent.addView(wizard);

                ImageView imageView = (ImageView) findViewById(R.id.imageView4);

                imageView.setImageResource(R.mipmap.deca_image);
            }

        if (textEntered.equals("Science Communication and Image Complex")) {
            // get ahold of an instance of your layout
            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
            // assuming your Wizard content is in content_wizard.xml
            View wizard = getLayoutInflater().inflate(R.layout.servicos_deca, null);

            // add the inflated View to the layout
            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.ccci);
        }

        if (textEntered.equals("Department of Physics")) {
            // get ahold of an instance of your layout
            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
            // assuming your Wizard content is in content_wizard.xml
            View wizard = getLayoutInflater().inflate(R.layout.servicos_deca, null);

            // add the inflated View to the layout
            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.mipmap.dfis);
        }

        if (textEntered.equals("University's Restaurant")) {
            // get ahold of an instance of your layout
            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
            // assuming your Wizard content is in content_wizard.xml
            View wizard = getLayoutInflater().inflate(R.layout.servicos_restaurant, null);

            // add the inflated View to the layout
            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.restaurante);
        }

        if (textEntered.equals("Department of Mathematics")) {
            // get ahold of an instance of your layout
            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
            // assuming your Wizard content is in content_wizard.xml
            View wizard = getLayoutInflater().inflate(R.layout.servicos_deca, null);

            // add the inflated View to the layout
            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.matematica);
        }

        if (textEntered.equals("Department of Social, Legal and Political Sciences")) {
            // get ahold of an instance of your layout
            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
            // assuming your Wizard content is in content_wizard.xml
            View wizard = getLayoutInflater().inflate(R.layout.servicos_deca, null);

            // add the inflated View to the layout
            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.ciencias_politicas);
        }

        if (textEntered.equals("Technological Laboratories Centre")) {
            // get ahold of an instance of your layout
            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
            // assuming your Wizard content is in content_wizard.xml
            View wizard = getLayoutInflater().inflate(R.layout.servicos_deca, null);

            // add the inflated View to the layout
            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.ciceco);
        }

        if (textEntered.equals("Department of Economics, Management and Industrial Engineering")) {
            // get ahold of an instance of your layout
            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
            // assuming your Wizard content is in content_wizard.xml
            View wizard = getLayoutInflater().inflate(R.layout.servicos_deca, null);

            // add the inflated View to the layout
            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.degei);
        }

        if (textEntered.equals("Pedagogical, Scientific and Technological Complex")) {
            // get ahold of an instance of your layout
            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
            // assuming your Wizard content is in content_wizard.xml
            View wizard = getLayoutInflater().inflate(R.layout.servicos_deca, null);

            // add the inflated View to the layout
            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.cp);
        }

        if (textEntered.equals("Central Analysis Laboratory")) {
            // get ahold of an instance of your layout
            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
            // assuming your Wizard content is in content_wizard.xml
            View wizard = getLayoutInflater().inflate(R.layout.servicos_deca, null);

            // add the inflated View to the layout
            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.laboratorio_de_analises);
        }

        if (textEntered.equals("Department of Geosciences")) {
            // get ahold of an instance of your layout
            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
            // assuming your Wizard content is in content_wizard.xml
            View wizard = getLayoutInflater().inflate(R.layout.servicos_deca, null);

            // add the inflated View to the layout
            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.geociencias);
        }

        if (textEntered.equals("Department of Civil Engineering")) {
            // get ahold of an instance of your layout
            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
            // assuming your Wizard content is in content_wizard.xml
            View wizard = getLayoutInflater().inflate(R.layout.servicos_deca, null);

            // add the inflated View to the layout
            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.civil);
        }

        if (textEntered.equals("Department of Mechanical Engineering")) {
            // get ahold of an instance of your layout
            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
            // assuming your Wizard content is in content_wizard.xml
            View wizard = getLayoutInflater().inflate(R.layout.servicos_deca, null);

            // add the inflated View to the layout
            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.mecanica);
        }

        if (textEntered.equals("Department of Ceramics and Glass Engineering")) {
            // get ahold of an instance of your layout
            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
            // assuming your Wizard content is in content_wizard.xml
            View wizard = getLayoutInflater().inflate(R.layout.servicos_deca, null);

            // add the inflated View to the layout
            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.mecanica);
        }



        if (textEntered.equals("Print center")) {

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.fotocopias);
        }

        if (textEntered.equals("Bank")) {

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.papelaria);
        }

        if (textEntered.equals("Drugstore")) {

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.farmacia);
        }

        if (textEntered.equals("Post Office")) {

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.papelaria);
        }

        if (textEntered.equals("Stationer's")) {

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.papelaria);
        }

        if (textEntered.equals("Rectory")) {
            // get ahold of an instance of your layout
            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
            // assuming your Wizard content is in content_wizard.xml
            View wizard = getLayoutInflater().inflate(R.layout.servicos_reitoria, null);

            // add the inflated View to the layout
            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.reitoria);
        }

        if (textEntered.equals("STIC")) {

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.stic);
        }

        if (textEntered.equals("Health Care Center")) {
            // get ahold of an instance of your layout
            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
            // assuming your Wizard content is in content_wizard.xml
            View wizard = getLayoutInflater().inflate(R.layout.servicos_health, null);

            // add the inflated View to the layout
            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.drawable.sasua);
        }
    }




    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .enableAutoManage(this, 0, this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .build();
    }

    @Override
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
        super.onStop();
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

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location loc = LocationServices
                .FusedLocationApi
                .getLastLocation(mGoogleApiClient);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    public void getDirectionsFromCurrentLocation(View view) {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location loc = LocationServices
                .FusedLocationApi
                .getLastLocation(mGoogleApiClient);


//40.628842, -8.656629

        Intent intentThatStartedThisActivity = getIntent();
        double Lat = intentThatStartedThisActivity.getExtras().getDouble("lat");
        double Long = intentThatStartedThisActivity.getExtras().getDouble("long");
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=" + Lat + "," + Long));
            startActivity(intent);

    }

    public void getActionDial(View view) {
        Intent intentThatStartedThisActivity = getIntent();
        int call = intentThatStartedThisActivity.getExtras().getInt("num");
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + call));
        startActivity(intent);
    }

    public void getActionLink(View view) {
        String url = getIntent().getExtras().getString("website");
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void getActionEmail (View view) {
        String email = getIntent().getExtras().getString("email");
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] {email});
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT,"");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "");

/* Send it off to the Activity-Chooser */
        startActivity(Intent.createChooser(intent,"Send"));
    }

}