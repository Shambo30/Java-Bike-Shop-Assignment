package edu.curtin.oose2024s1.assignment2.observer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Bike Shop Observer following Observer pattern.
 * Monitors the bikeShopService instance and tallies messages
 * accordingly as well as handle file writing for "sim_results.txt".
 */
public class BikeShopObserver implements Observer 
{
    private static final Logger logger = Logger.getLogger(BikeShopObserver.class.getName());

    private int totalMessages;
    private int totalFailures;

    public BikeShopObserver() 
    {
        this.totalMessages = 0;
        this.totalFailures = 0;
    }

    @Override
    public void update(String message) 
    {
        // Increment the count of messages
        totalMessages++;

        // Check for failures in the message
        if(message.contains("FAILURE")) 
        {
            totalFailures++;
        }

        // Log the message to a file
        logger.info("Writing BikeShop stats to file 'sim_results.txt'.");
        writeToFile(message);
    }

    public int getTotalMessages() 
    {
        return totalMessages;
    }

    public int getTotalFailures() 
    {
        return totalFailures;
    }

    public void writeFinalStats(int money)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("sim_results.txt", true)))
        {
            writer.newLine();
            writer.write("Final money: " + money);
            writer.newLine();
            writer.write("Total messages processed: " + getTotalMessages());
            writer.newLine();
            writer.write("Total failures: " + getTotalFailures());
            writer.newLine();
            writer.flush();
            logger.info("Final Bike Shop statistics written to file 'sim_results.txt'.");
        }
        catch(IOException e)
        {
            logger.severe(() -> "Failed to write to 'sim results.txt': " + e);
        }
    }

    private void writeToFile(String message)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("sim_results.txt", true)))
        {
            writer.newLine();
            writer.write(message);
            writer.newLine();
            writer.flush();
        }
        catch(IOException e)
        {
            logger.severe(() -> "Failed to write to 'sim results.txt': " + e);
        }
    }


}
