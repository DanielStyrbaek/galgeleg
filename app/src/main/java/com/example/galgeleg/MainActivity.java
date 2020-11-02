package com.example.galgeleg;

import android.content.Intent;
import android.os.Bundle;

import com.example.galgeleg.popup.Dialog_lost;
import com.example.galgeleg.popup.Dialog_startSpil;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startSpil, highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startSpil = findViewById(R.id.start_game);
        highScore = findViewById(R.id.high_score_akt);


        startSpil.setOnClickListener(v -> {
            Dialog_startSpil dialog = new Dialog_startSpil();
            dialog.setCancelable(false);
            dialog.show(getSupportFragmentManager(), "Dialog_start");
        });

        highScore.setOnClickListener(v -> {
            Intent i = new Intent(this, Highscore_activity.class);
            startActivity(i);
        });
    }

}