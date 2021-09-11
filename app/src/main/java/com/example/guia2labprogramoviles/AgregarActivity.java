package com.example.guia2labprogramoviles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.guia2labprogramoviles.model.Persona;
import static com.example.guia2labprogramoviles.MainActivity.personas;

public class AgregarActivity extends AppCompatActivity {

    ProgressBar barraCarga;
    TextView nombre, porcentaje;
    Button guardar;
    Handler h = new Handler();
    Intent principal;
    int i = 0;
    Boolean isActive = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        barraCarga = (ProgressBar)findViewById(R.id.pbLoad);
        nombre = (TextView)findViewById(R.id.txbNombre);
        guardar = (Button)findViewById(R.id.btnGuardar);
        porcentaje = (TextView)findViewById(R.id.txvPorcentaje);
    }

    public void guardarRegistro(View view){
        if (!isActive) {
            if (!nombre.getText().toString().isEmpty()) {
                Thread hilo = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        while (i <= 100) {
                            h.post(new Runnable() {
                                @Override
                                public void run() {
                                    porcentaje.setText(i + " %");
                                    barraCarga.setProgress(i);
                                }
                            });

                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            if (i == 100) {
                                personas.add(new Persona(nombre.getText().toString()));
                                principal = new Intent(AgregarActivity.this, MainActivity.class);
                                startActivity(principal);
                            }
                            i++;
                            isActive = true;
                        }
                    }
                });
                hilo.start();

            }else{
                Toast.makeText(this,"Campo vacio", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

}