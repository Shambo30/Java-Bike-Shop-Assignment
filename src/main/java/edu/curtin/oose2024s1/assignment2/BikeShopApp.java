package edu.curtin.oose2024s1.assignment2;

import edu.curtin.oose2024s1.assignment2.controller.BikeShopService;
import edu.curtin.oose2024s1.assignment2.factory.DependencyInjector;
import edu.curtin.oose2024s1.assignment2.observer.BikeShopObserver;
import edu.curtin.oose2024s1.assignment2.BikeShopInput;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Assignment 2 completed by Samuel Eaves
 * Main entry point of program.
 */
public class BikeShopApp
{
    private static final Logger logger = Logger.getLogger(BikeShopApp.class.getName());

    public static void main(String[] args)
    {
        logger.info("Initializing BikeShopService instance and observer.");
        BikeShopService bikeShopService = DependencyInjector.createBikeShopService();
        BikeShopObserver observer = new BikeShopObserver();
        bikeShopService.attachObserver(observer);

        //BikeShopInput inp = new BikeShopInput();
        BikeShopInput inp = new BikeShopInput(123);  // Seed for the random number generator

        try
        {
            int daysDone = 0;
            while(System.in.available() == 0)
            {

                // For illustration purposes -- this just prints out the messages as they come in.
                System.out.println("---");
                String msg = inp.nextMessage();
                while(msg != null)
                {
                    System.out.println(msg);
                    bikeShopService.processMessage(msg);
                    bikeShopService.updateBikeStates();
                    msg = inp.nextMessage();
                }

                //Daily finished stats print
                System.out.println("\nDays done: " + daysDone);
                System.out.println("Total cash: $" + bikeShopService.getMoney());
                System.out.println("Available bikes: " + bikeShopService.getAvailableCount());
                System.out.println("Bikes being serviced: " + bikeShopService.getServicedCount());
                System.out.println("Bikes awaiting pickup: " + bikeShopService.getPickUpCount());
                System.out.println("");

                // Wait 1 second
                try
                {
                    logger.info("Sleeping program for one second and incrementing day count.");
                    Thread.sleep(1000);
                    daysDone++;
                }
                catch(InterruptedException e)
                {
                    logger.severe(() -> "Thread interrupted: " + e);
                    throw new AssertionError(e);
                }
            }
        }
        catch(IOException e)
        {
            logger.severe(() ->"Error reading input from BikeShopInput: " + e);
            System.out.println("Error reading input from BikeShopInput.");
        }
        
        //Displaying final stats to user
        logger.info("Printing final bikeShopService statistics to user.");
        System.out.println("\nFinal money: $" + bikeShopService.getMoney());
        System.out.println("Total messages processed: " + observer.getTotalMessages());
        System.out.println("Total failures: " + observer.getTotalFailures());

        //Writing final stats to file
        observer.writeFinalStats(bikeShopService.getMoney());
    }
}
