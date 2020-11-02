package com.example.galgeleg.popup;

import android.content.Context;
import android.nfc.Tag;
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


public class Dialog_won extends DialogFragment {

    private static final String TAG = "Dialog_won";

    View root;
    IGame_Activity game_activity;
    TextView txtV;

    Button btnReplay, btnMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        root = inflater.inflate(R.layout.fragment_dialog_won, container, false);

        btnReplay = root.findViewById(R.id.action_play_again);
        btnMenu = root.findViewById(R.id.action_menu);
        txtV = root.findViewById(R.id.w_score);

        int score = getArguments().getInt("score");

        txtV.setText("Din score var :" + score);


        btnReplay.setOnClickListener(v -> {
            game_activity.startGame();
            dismiss();
        });



        btnMenu.setOnClickListener(v -> {
            game_activity.handleGameOver();
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