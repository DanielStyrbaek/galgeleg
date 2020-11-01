package com.example.galgeleg.observers;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.galgeleg.IGame_Activity;
import com.example.galgeleg.R;


public class Word_Frag extends Fragment implements IObserver{

    View root;
    IGame_Activity game_activity;
    IObservable observe_game;

    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =inflater.inflate(R.layout.fragment_word_, container, false);

        textView = root.findViewById(R.id.word_display);
        observe_game.add(this);
        textView.setText(game_activity.getVisibleText());
        return root;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        game_activity = (IGame_Activity) getActivity();
        observe_game = (IObservable) getActivity();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        observe_game.remove(this);
    }

    @Override
    public void update() {
        String visible_text = game_activity.getVisibleText();
        textView.setText(visible_text);
    }
}