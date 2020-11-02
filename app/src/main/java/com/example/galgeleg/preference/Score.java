package com.example.galgeleg.preference;

public class Score implements Comparable {

    String name;
    String word;
    int triesLeft;
    int score;

    public Score(String name, String word, int triesLeft) {
        this.name = name;
        this.word = word;
        this.triesLeft = triesLeft;
        this.score = computeScore();
    }

    public int computeScore() {
        if(triesLeft != 0) {
            return this.word.length() * this.triesLeft;
        }
        return this.word.length();
    }

    public String getName() {
        return name;
    }

    public String getWord() {
        return word;
    }

    public int getTriesLeft() {
        return triesLeft;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Object o) {
        int compareScore = ((Score) o).getScore();

        return compareScore-this.score;
    }
}
