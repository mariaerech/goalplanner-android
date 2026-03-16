package com.example.goalplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends Activity {

    private EditText username, password;
    private Button btnLogin;
    private TextView createAccount;

    private final String predefinedUser = "madu.rech";
    private final String predefinedPassword = "madu.123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        createAccount = findViewById(R.id.createAccount);

        btnLogin.setOnClickListener(v -> {
            String userText = username.getText().toString().trim();
            String passText = password.getText().toString().trim();

            if (userText.equals(predefinedUser) && passText.equals(predefinedPassword)) {
                Intent intent = new Intent(MainActivity.this, AgendaActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(MainActivity.this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
            }
        });

        createAccount.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
            startActivity(intent);
        });
    }
}
