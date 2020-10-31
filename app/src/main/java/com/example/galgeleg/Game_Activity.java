package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class Game_Activity extends AppCompatActivity implements IGame_Activity {

    FragmentFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_);
        FragmentFactory factory = new FragmentFactory();


        Display_Frag fragment = new Display_Frag();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.display, fragment)  // tom container i layout
                .commit();

        Word_Frag fragment2 = new Word_Frag();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.wordDisplay, fragment2)  // tom container i layout
                .commit();

        Alphabet_Frag fragment3 = new Alphabet_Frag();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.alphabet_display, fragment3)  // tom container i layout
                .commit();

    }

    @Override
    public void inflateFragment(String fragmentTag) {
        factory.createWordFrag(fragmentTag);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.commit();
    }
}