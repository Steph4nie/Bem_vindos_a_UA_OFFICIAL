package com.example.stephanie.bem_vindos_a_ua_official;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

public class detailsEdificios extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    TextView dep;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_edificios);
        TextView dep = (TextView) findViewById(R.id.nomeDep);

        TextView textViewNum = (TextView) findViewById(R.id.telefone_numero);
        TextView Website = (TextView) findViewById(R.id.website_link);
        TextView Email = (TextView) findViewById(R.id.email_link);
        TextView horas = (TextView) findViewById(R.id.horario_deca_horas_2);

        textViewNum.setText(getIntent().getStringExtra("numberShow"));
        Website.setText(getIntent().getStringExtra("website"));
        Email.setText(getIntent().getStringExtra("email"));
        String titulo = getIntent().getStringExtra("title");
        String horasAbertas = getIntent().getStringExtra("horario");
        horas.setText(horasAbertas);

        //sublinhado
        textViewNum.setPaintFlags(textViewNum.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        Website.setPaintFlags(Website.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        Email.setPaintFlags(Email.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        dep.setText(titulo);


        if (titulo.equals("Department of Communication and the Arts")) {
//            // get ahold of an instance of your layout
//            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
//            // assuming your Wizard content is in content_wizard.xml
//            View wizard = getLayoutInflater().inflate(R.layout.servicos_deca, null);
//
//            // add the inflated View to the layout
//            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.mipmap.deca_image);
        }

        if (titulo.equals("DFIS - Departamento de Física")) {
//            // get ahold of an instance of your layout
//            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
//            // assuming your Wizard content is in content_wizard.xml
//            View wizard = getLayoutInflater().inflate(R.layout.servicos_deca, null);
//
//            // add the inflated View to the layout
//            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.mipmap.dfis);
        }

        if (titulo.equals("DFIS - Departamento de Física")) {
//            // get ahold of an instance of your layout
//            LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
//            // assuming your Wizard content is in content_wizard.xml
//            View wizard = getLayoutInflater().inflate(R.layout.servicos_deca, null);
//
//            // add the inflated View to the layout
//            dynamicContent.addView(wizard);

            ImageView imageView = (ImageView) findViewById(R.id.imageView4);

            imageView.setImageResource(R.mipmap.dfis);
        }

        buildGoogleApiClient();
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
    public void getActionDial2(View view) {
        int call = getIntent().getExtras().getInt("num");
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + call));
        startActivity(intent);
    }

    public void getActionLink2(View view) {
        String url = getIntent().getExtras().getString("website");
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
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

    public void getDirectionsFromCurrentLocation2(View view) {
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

    public void getActionEmail2 (View view) {
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
