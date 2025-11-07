package com.example.teste; // Certifique-se de que o pacote está correto

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton; // Importe o ImageButton/ImageView se necessário
import android.widget.ImageView;   // Pode ser um ImageView também
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- ENCONTRE OS COMPONENTES PELOS IDs CORRETOS DO SEU XML ---

        // Botão Feliz (pode ser ImageView, ImageButton ou Button)
        // Use o ID da imagem clicável
        View botaoFelizImagem = findViewById(R.id.opcaoFeliz);
        // Use o ID do texto clicável
        Button botaoFelizTexto = findViewById(R.id.botaoFeliz);

        // Botão Triste
        View botaoTristeImagem = findViewById(R.id.opcaoTriste);
        Button botaoTristeTexto = findViewById(R.id.botaoTriste);

        // Botão Bravo
        View botaoBravoImagem = findViewById(R.id.opcaoRaiva);
        Button botaoBravoTexto = findViewById(R.id.botaoBravo);

        // Botão Entediado
        View botaoEntediadoImagem = findViewById(R.id.opcaoEntediado);
        Button botaoEntediadoTexto = findViewById(R.id.botaoEntediado);


        // --- CONFIGURAÇÃO DOS LISTENERS ---

        // Listener para o botão FELIZ (tanto na imagem quanto no texto)
        View.OnClickListener listenerFeliz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TelaFelizActivity.class);
                startActivity(intent);
            }
        };
        botaoFelizImagem.setOnClickListener(listenerFeliz);
        botaoFelizTexto.setOnClickListener(listenerFeliz);

        // Listener para o botão TRISTE
        View.OnClickListener listenerTriste = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TelaTristeActivity.class);
                startActivity(intent);
            }
        };
        botaoTristeImagem.setOnClickListener(listenerTriste);
        botaoTristeTexto.setOnClickListener(listenerTriste);

        // Listener para o botão BRAVO
        View.OnClickListener listenerBravo = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TelaBravoActivity.class);
                startActivity(intent);
            }
        };
        botaoBravoImagem.setOnClickListener(listenerBravo);
        botaoBravoTexto.setOnClickListener(listenerBravo);

        // Listener para o botão ENTEDIADO
        View.OnClickListener listenerEntediado = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TelaEntediadoActivity.class);
                startActivity(intent);
            }
        };
        botaoEntediadoImagem.setOnClickListener(listenerEntediado);
        botaoEntediadoTexto.setOnClickListener(listenerEntediado);
    }
}
