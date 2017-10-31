package interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

import model.WPPost;

/**
 * 
 * WPPostInterface - Interface for the wp_posts table.
 * @author Giuseppe Antonio Sansone <giuseppeantonio.sansone@gmail.com>
 * @version 0.1
 */
public class WPPostInterface 
{
	private WPPost post;
	private Connection conn;
	private ArrayList<WPPost> readValues;
	private ArrayList<WPPost> rowsWithErrors;
	
	private static final String READ_QUERY = "SELECT * FROM wp_posts";
	private String WRITE_STATEMENT = "INSERT INTO wp_posts(ID, post_author, post_date, post_date_gmt, post_content," 
										+"post_title, post_excerpt, post_status, comment_status, ping_status, "
										+"post_password, post_name, to_ping, pinged, post_modified, post_modified_gmt, "
										+"post_content_filtered, post_parent, guid, menu_order, post_type, "
										+"post_mime_type, comment_count) "
										+"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private static final String ID = "ID";
	private static final String POST_AUTHOR = "post_author";
	private static final String POST_DATE = "post_date";
	private static final String POST_DATE_GMT = "post_date_gmt";
	private static final String POST_CONTENT = "post_content";
	private static final String POST_TITLE = "post_title";
	private static final String POST_EXCERPT= "post_excerpt";
	private static final String POST_STATUS = "post_status";
	private static final String COMMENT_STATUS = "comment_status";
	private static final String PING_STATUS = "ping_status";
	private static final String POST_PASSWORD = "post_password";
	private static final String POST_NAME = "post_name";
	private static final String TO_PING = "to_ping";
	private static final String PINGED = "pinged";
	private static final String POST_MODIFIED = "post_modified";
	private static final String POST_MODIFIED_GMT = "post_modified_gmt";
	private static final String POST_CONTENT_FILTERED = "post_content_filtered";
	private static final String POST_PARENT = "post_parent";
	private static final String GUID = "guid";
	private static final String MENU_ORDER = "menu_order";
	private static final String POST_TYPE = "post_type";
	private static final String POST_MIME_TYPE = "post_mime_type";
	private static final String COMMENT_COUNT = "comment_count";
	
	/**
	 * Contructor for the class
	 * @param post a Post instance
	 * @param conn the database connection instance
	 */
	public WPPostInterface(WPPost post, Connection conn) 
	{
		this.post = post;
		this.conn = conn;
		this.readValues = new ArrayList<WPPost>();
		this.rowsWithErrors = new ArrayList<WPPost>();
	}
	
	/**
	 * Empy constructor for the class
	 */
	public WPPostInterface() {}

	/**
	 * Get the post attribute
	 * @return the post attribute
	 */
	public WPPost getPost() {return post;}

	/**
	 * Set the post attribute
	 * @param post the post attribute
	 */
	public void setPost(WPPost post) {this.post = post;}

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
	 * Set a list of read rows in the table
	 * @return a list of read rows
	 */
	public ArrayList<WPPost> getReadValues() {return readValues;}

	/**
	 * Set a list of read rows in the table
	 * @param readValues a list of read rows
	 */
	public void setReadValues(ArrayList<WPPost> readValues) {this.readValues = readValues;}
	
	/**
	 * Get a list of rows with an error state
	 * @return a list of rows with an error state
	 */
	public ArrayList<WPPost> getRowsWithErrors() {return rowsWithErrors;}
	
	/**
	 * Set a list of rows with an error state
	 * @param rowsWithErrors a list of rows with an error state
	 */
	public void setRowsWithErrors(ArrayList<WPPost> rowsWithErrors) {this.rowsWithErrors = rowsWithErrors;}

	/**
	 * Read the wp_posts table
	 * @throws SQLException
	 */
	public void readTable() throws SQLException
	{
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(READ_QUERY);
		
		while(rs.next())
		{
			WPPost post = new WPPost(rs.getInt(ID), rs.getInt(POST_AUTHOR), rs.getTimestamp(POST_DATE),
					rs.getTimestamp(POST_DATE_GMT), rs.getString(POST_CONTENT), rs.getString(POST_TITLE), 
					rs.getString(POST_EXCERPT), rs.getString(POST_STATUS), rs.getString(COMMENT_STATUS),
					rs.getString(PING_STATUS), rs.getString(POST_PASSWORD), rs.getString(POST_NAME),
					rs.getString(TO_PING), rs.getString(PINGED), rs.getTimestamp(POST_MODIFIED), 
					rs.getTimestamp(POST_MODIFIED_GMT), rs.getString(POST_CONTENT_FILTERED), rs.getInt(POST_PARENT),
					rs.getString(GUID), rs.getInt(MENU_ORDER), rs.getString(POST_TYPE), rs.getString(POST_MIME_TYPE),
					rs.getInt(COMMENT_COUNT));
			readValues.add(post);
		}
	}
	
	/**
	 * Write the wp_post table
	 * @throws WriteWPPostException
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public void writeTable()
	{
		Iterator<WPPost> itr = readValues.iterator();
		
		while(itr.hasNext())
		{
			WPPost post = itr.next();
			PreparedStatement prStm;
			int res = 0;
			
			try 
			{
				if(post.getPostDateGMT() == null)
				{
					post.setPostDateGMT(new Timestamp(0));
				}
				
				if(post.getPostModifiedGMT() == null)
				{
					post.setPostModifiedGMT(new Timestamp(0));
				}
				
				prStm = conn.prepareStatement(WRITE_STATEMENT);
				prStm.setInt(1, post.getId());
				prStm.setInt(2, post.getPostAuthor());
				prStm.setTimestamp(3, post.getPostDate());
				prStm.setTimestamp(4, post.getPostDateGMT());
				prStm.setString(5, post.getPostContent());
				prStm.setString(6, post.getPostTitle());
				prStm.setString(7, post.getPostExcerpt());
				prStm.setString(8, post.getPostStatus());
				prStm.setString(9, post.getCommentStatus());
				prStm.setString(10, post.getPingStatus());
				prStm.setString(11, post.getPostPassword());
				prStm.setString(12, post.getPostName());
				prStm.setString(13, post.getToPing());
				prStm.setString(14, post.getPinged());
				prStm.setTimestamp(15, post.getPostModified());
				prStm.setTimestamp(16, post.getPostModifiedGMT());
				prStm.setString(17, post.getPostContentFiltered());
				prStm.setInt(18, post.getPostParent());
				prStm.setString(19, post.getGuid());
				prStm.setInt(20, post.getMenuOrder());
				prStm.setString(21, post.getPostType());
				prStm.setString(22, post.getPostMimeType());
				prStm.setInt(23, post.getCommentCount());
				
				res = prStm.executeUpdate();
				
				if(res == 0)
				{
					try 
					{
						throw new WriteWPPostException(post.toString());
					} 
					catch (WriteWPPostException e) 
					{
						//e.printStackTrace(); // TODO Debug Mode! Delete This!
						this.rowsWithErrors.add(post);
					}
				}
			} 
			catch (SQLException e1) 
			{
				//e1.printStackTrace(); // TODO Debug Mode! Delete This!
				this.rowsWithErrors.add(post);
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
		return "WPPostInterface [post=" + post + ", conn=" + conn + "]";
	}
	
	
	
	
}
