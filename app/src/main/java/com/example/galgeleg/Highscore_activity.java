package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.galgeleg.preference.Score;

import java.util.ArrayList;

public class Highscore_activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdpater;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore_activity);

        ArrayList<Score> testList = new ArrayList<>();
        testList.add(new Score("Thomas", "ord", 4));
        testList.add(new Score("Daniel", "Kvist", 2));

        recyclerView = findViewById(R.id.highscore_list);
        //recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdpater = new HighScoreAdapter(this, testList);


        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdpater);
    }
}