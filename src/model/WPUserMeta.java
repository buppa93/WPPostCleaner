package model;

/**
 * PJDCC - Summary for class responsabilities.
 *
 * @author john doe <jdoe@myorg.com>
 * @since 1.2
 * @version 1.8 Changes done
 */
public class WPUserMeta 
{

	private int uMetaId;
	private int userId;
	private String metaKey;
	private String metaValue;
	
	/**
	 * 
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
	 * 
	 */
	public WPUserMeta() {}
	
	/**
	 * 
	 * @return
	 */
	public int getuMetaId() 
	{
		return uMetaId;
	}

	/**
	 * 
	 * @param uMetaId
	 */
	public void setuMetaId(int uMetaId) {this.uMetaId = uMetaId;}

	/**
	 * 
	 * @return
	 */
	public int getUserId() {return userId;}

	/**
	 * 
	 * @param userId
	 */
	public void setUserId(int userId) {this.userId = userId;}

	/**
	 * 
	 * @return
	 */
	public String getMetaKey() {return metaKey;}

	/**
	 * 
	 * @param metaKey
	 */
	public void setMetaKey(String metaKey) {this.metaKey = metaKey;}

	/**
	 * 
	 * @return
	 */
	public String getMetaValue() {return metaValue;}

	/**
	 * 
	 * @param metaValue
	 */
	public void setMetaValue(String metaValue) {this.metaValue = metaValue;}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "WPUserMeta [uMetaId=" + uMetaId + ", userId=" + userId + ", metaKey=" + metaKey + ", metaValue="
				+ metaValue + "]";
	}

	
	

}
