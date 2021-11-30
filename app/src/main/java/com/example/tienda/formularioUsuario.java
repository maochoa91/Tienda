package com.example.tienda;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class formularioUsuario extends AppCompatActivity {
    Button B1;
    EditText Enombre,Eapellido, Econtraseña1,Econtraseña2,Etelefono,Efecha,Ecorreo,Eusuario;
    GestorDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_usuario);
        B1=(Button) findViewById(R.id.b1);
        Enombre=(EditText) findViewById(R.id.Enombre);
        Eapellido=(EditText) findViewById(R.id.eapellido);
        Eusuario=(EditText) findViewById(R.id.eusuario);
        Econtraseña1=(EditText) findViewById(R.id.ePassword1);
        Econtraseña2=(EditText) findViewById(R.id.ePassword2);
        Etelefono=(EditText) findViewById(R.id.etelefono);
        Efecha=(EditText) findViewById(R.id.efecha);
        Ecorreo=(EditText) findViewById(R.id.ecorreo);
        db=new GestorDB(this);
        db.insertData("IVAn","OCHOA","ma","123656","correo","fecha","contraseña1");
    }

    public void guardarDatos(View view)
    {
        String nombre,apellido,telefono,correo,contraseña1,contraseña2,fecha,usuario;
        nombre=Enombre.getText().toString();
        apellido=Eapellido.getText().toString();
        usuario=Eusuario.getText().toString();
        telefono=Etelefono.getText().toString();
        correo=Ecorreo.getText().toString();
        fecha=Efecha.getText().toString();
        contraseña1=Econtraseña1.getText().toString();
        contraseña2=Econtraseña2.getText().toString();
        AlertDialog.Builder Alerta=new AlertDialog.Builder(this);
        Alerta.setTitle("advertencia");

        boolean v1,v2,v3;
        boolean v4;
        Cursor res;
        v1=nombre.matches("[A-Z].*");
        v2=apellido.matches("[A-Z].*");
        v3=contraseña1.equals(contraseña2);

        if(v1&&v2&&v3)
        {
           //db.onUpgrade(db.getWritableDatabase(),1,1);
           res=db.getData(usuario);

            if(res.moveToFirst())
            {
              Alerta.setMessage("Usuario ya existe");
            }
           else
            {

                Alerta.setMessage("registro exitoso");
                db.insertData(nombre,apellido,usuario,telefono,correo,fecha,contraseña1);
          }


        }
        else
        {
            Alerta.setMessage("error");

        }
        Alerta.create().show();


    }
    public void consultar(View view){
        Cursor res=db.getData("3");
        String informacion=null;
        if(res.moveToFirst())
        {
            informacion="ID="+res.getString(0)+"\n nombre="+res.getString(1);
        }

    }


    public void volver(View view) {



            Intent SA = new Intent(view.getContext(),MainActivity.class);
            startActivity(SA);

    }
}