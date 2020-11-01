package com.example.galgeleg.preference;

public class Score {

    String name;
    String word;
    int triesLeft;

    public Score(String name, String word, int triesLeft) {
        this.name = name;
        this.word = word;
        this.triesLeft = triesLeft;
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
}
