package com.example.adrian.foodtravel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adrian on 25/05/2015.
 */
public class FoodTravelSQLiteHelper extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE IF NOT EXISTS establecimiento (" +
                            "id_esta INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                            "nombre TEXT NOT NULL UNIQUE)";
    String sqlCreate2 = "CREATE TABLE IF NOT EXISTS menu (" +
                            "id_menu INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                            "nombre TEXT NOT NULL," +
                            "precio FLOAT NOT NULL," +
                            "establecimiento INT NOT NULL," +
                            "FOREIGN KEY (establecimiento) REFERENCES establecimiento (id_esta)\n" +
                                "ON DELETE CASCADE\n" +
                                "ON UPDATE CASCADE);";
    String sqlCreate3 = "CREATE TABLE IF NOT EXISTS producto (" +
                            "id_producto INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                            "tipo TEXT NOT NULL," +
                            "precio_min FLOAT NOT NULL," +
                            "precio_max FLOAT NOT NULL," +
                            "oferta FLOAT);";
    String sqlCreate4 ="CREATE TABLE IF NOT EXISTS establ_producto (" +
                            "establecimiento INT NOT NULL," +
                            "producto INT NOT NULL," +
                            "FOREIGN KEY (establecimiento) REFERENCES establecimiento (id_esta)\n" +
                                "ON DELETE CASCADE\n" +
                                "ON UPDATE CASCADE," +
                            "FOREIGN KEY (producto) REFERENCES producto (id_producto)\n" +
                                "ON DELETE RESTRICT\n" +
                                "ON UPDATE CASCADE);";
    String sqlCreate5 = "CREATE TABLE IF NOT EXISTS lugar (" +
                            "id_lugar INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                            "direccion TEXT NOT NULL," +
                            "latitud FLOAT NOT NULL," +
                            "longitud FLOAT NOT NULL," +
                            "establecimiento INT NOT NULL," +
                            "FOREIGN KEY (establecimiento) REFERENCES establecimiento (id_esta)\n" +
                                "ON DELETE CASCADE\n" +
                                "ON UPDATE CASCADE);";

    // constructor
    public FoodTravelSQLiteHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
        db.execSQL(sqlCreate2);
        db.execSQL(sqlCreate3);
        db.execSQL(sqlCreate4);
        db.execSQL(sqlCreate5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS Usuarios");

    }
}