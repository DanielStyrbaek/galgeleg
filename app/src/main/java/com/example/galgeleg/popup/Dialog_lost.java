package com.example.galgeleg.popup;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.galgeleg.IGame_Activity;
import com.example.galgeleg.R;


public class Dialog_lost extends DialogFragment {

    View root;
    IGame_Activity game_activity;
    TextView txtView;

    Button btnReplay, btnMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        root = inflater.inflate(R.layout.fragment_dialog_lost, container, false);

        btnReplay = root.findViewById(R.id.l_action_play_again);
        btnMenu = root.findViewById(R.id.l_action_menu);
        txtView = root.findViewById(R.id.lost_word);

        txtView.setText("Ordet var: " + game_activity.getWord() + ", Men du vidste du vel godt?");


        btnMenu.setOnClickListener(v -> {
            game_activity.handleGameOver();
            dismiss();
        });

        btnReplay.setOnClickListener(v -> {
            game_activity.startGame();
            dismiss();
        });

        return root;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        game_activity = (IGame_Activity) getActivity();
    }
}
