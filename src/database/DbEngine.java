package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * DbEngine - Manage a connection to a database.
 * @author Giuseppe Antonio Sansone <giuseppeantonio.sansone@gmail.com>
 * @version 0.1
 */
public class DbEngine
{
	private static final String DRIVER_CLASS_NAME = "org.gjt.mm.mysql.Driver";
	private static final String DBMS = "jdbc:mysql";
	private Connection conn;
	
	/**
	 * Empty constructor for the class
	 */
	public DbEngine() {}
	
	/**
	 * Initialize a connection to a database
	 * @param host the host name
	 * @param user the database username
	 * @param password the password for the user
	 * @throws DatabaseConnectionException
	 */
	public void initConnection(String host, String user, String password) 
			throws DatabaseConnectionException
	{
		String connectionString = DBMS+"://" + host + "?zeroDateTimeBehavior=convertToNull"; 
		
		try 
		{
			Class.forName(DRIVER_CLASS_NAME).newInstance() ;
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) 
		{
			//e.printStackTrace(); //TODO print error message
		}
		
		try 
		{
			conn = (Connection) DriverManager.getConnection(connectionString, user, password);
		}
		catch (SQLException e) 
		{
			//e.printStackTrace(); //TODO print error message
		}  
	}
	
	/**
	 * Get the connection instance
	 * @return connection instance
	 */
	public Connection getConnection() {return conn;}
	
	/**
	 * Close the connection to database
	 */
	public void closeConnection()
	{
		try 
		{
			conn.close();
		} 
		catch (SQLException e) 
		{
			//e.printStackTrace(); //TODO print error message
		}
	}
}
