package com.example.mascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mascotas.Modelos.Mascostas;
import com.example.mascotas.Modelos.Registro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String mascotas = "";
    EditText edtID, edtRaza, edtNombre, edtEdad;
    Button btnRegistrar, btnMostrar;
    TextView tvListamascotas;

    Registro datosMascotas = new Registro();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


                /*


        Mascostas neron=new Mascostas("2A","coker","neron",2);
neron.setEdad(10);
   System.out.println("la eded de neron es"+neron.getEdad());
*/
        initComponentes();
        registrarMascotas();
        mostrarMascotas();


    }

    private void mostrarMascotas() {
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File datos = new File(getFilesDir(), "datos.txt");

                try {
                    FileReader reader = new FileReader(datos);
                    BufferedReader reader2 = new BufferedReader(reader);
                    String line;
                    tvListamascotas.setText("");
                    while ((line = reader2.readLine()) != null) {

                        tvListamascotas.setText(tvListamascotas.getText().toString()+line+"\n");

                    }
                    reader2.close();

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
    }

    private void registrarMascotas() {
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mascostas mascota = new Mascostas(edtID.getText().toString(), edtRaza.getText().toString(), edtNombre.getText().toString(), Integer.parseInt(edtEdad.getText().toString()));
                datosMascotas.setAgregarMascotas(mascota);

                limpiarDatos();
                crearArchivo(mascota.toString() + "\n");

            }
        });
    }

    private void initComponentes() {
        edtID = findViewById(R.id.edt_id);
        edtRaza = findViewById(R.id.edt_raza);
        edtNombre = findViewById(R.id.edt_nombre);
        edtEdad = findViewById(R.id.edt_edad);
        btnRegistrar = findViewById(R.id.But_registro);
        btnMostrar = findViewById(R.id.but_mostrar_mascota);
        tvListamascotas = findViewById(R.id.texw_Mascota);


    }

    private void limpiarDatos() {
        edtID.setText("");
        edtRaza.setText("");
        edtNombre.setText("");
        edtEdad.setText("");
    }

    private void crearArchivo(String datosMascotas) {
        File datos = new File(getFilesDir(), "datos.txt");
        if (!datos.exists()) {
            try {
                FileWriter datosEscritura = new FileWriter(datos);
                datosEscritura.append(datosMascotas);
                datosEscritura.flush();
                datosEscritura.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            try {
                Files.write(Paths.get(getFilesDir() + "/datos.txt"), datosMascotas.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}