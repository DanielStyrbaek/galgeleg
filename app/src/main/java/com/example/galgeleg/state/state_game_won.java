package com.example.galgeleg.state;

import com.example.galgeleg.Game_Logic;

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

    }

    @Override
    public void update_visible_word() {

    }

    @Override
    public void guess_letter(String letter) {

    }
}
