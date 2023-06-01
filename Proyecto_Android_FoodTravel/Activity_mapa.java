package com.example.adrian.foodtravel;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Activity_mapa extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    boolean bandera = false;
    boolean bandera2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_mapa);
        setUpMapIfNeeded();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        Intent datos = getIntent();
        bandera2 = datos.getExtras().getBoolean("bandera2");
        Intent datos2 = getIntent();
        bandera = datos2.getExtras().getBoolean("bandera");

        CameraPosition campos = null;
        CameraUpdate camUpd3 = null;


        if (bandera2 == true) {
            String nombre = datos.getExtras().getString("nombre").toString();
            String direccion = datos.getExtras().getString("direccion").toString();
            float latitud = datos.getExtras().getFloat("latitud");
            float longitud = datos.getExtras().getFloat("longitud");

            mMap.addMarker(new MarkerOptions().position(new LatLng(latitud, longitud)).title(nombre).snippet(direccion));

            campos = new CameraPosition(new LatLng(latitud, longitud), 18, 0, 0);
            camUpd3 = CameraUpdateFactory.newCameraPosition(campos);
            mMap.animateCamera(camUpd3);
        }

        if (bandera == true) {
            String nombreEsta = datos2.getExtras().getString("nombreEsta").toString();
            ArrayList<String> arrayDirecc = datos2.getExtras().getStringArrayList("arrayDirecc");
            ArrayList<String> arrayLatitud = datos2.getExtras().getStringArrayList("arrayLatitud");
            ArrayList<String> arrayLongitud = datos2.getExtras().getStringArrayList("arrayLongitud");

            for (int i = 0; i < arrayDirecc.size(); i++) {
                mMap.addMarker(new MarkerOptions().position(new LatLng(Float.parseFloat(arrayLatitud.get(i)), Float.parseFloat(arrayLongitud.get(i)))).title(nombreEsta).snippet(arrayDirecc.get(i)));
            }

            campos = new CameraPosition(new LatLng(Float.parseFloat(arrayLatitud.get(0)), Float.parseFloat(arrayLongitud.get(0))),12, 0, 0);
            camUpd3 = CameraUpdateFactory.newCameraPosition(campos);
            mMap.animateCamera(camUpd3);
        }
    }
}
