package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class productos extends AppCompatActivity {
    RecyclerView LISTAPRODUCTOS;
    List<producto> PRODUCTOS;
    Context CONTEXTO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

      LISTAPRODUCTOS=(RecyclerView)findViewById(R.id.lista);
       LISTAPRODUCTOS.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(CONTEXTO);
      LISTAPRODUCTOS.setLayoutManager(layoutManager);
       Adaptador adaptador=new Adaptador(PRODUCTOS);
        inicializaDATOS();
      inicializaADAPTADOR();

    }
    private void inicializaDATOS() {
        PRODUCTOS=new ArrayList<>();
        //int i;
        PRODUCTOS.add(new producto("hola",R.drawable.ic_launcher_background));
        PRODUCTOS.add(new producto("como",R.drawable.ic_launcher_background));
        PRODUCTOS.add(new producto("te ",R.drawable.ic_launcher_background));
        PRODUCTOS.add(new producto("va",R.drawable.ic_launcher_background));

    }
    private void inicializaADAPTADOR() {
        Adaptador adaptador=new Adaptador(PRODUCTOS);
        LISTAPRODUCTOS.setAdapter(adaptador);
    }
}