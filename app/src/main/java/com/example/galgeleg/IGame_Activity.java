package com.example.galgeleg;

public interface IGame_Activity {

    String getVisibleText();

    void inflateFragment(String fragmentTag);

    void gameOver(boolean state, int score);

    void guess(String letter);

    void startGame();

    void handleGameOver();


    String getWord();
}
