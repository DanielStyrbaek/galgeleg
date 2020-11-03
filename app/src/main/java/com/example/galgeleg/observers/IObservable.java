package com.example.galgeleg.observers;

import android.os.Handler;

public interface IObservable {
    void add(IObserver observer);
    void remove(IObserver observer);
    void Notify();
    int getNumberOfTries();
}
