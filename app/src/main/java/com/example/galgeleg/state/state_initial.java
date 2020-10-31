package com.example.galgeleg.state;

import com.example.galgeleg.Game_Logic;

public class state_initial implements IGameState {

    Game_Logic game;

    public state_initial(Game_Logic game_logic) {
        this.game = game_logic;
    }

    @Override
    public void handle() {

    }

    @Override
    public void start_new_game() {
        this.game.setWord("Hangmantest");
        this.game.update_visible_word();
        this.game.change_state(new state_game_running(this.game));

    }

    @Override
    public void update_visible_word() {
        this.game.setVisibleWord("");

    }

    @Override
    public void guess_letter(String letter) {

    }
}
