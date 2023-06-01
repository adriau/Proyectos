package com.example.adrian.foodtravel;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Activity_Establecimientos extends ActionBarActivity {
    TextView txtNombre, txtDireccion, txtMenu, txtSeparador4, txtProducto, txtSeparador3;
    Button btnVerMapa;
    GridView GridProductos;
    ListView listMenu;

    String nombre;
    String direccion;
    boolean bandera = false;

    ArrayList<String> productos;

    FoodTravelSQLiteHelper usdbh = new FoodTravelSQLiteHelper(this, "FoodTravel_BD", null, 1);
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_establecimientos);

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtDireccion = (TextView) findViewById(R.id.txtDireccion);
        txtMenu = (TextView) findViewById(R.id.txtMenu);
        txtSeparador4 = (TextView) findViewById(R.id.txtSeparador4);
        txtProducto = (TextView) findViewById(R.id.txtProducto);
        txtSeparador3 = (TextView) findViewById(R.id.txtSeparador3);
        btnVerMapa = (Button) findViewById(R.id.btnVerMapa);
        GridProductos = (GridView) findViewById(R.id.GridProductos);
        listMenu = (ListView) findViewById(R.id.listMenu);


        mostrarEstablecimiento();
        anhadirMenus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity__establecimientos, menu);
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

    public void mostrarEstablecimiento() {
        int tamanhoGrid = 210;
        int aumentar = 1;
        db = usdbh.getWritableDatabase();

        Intent i = getIntent();
        nombre = i.getExtras().getString("nombre");
        direccion = i.getExtras().getString("direccion");

        productos = new ArrayList<>();

        txtNombre.setText(nombre);
        txtDireccion.setText(direccion);

        productos.add("Tipo");
        productos.add("PrecioMin");
        productos.add("PrecioMax");
        productos.add("Oferta");

        Cursor c = db.rawQuery("SELECT tipo, precio_min, precio_max, oferta FROM producto WHERE id_producto IN (SELECT producto FROM establ_producto WHERE establecimiento = (SELECT id_esta FROM establecimiento WHERE nombre ='" + nombre + "'))", null);
        if (c.moveToFirst()) {
            do {
                String tipo = c.getString(0);
                float precio_min = c.getFloat(1);
                float precio_max = c.getFloat(2);
                float oferta = c.getFloat(3);

                productos.add(tipo);
                productos.add(String.valueOf(precio_min));
                productos.add(String.valueOf(precio_max));
                productos.add(String.valueOf(oferta));

                aumentar++;
            } while (c.moveToNext());
        } else {
            txtProducto.setVisibility(View.GONE);
            txtSeparador3.setVisibility(View.GONE);
            GridProductos.setVisibility(View.GONE);
        }
        ViewGroup.LayoutParams layoutParams = GridProductos.getLayoutParams();
        layoutParams.height = tamanhoGrid * aumentar; //this is in pixels
        GridProductos.setLayoutParams(layoutParams);

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, productos);
        GridProductos = (GridView) findViewById(R.id.GridProductos);
        GridProductos.setAdapter(adaptador);
    }

    public void anhadirMenus() {
        int tamanhoGrid = 190;
        int aumentar = 1;

        ArrayList<String> arrayMenu = new ArrayList();

        Cursor c = db.rawQuery("SELECT nombre, precio FROM menu WHERE establecimiento = (SELECT id_esta FROM establecimiento WHERE nombre ='" + nombre + "')", null);
        if (c.moveToFirst()) {
            do {
                String menu = c.getString(0);
                String precio = c.getString(1);

                String menuF = menu + "     " + precio + " Eur.";
                arrayMenu.add(menuF);

                aumentar++;
            } while (c.moveToNext());
        } else {
            txtMenu.setVisibility(View.GONE);
            txtSeparador4.setVisibility(View.GONE);
            listMenu.setVisibility(View.GONE);
        }

        ViewGroup.LayoutParams layoutParams = listMenu.getLayoutParams();
        layoutParams.height = tamanhoGrid * aumentar; //this is in pixels
        listMenu.setLayoutParams(layoutParams);

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayMenu);
        listMenu.setAdapter(adaptador);
        listMenu.setAdapter(new ArrayAdapter(this, R.layout.list_item, arrayMenu));

        registerForContextMenu(listMenu);
    }

    public void onCLick_Mapa(View v) {
        Intent verMapa = new Intent(this, Activity_mapa.class);

        Cursor c = db.rawQuery("SELECT latitud, longitud FROM lugar WHERE direccion ='" + direccion + "'", null);
        if (c.moveToFirst()) {
            float latitud = c.getFloat(0);
            float longitud = c.getFloat(1);

            bandera = true;

            verMapa.putExtra("bandera2", bandera);
            verMapa.putExtra("nombre", nombre);
            verMapa.putExtra("direccion", direccion);
            verMapa.putExtra("latitud", latitud);
            verMapa.putExtra("longitud", longitud);

            bandera = false;
        }

        startActivity(verMapa);

    }

}
