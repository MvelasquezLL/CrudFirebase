package com.example.crudfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Agregar extends AppCompatActivity {

    EditText nombre, apellido, email, imgURL;
    Button btnadd, btnatras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        imgURL = findViewById(R.id.img1);
        nombre = findViewById(R.id.nombretxt);
        apellido = findViewById(R.id.apellidotxt);
        email = findViewById(R.id.emailtxt);

        btnadd = findViewById(R.id.btn_agregar);
        btnatras = findViewById(R.id.btn_atras);

        btnadd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                insertardatos();
            }
        });
        btnatras.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }
    private void insertardatos() {
        Map<String,Object> map = new HashMap<>();
        map.put("Nombre", nombre.getText().toString());
        map.put("Apellido", apellido.getText().toString());
        map.put("Email", email.getText().toString());
        map.put("ImgURL", imgURL.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Programación Android").push()
                .setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused){
                        Toast.makeText(Agregar.this, "Insertado Correctamente", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener(){
                    @Override
                    public void onFailure(@NonNull Exception e){
                        Toast.makeText(Agregar.this, "Error al Insertar", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}