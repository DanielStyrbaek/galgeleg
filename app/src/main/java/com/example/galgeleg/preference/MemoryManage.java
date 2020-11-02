package com.example.galgeleg.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemoryManage {

    public SharedPreferences memory;

    public SharedPreferences getMemory() {
        return memory;
    }

    public SharedPreferences.Editor getEditor() {
        return mEditor;
    }

    public SharedPreferences.Editor mEditor;

    Gson gson;

    public MemoryManage(Context context) {
        this.memory = PreferenceManager.getDefaultSharedPreferences(context);
        this.mEditor = memory.edit();
        this.gson = new Gson();

    }

    public void saveScore(String name, String word, int tries) {
        Score score = new Score(name, word, tries);
        Gson gson = new Gson();

        String json = gson.toJson(score);
        System.out.println(String.format("test %s", name));
        String key =  name;
        mEditor.putString(key, json);
        mEditor.commit();
    }

    public Score getScore(String key) {

        String json = memory.getString(key, "");

        System.out.println("test3 " + json);
        Score obj = gson.fromJson(json, Score.class);

        System.out.println("test1" +obj.getName());

        return obj;

    }


    public ArrayList getAll() {

        Map<String, ?> all = memory.getAll();

        Object[] jsonArray = all.values().toArray();
        ArrayList<Score> allScores = new ArrayList<>();
        Gson gson = new Gson();
        for (Object e: jsonArray) {
            Score o = gson.fromJson((String) e, Score.class);
            allScores.add(o);
        }

        Collections.sort(allScores);

        return allScores;
    }



}
