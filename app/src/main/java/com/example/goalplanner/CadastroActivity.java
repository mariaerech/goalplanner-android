package com.example.goalplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class CadastroActivity extends Activity {

    private EditText etNome, etEmail, etUsuario, etSenha, etTimeFavorito, etTimeEstrangeiro;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        etUsuario = findViewById(R.id.etUsuario);
        etSenha = findViewById(R.id.etSenha);
        etTimeFavorito = findViewById(R.id.etTimeFavorito);
        etTimeEstrangeiro = findViewById(R.id.etTimeEstrangeiro);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(v -> {
            Toast.makeText(CadastroActivity.this, "Cadastro realizado", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
