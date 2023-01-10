package com.example.firebase.utils;

import android.graphics.Color;
import android.view.View;
import com.google.android.material.snackbar.Snackbar;

public class ShowingSnackBar {
    public static void show(View view, String message) {
        Snackbar snackbar = Snackbar.make(
                view, message, Snackbar.LENGTH_SHORT
        );
        snackbar.setBackgroundTint(Color.WHITE);
        snackbar.setTextColor(Color.BLACK);
        snackbar.show();
    }
}