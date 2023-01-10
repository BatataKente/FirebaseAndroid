package com.example.firebase.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firebase.databinding.ActivityFormCadastroBinding;
import com.example.firebase.utils.HideKeyboardTouchListener;
import com.example.firebase.utils.Initialization;
import com.example.firebase.utils.ShowingSnackBar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class FormCadastro extends AppCompatActivity implements Initialization {
    private EditText edit_name, edit_email, edit_password;
    private Button button_register;
    private ActivityFormCadastroBinding bind;
    Pair<String, String> messages = new Pair<>("Preencha todos os campos", "Cadastro realizado com sucesso");
    private View messageView;
    private View view;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        setOnClickListeners();
        setContentView(bind.getRoot());
    }
    @Override public void initialize() {
        bind = ActivityFormCadastroBinding.inflate(getLayoutInflater());
        edit_name = bind.editNome;
        edit_email = bind.editEmail;
        edit_password = bind.editPassword;
        button_register = bind.buttonRegister;
        view = bind.getRoot();
    }
    private void setOnClickListeners() {
        view.setOnTouchListener(new HideKeyboardTouchListener());
        button_register.setOnClickListener(this::onClickButtonEffect);
    }
    private void onClickButtonEffect(View view) {
        String nome = edit_name.getText().toString();
        String email = edit_email.getText().toString();
        String password = edit_password.getText().toString();
        messageView = view;
        if (nome.isEmpty()||email.isEmpty()||password.isEmpty()) {
            ShowingSnackBar.show(messageView, messages.first);
        } else {
            button_register.setEnabled(false);
            registerUser(email, password);
        }
    }
    private void registerUser(String email, String password) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(
            email, password
        ).addOnCompleteListener(
            task -> {
            button_register.setEnabled(true);
                if (task.isSuccessful()) {
                    ShowingSnackBar.show(messageView, messages.second);
                } else {
                    Exception exception = task.getException();
                    if (exception instanceof FirebaseAuthException) {
                        String errorCode = ((FirebaseAuthException) exception).getErrorCode();
                        String errorMessage = errorCode.equals("ERROR_EMAIL_ALREADY_IN_USE")?
                                "E-mail já está em uso" : "Erro ao criar usuário: " + errorCode;
                        ShowingSnackBar.show(messageView, errorMessage);
                    }
                }
            }
        );
    }
}


