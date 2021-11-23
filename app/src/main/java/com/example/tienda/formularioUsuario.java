package com.example.tienda;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class formularioUsuario extends AppCompatActivity {
    Button B1;
    EditText Enombre,Eapellido, Econtraseña1,Econtraseña2,Etelefono,Efecha,Ecorreo;
    GestorDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_usuario);
        B1=(Button) findViewById(R.id.b1);
        Enombre=(EditText) findViewById(R.id.Enombre);
        Eapellido=(EditText) findViewById(R.id.eapellido);
        Econtraseña1=(EditText) findViewById(R.id.ePassword1);
        Econtraseña2=(EditText) findViewById(R.id.ePassword2);
        Etelefono=(EditText) findViewById(R.id.etelefono);
        Efecha=(EditText) findViewById(R.id.efecha);
        Ecorreo=(EditText) findViewById(R.id.ecorreo);
        db=new GestorDB(this);

    }

    public void guardarDatos(View view)
    {
        String nombre,apellido,telefono,correo,contraseña1,contraseña2,fecha;
        nombre=Enombre.getText().toString();
        apellido=Eapellido.getText().toString();
        telefono=Etelefono.getText().toString();
        correo=Ecorreo.getText().toString();
        fecha=Efecha.getText().toString();
        contraseña1=Econtraseña1.getText().toString();
        contraseña2=Econtraseña2.getText().toString();

        db.insertData(nombre,apellido,telefono,correo,fecha,contraseña1);
        int v1,v2,v3;
        boolean v4;
        v4=nombre.matches("[A-Z].*");

        v1=validarDatos(1,nombre);
        v2=validarDatos(1,apellido);
        v3=validarDatos(2,telefono);

    }
    public void consultar(View view){
        Cursor res=db.getData("1");
        String informacion=null;
        if(res.moveToFirst())
        {
            informacion="ID="+res.getString(0)+"\n nombre="+res.getString(1);
        }

    }
    private int validarDatos(int i, String cadena) {
        int validacion=1,c,pos;
        switch (i)
        {
            case 1:
                for(pos=0;pos<cadena.length();pos++) {
                    c = cadena.charAt(pos);
                    if(c<65||c>90)
                    {
                        validacion=0;
                        pos=cadena.length();
                    }
                }
                break;

            case 2:
                for(pos=0;pos<cadena.length();pos++) {
                    c = cadena.charAt(pos);
                    if(c<48||c>57)
                    {
                        validacion=0;
                        pos=cadena.length();
                    }
                }
                break;
        }
        return validacion;
    }

    public void volver(View view) {



            Intent SA = new Intent(view.getContext(),MainActivity.class);
            startActivity(SA);

    }
}