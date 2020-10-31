package com.example.galgeleg;

import com.example.galgeleg.state.IGameState;
import com.example.galgeleg.state.state_game_lost;
import com.example.galgeleg.state.state_game_running;
import com.example.galgeleg.state.state_game_won;
import com.example.galgeleg.state.state_initial;

import java.lang.reflect.AccessibleObject;

public class Game_Logic {

    IGameState state;
    String visibleWord = " ";
    IGame_Activity activity;
    String correctLetters = " ";
    int nrOfTries = 7;



    String word;



    public Game_Logic(IGame_Activity activity) {
        this.state = new state_initial(this);
        this.activity = activity;
    }

    public void change_state(IGameState state) {
        this.state = state;

        if (this.state instanceof state_game_won) {
            this.activity.gameOver(true);
        }

        if (this.state instanceof state_game_lost) {
            this.activity.gameOver(false);
        }
    }

    public void handle() {
        this.state.handle();
    }

    public void start_new_game() {
        this.state.start_new_game();
    }

    public void update_visible_word() {
        this.state.update_visible_word();

    }

    public void guess_letter(String letter) {
        this.state.guess_letter(letter);

    }



    public void setWord(String word) {
        this.word = word;
    }

    public void setVisibleWord(String visibleWord) {
        this.visibleWord = visibleWord;
    }

    public int getNrOfTries() {
        return nrOfTries;
    }

    public void setNrOfTries(int nrOfTries) {
        this.nrOfTries = nrOfTries;
    }

    public String getWord() {
        return word;
    }

    public String getVisibleWord() {
        return visibleWord;
    }

    public String getCorrectLetters() {
        return correctLetters;
    }

    public void setCorrectLetters(String correctLetters) {
        this.correctLetters = correctLetters;
    }
}
