package com.example.goalplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class InfoJogoActivity extends Activity {

    private TextView confronto, horario, tituloInfo;
    private ImageView escudo1, escudo2, estadio, btnPerfil;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_jogo);

        confronto = findViewById(R.id.confronto);
        horario = findViewById(R.id.horario);
        tituloInfo = findViewById(R.id.tituloInfo);
        escudo1 = findViewById(R.id.Escudo1);
        escudo2 = findViewById(R.id.Escudo2);
        estadio = findViewById(R.id.estadio);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnPerfil = findViewById(R.id.btnPerfil);

        Intent intent = getIntent();
        String confrontoTexto = intent.getStringExtra("confronto");
        String horarioTexto = intent.getStringExtra("horario");
        String time1 = intent.getStringExtra("time1");
        String time2 = intent.getStringExtra("time2");
        String estadioNome = intent.getStringExtra("estadio");

        confronto.setText(confrontoTexto);
        horario.setText(horarioTexto);

        escudo1.setImageResource(getImagemPorNome(time1));
        escudo2.setImageResource(getImagemPorNome(time2));
        estadio.setImageResource(getImagemPorNome(estadioNome));

        btnVoltar.setOnClickListener(v -> finish());

        btnPerfil.setOnClickListener(v -> {
            Intent perfilIntent = new Intent(InfoJogoActivity.this, PerfilActivity.class);
            startActivity(perfilIntent);
        });
    }
    private int getImagemPorNome(String nome) {
        nome = nome.toLowerCase()
                .replace(" ", "_")
                .replace("ã", "a")
                .replace("á", "a")
                .replace("é", "e")
                .replace("ê", "e")
                .replace("ô", "o")
                .replace("ó", "o")
                .replace("í", "i")
                .replace("ç", "c");

        int id = getResources().getIdentifier(nome, "drawable", getPackageName());

        return id != 0 ? id : R.drawable.placeholder;
    }
}
