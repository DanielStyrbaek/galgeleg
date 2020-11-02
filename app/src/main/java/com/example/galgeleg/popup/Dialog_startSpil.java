package com.example.galgeleg.popup;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.galgeleg.Game_Activity;
import com.example.galgeleg.Game_Logic;
import com.example.galgeleg.IGame_Activity;
import com.example.galgeleg.R;

public class Dialog_startSpil extends DialogFragment {

    private static final String TAG = "Dialog_start";
    View root;

    Button btnBack, btnStartGame;

    EditText edtTxt;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        root = inflater.inflate(R.layout.fragment_dialog_start_spil, container, false);

        btnBack = root.findViewById(R.id.s_back);
        btnStartGame = root.findViewById(R.id.s_play_game);

        edtTxt = root.findViewById(R.id.enter_name);

        btnBack.setOnClickListener(v -> {
            edtTxt.setText("");
            dismiss();
        });

        btnStartGame.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), Game_Activity.class);
            i.putExtra("name", edtTxt.getText().toString());
            startActivity(i);
        });



        return root;
    }
}