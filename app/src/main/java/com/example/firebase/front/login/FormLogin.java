package com.example.firebase.front.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.firebase.databinding.ActivityFormLoginBinding;
import com.example.firebase.front.home.FormHome;
import com.example.firebase.front.options.FormOptions;
import com.example.firebase.front.register.FormCadastro;
import com.example.firebase.utils.Initialization;
import com.example.firebase.utils.ShowingSnackBar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class FormLogin extends AppCompatActivity implements Initialization {
    private TextView text_tela_cadastro, text_options;
    private EditText edit_email, edit_password;
    private ProgressBar progressBar;
    private AppCompatButton button_entrar;
    private View view;
    private final Pair<String, String> messages = new Pair<>(
        "Preencha todos os campos", "Login realizado com sucesso"
    );
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        setContentView(view);
        setOnClickListeners();
    }
    @Override protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.INVISIBLE);
    }
    @Override public void initialize() {
        ActivityFormLoginBinding bind = ActivityFormLoginBinding.inflate(
            getLayoutInflater()
        );
        text_tela_cadastro = bind.textCadastrar;
        text_options = bind.textOtherOptions;
        edit_email = bind.editEmail;
        edit_password = bind.editSenha;
        button_entrar = bind.botaoEntrar;
        progressBar = bind.progressBar;
        view = bind.getRoot();
    }
    private void setOnClickListeners() {
        button_entrar.setOnClickListener(
            view -> {
                String email = edit_email.getText().toString();
                String password = edit_password.getText().toString();
                if (email.isEmpty() || password.isEmpty()) {
                    ShowingSnackBar.show(view, messages.first);
                } else {
                    autenticateUser(email, password);
                }
            }
        );
        text_tela_cadastro.setOnClickListener(
            view -> startActivity(
                new Intent(FormLogin.this, FormCadastro.class)
            )
        );
        text_options.setOnClickListener(
            view -> startActivity(
                new Intent(this, FormOptions.class)
            )
        );
    }
    private void autenticateUser(String email, String password) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener(
            task -> {
                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.VISIBLE);
                    startActivity(
                        new Intent(FormLogin.this, FormHome.class)
                    );
                } else {
                    Exception exception = task.getException();
                    if (exception instanceof FirebaseAuthException) {
                        String error = ((FirebaseAuthException) exception).getErrorCode();
                        ShowingSnackBar.show(view, error.toLowerCase());
                    }
                }
            }
        );
    }
}