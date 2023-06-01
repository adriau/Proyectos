package com.example.adrian.foodtravel;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class Activity_AnhadirDireccion extends ActionBarActivity {
    RadioButton rdbMiPosicion;

    float latitud;
    float longitud;
    String direccion;
    String lugar;

    FoodTravelSQLiteHelper usdbh = new FoodTravelSQLiteHelper(this, "FoodTravel_BD", null, 1);
    SQLiteDatabase db;

    LocationManager objLocation;
    LocationListener objLocListener;

    ContentValues nuevoLugar = new ContentValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_anhadir_direccion);

        rdbMiPosicion = (RadioButton) findViewById(R.id.rdbMiPosicion);

        objLocation = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        objLocListener = new MiPosicion();
        objLocation.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, objLocListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_add_direccion, menu);
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

    public void onClickAnhadirLugar(View v) {
        db = usdbh.getWritableDatabase();

        if (rdbMiPosicion.isChecked()) {
            direccion(db);
        } else {
            Toast.makeText(this, "Debe marcar la opcion", Toast.LENGTH_LONG).show();
        }

    }

    public String obtenerDireccion(Location loc) {
        if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
                if (!list.isEmpty()) {
                    Address address = list.get(0);
                    address.getAddressLine(0);

                    direccion = address.getAddressLine(0);
                    String ciudad = address.getLocality();

                    lugar = direccion + ", " + ciudad;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lugar;
    }

    public void direccion(SQLiteDatabase db) {
        if (objLocation.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            if (MiPosicion.latitud > 0) {
                latitud = MiPosicion.latitud;
                longitud = MiPosicion.longitud;
                String miPosicion = obtenerDireccion(MiPosicion.coordenada);

                nuevoLugar.put("direccion", miPosicion);
                nuevoLugar.put("latitud", latitud);
                nuevoLugar.put("longitud", longitud);

                Intent nombreRecibido = getIntent();
                String nombre = nombreRecibido.getExtras().getString("nombre");

                Cursor c = db.rawQuery("SELECT id_esta FROM establecimiento WHERE nombre='" + nombre + "'", null);

                if (c.moveToFirst()) {
                    int id = c.getInt(0);
                    nuevoLugar.put("establecimiento", id);
                    db.insert("lugar", null, nuevoLugar);
                    Toast.makeText(this, "Ubicacion insertada", Toast.LENGTH_LONG).show();
                }
            }
        } else {
            Toast.makeText(this, "Es necesario que el GPS este activado", Toast.LENGTH_LONG).show();
        }
    }
}
