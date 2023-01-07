package com.example.firebase.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.firebase.R;
import com.example.firebase.databinding.ActivityFormHomeBinding;

public class FormHome extends AppCompatActivity {
    private @NonNull ActivityFormHomeBinding bind;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityFormHomeBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_form_home);
    }
}