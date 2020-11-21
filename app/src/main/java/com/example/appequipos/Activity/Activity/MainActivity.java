package com.example.appequipos.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.appequipos.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            editText variable
         */
        final EditText editName = findViewById(R.id.editTextNombreEquipo);
        /*
            Spinner variable
        */
        final Spinner spinnerDeporte = findViewById(R.id.spinnerDeporte);

        /*
            Button variable
        */
        final Button btnRegistrar = findViewById(R.id.buttonRegistrarEquipo);
        ArrayList deportes = new ArrayList<>();
        ArrayAdapter spinnerAdapterYears = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, deportes);
        spinnerDeporte.setAdapter(spinnerAdapterYears);

        //btnRegistrar.setOnClickListener();


    }
}