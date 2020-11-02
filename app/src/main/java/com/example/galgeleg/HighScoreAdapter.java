package com.example.galgeleg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galgeleg.preference.Score;

import java.util.ArrayList;

public class HighScoreAdapter extends RecyclerView.Adapter<HighScoreAdapter.ViewHolder> {
    private static final String TAG = "RecycleViewAdapter";

    private ArrayList<Score> Scores;

    public HighScoreAdapter(Context context, ArrayList<Score> scores) {
        Scores = scores;

        //TODO:
        // Scores.sort() ??
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_highscore_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Score currentScore = Scores.get(position);


        holder.name.setText(currentScore.getName());
        holder.word.setText(currentScore.getWord());
        holder.score.setText(String.valueOf(currentScore.computeScore()));

    }

    @Override
    public int getItemCount() {
        return Scores.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView name;
        public TextView word;
        public TextView score;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.high_name);
            word = itemView.findViewById(R.id.high_word);
            score = itemView.findViewById(R.id.high_score);
        }
    }

}
