package com.example.galgeleg.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.Map;

public class MemoryManage {

    public SharedPreferences memory;

    public SharedPreferences getMemory() {
        return memory;
    }

    public SharedPreferences.Editor getEditor() {
        return mEditor;
    }

    public SharedPreferences.Editor mEditor;

    public MemoryManage(Context context) {
        this.memory = PreferenceManager.getDefaultSharedPreferences(context);
        this.mEditor = memory.edit();

    }

    public void saveScore(String name, String word, int tries) {
        Score score = new Score(name, word, tries);
        Gson gson = new Gson();

        String json = gson.toJson(score);
        String key = String.format("%s", name);
        mEditor.putString(key, json);
    }

    public Map<String, ?> getAll() {
        Map<String, ?> all = memory.getAll();

        return all;
    }



}
