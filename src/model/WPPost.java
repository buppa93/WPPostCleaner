package model;

import java.sql.Timestamp;

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
	 * 
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
	 * 
	 */
	public WPPost() {}
	
	/**
	 * 
	 * @return
	 */
	public int getId() {return id;}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {this.id = id;}
	
	/**
	 * 
	 * @return
	 */
	public int getPostAuthor() {return postAuthor;}
	
	/**
	 * 
	 * @param postAuthor
	 */
	public void setPostAuthor(int postAuthor) {this.postAuthor = postAuthor;}
	
	/**
	 * 
	 * @return
	 */
	public Timestamp getPostDate() {return postDate;}
	
	/**
	 * 
	 * @param postDate
	 */
	public void setPostDate(Timestamp postDate) {this.postDate = postDate;}
	
	/**
	 * 
	 * @return
	 */
	public Timestamp getPostDateGMT() {return postDateGMT;}
	
	/**
	 * 
	 * @param postDateGMT
	 */
	public void setPostDateGMT(Timestamp postDateGMT) {this.postDateGMT = postDateGMT;}
	
	/**
	 * 
	 * @return
	 */
	public String getPostContent() {return postContent;}
	
	/**
	 * 
	 * @param postContent
	 */
	public void setPostContent(String postContent) {this.postContent = postContent;}
	
	/**
	 * 
	 * @return
	 */
	public String getPostTitle() {return postTitle;}
	
	/**
	 * 
	 * @param postTitle
	 */
	public void setPostTitle(String postTitle) {this.postTitle = postTitle;}
	
	/**
	 * 
	 * @return
	 */
	public String getPostExcerpt() {return postExcerpt;}
	
	/**
	 * 
	 * @param postStatus
	 */
	public void setPostStatus(String postStatus) {this.postStatus = postStatus;}
	
	/**
	 * 
	 * @return
	 */
	public String getPostStatus() {return postStatus;}
	
	/**
	 * 
	 * @param postExcerpt
	 */
	public void setPostExcerpt(String postExcerpt) {this.postExcerpt = postExcerpt;}
	/**
	 * 
	 * @return
	 */
	public String getCommentStatus() {return commentStatus;}
	
	/**
	 * 
	 * @param commentStatus
	 */
	public void setCommentStatus(String commentStatus) {this.commentStatus = commentStatus;}
	
	/**
	 * 
	 * @return
	 */
	public String getPingStatus() {return pingStatus;}
	
	/**
	 * 
	 * @param pingStatus
	 */
	public void setPingStatus(String pingStatus) {this.pingStatus = pingStatus;}
	
	/**
	 * 
	 * @return
	 */
	public String getPostPassword() {return postPassword;}
	
	/**
	 * 
	 * @param postPassword
	 */
	public void setPostPassword(String postPassword) {this.postPassword = postPassword;}
	
	/**
	 * 
	 * @return
	 */
	public String getPostName() {return postName;}
	
	/**
	 * 
	 * @param postName
	 */
	public void setPostName(String postName) {this.postName = postName;}
	
	/**
	 * 
	 * @return
	 */
	public String getToPing() {return toPing;}
	
	/**
	 * 
	 * @param toPing
	 */
	public void setToPing(String toPing) {this.toPing = toPing;}
	
	/**
	 * 
	 * @return
	 */
	public String getPinged() {return pinged;}
	
	/**
	 * 
	 * @param pinged
	 */
	public void setPinged(String pinged) {this.pinged = pinged;}
	
	/**
	 * 
	 * @return
	 */
	public Timestamp getPostModified() {return postModified;}
	
	/**
	 * 
	 * @param postModified
	 */
	public void setPostModified(Timestamp postModified) {this.postModified = postModified;}
	
	/**
	 * 
	 * @return
	 */
	public Timestamp getPostModifiedGMT() {return postModifiedGMT;}
	
	/**
	 * 
	 * @param postModifiedGMT
	 */
	public void setPostModifiedGMT(Timestamp postModifiedGMT) {this.postModifiedGMT = postModifiedGMT;}
	
	/**
	 * 
	 * @return
	 */
	public String getPostContentFiltered() {return postContentFiltered;}
	
	/**
	 * 
	 * @param postContentFiltered
	 */
	public void setPostContentFiltered(String postContentFiltered) {this.postContentFiltered = postContentFiltered;}
	
	/**
	 * 
	 * @return
	 */
	public int getPostParent() {return postParent;}
	
	/**
	 * 
	 * @param postParent
	 */
	public void setPostParent(int postParent) {this.postParent = postParent;}
	
	/**
	 * 
	 * @return
	 */
	public String getGuid() {return guid;}
	
	/**
	 * 
	 * @param guid
	 */
	public void setGuid(String guid) {this.guid = guid;}
	
	/**
	 * 
	 * @return
	 */
	public int getMenuOrder() {return menuOrder;}
	
	/**
	 * 
	 * @param menuOrder
	 */
	public void setMenuOrder(int menuOrder) {this.menuOrder = menuOrder;}
	
	/**
	 * 
	 * @return
	 */
	public String getPostType() {return postType;}
	
	/**
	 * 
	 * @param postType
	 */
	public void setPostType(String postType) {this.postType = postType;}
	
	/**
	 * 
	 * @return
	 */
	public String getPostMimeType() {return postMimeType;}
	
	/**
	 * 
	 * @param postMimeType
	 */
	public void setPostMimeType(String postMimeType) {this.postMimeType = postMimeType;}
	
	/**
	 * 
	 * @return
	 */
	public int getCommentCount() {return commentCount;}
	
	/**
	 * 
	 * @param commentCount
	 */
	public void setCommentCount(int commentCount) {this.commentCount = commentCount;}
	
	/**
	 * 
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
