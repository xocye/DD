package com.example.xocye.dopingdetector.dataaccess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataAccess extends SQLiteOpenHelper{



    public DataAccess(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     // si no existe la  base de datos la crea  y  ejecuta los sigeunetes comandos


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // se  elimina la  versión anterior  de la tabala
      db.execSQL("DROP TABLE IF EXISTS Farmaco");

        // se  crea la nueva version de la tabla

    }
}