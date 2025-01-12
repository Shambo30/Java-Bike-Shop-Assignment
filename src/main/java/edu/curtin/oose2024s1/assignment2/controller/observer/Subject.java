package edu.curtin.oose2024s1.assignment2.observer;

/**
 * Simple subject interface following Observer pattern
 */
public interface Subject
{
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(String message);
}