package edu.curtin.oose2024s1.assignment2.factory;

import edu.curtin.oose2024s1.assignment2.controller.messagehandler.*;

/**
 * Factory for MessageHandler to create MessageHandlers as required
 */
public class MessageHandlerFactory
{
    public MessageHandler createMessageHandler(String messageType)
    {
        switch(messageType)
        {
            case "DELIVERY":
                return new DeliveryMessageHandler();

            case "DROP-OFF":
                return new DropOffMessageHandler();

            case "PURCHASE-ONLINE":
                return new PurchaseOnlineMessageHandler();

            case "PURCHASE-IN-STORE":
                return new PurchaseInStoreMessageHandler();

            case "PICK-UP":
                return new PickUpMessageHandler();

            default:
                throw new IllegalArgumentException("Unknown message type: " + messageType);
        }
    }
}