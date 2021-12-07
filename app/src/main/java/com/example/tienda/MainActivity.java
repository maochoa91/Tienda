package com.example.tienda;

import android.content.DialogInterface;
import android.content.Intent;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button B1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        B1=(Button) findViewById(R.id.b1);
    }

    public void Registro(View view) {
        AlertDialog.Builder Alerta=new AlertDialog.Builder(this);
        Alerta.setTitle("advertencia");
        Alerta.setMessage("Has ingresado al registro");
        Alerta.setPositiveButton("ingresar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent SA = new Intent(view.getContext(),formularioUsuario.class);
                startActivity(SA);
            }
        });
        Alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast toast2= Toast.makeText(view.getContext(),"",Toast.LENGTH_LONG);
                toast2.setText("usted cancelo");
                toast2.setGravity(Gravity.AXIS_SPECIFIED, 200,50);
                toast2.show();
            }
        });
        Alerta.create().show();

    }

    public void consultar(View view) {


            Intent SA = new Intent(view.getContext(),Consultar.class);
            startActivity(SA);

    }
    public void Productos(View view) {


            Intent SA = new Intent(view.getContext(),productos.class);
            startActivity(SA);

    }
}