package com.example.adrian.foodtravel;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Activity_direcciones extends ActionBarActivity {
    ListView listDirecciones;
    ArrayList<String> arrayDireccion;

    String direccion;
    String nombreEsta;
    boolean bandera = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_direcciones);

        listDirecciones = (ListView) findViewById(R.id.listDirecciones);
        enviarNombre();
        llenarList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        llenarList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_direcciones, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflador = getMenuInflater();
        inflador.inflate(R.menu.menu_insertarproducto, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final String direcc;
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            /*case R.id.AddProducto:
                final Intent i = new Intent(this, Activity_AnhadirProductos.class);

                direcc = arrayDireccion.get(info.position);

                i.putExtra("nombre", nombreEsta);
                i.putExtra("direccion", direcc);
                startActivity(i);
                return true;*/
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        FoodTravelSQLiteHelper usdbh = new FoodTravelSQLiteHelper(this, "FoodTravel_BD", null, 1);

        SQLiteDatabase db = usdbh.getWritableDatabase();

        ArrayList<String> arrayDirecc = new ArrayList<>();
        ArrayList<String> arrayLatitud = new ArrayList<>();
        ArrayList<String> arrayLongitud = new ArrayList<>();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.menu_mapa:
                Intent intentMapa = new Intent(this, Activity_mapa.class);
                Cursor c = db.rawQuery("SELECT direccion, latitud, longitud FROM lugar WHERE establecimiento = (SELECT id_esta FROM establecimiento WHERE nombre = '" + nombreEsta + "')", null);
                if (c.moveToFirst()) {
                    do {
                        String direccion = c.getString(0);
                        String latitud = c.getString(1);
                        String longitud = c.getString(2);

                        arrayDirecc.add(direccion);
                        arrayLatitud.add(latitud);
                        arrayLongitud.add(longitud);

                    } while (c.moveToNext());
                }
                bandera = true;

                intentMapa.putExtra("bandera", bandera);
                intentMapa.putExtra("nombreEsta", nombreEsta);
                intentMapa.putExtra("arrayDirecc", arrayDirecc);
                intentMapa.putExtra("arrayLatitud", arrayLatitud);
                intentMapa.putExtra("arrayLongitud", arrayLongitud);

                bandera = false;
                startActivity(intentMapa);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void llenarList() {
        FoodTravelSQLiteHelper usdbh = new FoodTravelSQLiteHelper(this, "FoodTravel_BD", null, 1);

        SQLiteDatabase db = usdbh.getWritableDatabase();

        arrayDireccion = new ArrayList();
        Intent nombre = getIntent();
        nombreEsta = nombre.getExtras().getString("nombre");

        Cursor c = db.rawQuery("SELECT direccion FROM lugar WHERE establecimiento = (SELECT id_esta FROM establecimiento WHERE nombre = '" + nombreEsta + "')", null);
        if (c.moveToFirst()) {
            do {
                String direccion = c.getString(0);
                int posicion = direccion.lastIndexOf(",");
                String ciudad = direccion.substring(posicion + 1, direccion.length());

                if (direccion.indexOf(ciudad) != -1) {
                    arrayDireccion.add(direccion);
                }
            } while(c.moveToNext());

        }

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayDireccion);

        listDirecciones.setAdapter(adaptador);
        listDirecciones.setAdapter(new ArrayAdapter(this, R.layout.list_item, arrayDireccion));

        registerForContextMenu(listDirecciones);
        db.close();

    }

    public void enviarNombre() {
        final Intent direccion = new Intent(this, Activity_Establecimientos.class);
        listDirecciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String direcc = parent.getItemAtPosition(position).toString();
                direccion.putExtra("nombre", nombreEsta);
                direccion.putExtra("direccion", direcc);
                startActivity(direccion);
            }
        });
    }
}
