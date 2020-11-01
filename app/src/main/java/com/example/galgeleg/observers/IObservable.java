package com.example.galgeleg.observers;

public interface IObservable {
    void add(IObserver observer);
    void remove(IObserver observer);
    void Notify();
    int getNumberOfTries();
}
