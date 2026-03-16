package com.example.goalplanner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class PerfilActivity extends Activity {

    private EditText nome, usuario, senha, timeFavorito, timeEstrangeiro, email;
    private Button btnVoltar, btnAtualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nome = findViewById(R.id.nomePerfil);
        usuario = findViewById(R.id.usuarioPerfil);
        senha = findViewById(R.id.senhaPerfil);
        timeFavorito = findViewById(R.id.timeFavoritoPerfil);
        timeEstrangeiro = findViewById(R.id.timeEstrangeiroPerfil);
        email = findViewById(R.id.emailPerfil);

        btnVoltar = findViewById(R.id.btnVoltarPerfil);
        btnAtualizar = findViewById(R.id.btnAtualizarPerfil);

        btnVoltar.setOnClickListener(v -> finish());

        btnAtualizar.setOnClickListener(v -> {
            Toast.makeText(PerfilActivity.this, "Dados atualizados", Toast.LENGTH_SHORT).show();
        });
    }
}