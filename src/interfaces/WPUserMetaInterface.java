package interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import model.WPUser;
import model.WPUserMeta;

/**
 * 
 * WPUserMetaInterface - Interface for the wp_usermeta table.
 * @author Giuseppe Antonio Sansone <giuseppeantonio.sansone@gmail.com>
 * @version 0.1
 */
public class WPUserMetaInterface 
{
	private WPUserMeta userMeta;
	private Connection conn;
	private ArrayList<WPUserMeta> readValues;
	private ArrayList<WPUserMeta> rowsWithErrors;
	
	private static final String READ_QUERY = "SELECT * FROM wp_usermeta";
	private String WRITE_STATEMENT = "INSERT INTO wp_usermeta (umeta_id, user_id, meta_key, meta_value) VALUES (?, ?, ?, ?)";
	
	private static final String UMETA_ID = "umeta_id";
	private static final String USER_ID = "user_id";
	private static final String META_KEY = "meta_key";
	private static final String META_VALUE = "meta_value";
	
	/**
	 * Constructor for the class
	 * @param userMeta a UserMeta instance
	 * @param conn a connection instance
	 */
	public WPUserMetaInterface(WPUserMeta userMeta, Connection conn) 
	{
		this.userMeta = userMeta;
		this.conn = conn;
		this.readValues = new ArrayList<WPUserMeta>();
		this.rowsWithErrors = new ArrayList<WPUserMeta>();
	}
	
	/**
	 * Empty constructor for the class
	 */
	public WPUserMetaInterface() {}

	/**
	 * Get the UserMeta attribute
	 * @return the UserMeta attribute
	 */
	public WPUserMeta getUserMeta() {return userMeta;}

	/**
	 * Set the UserMeta attribute
	 * @param userMeta the UserMeta attribute
	 */
	public void setUserMeta(WPUserMeta userMeta) {this.userMeta = userMeta;}

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
	public ArrayList<WPUserMeta> getReadValues() {return readValues;}

	/**
	 * Set a list of read rows in the table
	 * @param readValues a list of read rows
	 */
	public void setReadValues(ArrayList<WPUserMeta> readValues) {this.readValues = readValues;}
	
	/**
	 * Get a list of rows with an error state
	 * @return list of rows with an error state
	 */
	public ArrayList<WPUserMeta> getRowsWithErrors() {return rowsWithErrors;}
	
	/**
	 * Set a list of rows with an error state
	 * @param rowsWithErrors list of rows with an error state
	 */
	public void setRowsWithErrors(ArrayList<WPUserMeta> rowsWithErrors) {this.rowsWithErrors = rowsWithErrors;}
	
	/**
	 * Read the wp_usermete table
	 * @throws SQLException
	 */
	public void readTable() throws SQLException
	{
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(READ_QUERY);
		
		while(rs.next())
		{
			WPUserMeta userMeta = new WPUserMeta(rs.getInt(UMETA_ID), rs.getInt(USER_ID), rs.getString(META_KEY),
					rs.getString(META_VALUE));
			
			readValues.add(userMeta);
		}
	}
	
	/**
	 * Write the wp_usermeta table
	 * @throws WriteWPUserMetaException
	 * @throws SQLException
	 */
	public void writeTable()
	{
		Iterator<WPUserMeta> itr = readValues.iterator();
		
		while(itr.hasNext())
		{
			WPUserMeta wpUserMeta = itr.next();
			PreparedStatement prStm = null;
			int res = 0;
			try 
			{
				prStm = conn.prepareStatement(WRITE_STATEMENT);
				prStm.setInt(1, wpUserMeta.getuMetaId());
				prStm.setInt(2, wpUserMeta.getUserId());
				prStm.setString(3, wpUserMeta.getMetaKey());
				prStm.setString(4, wpUserMeta.getMetaValue());
				
				res = prStm.executeUpdate();
				
				if(res == 0)
				{
					try 
					{
						throw new WriteWPUserMetaException(wpUserMeta.toString());
					} 
					catch (WriteWPUserMetaException e) 
					{
						//e.printStackTrace(); // TODO Debug Mode! Delete This!
						this.rowsWithErrors.add(wpUserMeta);
					}
				}
			} 
			catch (SQLException e1) 
			{
				//e1.printStackTrace(); // TODO Debug Mode! Delete This!
				this.rowsWithErrors.add(wpUserMeta);
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
		return "WPUserMetaInterface [userMeta=" + userMeta + ", conn=" + conn + ", readValues=" + readValues + "]";
	}
	
	
	
	

}
