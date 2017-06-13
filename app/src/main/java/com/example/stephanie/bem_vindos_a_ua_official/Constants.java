package com.example.stephanie.bem_vindos_a_ua_official;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

/**
 * Created by Stephanie on 05/05/2017.
 */

public class Constants {

    //duas horas
    public static final long GEOFENCE_EXPIRATION_IN_MILLISECONDS = 7200000;

    //uma semana
    public static final long GEOFENCE_EXPIRATION_IN_MILLISECONDS_WEEK = 604800000;

    public static final float GEOFENCE_RADIUS_IN_METERS = 75;

    public static final HashMap<String, LatLng> LANDMARKSArchitecture = new     HashMap<String, LatLng>();
    static {
        //arquitetura

        //40.631067, -8.659567 biblioteca
        LANDMARKSArchitecture.put("Biblioteca", new LatLng(40.631067, -8.659567));
        //40.630735, -8.659175 Serviços da Acção Social da UA
        LANDMARKSArchitecture.put("Serviços da Acção Social da UA", new LatLng(40.630735, -8.659175));
        //40.631209, -8.655459 Snack Bar
        LANDMARKSArchitecture.put("Snack Bar", new LatLng(40.631209, -8.655459));
        //40.629613, -8.655647 Complexo Pedagógico
        LANDMARKSArchitecture.put("Complexo Pedagógico", new LatLng(40.629613, -8.655647));
//        //40.465949, -8.675332
//        LANDMARKSArchitecture.put("Casa", new LatLng(40.465949, -8.675332));
    }

    public static final HashMap<String, LatLng> LANDMARKSWelcomeUA = new     HashMap<String, LatLng>();
    static {
        //Bemvindos à UA

        //40.631067, -8.659567 biblioteca
        LANDMARKSWelcomeUA.put("Biblioteca", new LatLng(40.631067, -8.659567));
        //40.630735, -8.659175 Serviços da Acção Social da UA
        LANDMARKSWelcomeUA.put("Serviços da Acção Social da UA", new LatLng(40.630735, -8.659175));
        //40.631209, -8.655459 Snack Bar
        LANDMARKSWelcomeUA.put("Snack Bar", new LatLng(40.631209, -8.655459));
        //40.629613, -8.655647 Complexo Pedagógico
        LANDMARKSWelcomeUA.put("Complexo Pedagógico", new LatLng(40.629613, -8.655647));

    }

        //Eventos + promoções
    public static final HashMap<String, LatLng> LANDMARKSGeral= new     HashMap<String, LatLng>();
    static {
//      40.465949, -8.675332
//      LANDMARKSGeral.put("Casa", new LatLng(40.465949, -8.675332));
//      LANDMARKSGeral.put("SlERD 2017 going on inside Department of Comunication and Arts", new LatLng(40.628839,-8.6588147));
        LANDMARKSGeral.put("Gravação da versão beta a decorrer dentro de casa", new LatLng(40.628842, -8.656629));

    }
}