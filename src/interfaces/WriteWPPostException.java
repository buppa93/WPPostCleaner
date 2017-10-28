package interfaces;

/**
 * PJDCC - Summary for class responsabilities.
 *
 * @author john doe <jdoe@myorg.com>
 * @since 1.2
 * @version 1.8 Changes done
 */
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
