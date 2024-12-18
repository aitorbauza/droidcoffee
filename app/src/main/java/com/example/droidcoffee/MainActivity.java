package com.example.droidcoffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private String selectedDessert = ""; // Guarda el postre seleccionado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Imágenes del XML
        ImageView imageDonut = findViewById(R.id.donuts);
        ImageView imageIceCream = findViewById(R.id.ice_cream);
        ImageView imageFroyo = findViewById(R.id.froyo);

        // Clicks listeners para las imágenes (todas tienen un toast)
        imageDonut.setOnClickListener(v -> {
            selectedDessert = "donut";
            Toast.makeText(MainActivity.this, "You have chosen a donut!", Toast.LENGTH_SHORT).show();
        });

        imageIceCream.setOnClickListener(v -> {
            selectedDessert = "ice cream sandwich";
            Toast.makeText(MainActivity.this, "You have chosen an ice cream sandwich!", Toast.LENGTH_SHORT).show();
        });

        imageFroyo.setOnClickListener(v -> {
            selectedDessert = "FroYo";
            Toast.makeText(MainActivity.this, "You have chosen a FroYo!", Toast.LENGTH_SHORT).show();
        });

        // FloatingActionButton
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(v -> {
            // Intent para ir a MainActivity2
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("SELECTED_DESSERT", selectedDessert); // Enviar el postre seleccionado
            startActivity(intent);
        });
    }
}
