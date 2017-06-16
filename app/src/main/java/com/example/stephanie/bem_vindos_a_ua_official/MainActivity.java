package com.example.stephanie.bem_vindos_a_ua_official;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Map;

import static com.example.stephanie.bem_vindos_a_ua_official.R.id.map;

// FONTES
// http://stackoverflow.com/questions/37063773/how-to-create-geofence-in-an-android
// TODO adicinar permissões para android 6.0
// TODO lembrar que a rotação do telemovel pode dar cabo da app então é preciso ver o ciclo de vida (ate agora esta tudo bem, é para lembrar no fim

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, GoogleMap.OnMarkerClickListener, OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener, ResultCallback<Status> {


    private GoogleMap mMap;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private RelativeLayout dialog_popup;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    protected ArrayList<Geofence> mGeofenceList;


    Marker m1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        dialog_popup = (RelativeLayout) findViewById(R.id.relative);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //mapa
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);

        //menu
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //localização, está ligada? Se sim faz toast, se não chama função showGPSDisabledAlertToUser();
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(this, "GPS está ligado no seu dispositivo", Toast.LENGTH_LONG).show();
        } else {
            showGPSDisabledAlertToUser();
        }


        // Empty list for storing geofences.
        mGeofenceList = new ArrayList<Geofence>();

        // Get the geofences used. Geofence data is hard coded in this sample.
        populateGeofenceList();

        // Kick off the request to build GoogleApiClient.
        buildGoogleApiClient();

    }


    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }
    //SE GPS ESTIVER DESLIGADO REENCAMINHA PARA AS SETTINGS
    private void showGPSDisabledAlertToUser() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("GPS está desligado no seu dispositivo. Pretende ligá-lo?")
                .setCancelable(false)
                .setPositiveButton("Carregue aqui",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent callGPSSettingIntent = new Intent(
                                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(callGPSSettingIntent);
                            }
                        });
        alertDialogBuilder.setNegativeButton("Cancelar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            Intent startSettingsActivity = new Intent(this, SettingsActivity.class);
//            startActivity(startSettingsActivity);
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        //backonpressed
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        int id = item.getItemId();
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        if (id == R.id.nav_camera) {
            // Handle the camera action
            startActivity(new Intent(this, ListaEdificiosActivity.class));
            return true;
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(this, servicosGeralActivity.class));
            return true;
        } else if (id == R.id.nav_slideshow) {
            // atividade roteiros
            startActivity(new Intent(this, RoteiroActivity.class));
            return true;


        }

        return true;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;
//

        // Add a marker in Sydney and move the camera

        final LatLng campus = new LatLng(40.6299138, -8.6575809);

        //mMap.addMarker(new MarkerOptions().position(campus).title("Marker in campus"));
        LatLng location = new LatLng(40.628842, -8.656629);
//-------------------POLYLINES--------------------------//
        //PERCURSO: DECA - DEMAT
        //DECA - 40.628842, -8.656629
        //DEMAT - 40.630352, -8.658232
        //JSON - https://maps.googleapis.com/maps/api/directions/json?origin=DECA%20-%20Departamento%20de%20Comunica%C3%A7%C3%A3o%20e%20Arte%20da%20Universidade%20de%20Aveiro&destination=Departamento%20de%20Matem%C3%A1tica%20da%20Universidade%20de%20Aveiro&key=AIzaSyAWPNkAbmHIyY2pJ5jswrzod1nhSEzHhug


        mMap.moveCamera(CameraUpdateFactory.newLatLng(campus));
        //mais zoom
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);


//        usar janelas personalizadas
//        link para mandar para uma pagina do deca mesmo
        googleMap.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) this);

        final Marker deca = mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(40.628842, -8.656629))
                        .title("Deca")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_21)
                //adicionar aqui icone personalizado que vai ter o número do dep

        ));

        //https://stackoverflow.com/questions/14226453/google-maps-api-v2-how-to-make-markers-clickable

        final Marker CCCI = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.629071, -8.656862))
                .title("CCCI")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_40)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker CIFOP = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.631815, -8.6588599))
                .title("CIFOP")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_5)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker Biblioteca = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.63123669, -8.66017029))
                .title("Biblioteca")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_17)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker DEMAT = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.630406, -8.658233))
                .title("DEMAT")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_11)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker DCSPT = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.6298911, -8.6582347))
                .title("DCSPT")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_12)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker DEFI = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.6302109, -8.656709))
                .title("DEFI")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_13)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker CLT = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.629984, -8.656331))
                .title("DEFI")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_29)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker DEGEIT = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.63058327, -8.65731105))
                .title("DDEGEIT")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_10)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker CP = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.62940058, -8.65565076))
                .title("CP")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_23)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker LABCENTRAL = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.62922755 , -8.656189896))
                .title("CP")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_14)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker DEGEO = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.62949014 , -8.65697309))
                .title("DEGEO")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_16)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker DEC = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.62974867 , -8.65724936))
                .title("DEGEO")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_28)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker DEM = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.62992984 , -8.65759939))
                .title("DEM")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_22)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker STIC = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.62992984 , -8.65759939))
                .title("STIC")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_27)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker CUA = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.63066672 , -8.65916044))
                .title("CUA")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_6)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker Livraria = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.63138732 , -8.65889356))
                .title("Livraria")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_q)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker DAO = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.6326164 , -8.6590391))
                .title("DAO")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_7)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker DETI = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.6331731 , -8.6594933))
                .title("DAO")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_4)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker DEBI = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.6335676 , -8.6590284))
                .title("DEBI")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_8)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker DEMC = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.63394801 , -8.65843087))
                .title("DEMC")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_9)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker IEETA = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.633105321 , -8.660040))
                .title("IEETA")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_24)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker Herbário = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.63353277 , -8.65997583))
                .title("Herbário")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_26)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker IT = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.63408643 , -8.65985781))
                .title("IT")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_19)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker DLC = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.63511638 , -8.65790516))
                .title("DLC")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_2)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker TEMA = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.63476221 , -8.65739018))
                .title("TEMA")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_3)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker CESAM = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.63476221 , -8.65810499))
                .title("CESAM")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_1)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker IEUA = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.63604454 , -8.65739018))
                .title("IEUA")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_3)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker IDAD = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.6363896 , -8.6584901))
                .title("IDAD")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_d)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker GRETUA = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.6369157 , -8.6580389))
                .title("GRETUA")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_i)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker ResidênciaDocentes = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.63711923 , -8.65766376))
                .title("ResidênciaDocentes")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_c)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker ISCA = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.630464 , -8.6533064))
                .title("ISCA")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_35)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker REITORIA = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.63117969 , -8.65752429))
                .title("REITORIA")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_25)
                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        final Marker PAVILHAO = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.62981991 , -8.654311))
                .title("PAVILHAO")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_e)

                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

        //40.631540, -8.655468
        final Marker Snackbar = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.631243, -8.655514))
                .title("Snackbar")
                .snippet("Saber Mais")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_r)

                        //adicionar aqui icone personalizado que vai ter o número do dep
                ));

    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        String name= marker.getTitle();
        if (name.equalsIgnoreCase("Deca"))
        {
//            Adiciona texto
            String textTitle = "DECA - Departamento de Comunicação e Arte";
            double latitude = 40.62981991;
            double longitude = -8.654311;
            int number = 234370389;
            String numberShow = "234 370 389";
            String website = "";
            String email = "";
            String tituloservico = "Serviços";
            String horario = "";
            String textoDebaixoDoHorario = "";


            Context context = MainActivity.this;
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
        if (name.equalsIgnoreCase("CCCI")) {
            String textTitle = "CCCI - Complexo das ciências da comunicação e imagem";
            Context context = MainActivity.this;
            Class destinationActivity = DecaActivity.class;
            Intent startChildActivityIntent = new Intent(context, destinationActivity);
            startChildActivityIntent.putExtra(Intent.EXTRA_TEXT, textTitle);
            startActivity(startChildActivityIntent);
        }

       return true;
    }

//    @Override
//    public boolean onMarkerClick(Marker marker) {
////        String name= marker.getTitle();
////
////        if (name.equals("Deca"))
////        {
////            startActivity(new Intent(this, DecaActivity.class));
////            return true;
////            //write your code here
////        }
////        return true;
//    }


    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        mLocationRequest.setInterval(1000);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    //funções para geofencing
    private PendingIntent getGeofencePendingIntent() {
        Intent intent = new Intent(this, GeofenceTransitionsIntentService.class);
        // We use FLAG_UPDATE_CURRENT so that we get the same pending intent back when calling addgeoFences()
        return PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    //// TODO: 05/05/2017 está aqui a função para o onclick
    public void addGeofencesButtonHandler(View view) {
        if (!mGoogleApiClient.isConnected()) {
            Toast.makeText(this, getString(R.string.not_connected), Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            LocationServices.GeofencingApi.addGeofences(
                    mGoogleApiClient,
                    // The GeofenceRequest object.
                    getGeofencingRequest(true),
                    // A pending intent that that is reused when calling removeGeofences(). This
                    // pending intent is used to generate an intent when a matched geofence
                    // transition is observed.
                    getGeofencePendingIntent()
            ).setResultCallback(this); // Result processed in onResult().
        } catch (SecurityException securityException) {
            // Catch exception generated if the app does not use ACCESS_FINE_LOCATION permission.
        }
    }

    public void populateGeofenceList() {
        //vai disparar apenas notificações de eventos e promoções no background
        for (Map.Entry<String, LatLng> entry : Constants.LANDMARKSGeral.entrySet()) {
            mGeofenceList.add(new Geofence.Builder()
                    .setRequestId(entry.getKey())
                    .setCircularRegion(
                            entry.getValue().latitude,
                            entry.getValue().longitude,
                            Constants.GEOFENCE_RADIUS_IN_METERS
                    )
                    .setExpirationDuration(Constants.GEOFENCE_EXPIRATION_IN_MILLISECONDS_WEEK)
                    .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER)
                    .build());
        }

    }


    private GeofencingRequest getGeofencingRequest(boolean b) {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
        builder.setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER);
        builder.addGeofences(mGeofenceList);
        return builder.build();
    }


    @Override
    public void onResult(@NonNull Status status) {
        if (status.isSuccess()) {
            Toast.makeText(
                    this,
                    "Geofences Added",
                    Toast.LENGTH_SHORT
            ).show();
        } else {
            // Get the status code for the error and log it using a user-friendly message.
            String errorMessage = GeofenceErrorMessage.getErrorString(this,
                    status.getStatusCode());
        }

    }


}