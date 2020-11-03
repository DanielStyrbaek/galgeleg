package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ProgressBar;

import com.example.galgeleg.factories.FragmentFactory;
import com.example.galgeleg.observers.IObservable;
import com.example.galgeleg.observers.IObserver;
import com.example.galgeleg.popup.Dialog_lost;
import com.example.galgeleg.popup.Dialog_won;
import com.example.galgeleg.preference.MemoryManage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Game_Activity extends AppCompatActivity implements IGame_Activity, IObservable {

    FragmentFactory factory;
    Game_Logic logic;
    WordDB wordDB;
    ProgressBar progressBar;
    List<IObserver> observers = new ArrayList<IObserver>();


    Executor bgThread = Executors.newSingleThreadExecutor();
    Handler uithread = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_);

        progressBar = findViewById(R.id.progres_bar);

        init();


    }

    @Override
    public void gameOver(boolean state, int score) {
        if(state) {
            DialogFragment dialog = factory.createDialog("won", score);
            dialog.show(getSupportFragmentManager(), "Dialog_won");
        } else {
            DialogFragment dialog = factory.createDialog("lost", score);
            dialog.show(getSupportFragmentManager(), "Dialog_lost");
        }

    }

    private void init() {
        progressBar.setVisibility(View.VISIBLE);
        factory = new FragmentFactory();
        wordDB = new WordDB();
        String user = getIntent().getStringExtra("name");
        logic = new Game_Logic(this, wordDB, this, user, getIntent().getIntExtra("choice", 0));

        bgThread.execute(()-> {
            try {
                logic.start_new_game();
                uithread.post(()-> {
                    Notify();
                    progressBar.setVisibility(View.INVISIBLE);
                });
            } catch (Exception e) {
                e.printStackTrace();
                uithread.post(()-> {

                });
            }


        });


        Fragment fragment = factory.createFragment("display");
        Fragment fragment2 = factory.createFragment("word");
        Fragment fragment3 = factory.createFragment("alphabet");
        getSupportFragmentManager().beginTransaction()
                .add(R.id.display, fragment)
                .add(R.id.wordDisplay, fragment2)
                .add(R.id.alphabet_display, fragment3)
                .commit();


    }

    public void guess (String letter) {
        this.logic.guess_letter(letter);

        Notify();
    }

    @Override
    public void startGame() {
        this.logic.start_new_game();
        Fragment fragment3 = factory.createFragment("alphabet");
        getSupportFragmentManager().beginTransaction()
                .add(R.id.alphabet_display, fragment3)
                .commit();
        Notify();

    }

    @Override
    public void handleGameOver() {
        this.logic.handleEndGame();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public String getWord() {
        return this.logic.getWord();
    }

    @Override
    public int getNumberOfTries() {
        return this.logic.getNrOfTries();
    }

    @Override
    public void add(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        observers.remove(observer);

    }

    @Override
    public void Notify() {
        for (IObserver observer : observers) {
            observer.update(uithread);
        }

    }

    @Override
    public String getVisibleText() {
        return this.logic.getVisibleWord();
    }
}