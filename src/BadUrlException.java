
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
