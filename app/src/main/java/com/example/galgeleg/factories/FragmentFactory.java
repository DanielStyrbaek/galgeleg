package com.example.galgeleg.factories;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.galgeleg.Alphabet_Frag;
import com.example.galgeleg.popup.Dialog_lost;
import com.example.galgeleg.popup.Dialog_won;
import com.example.galgeleg.observers.Display_Frag;
import com.example.galgeleg.observers.Word_Frag;

public class FragmentFactory {


    public FragmentFactory() {

    }


    public Fragment createFragment(String type) {

        if (type == "word") {
            Word_Frag fragment = new Word_Frag();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args); */
            return fragment;
        } else if (type == "display") {
            Display_Frag fragment = new Display_Frag();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args); */
            return fragment;
        } else if (type == "alphabet") {
            Alphabet_Frag fragment = new Alphabet_Frag();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args); */
            return fragment;
        }


        return null;
    }

    public DialogFragment createDialog(String type, int score) {
        switch (type) {
            case "won":

                Dialog_won dialogWon = new Dialog_won();
                dialogWon.setCancelable(false);

                Bundle bundle = new Bundle();
                bundle.putInt("score", score);
                dialogWon.setArguments(bundle);
                return dialogWon;

            case "lost":
                Dialog_lost dialog = new Dialog_lost();
                dialog.setCancelable(false);
                return dialog;

            default:
                return null;

        }

    }

}
