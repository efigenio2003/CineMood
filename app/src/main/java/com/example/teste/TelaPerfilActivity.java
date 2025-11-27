package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast; // Importação adicionada
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class TelaPerfilActivity extends AppCompatActivity {

    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 9001;
    private TextView textNomePerfil;
    private TextView textEmailPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil);

        ImageButton botaoHome = findViewById(R.id.botaoHome);
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        textNomePerfil = findViewById(R.id.textNomePerfil);
        textEmailPerfil = findViewById(R.id.textEmailPerfil);

        // Configurar o botão Home para voltar à tela principal
        if (botaoHome != null) {
            botaoHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(TelaPerfilActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            });
        }

        // Configurar opções de login do Google
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Verificar se já há um usuário logado
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);

        // Configurar o listener do botão de login
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Resultado retornado ao iniciar a Intent de login
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Login realizado com sucesso, atualizar a interface
            updateUI(account);
            Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
        } catch (ApiException e) {
            // O login falhou
            Log.w("TelaPerfilActivity", "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
            Toast.makeText(this, "Falha no login. Código: " + e.getStatusCode(), Toast.LENGTH_LONG).show();
        }
    }

    private void updateUI(@Nullable GoogleSignInAccount account) {
        if (account != null) {
            // Usuário logado
            String personName = account.getDisplayName();
            String personEmail = account.getEmail();
            
            textNomePerfil.setText(personName);
            textEmailPerfil.setText(personEmail);
            findViewById(R.id.sign_in_button).setVisibility(View.GONE);
        } else {
            // Usuário não logado
            textNomePerfil.setText("Usuário");
            textEmailPerfil.setText("usuario@email.com");
            findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
        }
    }
}
