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

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    ListView listNombres;
    String nombre;
    boolean bandera = false;
    ArrayList<String> arrayEstable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listNombres = (ListView) findViewById(R.id.listNombres);
        enviarNombre();
    }

    @Override
    protected void onResume() {
        super.onResume();
        llenarList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflador = getMenuInflater();
        inflador.inflate(R.menu.menu_insertardireccion, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final String estable;
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.AddDireccion:
                final Intent i = new Intent(this, Activity_AnhadirDireccion.class);

                estable = arrayEstable.get(info.position);

                i.putExtra("nombre", estable);
                startActivity(i);
                return true;
            case R.id.AddProducto:
                final Intent b = new Intent(this, Activity_AnhadirProductos.class);

                //direcc = arrayDireccion.get(info.position);
                estable = arrayEstable.get(info.position);
                b.putExtra("nombre", estable);
                //i.putExtra("direccion", direcc);
                startActivity(b);
                return true;
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


        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.menu_add:
                Intent intentAnhadir = new Intent(this, Activity_anhadir.class);
                startActivity(intentAnhadir);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void llenarList() {
        FoodTravelSQLiteHelper usdbh = new FoodTravelSQLiteHelper(this, "FoodTravel_BD", null, 1);

        SQLiteDatabase db = usdbh.getWritableDatabase();

        //Array que recibira los nombres de los establecimientos
        arrayEstable = new ArrayList();
        //Array donde estaran los datos
        String[] datos_establecimiento = new String[] {"id_esta", "nombre"};
        //Cursor para recorrer los datos
        Cursor establecimiento = db.query("establecimiento", datos_establecimiento, null, null, null, null, null);

        //Comprobamos que recuperara datos
        if (establecimiento.moveToFirst()) {
            //Los recorremos
            do {
                //Le pasamos el valor en la posicion "1" en una variable
                nombre = establecimiento.getString(1);
                //Añadimos la variable en el array
                arrayEstable.add(nombre);

            } while(establecimiento.moveToNext());
        }

        //Llenamos el ListView
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayEstable);


        listNombres.setAdapter(adaptador);
        listNombres.setAdapter(new ArrayAdapter(this, R.layout.list_item, arrayEstable));

        registerForContextMenu(listNombres);
        db.close();
    }

    public void enviarNombre() {
        final Intent direccion = new Intent(this, Activity_direcciones.class);
        listNombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String estable = parent.getItemAtPosition(position).toString();
                direccion.putExtra("nombre", estable);
                startActivity(direccion);
            }
        });
    }

}
