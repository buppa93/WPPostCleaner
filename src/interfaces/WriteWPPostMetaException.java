package interfaces;

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
