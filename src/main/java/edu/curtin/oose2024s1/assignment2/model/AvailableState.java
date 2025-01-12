package edu.curtin.oose2024s1.assignment2.model;

/**
 * The default state for Bike objects
 */
public class AvailableState implements BikeState
{
    @Override
    public void handleDelivery(Bike bike)
    {
        System.out.println("Bike is already available.");
    }

    @Override
    public void handleDropOff(Bike bike, String email)
    {
        System.out.println("Bike is being dropped off for service.");
        bike.setEmail(email);
        bike.setState(new ServicingState());
    }

    @Override
    public void handlePurchaseOnline(Bike bike, String email)
    {
        System.out.println("Bike is purchased online.");
        bike.setEmail(email);
        bike.setState(new SoldState());
        bike.setHasTakenPayment(true);
    }

    @Override
    public void handlePurchaseInStore(Bike bike)
    {
        System.out.println("Bike is being purchased in-store");
        bike.setState(new SoldState());
    }

    @Override
    public void handlePickUp(Bike bike, String email)
    {
        System.out.println("Bike is not awaiting pickup.");
    }

    @Override
    public void updateState(Bike bike)
    {
        //redundant function in AvailableState
    }
}