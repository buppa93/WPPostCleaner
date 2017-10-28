package interfaces;

/**
 * PJDCC - Summary for class responsabilities.
 *
 * @author john doe <jdoe@myorg.com>
 * @since 1.2
 * @version 1.8 Changes done
 */
public class WriteWPPostMetaException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WriteWPPostMetaException(String message)
	{
		super(message);
	}
	
	public String toString() 
	{
		return "Failed to write POST META in the wp_postmeta table writing phase: " + getMessage();
	}

}
