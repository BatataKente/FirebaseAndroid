package com.example.firebase.front.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.firebase.databinding.ActivityFormHomeBinding;
import com.example.firebase.utils.Initialization;

public class FormHome extends AppCompatActivity implements Initialization {
    private ActivityFormHomeBinding bind;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        setContentView(bind.getRoot());
    }
    @Override public void initialize() {
        bind = ActivityFormHomeBinding.inflate(getLayoutInflater());
    }
}