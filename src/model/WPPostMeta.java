package model;

/**
 * PJDCC - Summary for class responsabilities.
 *
 * @author john doe <jdoe@myorg.com>
 * @since 1.2
 * @version 1.8 Changes done
 */
public class WPPostMeta 
{
	private int metaId;
	private int postId;
	private String metaKey;
	private String metaValue;
	
	/**
	 * 
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
	 * 
	 */
	public WPPostMeta() {}

	/**
	 * 
	 * @return
	 */
	public int getMetaId() {return metaId;}
	
	/**
	 * 
	 * @param metaId
	 */
	public void setMetaId(int metaId) {this.metaId = metaId;}

	/**
	 * 
	 * @return
	 */
	public int getPostId() {return postId;}

	/**
	 * 
	 * @param postId
	 */
	public void setPostId(int postId) {this.postId = postId;}

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
	public String toString() 
	{
		return "WPPostMeta [metaId=" + metaId + ", postId=" + postId + ", metaKey=" + metaKey + ", metaValue="
				+ metaValue + "]";
	}
}
