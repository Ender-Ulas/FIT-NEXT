package com.example.fitnext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button egzersizler;
    private Button beslenme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        egzersizler = findViewById(R.id.btn_Egzersizler);
        beslenme = findViewById(R.id.btn_Beslenme);
        egzersizler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(),Egzersizler.class);
                startActivity(intent);
            }
        });
        beslenme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(),BESLENME.class);
                startActivity(intent);
            }
        });


    }
}