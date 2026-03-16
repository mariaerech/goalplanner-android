package com.example.goalplanner;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class AgendaActivity extends Activity {

    private LinearLayout layoutJogos;
    private Button btnProximo;

    private String[][] jogos = {
            {"BRASILEIRÃO", "Mirassol vs Sport", "11:00 - Estádio José Maria de Campos Maia"},
            {"BRASILEIRÃO", "Juventude vs Grêmio", "16:00 - Estádio Alfredo Jaconi"},
            {"BRASILEIRÃO", "Santos vs Botafogo", "16:00 - Vila Belmiro"},
            {"BRASILEIRÃO", "Ceará vs Atlético MG", "18:30 - Arena Castelão"},
            {"BRASILEIRÃO", "Corinthians vs Vitória", "18:30 - Neo Química Arena"},
            {"BRASILEIRÃO", "Flamengo vs Fortaleza", "18:30 - Maracanã"},
            {"BRASILEIRÃO", "Cruzeiro vs Palmeiras", "19:30 - Estádio Mineirão"},
            {"BRASILEIRÃO", "Internacional vs Fluminense", "20:30 - Estádio Beira Rio"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        layoutJogos = findViewById(R.id.layoutJogos);
        btnProximo = findViewById(R.id.btnProximo);

        for (String[] jogo : jogos) {
            LinearLayout jogoItem = new LinearLayout(this);
            jogoItem.setOrientation(LinearLayout.VERTICAL);
            jogoItem.setPadding(16, 16, 16, 16);

            TextView campeonato = new TextView(this);
            campeonato.setText(jogo[0]);
            campeonato.setTextSize(14);
            campeonato.setTextColor(Color.BLACK);
            campeonato.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            TextView confronto = new TextView(this);
            confronto.setText(jogo[1]);
            confronto.setTextSize(16);
            confronto.setTypeface(null, Typeface.BOLD);
            confronto.setTextColor(Color.BLACK);

            TextView horario = new TextView(this);
            horario.setText(jogo[2]);
            horario.setTextSize(14);
            horario.setTextColor(Color.DKGRAY);

            Button btnInfo = new Button(this);
            btnInfo.setText("Ver Jogo");

            final String confrontoTexto = jogo[1];
            final String horarioTexto = jogo[2];
            final String time1 = confrontoTexto.split(" vs ")[0].trim();
            final String time2 = confrontoTexto.split(" vs ")[1].trim();
            final String estadioNome = horarioTexto.split(" - ")[1].trim();

            btnInfo.setOnClickListener(v -> {
                Intent intent = new Intent(AgendaActivity.this, InfoJogoActivity.class);
                intent.putExtra("confronto", confrontoTexto);
                intent.putExtra("horario", horarioTexto);
                intent.putExtra("time1", time1);
                intent.putExtra("time2", time2);
                intent.putExtra("estadio", estadioNome);
                startActivity(intent);
            });

            jogoItem.addView(campeonato);
            jogoItem.addView(confronto);
            jogoItem.addView(horario);
            jogoItem.addView(btnInfo);

            layoutJogos.addView(jogoItem);
        }

        ImageView btnPerfil = findViewById(R.id.btnPerfil);
        btnPerfil.setOnClickListener(v -> {
            Intent intent = new Intent(AgendaActivity.this, PerfilActivity.class);
            startActivity(intent);
        });

        btnProximo.setOnClickListener(v -> {
            Toast.makeText(this, "Jogos do próximo dia ainda não disponíveis", Toast.LENGTH_SHORT).show();
        });
    }
}
