package edu.curtin.oose2024s1.assignment2.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple message subject following Observer pattern
 * Made for BikeShopService instance
 */
public class MessageSubject implements Subject
{
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer)
    {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer)
    {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message)
    {
        for(Observer observer : observers)
        {
            observer.update(message);
        }
    }
}