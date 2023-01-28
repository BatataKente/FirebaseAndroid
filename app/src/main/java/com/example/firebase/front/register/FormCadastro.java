package com.example.firebase.front.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FormCadastro extends AppCompatActivity implements Initialization {
    private EditText edit_name, edit_email, edit_password;
    private Button button_register;
    private View view;
    private final Pair<String, String> messages = new Pair<>(
        "Preencha todos os campos", "Cadastro realizado com sucesso"
    );
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        setOnClickListeners();
        setContentView(view);
    }
    @Override public void initialize() {
        ActivityFormCadastroBinding bind = ActivityFormCadastroBinding.inflate(
            getLayoutInflater()
        );
        edit_name = bind.editNome;
        edit_email = bind.editEmail;
        edit_password = bind.editPassword;
        button_register = bind.buttonRegister;
        view = bind.getRoot();
    }
    private void setOnClickListeners() {
        view.setOnTouchListener(new HideKeyboardTouchListener());
        button_register.setOnClickListener(view -> onClickButtonEffect());
    }
    private void onClickButtonEffect() {
        String nome = edit_name.getText().toString();
        String email = edit_email.getText().toString();
        String password = edit_password.getText().toString();
        if (nome.isEmpty()||email.isEmpty()||password.isEmpty()) {
            ShowingSnackBar.show(view, messages.first);
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
                    saveUserData();
                    ShowingSnackBar.show(view, messages.second);
                } else {
                    Exception exception = task.getException();
                    if (exception instanceof FirebaseAuthException) {
                        String error = ((FirebaseAuthException) exception).getErrorCode();
                        ShowingSnackBar.show(view, "ERROR: " + error.toLowerCase());
                    }
                }
            }
        );
    }
    private void saveUserData() {
        String name = edit_name.getText().toString();
        FirebaseFirestore dragonBall = FirebaseFirestore.getInstance();
        Map<String, Object> users = new HashMap<>();
        users.put("nome", name);
        String userID = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
        DocumentReference documentReference = dragonBall.collection(
                "Users"
        ).document(userID);
        documentReference.set(users).addOnSuccessListener(
            unused -> Log.d(this.getClass().getName(), "Success on saving data")
        ).addOnFailureListener(
            error -> Log.d(this.getClass().getName(), "Error on saving data: " + error)
        );
    }
}