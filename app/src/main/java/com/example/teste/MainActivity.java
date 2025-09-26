package com.example.teste;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textFrase;
    Button botaoNovaFrase;

    String[] frases = {
            "Acredite nos seus sonhos.",
            "Você é capaz de tudo que quiser.",
            "Persista! O resultado vem com o tempo.",
            "O esforço de hoje é o sucesso de amanhã.",
            "Não desista. Grandes coisas levam tempo."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textFrase = findViewById(R.id.textFrase);
        botaoNovaFrase = findViewById(R.id.botaoNovaFrase);

        botaoNovaFrase.setOnClickListener(v -> {
            int index = new Random().nextInt(frases.length);
            textFrase.setText(frases[index]);
        });
    }
}