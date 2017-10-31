package interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import model.WPUser;

/**
 * 
 * WPUserInterface - Interface for the wp_users table.
 * @author Giuseppe Antonio Sansone <giuseppeantonio.sansone@gmail.com>
 * @version 0.1
 */
public class WPUserInterface 
{
	private WPUser user;
	private Connection conn;
	private ArrayList<WPUser> readValues;
	private ArrayList<WPUser> rowsWithErrors;
	
	private static final String READ_QUERY = "SELECT * FROM wp_users";
	private String WRITE_STATEMENT = "INSERT INTO wp_users(ID, user_login, user_pass, user_nicename, user_email, "
										+"user_url, user_registered, user_activation_key, user_status, display_name) "
										+"VALUES(?,?,?,?,?,?,?,?,?,?)";
	
	private static final String ID = "ID";
	private static final String USER_LOGIN = "user_login";
	private static final String USER_PASS = "user_pass";
	private static final String USER_NICENAME = "user_nicename";
	private static final String USER_EMAIL = "user_email";
	private static final String USER_URL = "user_url";
	private static final String USER_REGISTERED = "user_registered";
	private static final String USER_ACTIVATION_KEY = "user_activation_key";
	private static final String USER_STATUS = "user_status";
	private static final String DISPLAY_NAME = "display_name";
	
	/**
	 * Constructorfor the class
	 * @param user a User instance
	 * @param conn the connection instance
	 */
	public WPUserInterface(WPUser user, Connection conn) 
	{
		this.user = user;
		this.conn = conn;
		this.readValues = new ArrayList<WPUser>();
		this.rowsWithErrors = new ArrayList<WPUser>();
	}
	
	/**
	 * Empty constructor for the class
	 */
	public WPUserInterface() {}

	/**
	 * Get the User attribute
	 * @return the user attribute
	 */
	public WPUser getUser() {return user;}

	/**
	 * Set the User attribute
	 * @param user the user attribute
	 */
	public void setUser(WPUser user) {this.user = user;}

	/**
	 * Get the connection attribute
	 * @return the connection attribute
	 */
	public Connection getConn() {return conn;}

	/**
	 * Set the connection attribute
	 * @param conn the connection attribute
	 */
	public void setConn(Connection conn) {this.conn = conn;}

	/**
	 * Get a list of read rows in the table
	 * @return a list of read rows
	 */
	public ArrayList<WPUser> getReadValues() {return readValues;}

	/**
	 * Set a list of read rows in the table
	 * @param readValues a list of read rows
	 */
	public void setReadValues(ArrayList<WPUser> readValues) {this.readValues = readValues;}
	
	/**
	 * Get a list of rows with an error state
	 * @returna list of rows with an error state
	 */
	public ArrayList<WPUser> getRowsWithErrors() {return rowsWithErrors;}
	
	/**
	 * Set a list of rows with an error state
	 * @param rowsWithErrors list of rows with an error state
	 */
	public void setRowsWithErrors(ArrayList<WPUser> rowsWithErrors) {this.rowsWithErrors = rowsWithErrors;}
	
	/**
	 * Read the wp_users table
	 * @throws SQLException
	 */
	public void readTable() throws SQLException
	{
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(READ_QUERY);
		
		while(rs.next())
		{
			WPUser user = new WPUser(rs.getInt(ID), rs.getString(USER_LOGIN), rs.getString(USER_PASS),
					rs.getString(USER_NICENAME), rs.getString(USER_EMAIL), rs.getString(USER_URL), 
					rs.getTimestamp(USER_REGISTERED), rs.getString(USER_ACTIVATION_KEY), rs.getInt(USER_STATUS),
					rs.getString(DISPLAY_NAME));
			readValues.add(user);
		}
	}
	
	/**
	 * Write th wp_users table
	 * @throws WriteWPUserException
	 * @throws SQLException
	 */
	public void writeTable()
	{
		Iterator<WPUser> itr = readValues.iterator();
		
		while(itr.hasNext())
		{
			WPUser user = itr.next();
			PreparedStatement prStm = null;
			int res = 0;
			try
			{
				prStm = conn.prepareStatement(WRITE_STATEMENT);
				prStm.setInt(1, user.getId());
				prStm.setString(2, user.getUserLogin());
				prStm.setString(3, user.getUserPass());
				prStm.setString(4, user.getUserNicename());
				prStm.setString(5, user.getUserEmail());
				prStm.setString(6, user.getUserUrl());
				prStm.setTimestamp(7, user.getUserRegistered());
				prStm.setString(8, user.getUserActivationKey());
				prStm.setInt(9, user.getUserStatus());
				prStm.setString(10, user.getDisplayName());
				
				res = prStm.executeUpdate();
				
				if(res == 0)
				{
					try 
					{
						throw new WriteWPUserException(user.toString());
					} 
					catch (WriteWPUserException e) 
					{
						//e.printStackTrace(); // TODO Debug Mode! Delete This!
						this.rowsWithErrors.add(user);
					}
				}
			}
			catch(SQLException e)
			{
				//e.printStackTrace(); // TODO Debug Mode! Delete This!
				this.rowsWithErrors.add(user);
				
			}
		}
	}
	
	/**
	 * Get a string rappresentation for the object
	 * @return a string rappresentation of the object
	 */
	@Override
	public String toString() 
	{
		return "WPUserInterface [user=" + user + ", conn=" + conn + "]";
	}
	
	
	
	

}
