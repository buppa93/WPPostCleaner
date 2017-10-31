package interfaces;

/**
 * WriteWPUserException - Manage an exception on the write wp_users phase.
 *
 * @author Giuseppe Antonio Sansone <giuseppeantonio.sansone@gmailcom>
 * @version 0.1 
 */
public class WriteWPUserMetaException extends Exception 
{
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the class
	 * @param message The error message for the exception
	 */
	public WriteWPUserMetaException(String message)
	{
		super(message);
	}
	
	/**
	 * Get a string rappresentation for the object
	 * @return a string rappresentation of the object
	 */
	public String toString() 
	{
		return "Failed to write USER META in the wp_usermeta table writing phase: " + getMessage();
	}

}
