package com.example.firebase.front.options;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firebase.utils.Initialization;

public class FormOptions extends AppCompatActivity implements Initialization {
    FormOptionsScrollView view;
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        setContentView(view);

    }
    @Override public void initialize() {
        view = new FormOptionsScrollView(this);
    }
}
