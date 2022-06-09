package com.example.fitnext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;



public class boykilohesapla extends AppCompatActivity {
    private EditText editText;
    private TextView boy_tv,durum_tv,ideal_tv,kilo_tv;
    private SeekBar seekBar;
    private RadioGroup radioGroup;
    private boolean erkekmi = true;
    private double boy = 0.0;
    private int kilo = 50;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boykilohesapla);

        editText = (EditText) findViewById(R.id.editText);
        boy_tv = (TextView) findViewById(R.id.boy_tv);
        durum_tv = (TextView) findViewById(R.id.durum_tv);
        ideal_tv = (TextView) findViewById(R.id.ideal_tv);
        kilo_tv = (TextView) findViewById(R.id.kilo_tv);
        radioGroup = (RadioGroup) findViewById(R.id.radioGrup);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        editText.addTextChangedListener(editTextOlayIsleyicisi);
        seekBar.setOnSeekBarChangeListener(seekBarOlayIsleyicisi);
        radioGroup.setOnCheckedChangeListener(radioGroupOlayIsleyicisi);

        guncelle();
    }
    private void guncelle() {
        kilo_tv.setText(String.valueOf(kilo) + " kg");
        boy_tv.setText(String.valueOf(boy));
        int ideal_kiloBay = (int) (50 + 2.3 * (boy * 100 * 0.4 - 60));
        int ideal_kiloBayan = (int) (45.5 + 2.3 * (boy * 100 * 0.4 - 60));
        double vki = kilo / (boy * boy);

        if (boy <= 0) {
            ideal_tv.setText("");
            durum_tv.setText("");
        } else {
            if (erkekmi) {
                ideal_tv.setText(String.valueOf(ideal_kiloBay));

                if (vki <= 17.5) {
                    durum_tv.setBackgroundResource(R.color.cokzayif);
                    durum_tv.setText(R.string.cokzayif);
                } else if (vki > 17.5 && vki <= 20.7) {
                    durum_tv.setBackgroundResource(R.color.zayif);
                    durum_tv.setText(R.string.zayif);
                } else if (vki > 20.7 && vki <= 26.4) {
                    durum_tv.setBackgroundResource(R.color.ideal);
                    durum_tv.setText(R.string.ideal);
                } else if (vki > 26.4 && vki <= 27.8) {
                    durum_tv.setBackgroundResource(R.color.birazFazla);
                    durum_tv.setText(R.string.birazFazla);
                } else if (vki > 27.8 && vki <= 31.1) {
                    durum_tv.setBackgroundResource(R.color.fazla);
                    durum_tv.setText(R.string.fazla);
                } else if (vki > 31.1 && vki <= 34.9) {
                    durum_tv.setBackgroundResource(R.color.cokFazla);
                    durum_tv.setText(R.string.cokFazla);
                } else if (vki > 34.9 && vki <= 40) {
                    durum_tv.setBackgroundResource(R.color.riskli);
                    durum_tv.setText(R.string.riskli);
                } else if (vki > 40 && vki <= 50) {
                    durum_tv.setBackgroundResource(R.color.hasta);
                    durum_tv.setText(R.string.hasta);
                } else {
                    durum_tv.setBackgroundResource(R.color.superkilo);
                    durum_tv.setText(R.string.superkilo);
                }

            } else {
                ideal_tv.setText(String.valueOf(ideal_kiloBayan));


                if (vki <= 17.5) {
                    durum_tv.setBackgroundResource(R.color.cokzayif);
                    durum_tv.setText(R.string.cokzayif);
                } else if (vki > 17.5 && vki <= 19.1) {
                    durum_tv.setBackgroundResource(R.color.zayif);
                    durum_tv.setText(R.string.zayif);
                } else if (vki > 19.1 && vki <= 25.8) {
                    durum_tv.setBackgroundResource(R.color.ideal);
                    durum_tv.setText(R.string.ideal);
                } else if (vki > 25.8 && vki <= 27.3) {
                    durum_tv.setBackgroundResource(R.color.birazFazla);
                    durum_tv.setText(R.string.birazFazla);
                } else if (vki > 27.3 && vki <= 32.3) {
                    durum_tv.setBackgroundResource(R.color.fazla);
                    durum_tv.setText(R.string.fazla);
                } else if (vki > 32.3 && vki <= 34.9) {
                    durum_tv.setBackgroundResource(R.color.cokFazla);
                    durum_tv.setText(R.string.cokFazla);
                } else if (vki > 34.9 && vki <= 40) {
                    durum_tv.setBackgroundResource(R.color.riskli);
                    durum_tv.setText(R.string.riskli);
                } else if (vki > 40 && vki <= 50) {
                    durum_tv.setBackgroundResource(R.color.hasta);
                    durum_tv.setText(R.string.hasta);
                } else {
                    durum_tv.setBackgroundResource(R.color.superkilo);
                    durum_tv.setText(R.string.superkilo);
                }
            }
        }
    }

    private RadioGroup.OnCheckedChangeListener radioGroupOlayIsleyicisi = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.bay)
                erkekmi = true;
            else if (i == R.id.bayan)
                erkekmi = false;
            guncelle();
        }
    };

    private SeekBar.OnSeekBarChangeListener seekBarOlayIsleyicisi = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            kilo = 30+i;
            guncelle();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private TextWatcher editTextOlayIsleyicisi = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            try {
                boy = Double.parseDouble(charSequence.toString())/100.0;

            }catch (NumberFormatException e){
                boy = 0.0;
            }
            guncelle();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}

