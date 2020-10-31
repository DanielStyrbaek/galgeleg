package com.example.galgeleg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

public class Alphabet_Frag extends Fragment {

    View root;
    GridLayout grid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        root = inflater.inflate(R.layout.fragment_alphabet_, container, false);

        grid = root.findViewById(R.id.alphabet_grid);

        Button btn = new Button(getContext());
        btn.setText("HEJ");
        btn.setTextSize(10);
        grid.addView(btn);


        return root;
    }
}