package com.example.tienda;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginUsuario extends AppCompatActivity {
    EditText Eusuario,Epassword;
    Button B1;
    CheckBox check;
    GestorDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuario);
        Eusuario=(EditText) findViewById(R.id.Eusuario);
        Epassword=(EditText) findViewById(R.id.Econtraseña);
        B1=(Button) findViewById(R.id.b1);
        check=(CheckBox) findViewById(R.id.check);
        db=new GestorDB(this);

    }

    public void ingresar(View view) {
        Cursor res;
        String clave;
        res=db.getData(Eusuario.getText().toString());
        if(res.moveToFirst())
        {
            clave=""+res.getString(7);
            if(clave.equals(Epassword.getText().toString()))
            {
                //llamar compras
            }
        }


    }
}