package com.example.teste;

import android.content.Intent; // <-- 1. Importe a classe Intent
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // ... (suas outras variáveis)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button6 = findViewById(R.id.button6);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 2. Crie uma Intent para abrir a SegundaTelaActivity
                Intent intent = new Intent(MainActivity.this, SegundaTelaActivity.class);

                // 3. Inicie a nova activity
                startActivity(intent);
            }
        });
    }
}
