package com.example.firebase.login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.firebase.databinding.ActivityFormLoginBinding;
import com.example.firebase.home.FormHome;
import com.example.firebase.register.FormCadastro;

public class FormLogin extends AppCompatActivity {
    private View text_tela_cadastro;
    private View button_entrar;
    private ActivityFormLoginBinding bind;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityFormLoginBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        configureEntrarIntent(FormHome.class);
        configureCadastroIntent(FormCadastro.class);
    }
    private void configureEntrarIntent(Class activity) {
        button_entrar = bind.botaoEntrar;
        button_entrar.setOnClickListener(view -> startActivity(
            new Intent(FormLogin.this, activity))
        );
    }
    private void configureCadastroIntent(Class activity) {
        text_tela_cadastro = bind.textCadastrar;
        text_tela_cadastro.setOnClickListener(view -> startActivity(
            new Intent(FormLogin.this, activity))
        );
    }
}

