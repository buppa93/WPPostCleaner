package model;

/**
 * 
 * WPUserMeta - Model a row in the wp_usermeta table
 * @author Giuseppe Antonio Sansone <giuseppeantonio.sansone@gmail.com>
 * @version 0.1
 */
public class WPUserMeta 
{

	private int uMetaId;
	private int userId;
	private String metaKey;
	private String metaValue;
	
	/**
	 * Constructor for the class
	 * @param uMetaId
	 * @param userId
	 * @param metaKey
	 * @param metaValue
	 */
	public WPUserMeta(int uMetaId, int userId, String metaKey, String metaValue) 
	{
		this.uMetaId = uMetaId;
		this.userId = userId;
		this.metaKey = metaKey;
		this.metaValue = metaValue;
	}
	
	/**
	 * Empty constructor for the class
	 */
	public WPUserMeta() {}
	
	/**
	 * Get the uMeta ID
	 * @return uMeta ID
	 */
	public int getuMetaId() 
	{
		return uMetaId;
	}

	/**
	 * Set the uMeta ID
	 * @param uMetaId UMeta ID
	 */
	public void setuMetaId(int uMetaId) {this.uMetaId = uMetaId;}

	/**
	 * Get the user ID
	 * @return user ID
	 */
	public int getUserId() {return userId;}

	/**
	 * Set the user ID
	 * @param userId user ID
	 */
	public void setUserId(int userId) {this.userId = userId;}

	/**
	 * Get the meta key
	 * @return the meta key
	 */
	public String getMetaKey() {return metaKey;}

	/**
	 * Set the meta key
	 * @param metaKey the meta key
	 */
	public void setMetaKey(String metaKey) {this.metaKey = metaKey;}

	/**
	 * Get the meta value
	 * @return the meta value
	 */
	public String getMetaValue() {return metaValue;}

	/**
	 * Set the meta value
	 * @param metaValue the meta value
	 */
	public void setMetaValue(String metaValue) {this.metaValue = metaValue;}

	/**
	 * Get a string rappresentation for the object
	 * @return a string rappresentation of the object
	 */
	@Override
	public String toString() {
		return "WPUserMeta [uMetaId=" + uMetaId + ", userId=" + userId + ", metaKey=" + metaKey + ", metaValue="
				+ metaValue + "]";
	}

	
	

}
