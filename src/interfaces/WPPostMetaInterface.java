package interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import model.WPPostMeta;

/**
 * 
 * WPPostMetaInterface - Interface for the wp_postmeta table.
 * @author Giuseppe Antonio Sansone <giuseppeantonio.sansone@gmail.com>
 * @version 0.1
 */
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
	 * Contructor foe the class
	 * @param postMeta a PostMeta instance
	 * @param conn the database connection instance
	 */
	public WPPostMetaInterface(WPPostMeta postMeta, Connection conn) 
	{
		this.postMeta = postMeta;
		this.conn = conn;
		this.readValues = new ArrayList<WPPostMeta>();
		this.rowsWithErrors =  new ArrayList<WPPostMeta>();
	}
	
	/**
	 * Empty contructor for the class
	 */
	public WPPostMetaInterface() {}

	/**
	 * Get the PostMeta attribute
	 * @return the PostMeta attribute
	 */
	public WPPostMeta getPostMeta() {return postMeta;}

	/**
	 * Set the PostMeta attribute
	 * @param postMeta the PostMeta attribute
	 */
	public void setPostMeta(WPPostMeta postMeta) {this.postMeta = postMeta;}

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
	public ArrayList<WPPostMeta> getReadValues() {return readValues;}

	/**
	 * Set a list of read rows for the table
	 * @param readValues a list of read rows
	 */
	public void setReadValues(ArrayList<WPPostMeta> readValues) {this.readValues = readValues;}

	/**
	 * Get a list of rows with an error state
	 * @return a list of rows with an error state
	 */
	public ArrayList<WPPostMeta> getRowsWithErrors() {return rowsWithErrors;}
	
	/**
	 * Set a list of rows with an error state
	 * @param rowsWithErrors a list of rows with an error state
	 */
	public void setRowsWithErrors(ArrayList<WPPostMeta> rowsWithErrors) {this.rowsWithErrors = rowsWithErrors;}
	
	/**
	 * Read the wp_postmeta table
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
	 * Write the wp_postmeta table
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
						//e.printStackTrace(); // TODO Debug Mode! Delete This!
						this.rowsWithErrors.add(wpPost);
					}
				}
			} 
			catch (SQLException e1) 
			{
				//e1.printStackTrace(); // TODO Debug Mode! Delete This!
				this.rowsWithErrors.add(wpPost);
			}
			
		}
	}

	/**
	 * Get a string rappresentation for the object
	 * @return a string rappresentation of the object
	 */
	@Override
	public String toString() {return "WPPostMetaInterface [postMeta=" + postMeta + ", conn=" + conn + "]";}
	
}
