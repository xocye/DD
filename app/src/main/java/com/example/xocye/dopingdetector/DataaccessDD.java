package com.example.xocye.dopingdetector;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class DataaccessDD extends SQLiteOpenHelper {

    public DataaccessDD(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, nombre, factory, version);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {

        //Creamos la tabla
        db.execSQL("create table usuario(Code integer primary key, Name text)");

    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int version1, int version2) {

        db.execSQL("drop table if exists Farmaco");

        db.execSQL("create table Farmaco(Code integer primary key, Name text)");

    }

}