package edu.curtin.oose2024s1.assignment2.model;

/**
 * Bike State interface implementing the State pattern
 */
public interface BikeState
{
    void handleDelivery(Bike bike);
    void handleDropOff(Bike bike, String email);
    void handlePurchaseOnline(Bike bike, String email);
    void handlePurchaseInStore(Bike bike);
    void handlePickUp(Bike bike, String email);
    void updateState(Bike bike);
}