package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton; // Importação correta para ImageButton
import androidx.appcompat.app.AppCompatActivity;

public class TelaFelizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_feliz);

        // 1. Encontrar o ImageButton pelo ID que você definiu no XML
        ImageButton botaoHome = findViewById(R.id.botaoHome);

        // 2. Configurar o listener de clique para o botão
        botaoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3. Criar uma Intent para abrir a MainActivity (sua tela principal)
                Intent intent = new Intent(TelaFelizActivity.this, MainActivity.class);

                // Opcional: Limpa o histórico de telas para que o usuário não volte
                // para a TelaFelizActivity ao pressionar o botão "Voltar" do celular.
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

                // 4. Iniciar a Activity principal
                startActivity(intent);

                // 5. Finalizar a Activity atual para que o usuário não possa voltar para ela
                finish();
            }
        });
    }
}
