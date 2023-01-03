package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FormLogin extends AppCompatActivity {

    private TextView text_tela_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);
        initializeComponents();
        text_tela_cadastro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(
                        new Intent(
                                FormLogin.this, FormCadastro.class
                        )
                    );
                }
            }
        );
    }
    private void initializeComponents() {
        text_tela_cadastro = findViewById(R.id.text_cadastrar);
    }
}