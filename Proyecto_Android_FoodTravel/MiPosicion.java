package com.example.adrian.foodtravel;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/**
 * Created by adrian on 30/05/2015.
 */
public class MiPosicion implements LocationListener {
    public static float latitud;
    public static float longitud;
    public static boolean statusGPS;
    public static Location coordenada;

    @Override
    public void onLocationChanged(Location location) {
        location.getLatitude();
        location.getLongitude();

        latitud = Float.parseFloat(String.valueOf(location.getLatitude()));
        longitud = Float.parseFloat(String.valueOf(location.getLongitude()));

        coordenada = location;
    }

    @Override
    public void onProviderDisabled(String provider) {
        statusGPS = false;
    }

    @Override
    public void onProviderEnabled(String provider) {
        statusGPS = true;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }
}
