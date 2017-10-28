/**
 * PJDCC - Summary for class responsabilities.
 *
 * @author john doe <jdoe@myorg.com>
 * @since 1.2
 * @version 1.8 Changes done
 */
public class BadUrlException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadUrlException(String message)
	{
		super(message);
	}
	
	public String toString() 
	{
		return "Fatal error: " + getMessage();
	}

}
