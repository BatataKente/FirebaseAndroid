package com.example.firebase.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.firebase.databinding.ActivityFormLoginBinding;
import com.example.firebase.home.FormHome;
import com.example.firebase.register.FormCadastro;
import com.example.firebase.utils.Initialization;

public class FormLogin extends AppCompatActivity implements Initialization {
    private TextView text_tela_cadastro;
    private AppCompatButton button_entrar;
    private ActivityFormLoginBinding bind;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        setContentView(bind.getRoot());
        setOnClickListeners();
    }
    @Override public void initialize() {
        bind = ActivityFormLoginBinding.inflate(getLayoutInflater());
        text_tela_cadastro = bind.textCadastrar;
        button_entrar = bind.botaoEntrar;
    }
    private void setOnClickListeners() {
        button_entrar.setOnClickListener(
            view -> startActivity(
                new Intent(FormLogin.this, FormHome.class)
            )
        );
        text_tela_cadastro.setOnClickListener(
            view -> startActivity(
                new Intent(FormLogin.this, FormCadastro.class)
            )
        );
    }
}