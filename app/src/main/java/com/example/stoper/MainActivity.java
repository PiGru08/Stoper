package com.example.stoper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewCzas;
    TextView textViewZapisCzasuDol;
    Button buttonStart;
    Button buttonStop;
    Button buttonZapisz;
    Button buttonReset;
    String czasDowyswietlenia;
    String zapisaneCzasy = "Zapisane czasy: "+"\n";
    int sekundy;
    boolean czyDzaiala = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCzas = findViewById(R.id.textViewCzas);
        textViewZapisCzasuDol = findViewById(R.id.textViewZapisCzasDol);
        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        buttonReset = findViewById(R.id.buttonReset);
        buttonZapisz = findViewById(R.id.buttonZapisz);
        zacznijOdliczanie();
        buttonStart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czyDzaiala = true;
                    }
                }
        );
        buttonStop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czyDzaiala = false;
                    }
                }
        );
        buttonReset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sekundy =0;
                        zapisaneCzasy = "Zapisane czasy:";
                        textViewZapisCzasuDol.setText(zapisaneCzasy);
                    }
                }
        );
        buttonZapisz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        zapisaneCzasy = zapisaneCzasy+czasDowyswietlenia+"\n";
                        textViewZapisCzasuDol.setText(zapisaneCzasy);
                    }
                }
        );

    }

    private void zacznijOdliczanie(){
        int s60, m60, h60;
        Handler handler = new Handler();
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        if(czyDzaiala) {
                            sekundy++;
                        }
                    int h60 = sekundy/3600;
                    int m60 = (sekundy - h60 * 3600)/60;
                    int s60 = sekundy%60;
                    czasDowyswietlenia = String.format("%02d:%02d:%02d",h60,m60,s60);
                    textViewCzas.setText(String.valueOf(czasDowyswietlenia));
                    handler.postDelayed(this,1000);
                    }
                }
        );
    }


}