package edu.curtin.oose2024s1.assignment2.factory;

import edu.curtin.oose2024s1.assignment2.controller.BikeShopService;
import edu.curtin.oose2024s1.assignment2.observer.MessageSubject;

/**
 * The Dependency Injector for MessageHandlerFactory
 */
public class DependencyInjector
{
    public static BikeShopService createBikeShopService()
    {
        MessageHandlerFactory factory = new MessageHandlerFactory();
        MessageSubject messageSubject = new MessageSubject();
        return new BikeShopService(factory, messageSubject, 15000);
    }
}