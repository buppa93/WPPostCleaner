package interfaces;

/**
 * PJDCC - Summary for class responsabilities.
 *
 * @author john doe <jdoe@myorg.com>
 * @since 1.2
 * @version 1.8 Changes done
 */
public class WriteWPUserMetaException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WriteWPUserMetaException(String message)
	{
		super(message);
	}
	
	public String toString() 
	{
		return "Failed to write USER META in the wp_usermeta table writing phase: " + getMessage();
	}

}
