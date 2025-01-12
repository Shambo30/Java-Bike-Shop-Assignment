package edu.curtin.oose2024s1.assignment2.model;

import edu.curtin.oose2024s1.assignment2.observer.Subject;
import edu.curtin.oose2024s1.assignment2.observer.MessageSubject;
import edu.curtin.oose2024s1.assignment2.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains all the information regarding the Bike Shop
 */
public class BikeShopInfo
{
    private List<Bike> bikes;
    private final Subject stateChangeSubject;
    private int money;

    public BikeShopInfo(int initialMoney)
    {
        this.money = initialMoney;
        this.bikes = new ArrayList<>();
        this.stateChangeSubject = new MessageSubject();

        for(int i = 0; i < 50; i++)
        {
            this.bikes.add(new Bike());
        }
    }

    public List<Bike> getBikes()
    {
        return bikes;
    }

    public Bike getAvailableBike()
    {
        for(Bike bike : bikes)
        {
            if(bike.getState() instanceof AvailableState)
            {
                return bike;
            }
        }
        return null; // no bikes
    }

    public Bike getBikeByEmail(String email)
    {
        for(Bike bike : bikes)
        {
            if(email.equals(bike.getEmail()))
            {
                return bike;
            }
        }
        return null; // no bike with email
    }

    public void addBikes(int number)
    {
        for(int i = 0; i < number; i++)
        {
            bikes.add(new Bike());
        }
    }

    public void removeBike(Bike bike)
    {
        bikes.remove(bike);
    }

    public void addMoney(int amount)
    {
        this.money += amount;
    }

    public int getMoney()
    {
        return money;
    }

    public boolean hasSpace(int number)
    {
        return (bikes.size() + number) <= 100;
    }

    //Counts bikes given their state, allows for easier outputting for each day
    //and in displaying different counts for each state type.
    public int countBikesByState(Class<? extends BikeState> stateClass)
    {
        int count = 0;
        for(Bike bike : bikes)
        {
            if(stateClass.isInstance(bike.getState()))
            {
                count++;
            }
        }
        return count;
    }

    public void updateBikeStates()
    {
        for(Bike bike : bikes)
        {
            bike.updateState();
        }
    }

    public void attachObserver(Observer observer)
    {
        stateChangeSubject.attach(observer);
    }

    public void notifyStateChange(String stateInfo)
    {
        stateChangeSubject.notifyObservers(stateInfo);
    }

}