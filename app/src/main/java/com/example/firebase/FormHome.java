package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.firebase.databinding.ActivityFormHomeBinding;

public class FormHome extends AppCompatActivity {
    private ActivityFormHomeBinding bind;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityFormHomeBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
    }
}