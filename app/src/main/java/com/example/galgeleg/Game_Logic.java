package com.example.galgeleg;

import android.content.Context;

import com.example.galgeleg.preference.MemoryManage;
import com.example.galgeleg.preference.Score;
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
    int nrOfTries = 6;
    WordDB wordDB;
    MemoryManage memory;
    String user;



    String word;

    public MemoryManage getMemory() {
        return memory;
    }

    public String getUser() {
        return user;
    }

    public Game_Logic(IGame_Activity activity, WordDB wordDB, Context context, String user) {
        this.state = new state_initial(this);
        this.activity = activity;
        this.wordDB = wordDB;
        this.user = user;
        System.out.println("test " + user);
        memory = new MemoryManage(context);

    }

    public void change_state(IGameState state) {
        this.state = state;

        if (this.state instanceof state_game_won) {
            Score score = new Score(user, word, nrOfTries);
            memory.saveScore(score);
            this.activity.gameOver(true, score.getScore());
        }

        if (this.state instanceof state_game_lost) {
            this.activity.gameOver(false, 0);
        }
    }

    public void handleEndGame() {
        this.state.handleEndGame();
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


    public WordDB getWordDB() {
        return wordDB;
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
