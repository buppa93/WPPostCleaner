package interfaces;

/**
 * PJDCC - Summary for class responsabilities.
 *
 * @author john doe <jdoe@myorg.com>
 * @since 1.2
 * @version 1.8 Changes done
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import model.WPUser;

public class WPUserInterface 
{
	private WPUser user;
	private Connection conn;
	private ArrayList<WPUser> readValues;
	
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
	 * 
	 * @param user
	 * @param conn
	 */
	public WPUserInterface(WPUser user, Connection conn) 
	{
		this.user = user;
		this.conn = conn;
		this.readValues = new ArrayList<WPUser>();
	}
	
	/**
	 * 
	 */
	public WPUserInterface() {}

	/**
	 * 
	 * @return
	 */
	public WPUser getUser() {return user;}

	/**
	 * 
	 * @param user
	 */
	public void setUser(WPUser user) {this.user = user;}

	/**
	 * 
	 * @return
	 */
	public Connection getConn() {return conn;}

	/**
	 * 
	 * @param conn
	 */
	public void setConn(Connection conn) {this.conn = conn;}

	/**
	 * 
	 * @return
	 */
	public ArrayList<WPUser> getReadValues() {return readValues;}

	/**
	 * 
	 * @param readValues
	 */
	public void setReadValues(ArrayList<WPUser> readValues) {this.readValues = readValues;}
	
	/**
	 * 
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
	 * 
	 * @throws WriteWPUserException
	 * @throws SQLException
	 */
	public void writeTable() throws WriteWPUserException, SQLException
	{
		Iterator<WPUser> itr = readValues.iterator();
		
		while(itr.hasNext())
		{
			WPUser user = itr.next();
			PreparedStatement prStm = conn.prepareStatement(WRITE_STATEMENT);
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
			
			int res = prStm.executeUpdate();
			
			if(res == 1)
			{
				throw new WriteWPUserException(user.toString());
			}
		}
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() 
	{
		return "WPUserInterface [user=" + user + ", conn=" + conn + "]";
	}
	
	
	
	

}
