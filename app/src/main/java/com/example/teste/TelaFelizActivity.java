package com.example.teste;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class TelaFelizActivity extends AppCompatActivity {

    private boolean isFavorited1 = false;
    private boolean isFavorited2 = false;
    private boolean isFavorited3 = false;
    private boolean isFavorited4 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_feliz);

        // Recuperar estado salvo
        SharedPreferences prefs = getSharedPreferences("MeusFavoritos", MODE_PRIVATE);
        isFavorited1 = prefs.getBoolean("fav_1", false);
        isFavorited2 = prefs.getBoolean("fav_2", false);
        isFavorited3 = prefs.getBoolean("fav_3", false);
        isFavorited4 = prefs.getBoolean("fav_4", false);

        ImageButton botaoHome = findViewById(R.id.botaoHome);
        ImageButton botaoFav1 = findViewById(R.id.botaoFav1);
        ImageButton botaoFav2 = findViewById(R.id.botaoFav2);
        ImageButton botaoFav3 = findViewById(R.id.botaoFav3);
        ImageButton botaoFav4 = findViewById(R.id.botaoFav4);

        // Atualizar ícones iniciais
        updateButtonIcon(botaoFav1, isFavorited1);
        updateButtonIcon(botaoFav2, isFavorited2);
        updateButtonIcon(botaoFav3, isFavorited3);
        updateButtonIcon(botaoFav4, isFavorited4);

        botaoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaFelizActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        setupFavoriteButton(botaoFav1, 1);
        setupFavoriteButton(botaoFav2, 2);
        setupFavoriteButton(botaoFav3, 3);
        setupFavoriteButton(botaoFav4, 4);
    }

    private void setupFavoriteButton(ImageButton button, final int buttonId) {
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean currentState = false;
                    switch (buttonId) {
                        case 1:
                            isFavorited1 = !isFavorited1;
                            currentState = isFavorited1;
                            break;
                        case 2:
                            isFavorited2 = !isFavorited2;
                            currentState = isFavorited2;
                            break;
                        case 3:
                            isFavorited3 = !isFavorited3;
                            currentState = isFavorited3;
                            break;
                        case 4:
                            isFavorited4 = !isFavorited4;
                            currentState = isFavorited4;
                            break;
                    }

                    // Salvar no SharedPreferences
                    SharedPreferences prefs = getSharedPreferences("MeusFavoritos", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("fav_" + buttonId, currentState);
                    editor.apply();

                    updateButtonIcon(button, currentState);
                }
            });
        }
    }

    private void updateButtonIcon(ImageButton button, boolean isFavorited) {
        if (button != null) {
            if (isFavorited) {
                button.setImageResource(R.drawable.fav2);
            } else {
                button.setImageResource(R.drawable.fav1);
            }
        }
    }
}
