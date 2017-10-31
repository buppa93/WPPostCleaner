/**
 * BadCommandException - Manage the wrong commands exception.
 *
 * @author Giuseppe Antonio Sansone <giuseppeantonio.sansone@gmailcom>
 * @version 0.1 
 */
public class BadCommandException extends Exception
{
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the class
	 * @param message The error message for the exception
	 */
	public BadCommandException(String message)
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
