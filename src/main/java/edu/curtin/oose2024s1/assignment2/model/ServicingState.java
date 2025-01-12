package edu.curtin.oose2024s1.assignment2.model;

/**
 * Servicing State indicates the bike is being serviced and needs
 * to wait two days (2 seconds) before it becomes available to be picked
 * up by the customer entering PickUpState.
 */
public class ServicingState implements BikeState
{
    private long serviceStartTime;

    public ServicingState()
    {
        this.serviceStartTime = System.currentTimeMillis();
    }

    @Override
    public void handleDelivery(Bike bike)
    {
        System.out.println("Bike cannot be delivered as it's being serviced.");
    }

    @Override
    public void handleDropOff(Bike bike, String email)
    {
        System.out.println("Bike is already being serviced.");
    }

    @Override
    public void handlePurchaseOnline(Bike bike, String email)
    {
        System.out.println("Bike cannot be purchased online as it's being serviced.");
    }

    @Override
    public void handlePurchaseInStore(Bike bike)
    {
        System.out.println("Bike cannot be purchased in-store as it's being serviced.");
        bike.setState(new SoldState());
    }

    @Override
    public void handlePickUp(Bike bike, String email)
    {
        System.out.println("Bike is ready for pickup.");
    }

    @Override
    public void updateState(Bike bike)
    {
        long currentTime = System.currentTimeMillis();
        if((currentTime - serviceStartTime) >= 2000)
        {
            System.out.println("Bike servicing complete. Ready for pickup for " + bike.getEmail());
            bike.setState(new PickUpState());
        }
    }
}