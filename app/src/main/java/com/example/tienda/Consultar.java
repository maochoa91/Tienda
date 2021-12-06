package com.example.tienda;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Consultar extends AppCompatActivity {

    FirebaseFirestore db_Fire;
    Map<String, Object> Datos;
    EditText E1;
    TextView T1,T2,T3;
    Button B1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
        db_Fire=FirebaseFirestore.getInstance();
        Datos= new HashMap<>();
        T1=(TextView)findViewById(R.id.t1);
        T2=(TextView)findViewById(R.id.t2);
        T3=(TextView)findViewById(R.id.t3);
        E1=(EditText) findViewById(R.id.e1);
        B1=(Button) findViewById(R.id.b1);

    }

    public void Consultar(View view) {
        db_Fire.collection("Usuarios").document("1").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
               T1.setText(documentSnapshot.getId().toString()+"\n" + documentSnapshot.get("nombre").toString());
            }
        });

    }
}