package edu.curtin.oose2024s1.assignment2.model;

/**
 * SoldState just a simple state to show the bike is sold.
 * A bit redundant but left to just indicate bikes bought in
 * store have been "sold" and taken.
 */
public class SoldState implements BikeState 
{
    @Override
    public void handleDelivery(Bike bike) 
    {
        System.out.println("Bike is already sold.");
    }

    @Override
    public void handleDropOff(Bike bike, String email) 
    {
        System.out.println("Bike is already sold.");
    }

    @Override
    public void handlePurchaseOnline(Bike bike, String email) 
    {
        System.out.println("Bike is already sold.");
    }

    @Override
    public void handlePurchaseInStore(Bike bike) 
    {
        System.out.println("Bike is already sold.");
    }

    @Override
    public void handlePickUp(Bike bike, String email) 
    {
        System.out.println("Bike is already sold.");
    }

    @Override
    public void updateState(Bike bike)
    {
        //redundant function in SoldState
    }
}
