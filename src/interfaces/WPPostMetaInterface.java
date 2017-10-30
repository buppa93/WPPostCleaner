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

import model.WPPost;
import model.WPPostMeta;

public class WPPostMetaInterface 
{
	private WPPostMeta postMeta;
	private Connection conn;
	private ArrayList<WPPostMeta> readValues;
	private ArrayList<WPPostMeta> rowsWithErrors;
	
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
		this.rowsWithErrors =  new ArrayList<WPPostMeta>();
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
	 * @return
	 */
	public ArrayList<WPPostMeta> getRowsWithErrors() {return rowsWithErrors;}
	
	/**
	 * 
	 * @param rowsWithErrors
	 */
	public void setRowsWithErrors(ArrayList<WPPostMeta> rowsWithErrors) {this.rowsWithErrors = rowsWithErrors;}
	
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
	public void writeTable()
	{
		Iterator<WPPostMeta> itr = readValues.iterator();
		
		while(itr.hasNext())
		{
			WPPostMeta wpPost = itr.next();
			PreparedStatement prStm;
			int res = 0;
			try 
			{
				prStm = conn.prepareStatement(WRITE_STATEMENT);
				prStm.setInt(1, wpPost.getMetaId());
				prStm.setInt(2, wpPost.getPostId());
				prStm.setString(3, wpPost.getMetaKey());
				prStm.setString(4, wpPost.getMetaValue());
				
				res = prStm.executeUpdate();
				
				if(res == 0)
				{
					try 
					{
						throw new WriteWPPostMetaException(wpPost.toString());
					} 
					catch (WriteWPPostMetaException e) 
					{
						e.printStackTrace(); // TODO Debug Mode! Delete This!
						this.rowsWithErrors.add(wpPost);
					}
				}
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace(); // TODO Debug Mode! Delete This!
				this.rowsWithErrors.add(wpPost);
			}
			
		}
	}

	@Override
	public String toString() {return "WPPostMetaInterface [postMeta=" + postMeta + ", conn=" + conn + "]";}
	
}
