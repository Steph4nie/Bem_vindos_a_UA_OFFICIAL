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

    public static final float GEOFENCE_RADIUS_IN_METERS = 500;

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
        LANDMARKSWelcomeUA.put("Alameda", new LatLng(40.630052, -8.657242));
        //40.629613, -8.655647 Complexo Pedagógico
        LANDMARKSWelcomeUA.put("Casa do Estudante", new LatLng(40.623843, -8.657336));

    }

        //Eventos + promoções
    public static final HashMap<String, LatLng> LANDMARKSGeral= new     HashMap<String, LatLng>();
    static {

        LANDMARKSGeral.put("geociências", new LatLng(40.629721, -8.656766
        ));

        LANDMARKSGeral.put("Meia lua", new LatLng(40.629179, -8.656350));

        LANDMARKSGeral.put("Laboratório Central", new LatLng(40.629355, -8.656243
        ));

        LANDMARKSGeral.put("Complexo Pedagógico", new LatLng(40.629526, -8.655948
        ));

        LANDMARKSGeral.put("Alameda", new LatLng(40.630055, -8.657112
        ));

        LANDMARKSGeral.put("CICECO", new LatLng(40.629949, -8.656576
        ));

        LANDMARKSGeral.put("degei", new LatLng(40.630501, -8.657463));

        LANDMARKSGeral.put("Fotossíntese", new LatLng(40.631312, -8.658608
        ));
    }
}