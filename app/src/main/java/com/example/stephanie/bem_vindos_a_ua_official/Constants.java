package com.example.stephanie.bem_vindos_a_ua_official;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

/**
 * Created by Stephanie on 05/05/2017.
 */

public class Constants {

    public static final long GEOFENCE_EXPIRATION_IN_MILLISECONDS = 12 * 60 * 60 * 1000;
    public static final float GEOFENCE_RADIUS_IN_METERS = 150;

    public static final HashMap<String, LatLng> LANDMARKS = new     HashMap<String, LatLng>();
    static {
//        // San Francisco International Airport.
//        LANDMARKS.put("Moscone South", new LatLng(37.783888,-122.4009012));
//
//        // Googleplex.
//        LANDMARKS.put("Japantown", new LatLng(37.785281,-122.4296384));
//
//        // Test
//        LANDMARKS.put("SFO", new LatLng(37.621313,-122.378955));

        // casa da Fátima
        LANDMARKS.put("Casa da Fatita", new LatLng(40.465559,-8.675408));
        //livraria da UA
//        40.631404, -8.658861
        LANDMARKS.put("Livraria da UA", new LatLng(40.631404, -8.658861));
        //40.6292820, -8.6562000
        LANDMARKS.put("Laboratório central de analises", new LatLng(40.6292820, -8.6562000));
        //40.467010, -8.674420
        LANDMARKS.put("Minipreço da Ponte de Vagos", new LatLng(40.467010,-8.674420));
    }
}