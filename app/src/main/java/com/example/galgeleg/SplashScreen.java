package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 6000;

    Animation topAnimation;
    TextView velk, til, galg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        // ANIMATION

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_anim);

        // HOOKS

        velk = findViewById(R.id.velkommen);
        til = findViewById(R.id.til);
        galg = findViewById(R.id.galge);


        velk.setAnimation(topAnimation);
        til.setAnimation(topAnimation);
        galg.setAnimation(topAnimation);


        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_SCREEN);
    }
}