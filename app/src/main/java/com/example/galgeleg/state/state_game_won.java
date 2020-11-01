package com.example.galgeleg.state;

import com.example.galgeleg.Game_Logic;
import com.example.galgeleg.WordDB;

import java.util.ArrayList;
import java.util.Random;

public class state_game_won implements IGameState
{

    Game_Logic game;

    public state_game_won(Game_Logic game_logic) {
        this.game = game_logic;
    }

    @Override
    public void handleEndGame() {

    }

    @Override
    public void start_new_game() {
        this.game.setNrOfTries(6);
        this.game.setCorrectLetters("");
        WordDB wordDB = this.game.getWordDB();
        ArrayList<String> words = wordDB.getWordDB();
        this.game.setWord(words.get(new Random().nextInt(words.size())));
        this.game.change_state(new state_game_running(this.game));
        this.game.update_visible_word();


    }

    @Override
    public void update_visible_word() {

    }

    @Override
    public void guess_letter(String letter) {

    }
}
