package com.example.galgeleg.popup;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.galgeleg.Game_Activity;
import com.example.galgeleg.R;

public class Dialog_startSpil extends DialogFragment {

    private static final String TAG = "Dialog_start";
    View root;

    Button btnBack, btnStartGame;

    Spinner dropDown;

    EditText edtTxt;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        root = inflater.inflate(R.layout.fragment_dialog_start_spil, container, false);

        btnBack = root.findViewById(R.id.s_back);
        btnStartGame = root.findViewById(R.id.s_play_game);
        dropDown = root.findViewById(R.id.s_spinner);
        edtTxt = root.findViewById(R.id.enter_name);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.word_choices, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDown.setAdapter(adapter);

        btnBack.setOnClickListener(v -> {
            edtTxt.setText("");
            dismiss();
        });

        btnStartGame.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), Game_Activity.class);
            i.putExtra("name", edtTxt.getText().toString());
            i.putExtra("choice", dropDown.getSelectedItemPosition());
            startActivity(i);
        });



        return root;
    }
}