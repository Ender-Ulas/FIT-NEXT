package com.example.fitnext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Egzersizler extends AppCompatActivity {
    private Button karin;
    private Button sirt;
    private Button gogus;
    private Button omuz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egzersizler);

        karin = findViewById(R.id.btn_karinkasi);
        sirt = findViewById(R.id.btn_sirt);
        gogus = findViewById(R.id.btn_gogus);
        omuz = findViewById(R.id.btn_omuz);

        karin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(),karinkasisayfasi.class);
                startActivity(intent);
            }
        });
        sirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(),sirtsayfasi.class);
                startActivity(intent);
            }
        });
        omuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(),omuzsayfasi.class);
                startActivity(intent);
            }
        });
        gogus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(),gogussayfasi.class);
                startActivity(intent);
            }
        });

    }
}