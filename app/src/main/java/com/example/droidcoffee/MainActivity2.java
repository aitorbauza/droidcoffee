package com.example.droidcoffee;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Se obtiene el mensaje del Intent
        String selectedDessert = getIntent().getStringExtra("SELECTED_DESSERT");

        // Se configurar el TextView
        TextView textViewHeader = findViewById(R.id.textView_header);
        if (selectedDessert != null && !selectedDessert.isEmpty()) {
            textViewHeader.setText("You have selected a " + selectedDessert + ".");
        } else {
            textViewHeader.setText("No dessert selected.");
        }

        //Spinner
        Spinner spinner = findViewById(R.id.spinner2);

        // array de strings
        String[] options = getResources().getStringArray(R.array.PHONE);

        // Creamos un ArrayAdapter usando el array de opciones
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);

        // Se especifica el diseño para la lista desplegable
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Se establece el adapter al Spinner
        spinner.setAdapter(adapter);

        // Se configurar el listener para cuando se seleccione una opción
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, android.view.View selectedItemView, int position, long id) {
                // Se muestra la opción seleccionada en un Toast
                String selectedOption = parentView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity2.this, "Selected: " + selectedOption, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // No hace nada si no se selecciona nada
            }
        });

        //  FloatingActionButton
        FloatingActionButton fab = findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(view -> {
            // Intent para ir a MainActivity
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
