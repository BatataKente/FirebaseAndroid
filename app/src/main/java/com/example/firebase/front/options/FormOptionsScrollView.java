package com.example.firebase.front.options;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firebase.R;
import com.example.firebase.front.home.FormHome;
import com.example.firebase.front.register.FormCadastro;
import com.example.firebase.utils.Initialization;

public class FormOptionsScrollView extends ScrollView implements Initialization {
    LinearLayout layout;
    public FormOptionsScrollView(Context context) {
        super(context);
        initialize();
        setLayout();
        setBackgroundResource(R.drawable.background);
        addView(layout);
    }
    @Override public void initialize() {
        layout = new LinearLayout(getContext());
    }
    private void setLayout() {
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(createButton(new FormCadastro()));
        layout.addView(createButton(new FormHome()));
    }
    private Button createButton(AppCompatActivity activity) {
        Button button = new Button(getContext());
        String[] name = activity.getClass().getName().split("\\.");
        button.setText(name[name.length-1]);
        return button;
    }
}
