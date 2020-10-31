package com.example.galgeleg;

import com.example.galgeleg.state.IGameState;
import com.example.galgeleg.state.state_game_running;

public class Game_Logic {

    IGameState state;

    public Game_Logic() {
        this.state = new state_game_running(this);
    }

    public void 
}
