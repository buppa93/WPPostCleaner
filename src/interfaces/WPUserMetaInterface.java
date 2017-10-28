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

import model.WPUserMeta;

public class WPUserMetaInterface 
{
	private WPUserMeta userMeta;
	private Connection conn;
	private ArrayList<WPUserMeta> readValues;
	
	private static final String READ_QUERY = "SELECT * FROM wp_usermeta";
	private String WRITE_STATEMENT = "INSERT INTO wp_usermeta (umeta_id, user_id, meta_key, meta_value) VALUES (?, ?, ?, ?)";
	
	private static final String UMETA_ID = "umeta_id";
	private static final String USER_ID = "user_id";
	private static final String META_KEY = "meta_key";
	private static final String META_VALUE = "meta_value";
	
	/**
	 * 
	 * @param userMeta
	 * @param conn
	 */
	public WPUserMetaInterface(WPUserMeta userMeta, Connection conn) 
	{
		this.userMeta = userMeta;
		this.conn = conn;
		this.readValues = new ArrayList<WPUserMeta>();
	}
	
	/**
	 * 
	 */
	public WPUserMetaInterface() {}

	/**
	 * 
	 * @return
	 */
	public WPUserMeta getUserMeta() {return userMeta;}

	/**
	 * 
	 * @param userMeta
	 */
	public void setUserMeta(WPUserMeta userMeta) {this.userMeta = userMeta;}

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
	public ArrayList<WPUserMeta> getReadValues() {return readValues;}

	/**
	 * 
	 * @param readValues
	 */
	public void setReadValues(ArrayList<WPUserMeta> readValues) {this.readValues = readValues;}
	
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
			WPUserMeta userMeta = new WPUserMeta(rs.getInt(UMETA_ID), rs.getInt(USER_ID), rs.getString(META_KEY),
					rs.getString(META_VALUE));
			
			readValues.add(userMeta);
		}
	}
	
	/**
	 * 
	 * @throws WriteWPUserMetaException
	 * @throws SQLException
	 */
	public void writeTable() throws WriteWPUserMetaException, SQLException
	{
		Iterator<WPUserMeta> itr = readValues.iterator();
		
		while(itr.hasNext())
		{
			WPUserMeta wpUserMeta = itr.next();
			PreparedStatement prStm = conn.prepareStatement(WRITE_STATEMENT);
			prStm.setInt(1, wpUserMeta.getuMetaId());
			prStm.setInt(2, wpUserMeta.getUserId());
			prStm.setString(3, wpUserMeta.getMetaKey());
			prStm.setString(5, wpUserMeta.getMetaValue());
			
			int res = prStm.executeUpdate();
			
			if(res == 1)
			{
				throw new WriteWPUserMetaException(wpUserMeta.toString());
			}
		}
	}

	/**
	 * 
	 */
	@Override
	public String toString() 
	{
		return "WPUserMetaInterface [userMeta=" + userMeta + ", conn=" + conn + ", readValues=" + readValues + "]";
	}
	
	
	
	

}
