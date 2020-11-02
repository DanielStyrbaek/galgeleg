package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.example.galgeleg.factories.FragmentFactory;
import com.example.galgeleg.observers.IObservable;
import com.example.galgeleg.observers.IObserver;
import com.example.galgeleg.popup.Dialog_lost;
import com.example.galgeleg.popup.Dialog_won;
import com.example.galgeleg.preference.MemoryManage;

import java.util.ArrayList;
import java.util.List;

public class Game_Activity extends AppCompatActivity implements IGame_Activity, IObservable {

    FragmentFactory factory;
    Game_Logic logic;
    WordDB wordDB;
    MemoryManage memory;
    List<IObserver> observers = new ArrayList<IObserver>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_);

        init();




    }



    @Override
    public void inflateFragment(String fragmentTag) {
        factory.createWordFrag(fragmentTag);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void gameOver(boolean state, int score) {
        if(state) {
            Dialog_won dialog = new Dialog_won();
            dialog.setCancelable(false);
            dialog.show(getSupportFragmentManager(), "Dialog_won");
        } else {
            Dialog_lost dialog = new Dialog_lost();
            dialog.setCancelable(false);
            dialog.show(getSupportFragmentManager(), "Dialog_won");
        }

    }

    private void init() {
        factory = new FragmentFactory();
        wordDB = new WordDB();
        String user = getIntent().getStringExtra("name");
        logic = new Game_Logic(this, wordDB, this, user);
        logic.start_new_game();


        //ADD OBSERVERS


        Fragment fragment = factory.createWordFrag("display");
        Fragment fragment2 = factory.createWordFrag("word");
        Fragment fragment3 = factory.createWordFrag("alphabet");
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
        Fragment fragment3 = factory.createWordFrag("alphabet");
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
            observer.update();
        }

    }

    @Override
    public String getVisibleText() {
        return this.logic.getVisibleWord();
    }
}