package edu.curtin.oose2024s1.assignment2.exceptions;

/**
 * Exception for Invalid Messages passed to handlers
 */
public class InvalidMessageException extends Exception
{
    public InvalidMessageException(String message)
    {
        super(message);
    }

    public InvalidMessageException(String message, Throwable cause)
    {
        super(message, cause);
    }
}