package com.example.firebase.register;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.firebase.R;
import com.example.firebase.databinding.ActivityFormCadastroBinding;

public class FormCadastro extends AppCompatActivity {
    private ActivityFormCadastroBinding bind;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityFormCadastroBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_form_cadastro);
    }
}