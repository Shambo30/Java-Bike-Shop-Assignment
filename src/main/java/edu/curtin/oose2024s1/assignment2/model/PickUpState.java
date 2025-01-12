package edu.curtin.oose2024s1.assignment2.model;

/**
 * Pick Up state indicating the bike is available for pickup.
 */
public class PickUpState implements BikeState
{
    @Override
    public void handleDelivery(Bike bike)
    {
        System.out.println("Bike cannot be delivered as it's awaiting pickup.");
    }

    @Override
    public void handleDropOff(Bike bike, String email)
    {
        System.out.println("Bike cannot be serviced as it's awaiting pickup.");
    }

    @Override
    public void handlePurchaseOnline(Bike bike, String email)
    {
        System.out.println("Bike cannot be purchased online as it's awaiting pickup.");
    }

    @Override
    public void handlePurchaseInStore(Bike bike)
    {
        System.out.println("Bike cannot be purchased in-store as it's awaiting pickup.");
        bike.setState(new SoldState());
    }

    @Override
    public void handlePickUp(Bike bike, String email)
    {
        System.out.println("Bike is being picked up.");
        bike.setEmail("");
        bike.setState(new AvailableState());
    }

    @Override
    public void updateState(Bike bike)
    {
        //redundant function in PickUpState
    }
}