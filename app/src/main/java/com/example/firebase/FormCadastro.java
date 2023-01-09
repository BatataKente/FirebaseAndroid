package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firebase.databinding.ActivityFormCadastroBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class FormCadastro extends AppCompatActivity {
    private EditText edit_name, edit_email, edit_password;
    private Button button_register;
    private ActivityFormCadastroBinding bind;
    Pair<String, String> messages = new Pair("Preencha todos os campos", "Cadastro realizado com sucesso");
    private View messageView;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeComponents();
        buttonTarget();
        setContentView(bind.getRoot());
    }
    private void initializeComponents()  {
        bind = ActivityFormCadastroBinding.inflate(getLayoutInflater());
        edit_name = bind.editNome;
        edit_email = bind.editEmail;
        edit_password = bind.editPassword;
        button_register = bind.buttonRegister;
    }
    private void buttonTarget() {
        button_register.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View view) {onClickButtonEffect(view);}
            }
        );
    }
    private void onClickButtonEffect(View view) {
        String nome = edit_name.getText().toString();
        String email = edit_email.getText().toString();
        String password = edit_password.getText().toString();
        messageView = view;
        if (nome.isEmpty()||email.isEmpty()||password.isEmpty()) {
            showSnackBar(messages.first);
        } else {
            registerUser(email, password);
        }
    }
    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(
                messageView, message, Snackbar.LENGTH_SHORT
        );
        snackbar.setBackgroundTint(Color.WHITE);
        snackbar.setTextColor(Color.BLACK);
        snackbar.show();
    }
    private void registerUser(String email, String password) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                email, password
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        showSnackBar(messages.second);
                    } else {
                        Exception exception = task.getException();
                        if (exception instanceof FirebaseAuthException) {
                            String errorCode = ((FirebaseAuthException) exception).getErrorCode();
                            String errorMessage = errorCode.equals("ERROR_EMAIL_ALREADY_IN_USE")?
                                    "E-mail já está em uso" : "Erro ao criar usuário: " + errorCode;
                            showSnackBar(errorMessage);
                        }
                    }
                }
            }
        );
    }
}