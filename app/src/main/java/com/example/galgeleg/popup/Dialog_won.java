package com.example.galgeleg.popup;

import android.content.Context;
import android.graphics.Color;
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

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;


public class Dialog_won extends DialogFragment {

    private static final String TAG = "Dialog_won";

    View root;
    IGame_Activity game_activity;
    TextView txtV;

    Button btnReplay, btnMenu;
    KonfettiView konfettiView;



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

        konfettiView = root.findViewById(R.id.viewKonfetti);

        init();





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

    private void init() {
        konfettiView.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE)
                .addSizes(new Size(12, 5f))
                .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                .streamFor(300, 5000L);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        game_activity = (IGame_Activity) getActivity();
    }
}