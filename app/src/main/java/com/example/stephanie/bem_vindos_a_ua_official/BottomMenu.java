//package com.example.stephanie.bem_vindos_a_ua_official;
//
//import android.content.Intent;
//import android.support.annotation.NonNull;
//import android.support.design.widget.BottomNavigationView;
//import android.support.v7.app.AppCompatActivity;
//import android.view.MenuItem;
//
///**
// * Created by Stephanie on 22/05/2017.
// */
//
//public class BottomMenu extends AppCompatActivity {
//    private BottomNavigationView bottomNavigationView;
//
//    public void addMenu() {
//        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                if (item.getItemId() == R.id.nav_camera) {
//
//                } else if (item.getItemId() == R.id.nav_gallery) {
//
//                } else {
//                    if (item.getItemId() == R.id.nav_slideshow) {
//                        IntentForRoteiros();
//                        return true;
//                    } else if (item.getItemId() == R.id.nav_manage) {
//
//                    }
//                }
//
//                return false;
//            }
//        });
//    }
//
//
//    public void IntentForRoteiros () {
//        startActivity(new Intent(this, RoteiroActivity.class));
//    }
//
//    public void IntentForMapas () {
//        startActivity(new Intent(this, MainActivity.class));
//    }
//}
