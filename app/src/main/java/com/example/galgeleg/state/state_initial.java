package com.example.galgeleg.state;

import com.example.galgeleg.Game_Logic;
import com.example.galgeleg.WordDB;

import java.util.ArrayList;
import java.util.Random;

public class state_initial implements IGameState {

    Game_Logic game;

    public state_initial(Game_Logic game_logic) {
        this.game = game_logic;
    }

    @Override
    public void handleEndGame() {

    }

    @Override
    public void start_new_game() {
        WordDB wordDB = this.game.getWordDB();
        try {
            wordDB.standartOrd();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> words = wordDB.getWordDB();


        if(words.isEmpty()) {
            throw new  IllegalStateException("List is empty");
        }
        this.game.setWord(words.get(new Random().nextInt(words.size())));
        System.out.println("this is the word" + this.game.getWord());
        this.game.update_visible_word();
        this.game.change_state(new state_game_running(this.game));

    }

    @Override
    public void update_visible_word() {
        String visibleword = "";
        String word = this.game.getWord();
        System.out.println("this is the word 2" + this.game.getWord());


        for (int i = 0; i < word.length(); i++) {
            visibleword += "_";
        }

        this.game.setVisibleWord(visibleword);

    }

    @Override
    public void guess_letter(String letter) {

    }
}
