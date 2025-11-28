package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- Botões de Emoção (ImageButtons) ---
        ImageButton botaoFeliz = findViewById(R.id.opcaoFeliz);
        ImageButton botaoTriste = findViewById(R.id.opcaoTriste);
        ImageButton botaoBravo = findViewById(R.id.opcaoRaiva);
        ImageButton botaoEntediado = findViewById(R.id.opcaoEntediado);
        
        // --- Botões de Navegação Inferior ---
        ImageButton botaoPerfil = findViewById(R.id.botaoPerfil);
        ImageButton botaoFavoritos = findViewById(R.id.botaoFavoritos);


        // --- CONFIGURAÇÃO DOS LISTENERS ---

        // Listener para o botão FELIZ
        if (botaoFeliz != null) {
            botaoFeliz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, TelaFelizActivity.class);
                    startActivity(intent);
                }
            });
        }

        // Listener para o botão TRISTE
        if (botaoTriste != null) {
            botaoTriste.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, TelaTristeActivity.class);
                    startActivity(intent);
                }
            });
        }

        // Listener para o botão BRAVO
        if (botaoBravo != null) {
            botaoBravo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, TelaBravoActivity.class);
                    startActivity(intent);
                }
            });
        }

        // Listener para o botão ENTEDIADO
        if (botaoEntediado != null) {
            botaoEntediado.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, TelaEntediadoActivity.class);
                    startActivity(intent);
                }
            });
        }
        
        // Listener para o botão PERFIL
        if (botaoPerfil != null) {
            botaoPerfil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, TelaPerfilActivity.class);
                    startActivity(intent);
                }
            });
        }

        // Listener para o botão FAVORITOS
        if (botaoFavoritos != null) {
            botaoFavoritos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, TelaFavoritosActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}
