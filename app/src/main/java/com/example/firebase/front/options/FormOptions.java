package com.example.firebase.front.options;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firebase.front.home.FormHome;
import com.example.firebase.front.register.FormCadastro;
import com.example.firebase.front.web.WebActivity;
import com.example.firebase.utils.Initialization;

public class FormOptions extends AppCompatActivity implements Initialization {
    FormOptionsScrollView view;
    AppCompatActivity[] activities = {
        new FormCadastro(), new FormHome(), new WebActivity()
    };
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        setContentView(view);
    }
    @Override public void initialize() {
        view = new FormOptionsScrollView(this);
        for (AppCompatActivity activity : activities) {
            view.layout.addView(createButton(activity));
        }
    }
    private Button createButton(AppCompatActivity activity) {
        Button button = new Button(this);
        String[] name = activity.getClass().getName().split("\\.");
        button.setText(name[name.length-1]);
        button.setOnClickListener(
            view -> startActivity(
                new Intent(this, activity.getClass())
            )
        );
        return button;
    }
}
