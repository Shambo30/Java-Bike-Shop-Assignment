package edu.curtin.oose2024s1.assignment2.model;

/**
 * Represents a single Bike object
 */
public class Bike
{
    private BikeState currentState;
    private String email;
    private boolean hasTakenPayment;

    public Bike()
    {
        this.currentState = new AvailableState();
        this.hasTakenPayment = false;
    }

    public void setState(BikeState state)
    {
        this.currentState = state;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setHasTakenPayment(boolean hasTakenPayment)
    {
        this.hasTakenPayment = hasTakenPayment;
    }

    public BikeState getState()
    {
        return currentState;
    }

    public String getEmail()
    {
        return email;
    }

    public boolean getHasTakenPayment()
    {
        return hasTakenPayment;
    }

    public void updateState()
    {
        currentState.updateState(this);
    }

}