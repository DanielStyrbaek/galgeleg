package com.example.galgeleg;

public interface IGame_Activity {

    String getVisibleText();

    void inflateFragment(String fragmentTag);

    void gameOver(boolean state);

    void guess(String letter);

    void startGame();

    void handleGameOver();


    String getWord();
}
