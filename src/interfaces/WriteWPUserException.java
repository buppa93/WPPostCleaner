package interfaces;

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
