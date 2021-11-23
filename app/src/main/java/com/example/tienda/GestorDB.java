package com.example.tienda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class GestorDB extends SQLiteOpenHelper {
    public final static String DATABASE_NAME="DB_prueba";
    public final static String TABLE_NAME="Tabla1";
    public final static String COL1="ID";
    public final static String COL2="nombre";
    public final static String COL3="apellido";
    public final static String COL4="telefono";
    public final static String COL5="correo";
    public final static String COL6="fecha";
    public final static String COL7="contraseña";

    public GestorDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " +TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+COL1+"TEXT,"+COL2 + " TEXT,"+ COL3+"TEXT, "+COL4+"INTEGER, "+COL5+"TEXT,"+ COL6+"TEXT,"+COL7+"TEXT )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String nombre, String apellido, String telefono, String correo, String fecha, String contraseña){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL2,nombre);
        cv.put(COL3,apellido);
        cv.put(COL4,telefono);
        cv.put(COL5,correo);
        cv.put(COL6,fecha);
        cv.put(COL7,contraseña);
        long result=db.insert(TABLE_NAME,null,cv);

        if(result==-1)
            return false;
        else
            return true;

    }
    public boolean upDateData(String id, String nombre, String apellido, String telefono, String correo, String fecha, String contraseña)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL2,nombre);
        cv.put(COL3,apellido);
        cv.put(COL4,telefono);
        cv.put(COL5,correo);
        cv.put(COL6,fecha);
        cv.put(COL7,contraseña);
        long result=db.update(TABLE_NAME,cv,"ID=?",new String[]{id});

        if(result==-1)
            return false;
        else
            return true;


    }

    public void deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,"ID=?",new String[]{id});

    }
    public Cursor getData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE ID='"+id+"'",null);
        return cursor;

    }
}
