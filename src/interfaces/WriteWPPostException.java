package interfaces;

/**
 * WriteWPPostException - Manage an exception on the write wp_posts phase.
 *
 * @author Giuseppe Antonio Sansone <giuseppeantonio.sansone@gmailcom>
 * @version 0.1 
 */
public class WriteWPPostException extends Exception 
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor for the class
	 * @param message The error message for the exception
	 */
	public WriteWPPostException(String message)
	{
		super(message);
	}
	
	/**
	 * Get a string rappresentation for the object
	 * @return a string rappresentation of the object
	 */
	public String toString() 
	{
		return "Failed to write POST in the wp_posts table writing phase: " + getMessage();
	}
}
