package com.example.sebastian.aseguradora;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by sebastian on 19/04/17.
 */

public class PolizasBD extends SQLiteOpenHelper {

    public static  class DatosTabla implements BaseColumns {
        public static final String NOMBRE_TABLA = "Directorio";
        public static final String COLUMNA_CODIGOS = "Codigos";
        public static final String COLUMNA_CEDULAS = "Cdedulas";
        public static final String COLUMNA_NOMBRES = "Nombres";
        public static final String COLUMNA_TELEFONOS = "Telefonos";
        public static final String COLUMNA_EMAILS = "Emails";
        public static final String COLUMNA_COBERTURAS = "Coberturas";

        public static final String NOMBRE_TABLA2 = "Coberturas";
        public static final String COLUMNA_PRIMAS = "Coberturas";

        private static final String CREAR_TABLA_1 =
                "CREATE TABLE " + DatosTabla.NOMBRE_TABLA + " (" +
                        DatosTabla.COLUMNA_CODIGOS + " INTEGER PRIMARY KEY," +
                        DatosTabla.COLUMNA_CEDULAS + " TEXT," +
                        DatosTabla.COLUMNA_NOMBRES + " TEXT," +
                        DatosTabla.COLUMNA_TELEFONOS + " TEXT," +
                        DatosTabla.COLUMNA_EMAILS + " TEXT," +
                        DatosTabla.COLUMNA_COBERTURAS + " TEXT)";

        private static final String CREAR_TABLA_2 =
                "CREATE TABLE " + DatosTabla.NOMBRE_TABLA2 + " (" +
                        DatosTabla.COLUMNA_CODIGOS + " INTEGER PRIMARY KEY," +
                        DatosTabla.COLUMNA_NOMBRES + " TEXT," +
                        DatosTabla.COLUMNA_PRIMAS + " TEXT)";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + DatosTabla.NOMBRE_TABLA;
    }

    public static  class Cobertura implements BaseColumns {


    }

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BasedeDatos.db";

    public PolizasBD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatosTabla.CREAR_TABLA_1);
        db.execSQL(DatosTabla.CREAR_TABLA_2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatosTabla.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
