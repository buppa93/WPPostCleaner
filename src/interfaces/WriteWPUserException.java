package interfaces;

/**
 * PJDCC - Summary for class responsabilities.
 *
 * @author john doe <jdoe@myorg.com>
 * @since 1.2
 * @version 1.8 Changes done
 */
public class WriteWPUserException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WriteWPUserException(String message)
	{
		super(message);
	}
	
	public String toString() 
	{
		return "Failed to write USER in the wp_users table writing phase: " + getMessage();
	}
	
}
