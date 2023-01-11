package com.example.firebase.front.options;

import android.content.Context;
import android.widget.LinearLayout;

import androidx.core.widget.NestedScrollView;

import com.example.firebase.R;
import com.example.firebase.utils.Initialization;

public class FormOptionsScrollView extends NestedScrollView implements Initialization {
    LinearLayout layout;
    public FormOptionsScrollView(Context context) {
        super(context);
        initialize();
        setLayout();
        setBackgroundResource(R.drawable.background);
        addView(layout);
    }
    @Override public void initialize() {layout = new LinearLayout(getContext());}
    private void setLayout() {
        layout.setOrientation(LinearLayout.VERTICAL);
    }
}
