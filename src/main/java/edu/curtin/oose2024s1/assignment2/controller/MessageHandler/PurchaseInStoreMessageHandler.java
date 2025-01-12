package edu.curtin.oose2024s1.assignment2.controller.messagehandler;

import edu.curtin.oose2024s1.assignment2.exceptions.MessageHandlingException;
import edu.curtin.oose2024s1.assignment2.model.*;

/**
 * Handles Purchase In Store messages generated by BikeShopInput
 */
public class PurchaseInStoreMessageHandler implements MessageHandler
{
    @Override
    public void handleMessage(BikeShopInfo info, String message) throws MessageHandlingException
    {
        Bike bike = info.getAvailableBike();
        if(bike != null)
        {
            bike.setState(new SoldState());
            info.removeBike(bike);
            info.addMoney(1000);
            info.notifyStateChange("Bike purchased in store.");
        }
        else
        {
            throw new MessageHandlingException("No bikes left (for a customer to purchase)");
        }
    }
}