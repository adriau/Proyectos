package com.example.adrian.foodtravel;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Activity_AnhadirProductos extends ActionBarActivity {
    EditText editPrecioMin, editPrecioMax, editOferta, editMenu, editPrecioMenu;
    Spinner spinnerProducto;
    Button btnAnhadirProducto;

    String producto;
    String precioMin;
    String precioMax;
    String precioOferta;
    String menu;
    String precioMenu;

    FoodTravelSQLiteHelper usdbh = new FoodTravelSQLiteHelper(this, "FoodTravel_BD", null, 1);
    SQLiteDatabase db;

    ContentValues nuevoProduc = new ContentValues();
    ContentValues nuevoMenu = new ContentValues();
    ContentValues estableProd = new ContentValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_anhadir_productos);

        editPrecioMin = (EditText) findViewById(R.id.editPrecioMin);
        editPrecioMax = (EditText) findViewById(R.id.editPrecioMax);
        editOferta = (EditText) findViewById(R.id.editOferta);
        editMenu = (EditText) findViewById(R.id.editMenu);
        editPrecioMenu = (EditText) findViewById(R.id.editPrecioMenu);
        spinnerProducto = (Spinner) findViewById(R.id.spinnerProducto);
        btnAnhadirProducto = (Button) findViewById(R.id.btnAnhadirProducto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_anhadir_productos, menu);
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

    public void onClickAnhadirProducto(View v) {
        Intent i = getIntent();
        String nombreEsta = i.getExtras().getString("nombre");

        db = usdbh.getWritableDatabase();

        producto = spinnerProducto.getSelectedItem().toString();
        precioMin = editPrecioMin.getText().toString();
        precioMax = editPrecioMax.getText().toString();
        precioOferta = editOferta.getText().toString();
        menu = editMenu.getText().toString();
        precioMenu = editPrecioMenu.getText().toString();

        if (!precioMin.equalsIgnoreCase("") && !precioMax.equalsIgnoreCase("")) {
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

                Cursor c_idE = db.rawQuery("SELECT id_esta FROM establecimiento WHERE nombre='" + nombreEsta + "'", null);
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
            }else {
                Toast.makeText(this, "Debes cubrir los campos", Toast.LENGTH_LONG).show();
            }
        }

        if (!menu.equalsIgnoreCase("") && !precioMenu.equalsIgnoreCase("")) {
            nuevoMenu.put("nombre", menu);
            nuevoMenu.put("precio", Float.valueOf(precioMenu));

            Cursor c = db.rawQuery("SELECT id_esta FROM establecimiento WHERE nombre='" + nombreEsta + "'", null);
            if (c.moveToFirst()) {
                int id = c.getInt(0);
                nuevoMenu.put("establecimiento", id);
            }

            db.insert("menu", null, nuevoMenu);
            Toast.makeText(this, "Se inserto correctamente", Toast.LENGTH_LONG).show();
        }

        db.close();
    }
}
