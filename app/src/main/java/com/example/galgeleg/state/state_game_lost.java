package com.example.galgeleg.state;

import com.example.galgeleg.Game_Logic;

public class state_game_lost implements IGameState{

    Game_Logic game;
    public state_game_lost(Game_Logic game_logic) {
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

    }

    @Override
    public void guess_letter(String letter) {

    }
}
