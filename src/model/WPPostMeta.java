package model;

/**
 * 
 * WPPostMeta - Model a row in the wp_postmeta table
 * @author Giuseppe Antonio Sansone <giuseppeantonio.sansone@gmail.com>
 * @version 0.1
 */
public class WPPostMeta 
{
	private int metaId;
	private int postId;
	private String metaKey;
	private String metaValue;
	
	/**
	 * Constructor for the class
	 * @param metaId
	 * @param postId
	 * @param metaKey
	 * @param metaValue
	 */
	public WPPostMeta(int metaId, int postId, String metaKey, String metaValue) 
	{
		this.metaId = metaId;
		this.postId = postId;
		this.metaKey = metaKey;
		this.metaValue = metaValue;
	}
	
	/**
	 * Empty constructor for the class
	 */
	public WPPostMeta() {}

	/**
	 * Get the meta ID
	 * @return the ID
	 */
	public int getMetaId() {return metaId;}
	
	/**
	 * Set the meta ID
	 * @param metaId the ID
	 */
	public void setMetaId(int metaId) {this.metaId = metaId;}

	/**
	 * Get the post ID
	 * @return post ID
	 */
	public int getPostId() {return postId;}

	/**
	 * Set the post ID
	 * @param postId post ID
	 */
	public void setPostId(int postId) {this.postId = postId;}

	/**
	 * Get the meta key
	 * @return meta key
	 */
	public String getMetaKey() {return metaKey;}

	/**
	 * Set the meta key
	 * @param metaKey meta key
	 */
	public void setMetaKey(String metaKey) {this.metaKey = metaKey;}

	/**
	 * Get the meta value
	 * @return meta value
	 */
	public String getMetaValue() {return metaValue;}

	/**
	 * Set the meta value
	 * @param metaValue meta value
	 */
	public void setMetaValue(String metaValue) {this.metaValue = metaValue;}	

	/**
	 * Get a string rappresentation for the object
	 * @return a string rappresentation of the object
	 */
	@Override
	public String toString() 
	{
		return "WPPostMeta [metaId=" + metaId + ", postId=" + postId + ", metaKey=" + metaKey + ", metaValue="
				+ metaValue + "]";
	}
}
