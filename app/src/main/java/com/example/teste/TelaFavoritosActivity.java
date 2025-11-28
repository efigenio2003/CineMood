package com.example.teste;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TelaFavoritosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_favoritos);

        // Referências para layouts FELIZ
        LinearLayout layoutFilme1 = findViewById(R.id.layoutFilme1);
        LinearLayout layoutFilme2 = findViewById(R.id.layoutFilme2);
        LinearLayout layoutFilme3 = findViewById(R.id.layoutFilme3);
        LinearLayout layoutFilme4 = findViewById(R.id.layoutFilme4);

        // Referências para layouts TRISTE
        LinearLayout layoutFilmeSad1 = findViewById(R.id.layoutFilmeSad1);
        LinearLayout layoutFilmeSad2 = findViewById(R.id.layoutFilmeSad2);
        LinearLayout layoutFilmeSad3 = findViewById(R.id.layoutFilmeSad3);
        LinearLayout layoutFilmeSad4 = findViewById(R.id.layoutFilmeSad4);

        // Referências para layouts BRAVO
        LinearLayout layoutFilmeAngry1 = findViewById(R.id.layoutFilmeAngry1);
        LinearLayout layoutFilmeAngry2 = findViewById(R.id.layoutFilmeAngry2);
        LinearLayout layoutFilmeAngry3 = findViewById(R.id.layoutFilmeAngry3);
        LinearLayout layoutFilmeAngry4 = findViewById(R.id.layoutFilmeAngry4);

        // Referências para layouts ENTEDIADO
        LinearLayout layoutFilmeBored1 = findViewById(R.id.layoutFilmeBored1);
        LinearLayout layoutFilmeBored2 = findViewById(R.id.layoutFilmeBored2);
        LinearLayout layoutFilmeBored3 = findViewById(R.id.layoutFilmeBored3);
        LinearLayout layoutFilmeBored4 = findViewById(R.id.layoutFilmeBored4);

        TextView textVazio = findViewById(R.id.textVazio);

        SharedPreferences prefs = getSharedPreferences("MeusFavoritos", MODE_PRIVATE);
        boolean hasAnyFavorite = false;

        // --- Verificar Filmes FELIZES ---
        if (prefs.getBoolean("fav_1", false)) { layoutFilme1.setVisibility(View.VISIBLE); hasAnyFavorite = true; }
        if (prefs.getBoolean("fav_2", false)) { layoutFilme2.setVisibility(View.VISIBLE); hasAnyFavorite = true; }
        if (prefs.getBoolean("fav_3", false)) { layoutFilme3.setVisibility(View.VISIBLE); hasAnyFavorite = true; }
        if (prefs.getBoolean("fav_4", false)) { layoutFilme4.setVisibility(View.VISIBLE); hasAnyFavorite = true; }

        // --- Verificar Filmes TRISTES ---
        if (prefs.getBoolean("sad_1", false)) { layoutFilmeSad1.setVisibility(View.VISIBLE); hasAnyFavorite = true; }
        if (prefs.getBoolean("sad_2", false)) { layoutFilmeSad2.setVisibility(View.VISIBLE); hasAnyFavorite = true; }
        if (prefs.getBoolean("sad_3", false)) { layoutFilmeSad3.setVisibility(View.VISIBLE); hasAnyFavorite = true; }
        if (prefs.getBoolean("sad_4", false)) { layoutFilmeSad4.setVisibility(View.VISIBLE); hasAnyFavorite = true; }

        // --- Verificar Filmes BRAVOS ---
        if (prefs.getBoolean("angry_1", false)) { layoutFilmeAngry1.setVisibility(View.VISIBLE); hasAnyFavorite = true; }
        if (prefs.getBoolean("angry_2", false)) { layoutFilmeAngry2.setVisibility(View.VISIBLE); hasAnyFavorite = true; }
        if (prefs.getBoolean("angry_3", false)) { layoutFilmeAngry3.setVisibility(View.VISIBLE); hasAnyFavorite = true; }
        if (prefs.getBoolean("angry_4", false)) { layoutFilmeAngry4.setVisibility(View.VISIBLE); hasAnyFavorite = true; }

        // --- Verificar Filmes ENTEDIADOS ---
        if (prefs.getBoolean("bored_1", false)) { layoutFilmeBored1.setVisibility(View.VISIBLE); hasAnyFavorite = true; }
        if (prefs.getBoolean("bored_2", false)) { layoutFilmeBored2.setVisibility(View.VISIBLE); hasAnyFavorite = true; }
        if (prefs.getBoolean("bored_3", false)) { layoutFilmeBored3.setVisibility(View.VISIBLE); hasAnyFavorite = true; }
        if (prefs.getBoolean("bored_4", false)) { layoutFilmeBored4.setVisibility(View.VISIBLE); hasAnyFavorite = true; }

        if (hasAnyFavorite) {
            textVazio.setVisibility(View.GONE);
        } else {
            textVazio.setVisibility(View.VISIBLE);
        }

        ImageButton botaoHome = findViewById(R.id.botaoHome);
        if (botaoHome != null) {
            botaoHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(TelaFavoritosActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
}
