package interfaces;

public class WriteWPPostException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WriteWPPostException(String message)
	{
		super(message);
	}
	
	public String toString() 
	{
		return "Failed to write POST in the wp_posts table writing phase: " + getMessage();
	}
}
