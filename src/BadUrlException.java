/**
 * 
 * BadUrlException - Manage a wrong url exception.
 * 
 * @author Giuseppe Antonio Sansone <giuseppeantonio.sansone@gmail.com>
 * @version 0.1
 */
public class BadUrlException extends Exception 
{
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the class
	 * @param message The error message for the exception
	 */
	public BadUrlException(String message)
	{
		super(message);
	}
	
	/**
	 * Get the string that describe the exception occurred
	 */
	public String toString() 
	{
		return "Fatal error: " + getMessage();
	}

}
