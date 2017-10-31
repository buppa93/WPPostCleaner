package model;

import java.sql.Timestamp;

/**
 * 
 * WPPost - Model a row in the wp_posts table
 * @author Giuseppe Antonio Sansone <giuseppeantonio.sansone@gmail.com>
 * @version 0.1
 */
public class WPPost 
{

	private int id;
	private int postAuthor;
	private Timestamp postDate;
	private Timestamp postDateGMT;
	private String postContent;
	private String postTitle;
	private String postExcerpt;
	private String postStatus;
	private String commentStatus;
	private String pingStatus;
	private String postPassword;
	private String postName;
	private String toPing;
	private String pinged;
	private Timestamp postModified;
	private Timestamp postModifiedGMT;
	private String postContentFiltered;
	private int postParent;
	private String guid;
	private int menuOrder;
	private String postType;
	private String postMimeType;
	private int commentCount;
	
	/**
	 * Constructor for the class
	 * @param id
	 * @param postAuthor
	 * @param postDate
	 * @param postDateGMT
	 * @param postContent
	 * @param postTitle
	 * @param postExcerpt
	 * @param commentStatus
	 * @param pingStatus
	 * @param postPassword
	 * @param postName
	 * @param toPing
	 * @param pinged
	 * @param postModified
	 * @param postModifiedGMT
	 * @param postContentFiltered
	 * @param postParent
	 * @param guid
	 * @param menuOrder
	 * @param postType
	 * @param postMimeType
	 * @param commentCount
	 */
	public WPPost(int id, int postAuthor, Timestamp postDate, Timestamp postDateGMT, String postContent, 
			String postTitle,String postExcerpt, String postStatus, String commentStatus, String pingStatus, 
			String postPassword, String postName,String toPing, String pinged, Timestamp postModified, 
			Timestamp postModifiedGMT, String postContentFiltered,int postParent, String guid, int menuOrder, 
			String postType, String postMimeType, int commentCount) 
	{
		this.id = id;
		this.postAuthor = postAuthor;
		this.postDate = postDate;
		this.postDateGMT = postDateGMT;
		this.postContent = postContent;
		this.postTitle = postTitle;
		this.postExcerpt = postExcerpt;
		this.postStatus = postStatus;
		this.commentStatus = commentStatus;
		this.pingStatus = pingStatus;
		this.postPassword = postPassword;
		this.postName = postName;
		this.toPing = toPing;
		this.pinged = pinged;
		this.postModified = postModified;
		this.postModifiedGMT = postModifiedGMT;
		this.postContentFiltered = postContentFiltered;
		this.postParent = postParent;
		this.guid = guid;
		this.menuOrder = menuOrder;
		this.postType = postType;
		this.postMimeType = postMimeType;
		this.commentCount = commentCount;
	}
	
	/**
	 * Empty constructor for the class
	 */
	public WPPost() {}
	
	/**
	 * Get the ID
	 * @return the post ID
	 */
	public int getId() {return id;}
	
	/**
	 * Set the ID
	 * @param id the post ID
	 */
	public void setId(int id) {this.id = id;}
	
	/**
	 * Get the post author
	 * @return the author
	 */
	public int getPostAuthor() {return postAuthor;}
	
	/**
	 * Set the post author
	 * @param postAuthor the author
	 */
	public void setPostAuthor(int postAuthor) {this.postAuthor = postAuthor;}
	
	/**
	 * Get the date of post creation
	 * @return the date of creation
	 */
	public Timestamp getPostDate() {return postDate;}
	
	/**
	 * Set the date of post creation
	 * @param postDate the date of creation
	 */
	public void setPostDate(Timestamp postDate) {this.postDate = postDate;}
	
	/**
	 * Get the date GMT of post creation
	 * @return the date of creation (GMT)
	 */
	public Timestamp getPostDateGMT() {return postDateGMT;}
	
	/**
	 * Set the date GMT of post creation
	 * @param postDateGMT the date of creation (GMT)
	 */
	public void setPostDateGMT(Timestamp postDateGMT) {this.postDateGMT = postDateGMT;}
	
	/**
	 * Get the post content
	 * @return the post content
	 */
	public String getPostContent() {return postContent;}
	
	/**
	 * Set the post content
	 * @param postContent the post content
	 */
	public void setPostContent(String postContent) {this.postContent = postContent;}
	
	/**
	 * Get the post title
	 * @return the post title
	 */
	public String getPostTitle() {return postTitle;}
	
	/**
	 * Set te post title
	 * @param postTitle the post title
	 */
	public void setPostTitle(String postTitle) {this.postTitle = postTitle;}
	
	/**
	 * Get the post excerpt
	 * @return the post excerpt
	 */
	public String getPostExcerpt() {return postExcerpt;}
	
	/**
	 * Set the post status
	 * @param postStatus the post status
	 */
	public void setPostStatus(String postStatus) {this.postStatus = postStatus;}
	
	/**
	 * Get the post status
	 * @return the post status
	 */
	public String getPostStatus() {return postStatus;}
	
	/**
	 * Set the post excerpt
	 * @param postExcerpt the post excerpt
	 */
	public void setPostExcerpt(String postExcerpt) {this.postExcerpt = postExcerpt;}
	
	/**
	 * Get the comment status 
	 * @return the comment status
	 */
	public String getCommentStatus() {return commentStatus;}
	
	/**
	 * Set the comment status
	 * @param commentStatus the comment status
	 */
	public void setCommentStatus(String commentStatus) {this.commentStatus = commentStatus;}
	
	/**
	 * Get the ping status
	 * @return the ping status
	 */
	public String getPingStatus() {return pingStatus;}
	
	/**
	 * Set the ping status
	 * @param pingStatus the ping status
	 */
	public void setPingStatus(String pingStatus) {this.pingStatus = pingStatus;}
	
	/**
	 * Get the post password
	 * @return the post password
	 */
	public String getPostPassword() {return postPassword;}
	
	/**
	 * Set the post password
	 * @param postPassword the post password
	 */
	public void setPostPassword(String postPassword) {this.postPassword = postPassword;}
	
	/**
	 * Get the post name
	 * @return the post name
	 */
	public String getPostName() {return postName;}
	
	/**
	 * Set the post name
	 * @param postName the post name
	 */
	public void setPostName(String postName) {this.postName = postName;}
	
	/**
	 * Get to ping value
	 * @return to ping value
	 */
	public String getToPing() {return toPing;}
	
	/**
	 * Set to ping value
	 * @param toPing to ping value
	 */
	public void setToPing(String toPing) {this.toPing = toPing;}
	
	/**
	 * Get pinged value
	 * @return pinged value
	 */
	public String getPinged() {return pinged;}
	
	/**
	 * Set the pinged value
	 * @param pinged pinged valued
	 */
	public void setPinged(String pinged) {this.pinged = pinged;}
	
	/**
	 * Get the post editing date
	 * @return the post editing date
	 */
	public Timestamp getPostModified() {return postModified;}
	
	/**
	 * Get the post editing date
	 * @param postModified the post editing date
	 */
	public void setPostModified(Timestamp postModified) {this.postModified = postModified;}
	
	/**
	 * Get the post editing date (GMT)
	 * @return the post editing date (GMT)
	 */
	public Timestamp getPostModifiedGMT() {return postModifiedGMT;}
	
	/**
	 * Set the post editing date (GMT)
	 * @param postModifiedGMT the post editing date (GMT)
	 */
	public void setPostModifiedGMT(Timestamp postModifiedGMT) {this.postModifiedGMT = postModifiedGMT;}
	
	/**
	 * Get the post content filtered
	 * @return post content filtered
	 */
	public String getPostContentFiltered() {return postContentFiltered;}
	
	/**
	 * Get the post content filtered
	 * @param postContentFiltered post content filtered
	 */
	public void setPostContentFiltered(String postContentFiltered) {this.postContentFiltered = postContentFiltered;}
	
	/**
	 * Get the post parent ID
	 * @return post parent ID
	 */
	public int getPostParent() {return postParent;}
	
	/**
	 * Set the post parent ID
	 * @param postParent post parent ID
	 */
	public void setPostParent(int postParent) {this.postParent = postParent;}
	
	/**
	 * Get the guid
	 * @return the guid
	 */
	public String getGuid() {return guid;}
	
	/**
	 * Set the guid
	 * @param guid the guid
	 */
	public void setGuid(String guid) {this.guid = guid;}
	
	/**
	 * Get menu order number
	 * @return menu order number
	 */
	public int getMenuOrder() {return menuOrder;}
	
	/**
	 * Set menu order number
	 * @param menuOrder menu order number
	 */
	public void setMenuOrder(int menuOrder) {this.menuOrder = menuOrder;}
	
	/**
	 * Get post type
	 * @return post type
	 */
	public String getPostType() {return postType;}
	
	/**
	 * Set post type
	 * @param postType post type
	 */
	public void setPostType(String postType) {this.postType = postType;}
	
	/**
	 * Get post MIME type
	 * @return post MIME type
	 */
	public String getPostMimeType() {return postMimeType;}
	
	/**
	 * Set post MIME type
	 * @param postMimeType post MIME type
	 */
	public void setPostMimeType(String postMimeType) {this.postMimeType = postMimeType;}
	
	/**
	 * Get comment count
	 * @return comment count
	 */
	public int getCommentCount() {return commentCount;}
	
	/**
	 * Set comment count
	 * @param commentCount comment count
	 */
	public void setCommentCount(int commentCount) {this.commentCount = commentCount;}
	
	/**
	 * Get a string rappresentation for the object
	 * @return a string rappresentation of the object
	 */
	@Override
	public String toString() 
	{
		return "WPPost [id=" + id + ", postAuthor=" + postAuthor + ", postDate=" + postDate + ", postDateGMT="
				+ postDateGMT + ", postContent=" + postContent + ", postTitle=" + postTitle + ", postExcerpt="
				+ postExcerpt + ", postStatus=" + postStatus + ", commentStatus=" + commentStatus 
				+ ", pingStatus=" + pingStatus + ", postPassword=" + postPassword + ", postName=" + postName 
				+ ", toPing=" + toPing + ", pinged=" + pinged + ", postModified=" + postModified 
				+ ", postModifiedGMT=" + postModifiedGMT + ", postContentFiltered=" + postContentFiltered 
				+ ", postParent=" + postParent + ", guid=" + guid + ", menuOrder=" + menuOrder + ", postType=" 
				+ postType + ", postMimeType=" + postMimeType + ", commentCount=" + commentCount + "]";
	}

}
