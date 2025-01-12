package edu.curtin.oose2024s1.assignment2.controller.messagehandler;

import edu.curtin.oose2024s1.assignment2.model.BikeShopInfo;
import edu.curtin.oose2024s1.assignment2.exceptions.MessageHandlingException;

/**
 * Interface to handle Messages from BikeShopInput and uses
 * Factory pattern with Dependency Injection.
 */

public interface MessageHandler
{
    void handleMessage(BikeShopInfo info, String message) throws MessageHandlingException; 
}