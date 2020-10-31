package com.example.galgeleg.observers;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.galgeleg.R;
import com.example.galgeleg.observers.IObserver;


public class Display_Frag extends Fragment implements IObserver {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_frag, container, false);
    }

    @Override
    public void update() {

    }
}