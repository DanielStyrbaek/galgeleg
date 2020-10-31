package com.example.galgeleg.state;

import com.example.galgeleg.Game_Logic;

public class state_game_running implements IGameState {

    Game_Logic game;

    public state_game_running(Game_Logic game_logic) {
        this.game = game_logic;
    }

    @Override
    public void handle() {

    }

    @Override
    public void start_new_game() {

    }

    @Override
    public void update_visible_word() {
        System.out.println("log test");
        String visibleWord = "";
        String correctLetters = this.game.getCorrectLetters();

        for(char c: this.game.getWord().toCharArray()) {
            if (correctLetters.indexOf(c) != -1) {
                visibleWord += c;
            } else {
                visibleWord += "_";
            }
        }
        System.out.println("test");
        this.game.setVisibleWord(visibleWord);

        if(!(visibleWord.contains("_"))) {
            System.out.println("is this really it");
            this.game.change_state(new state_game_won(this.game));
        }
    }

    @Override
    public void guess_letter(String letter) {
        String correctLetters = this.game.getCorrectLetters();

        if(this.game.getWord().contains(letter)) {
            correctLetters += letter;
            this.game.setCorrectLetters(correctLetters);
            this.game.update_visible_word();
        } else {
            this.game.setNrOfTries(this.game.getNrOfTries() -1);
            System.out.println(this.game.getNrOfTries());
        }

        if(this.game.getNrOfTries() == 0) {
            this.game.change_state(new state_game_lost(this.game));
        }

    }
}
