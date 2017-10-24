package interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import model.WPPostMeta;

public class WPPostMetaInterface 
{
	private WPPostMeta postMeta;
	private Connection conn;
	private ArrayList<WPPostMeta> readValues;
	
	private static final String READ_QUERY = "SELECT * FROM wp_postmeta";
	private String WRITE_STATEMENT = "INSERT INTO wp_postmeta (meta_id, post_id, meta_key, meta_value) VALUES (?,?,?,?)";
	
	private static final String META_ID = "meta_id";
	private static final String POST_ID = "post_id";
	private static final String META_KEY = "meta_key";
	private static final String META_VALUE = "meta_value";
	
	/**
	 * 
	 * @param postMeta
	 * @param conn
	 */
	public WPPostMetaInterface(WPPostMeta postMeta, Connection conn) 
	{
		this.postMeta = postMeta;
		this.conn = conn;
		this.readValues = new ArrayList<WPPostMeta>();
	}
	
	/**
	 * 
	 */
	public WPPostMetaInterface() {}

	/**
	 * 
	 * @return
	 */
	public WPPostMeta getPostMeta() {return postMeta;}

	/**
	 * 
	 * @param postMeta
	 */
	public void setPostMeta(WPPostMeta postMeta) {this.postMeta = postMeta;}

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
	public ArrayList<WPPostMeta> getReadValues() {return readValues;}

	/**
	 * 
	 * @param readValues
	 */
	public void setReadValues(ArrayList<WPPostMeta> readValues) {this.readValues = readValues;}
	
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
			WPPostMeta postMeta = new WPPostMeta(rs.getInt(META_ID), rs.getInt(POST_ID), rs.getString(META_KEY),
					rs.getString(META_VALUE));
			
			readValues.add(postMeta);
		}
	}
	
	/**
	 * 
	 * @throws WriteWPPostMetaException
	 * @throws SQLException 
	 */
	public void writeTable() throws WriteWPPostMetaException, SQLException
	{
		Iterator<WPPostMeta> itr = readValues.iterator();
		
		while(itr.hasNext())
		{
			WPPostMeta wpPost = itr.next();
			PreparedStatement prStm = conn.prepareStatement(WRITE_STATEMENT);
			prStm.setInt(1, wpPost.getMetaId());
			prStm.setInt(2, wpPost.getPostId());
			prStm.setString(3, wpPost.getMetaKey());
			prStm.setString(5, wpPost.getMetaValue());
			
			int res = prStm.executeUpdate();
			
			if(res == 1)
			{
				throw new WriteWPPostMetaException(wpPost.toString());
			}
		}
	}

	@Override
	public String toString() {return "WPPostMetaInterface [postMeta=" + postMeta + ", conn=" + conn + "]";}
	
}