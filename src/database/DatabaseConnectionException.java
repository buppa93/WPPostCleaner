package database;

/**
 * Modellare la situazione di fallito caricamento del driver del DBMS.
 * @author Stefano Cuppone
 *
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
