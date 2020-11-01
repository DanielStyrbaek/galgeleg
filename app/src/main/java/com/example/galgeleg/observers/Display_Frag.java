package com.example.galgeleg.observers;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.galgeleg.IGame_Activity;
import com.example.galgeleg.R;
import com.example.galgeleg.observers.IObserver;


public class Display_Frag extends Fragment implements IObserver {
    View root;
    int resImg;
    int nrOfTries;
    IGame_Activity game_activity;
    ImageView imgView;
    IObservable observe_game;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        root = inflater.inflate(R.layout.fragment_display_frag, container, false);
        imgView = root.findViewById(R.id.gallows_switch);
        observe_game.add(this);



        return root;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        game_activity =(IGame_Activity) getActivity();
        observe_game = (IObservable) getActivity();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        observe_game.remove(this);
    }

    @Override
    public void update() {

        nrOfTries = observe_game.getNumberOfTries();
        resImg = getResources().getIdentifier("hangman" + nrOfTries, "drawable", getActivity().getPackageName());
        imgView.setImageResource(resImg);
    }
}