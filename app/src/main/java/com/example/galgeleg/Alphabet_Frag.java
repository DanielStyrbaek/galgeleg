package com.example.galgeleg;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.galgeleg.factories.ButtonFactory;

public class Alphabet_Frag extends Fragment {

    View root;
    GridLayout grid;
    IGame_Activity game_activity;
    ButtonFactory btnFactory;
    char[] alphabet = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'Å', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Æ', 'Ø', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        root = inflater.inflate(R.layout.fragment_alphabet_, container, false);
        btnFactory = new ButtonFactory();
        grid = root.findViewById(R.id.alphabet_grid);


        for(char letter : alphabet) {
            Button btn = btnFactory.createButton(getContext(), letter);
            grid.addView(btn);
            btn.setOnClickListener(v -> {
                btn.setEnabled(false);

                game_activity.guess((String) btn.getText().toString().toLowerCase());
            });

        }

        //Button btn = new Button(getContext());




        return root;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        game_activity = (IGame_Activity) getActivity();
    }
}