package com.example.galgeleg.factories;

import android.app.Activity;
import android.content.Context;
import android.widget.Button;

public class ButtonFactory {

    public ButtonFactory() {

    }
    public Button createButton(Context context, char text) {
        final Button button = new Button(context);
        button.setMinimumHeight(120);
        button.setMinimumWidth(120);
        button.setWidth(50);
        button.setHeight(40);
        button.setText(text + "");

        return button;
    }
}
