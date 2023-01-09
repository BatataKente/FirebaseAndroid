package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.firebase.databinding.ActivityFormLoginBinding;

public class FormLogin extends AppCompatActivity {
    private TextView text_tela_cadastro;
    private AppCompatButton button_entrar;
    private ActivityFormLoginBinding bind;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityFormLoginBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
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