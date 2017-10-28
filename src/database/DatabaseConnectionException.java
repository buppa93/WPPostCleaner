package database;

/**
 * PJDCC - Summary for class responsabilities.
 *
 * @author john doe <jdoe@myorg.com>
 * @since 1.2
 * @version 1.8 Changes done
 */
public class DatabaseConnectionException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DatabaseConnectionException(String message){
		super(message);
	}
	
	public String toString() {
		return getMessage() + ":Caricamento driver DBMS fallito.";
	}

}
