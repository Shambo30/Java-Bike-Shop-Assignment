package edu.curtin.oose2024s1.assignment2.exceptions;

/**
 * Exception for MessageHandling issues in the handling itself.
 */
public class MessageHandlingException extends Exception
{
    public MessageHandlingException(String message)
    {
        super(message);
    }

    public MessageHandlingException(String message, Throwable cause)
    {
        super(message, cause);
    }
}