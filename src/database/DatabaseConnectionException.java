package database;

/**
 * 
 * DatabaseConnectionException - Manage a an to exception occurred in the database's connection.
 * @author Giuseppe Antonio Sansone <giuseppeantonio.sansone@gmail.com>
 * @version 0.1
 */
public class DatabaseConnectionException extends Exception
{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the class
	 * @param message The error message for the exception
	 */
	public DatabaseConnectionException(String message)
	{
		super(message);
	}
	
	/**
	 * Get the string that describe the exception occurred
	 */
	public String toString() 
	{
		return getMessage() + ":Caricamento driver DBMS fallito.";
	}

}
