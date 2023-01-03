package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FormLogin extends AppCompatActivity {
    private TextView text_tela_cadastro;
    private AppCompatButton button_entrar;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);
        configureEntrarIntent(FormHome.class);
        configureCadastroIntent(FormCadastro.class);
    }
    private void configureEntrarIntent(Class activity) {
        button_entrar = findViewById(R.id.botao_entrar);
        button_entrar.setOnClickListener(view -> startActivity(
            new Intent(FormLogin.this, activity))
        );
    }
    private void configureCadastroIntent(Class activity) {
        text_tela_cadastro = findViewById(R.id.text_cadastrar);
        text_tela_cadastro.setOnClickListener(view -> startActivity(
            new Intent(FormLogin.this, activity))
        );
    }
}