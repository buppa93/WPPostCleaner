package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Gestisce l'accesso alla base di dati.
 * @author Stefano Cuppone
 *
 */
public class DbEngine
{
	private static final String DRIVER_CLASS_NAME = "org.gjt.mm.mysql.Driver";
	private static final String DBMS = "jdbc:mysql";
	private static Connection conn;
	
	public DbEngine() {}
	
	/**
	 * 
	 * @param host
	 * @param user
	 * @param password
	 * @throws DatabaseConnectionException
	 */
	public void initConnection(String host, String user, String password) 
			throws DatabaseConnectionException
	{
		String connectionString = DBMS+"://" + host; 
		
		try 
		{
			Class.forName(DRIVER_CLASS_NAME).newInstance() ;
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			conn = (Connection) DriverManager.getConnection(connectionString, user, password);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
	}
	
	/**
	 * 
	 * @return
	 */
	public static Connection getConnection() {return conn;}
	
	/**
	 * 
	 */
	public static void closeConnection()
	{
		try 
		{
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
