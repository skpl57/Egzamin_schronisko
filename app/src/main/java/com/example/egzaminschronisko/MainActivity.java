package com.example.egzaminschronisko;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<PytanieZamkniete> pytania = new ArrayList<>();
    private RadioGroup radioGroup;
    private ImageView imageView;
    private int punkty = 0;
    private int iteracja = 0;
    private char wybranaOdp;
    private RadioButton radioA, radioB, radioC;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        radioGroup = findViewById(R.id.radioGroup);
        imageView = findViewById(R.id.imageView);
        pytania.add(new PytanieZamkniete("Które to schronisko?", R.drawable.zad1, "Na Rysiance.", "Na Wielkiej Raczy.", "Na Wielkiej Rycerzowej.", 'B'));
        pytania.add(new PytanieZamkniete("Zwierzę na zdjęciu to?", R.drawable.zad2, "owczarek.", "wilk.", "kozica.", 'A'));
        pytania.add(new PytanieZamkniete("W oddali są widoczne", R.drawable.zad3, "Himalaje.", "Alpy.", "Tatry.", 'C'));



        radioA = findViewById(R.id.radioA);
        radioB = findViewById(R.id.radioB);
        radioC = findViewById(R.id.radioC);
        textView = findViewById(R.id.textView);

        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(@NonNull RadioGroup radioGroup, int i) {
                        RadioButton radioButton = findViewById(i);
                        wybranaOdp = radioButton.getHint().charAt(0);
                    }
                }
        );
        findViewById(R.id.button).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pytania.get(iteracja).sprawdzOdpowiedz(wybranaOdp)){
                            punkty++;
                        }
                        if(iteracja == 2) iteracja = 0;
                        else iteracja++;
                        imageView.setImageResource(pytania.get(iteracja).nazwaPliku);
                        textView.setText(pytania.get(iteracja).trescPytania);
                        radioA.setText(pytania.get(iteracja).getTrescA());
                        radioB.setText(pytania.get(iteracja).getTrescB());
                        radioC.setText(pytania.get(iteracja).getTrescC());
                    }
                }
        );
    }
}