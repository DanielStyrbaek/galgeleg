package com.example.galgeleg.state;

public interface IGameState {
    void handle();

    void start_new_game();

    void update_visible_word();

    void guess_letter(String letter);

}
