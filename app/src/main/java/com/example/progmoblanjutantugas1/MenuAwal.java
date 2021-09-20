package com.example.progmoblanjutantugas1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuAwal extends AppCompatActivity {

    Button internal, eksternal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_awal);

        internal = findViewById(R.id.internalbtn);
        internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuAwal.this, DataInternal.class);
                startActivity(intent);
            }
        });

        eksternal = findViewById(R.id.eksternalbtn);
        eksternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuAwal.this, DataEksternal.class);
                startActivity(intent);
            }
        });
    }
}