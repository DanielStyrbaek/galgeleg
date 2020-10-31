package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.galgeleg.factories.FragmentFactory;
import com.example.galgeleg.observers.IObservable;
import com.example.galgeleg.observers.IObserver;

import java.util.ArrayList;
import java.util.List;

public class Game_Activity extends AppCompatActivity implements IGame_Activity, IObservable {

    FragmentFactory factory;
    Game_Logic logic;
    List<IObserver> observers = new ArrayList<IObserver>();
    //char[] alphabet = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'Å', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Æ', 'Ø', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_);

        init();
        logic.start_new_game();


    }



    @Override
    public void inflateFragment(String fragmentTag) {
        factory.createWordFrag(fragmentTag);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void gameOver(boolean state) {
        
    }

    private void init() {
        factory = new FragmentFactory();
        logic = new Game_Logic(this);

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
        System.out.println("test" + letter);
        this.logic.guess_letter(letter);
        Notify();
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