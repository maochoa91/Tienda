package com.example.tienda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class GestorDB extends SQLiteOpenHelper {
    public final static String DATABASE_NAME="Tienda";
    public final static String TABLE_NAME="Usuarios";
    public final static String TABLE_NAME_2="Productos";
    public final static String TABLE_NAME_3="Compras";
    public final static String COL1="ID";
    public final static String COL2="Nombre";
    public final static String COL3="Apellido";
    public final static String COL4="Usuario";
    public final static String COL5="Telefono";
    public final static String COL6="Correo";
    public final static String COL7="Fecha";
    public final static String COL8="Contrasena";
    public final static String COL1_2="ID";
    public final static String COL2_2="Producto";
    public final static String COL3_2="Disponible";
    public final static String COL1_3="ID";
    public final static String COL2_3="Usuario";
    public final static String COL3_3="Producto";
    public final static String COL4_3="Cantidad";

    public GestorDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " +TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+COL1+"TEXT,"+COL2 + " TEXT,"+ COL3+"TEXT, "+COL4+"TEXT, "+COL5+"TEXT,"+ COL6+"TEXT,"+COL7+"TEXT,"+COL8+"TEXT)" );
        db.execSQL("CREATE TABLE IF NOT EXISTS " +TABLE_NAME_2 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+COL1_2+"TEXT,"+COL2_2 + " TEXT,"+ COL3_2+"INTEGER)" );
        db.execSQL("CREATE TABLE IF NOT EXISTS " +TABLE_NAME_3 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+COL1_3+"TEXT,"+COL2_3 + " TEXT,"+ COL3_3+"TEXT, "+COL4_3+"INTEGER)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_2);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_3);
        onCreate(db);
    }

    public boolean insertData(String nombre, String apellido,String usuario ,String telefono, String correo, String fecha, String contrasena){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL2,nombre);
        cv.put(COL3,apellido);
        cv.put(COL4,usuario);
        cv.put(COL5,telefono);
        cv.put(COL6,correo);
        cv.put(COL7,fecha);
        cv.put(COL8,contrasena);
        long result=db.insert(TABLE_NAME,null,cv);

        if(result==-1)
            return false;
        else
            return true;

    }
    public boolean upDateData(String id, String nombre, String apellido,String usuario ,String telefono, String correo, String fecha, String contrasena)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL2,nombre);
        cv.put(COL3,apellido);
        cv.put(COL4,usuario);
        cv.put(COL5,telefono);
        cv.put(COL6,correo);
        cv.put(COL7,fecha);
        cv.put(COL8,contrasena);
        long result=db.update(TABLE_NAME,cv,"Usuario=?",new String[]{usuario});

        if(result==-1)
            return false;
        else
            return true;


    }

    public void deleteData(String usuario){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,"Usuario=?",new String[]{usuario});

    }
    public Cursor getData(String usu){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT *FROM "+TABLE_NAME+" WHERE Usuario='"+usu+"'",null);
        return cursor;

    }
}
