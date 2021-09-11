package com.example.guia2labprogramoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;
import com.example.guia2labprogramoviles.model.Persona;

public class MainActivity extends AppCompatActivity {

    Button verLista;
    Button agregarNombre;
    Button misDatos;

    public static ArrayList<Persona> personas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verLista = (Button)findViewById(R.id.btnVerLista);
        agregarNombre = (Button)findViewById(R.id.btnAgregarNombre);
        misDatos = (Button)findViewById(R.id.btnMisDatos);

        verLista.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (personas.isEmpty()){
                    Toast.makeText(MainActivity.this, "Lista vacia", Toast.LENGTH_SHORT).show();
                }else {
                    Intent ver = new Intent(MainActivity.this, ListaActivity.class);
                    startActivity(ver);
                }
            }

        });

        agregarNombre.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent add = new Intent(MainActivity.this, AgregarActivity.class);
                startActivity(add);
            }
        });

        misDatos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent dat = new Intent(MainActivity.this, DatosActivity.class);
                startActivity(dat);
            }
        });

    }
}
