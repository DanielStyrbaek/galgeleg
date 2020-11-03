package com.example.galgeleg.observers;

import android.os.Handler;

import androidx.fragment.app.Fragment;


public interface IObserver  {
    void update(Handler UIthread);
}
