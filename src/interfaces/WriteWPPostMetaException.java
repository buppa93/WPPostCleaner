package interfaces;

/**
 * WriteWPPostMetaException - Manage an exception on the write wp_postmeta phase.
 *
 * @author Giuseppe Antonio Sansone <giuseppeantonio.sansone@gmailcom>
 * @version 0.1 
 */
public class WriteWPPostMetaException extends Exception 
{
	private static final long serialVersionUID = 1L;


	/**
	 * Constructor for the class
	 * @param message The error message for the exception
	 */
	public WriteWPPostMetaException(String message)
	{
		super(message);
	}
	
	/**
	 * Get a string rappresentation for the object
	 * @return a string rappresentation of the object
	 */
	public String toString() 
	{
		return "Failed to write POST META in the wp_postmeta table writing phase: " + getMessage();
	}

}
