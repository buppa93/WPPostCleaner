package model;

import java.sql.Timestamp;

public class WPUser 
{
	private int id;
	private String userLogin;
	private String userPass;
	private String userNicename;
	private String userEmail;
	private String userUrl;
	private Timestamp userRegistered;
	private String userActivationKey;
	private int userStatus;
	private String displayName;
	
	/**
	 * 
	 * @param id
	 * @param userLogin
	 * @param userPass
	 * @param userNicename
	 * @param userEmail
	 * @param userUrl
	 * @param userRegistered
	 * @param userActivationKey
	 * @param userStatus
	 * @param displayName
	 */
	public WPUser(int id, String userLogin, String userPass, String userNicename, String userEmail, String userUrl,
			Timestamp userRegistered, String userActivationKey, int userStatus, String displayName) 
	{
		this.id = id;
		this.userLogin = userLogin;
		this.userPass = userPass;
		this.userNicename = userNicename;
		this.userEmail = userEmail;
		this.userUrl = userUrl;
		this.userRegistered = userRegistered;
		this.userActivationKey = userActivationKey;
		this.userStatus = userStatus;
		this.displayName = displayName;
	}
	
	/**
	 * 
	 */
	public WPUser() {}

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
	public String getUserLogin() {return userLogin;}

	/**
	 * 
	 * @param userLogin
	 */
	public void setUserLogin(String userLogin) {this.userLogin = userLogin;}

	/**
	 * 
	 * @return
	 */
	public String getUserPass() {return userPass;}

	/**
	 * 
	 * @param userPass
	 */
	public void setUserPass(String userPass) {this.userPass = userPass;}
	
	/**
	 * 
	 * @return
	 */
	public String getUserNicename() {return userNicename;}

	/**
	 * 
	 * @param userNicename
	 */
	public void setUserNicename(String userNicename) {this.userNicename = userNicename;}

	/**
	 * 
	 * @return
	 */
	public String getUserEmail() {return userEmail;}

	/**
	 * 
	 * @param userEmail
	 */
	public void setUserEmail(String userEmail) {this.userEmail = userEmail;}

	/**
	 * 
	 * @return
	 */
	public String getUserUrl() {return userUrl;}

	/**
	 * 
	 * @param userUrl
	 */
	public void setUserUrl(String userUrl) {this.userUrl = userUrl;}

	/**
	 * 
	 * @return
	 */
	public Timestamp getUserRegistered() {return userRegistered;}

	/**
	 * 
	 * @param userRegistered
	 */
	public void setUserRegistered(Timestamp userRegistered) {this.userRegistered = userRegistered;}

	/**
	 * 
	 * @return
	 */
	public String getUserActivationKey() {return userActivationKey;}

	/**
	 * 
	 * @param userActivationKey
	 */
	public void setUserActivationKey(String userActivationKey) {this.userActivationKey = userActivationKey;}

	/**
	 * 
	 * @return
	 */
	public int getUserStatus() {return userStatus;}

	/**
	 * 
	 * @param userStatus
	 */
	public void setUserStatus(int userStatus) {this.userStatus = userStatus;}

	/**
	 * 
	 * @return
	 */
	public String getDisplayName() {return displayName;}

	/**
	 * 
	 * @param displayName
	 */
	public void setDisplayName(String displayName) {this.displayName = displayName;}

	/**
	 * 
	 */
	@Override
	public String toString() 
	{
		return "WPUser [id=" + id + ", userLogin=" + userLogin + ", userPass=" + userPass + ", userNicename="
				+ userNicename + ", userEmail=" + userEmail + ", userUrl=" + userUrl + ", userRegistered="
				+ userRegistered + ", userActivationKey=" + userActivationKey + ", userStatus=" + userStatus
				+ ", displayName=" + displayName + "]";
	}
	
	
	
	
}
