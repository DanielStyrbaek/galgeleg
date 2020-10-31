package com.example.galgeleg;

public interface IGame_Activity {

    void inflateFragment(String fragmentTag);

    void gameOver(boolean state);

    void guess(String letter);
}
