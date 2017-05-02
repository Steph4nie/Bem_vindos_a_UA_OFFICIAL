package com.example.stephanie.bem_vindos_a_ua_official;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.stephanie.bem_vindos_a_ua_official.R.id.map;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {
    private GoogleMap mMap;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private RelativeLayout dialog_popup;
    Marker m1;
// TODO POR UM TOAST A AVISAR A PESSOA QUE TEM DE LIGAR O GPS
// TODO FAZER INTENTS PARA AS PÁGINAS DE DETALHE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog_popup = (RelativeLayout) findViewById(R.id.relative);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {
            // atividade roteiros
            startActivity(new Intent(this, RoteiroActivity.class));
            return  true;

        } else if (id == R.id.nav_manage) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


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
        Marker deca = mMap.addMarker(new MarkerOptions()


                .position(new LatLng(40.628842, -8.656629))
                .title("21 - Deca")
                .snippet("Saber Mais")
                //adicionar aqui icone personalizado que vai ter o número do dep
        );
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent = new Intent(MainActivity.this, DecaActivity.class);
                startActivity(intent);
            }});

//        mMap.setOnMarkerClickListener(
//                new GoogleMap.OnMarkerClickListener() {
//                    @Override
//                    public boolean onMarkerClick(Marker marker) {
//                        do something
//                        if(marker.getTitle().equals("21")) {
//                             se deca é clicado
//                            Toast.makeText(MainActivity.this, marker.getTitle(), Toast.LENGTH_SHORT).show();// display toast
//                        }
//                        return true;
//                    }
//                }
//           );

    }


    @Override
    public void onInfoWindowClick(Marker marker) {
        if (marker.getTitle().equals("21 - Deca")) {
            Toast.makeText(this, "janela de informação",
                    Toast.LENGTH_SHORT).show();
            //por aqui um intent que leva o user para outra atividade
//            Intent intent = new Intent(MainActivity.this,DecaActivity.class);
//            startActivity(intent);
//            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
//            final View popupView = inflater.inflate(R.layout.info_window, null);
//            final PopupWindow popupWindow = new PopupWindow(
//                    popupView,
//                    FrameLayout.LayoutParams.WRAP_CONTENT,
//                    FrameLayout.LayoutParams.WRAP_CONTENT);
//
//            Button btnDismiss = (Button) popupView.findViewById(R.id.dismissbtn);
//            btnDismiss.setOnClickListener(new Button.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    // TODO Auto-generated method stub
//                    popupWindow.dismiss();
//                    popupWindow.showAsDropDown(popupView);
//                }
//            });


        }


    }

}