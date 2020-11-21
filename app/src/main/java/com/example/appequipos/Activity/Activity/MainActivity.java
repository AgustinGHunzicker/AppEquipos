package com.example.appequipos.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.appequipos.Activity.database.AppDatabase;
import com.example.appequipos.Activity.model.Equipo;
import com.example.appequipos.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AppDatabase db;
        db = AppDatabase.getInstance(getApplicationContext());

        /*
            editText variable
         */
        final EditText editName = findViewById(R.id.editTextNombreEquipo);
        /*
            Spinner variable
        */
        final Spinner spinnerDeporte = findViewById(R.id.spinnerDeporte);
        /*
            ListView variable
        */
        final ListView listViewEquipos = findViewById(R.id.listViewEquipos);



        /*
            Spinner variable
         */
        ArrayList deportes = new ArrayList<>();
        deportes.add("Futbol");
        deportes.add("Rugby");
        ArrayAdapter spinnerAdapterYears = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, deportes);
        spinnerDeporte.setAdapter(spinnerAdapterYears);

        /*
            ListView variable
         */
        ArrayList equipos = new ArrayList<>();
        ArrayAdapter listViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,equipos);
        listViewEquipos.setAdapter(listViewAdapter);

        /*
            Button variable
        */
        final Button btnRegistrar = findViewById(R.id.buttonRegistrarEquipo);
        btnRegistrar.setOnClickListener(view -> {
            if(!editName.getText().toString().equals("")){
                Equipo eq = new Equipo();
                eq.setNombre(editName.getText().toString());
                eq.setDeporte(spinnerDeporte.getSelectedItem().toString());
                db.daoEquipo().insertar(eq);
                ArrayAdapter<Equipo> adapter= new ArrayAdapter<Equipo>(this, android.R.layout.simple_list_item_1,db.daoEquipo().buscarTodos());
                listViewEquipos.setAdapter(adapter);
            }
        });

    }
}