package com.example.adrian.foodtravel;

import android.content.ContentValues;
import android.content.Context;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class Activity_anhadir extends ActionBarActivity {
    EditText editNombre, editPrecioMin, editPrecioMax, editOtraUbicacion, editOferta, editMenu, editPrecioMenu;
    Spinner spinnerProducto;
    Button btnAnhadir, btnAnhadirProducto, btnAnhadirLugar;
    RadioButton rdbMiPosicion;

    FoodTravelSQLiteHelper usdbh = new FoodTravelSQLiteHelper(this, "FoodTravel_BD", null, 1);
    SQLiteDatabase db;

    ContentValues nuevoEstable = new ContentValues();
    ContentValues nuevoProduc = new ContentValues();
    ContentValues nuevoLugar = new ContentValues();
    ContentValues nuevoMenu = new ContentValues();
    ContentValues estableProd = new ContentValues();

    String nombre;
    String producto;
    String precioMin;
    String precioMax;
    String precioOferta;
    String menu;
    String precioMenu;
    String direccion;
    Float latitud;
    Float longitud;
    String lugar;

    LocationManager objLocation;
    LocationListener objLocListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_anhadir);

        editNombre = (EditText) findViewById(R.id.editNombre);
        editPrecioMin = (EditText) findViewById(R.id.editPrecioMin);
        editPrecioMax = (EditText) findViewById(R.id.editPrecioMax);
        editOferta = (EditText) findViewById(R.id.editOferta);
        editOtraUbicacion = (EditText) findViewById(R.id.editOtraUbicacion);
        editMenu = (EditText) findViewById(R.id.editMenu);
        editPrecioMenu = (EditText) findViewById(R.id.editPrecioMenu);
        spinnerProducto = (Spinner) findViewById(R.id.spinnerProducto);
        btnAnhadir = (Button) findViewById(R.id.btnAnhadir);
        btnAnhadirProducto = (Button) findViewById(R.id.btnAnhadirProducto);
        btnAnhadirLugar = (Button) findViewById(R.id.btnAnhadirLugar);
        rdbMiPosicion = (RadioButton) findViewById(R.id.rdbMiPosicion);

        objLocation = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        objLocListener = new MiPosicion();
        objLocation.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, objLocListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_anhadir, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        /*String otraUbicacion = editOtraUbicacion.getText().toString();*/

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    public void onClickAnhadir(View v) {
        btnAnhadir.setEnabled(false);
        btnAnhadirLugar.setEnabled(true);
        db = usdbh.getWritableDatabase();

        nombre = editNombre.getText().toString();

        if (!nombre.equalsIgnoreCase("")) {
            btnAnhadirLugar.setEnabled(true);
            nuevoEstable.put("nombre", nombre);
            db.insert("establecimiento", null, nuevoEstable);
        } else {
            Toast.makeText(this, "Debe escribir un nonbre", Toast.LENGTH_LONG).show();
        }


        db.close();
    }

    public void onClickAnhadirLugar(View v) {
        btnAnhadirLugar.setEnabled(false);
        btnAnhadirProducto.setEnabled(true);

        db = usdbh.getWritableDatabase();

        if (rdbMiPosicion.isChecked()) {
            direccion(db);
        } else {
            Toast.makeText(this, "Debe marcar la opcion", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickAnhadirProducto(View v) {
        db = usdbh.getWritableDatabase();

        producto = spinnerProducto.getSelectedItem().toString();
        precioMin = editPrecioMin.getText().toString();
        precioMax = editPrecioMax.getText().toString();
        precioOferta = editOferta.getText().toString();
        menu = editMenu.getText().toString();
        precioMenu = editPrecioMenu.getText().toString();

        if (!precioMin.equalsIgnoreCase("") || !precioMax.equalsIgnoreCase("")) {
            nuevoProduc.put("tipo", producto);
            nuevoProduc.put("precio_min", Float.valueOf(precioMin));
            nuevoProduc.put("precio_max", Float.valueOf(precioMax));

            if (!precioOferta.equalsIgnoreCase("")) {
                nuevoProduc.put("oferta", Float.valueOf(precioOferta));
            } else {
                nuevoProduc.put("oferta", 0);
            }

            db.insert("producto", null, nuevoProduc);
        } else {
            Toast.makeText(this, "Debes cubrir los campos indicados", Toast.LENGTH_LONG).show();
        }

        if (!menu.equalsIgnoreCase("") && !precioMenu.equalsIgnoreCase("")) {
            nuevoMenu.put("nombre", menu);
            nuevoMenu.put("precio", Float.valueOf(precioMenu));
            Cursor c = db.rawQuery("SELECT id_esta FROM establecimiento WHERE nombre='" + editNombre.getText().toString() + "'", null);
            if (c.moveToFirst()) {
                int id = c.getInt(0);
                nuevoMenu.put("establecimiento", id);
            }

            db.insert("menu", null, nuevoMenu);
        }

        Cursor c_idE = db.rawQuery("SELECT id_esta FROM establecimiento WHERE nombre='" + editNombre.getText().toString() + "'", null);
        if (c_idE.moveToFirst()) {
            int id_esta = c_idE.getInt(0);
            estableProd.put("establecimiento", id_esta);
        }


        Cursor c_idP = db.rawQuery("SELECT id_producto FROM producto WHERE tipo='" + producto + "'", null);
        if (c_idP.moveToLast()) {
            int id_producto = c_idP.getInt(0);
            estableProd.put("producto", id_producto);
        }

        db.insert("establ_producto", null, estableProd);

        db.close();
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

                Cursor c = db.rawQuery("SELECT id_esta FROM establecimiento WHERE nombre='" + editNombre.getText().toString() + "'", null);

                if (c.moveToFirst()) { //significa que se ha recuperado algo en la consulta
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
