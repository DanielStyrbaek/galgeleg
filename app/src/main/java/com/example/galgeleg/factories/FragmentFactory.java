package com.example.galgeleg.factories;

import androidx.fragment.app.Fragment;

import com.example.galgeleg.Alphabet_Frag;
import com.example.galgeleg.Dialog_lost;
import com.example.galgeleg.Dialog_won;
import com.example.galgeleg.observers.Display_Frag;
import com.example.galgeleg.observers.Word_Frag;

public class FragmentFactory {


    public FragmentFactory() {

    }


    public Fragment createWordFrag(String type) {

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
        } else if (type == "won") {
            Dialog_won fragment = new Dialog_won();
        } else if (type == "lost") {
            Dialog_lost fragment = new Dialog_lost();
        }


        return null;
    }

}
