package model;

import java.sql.Timestamp;

/**
 * 
 * WPUser - Model a row in the wp_users table
 * @author Giuseppe Antonio Sansone <giuseppeantonio.sansone@gmail.com>
 * @version 0.1
 */
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
	 * Constructor for the class
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
	 * Empty constructor for the class
	 */
	public WPUser() {}

	/**
	 * Get the user ID
	 * @return the user ID
	 */
	public int getId() {return id;}

	/**
	 * Set the user ID
	 * @param id the user ID
	 */
	public void setId(int id) {this.id = id;}

	/**
	 * Get the user login
	 * @return the user login
	 */
	public String getUserLogin() {return userLogin;}

	/**
	 * Set the user login
	 * @param userLogin the user login
	 */
	public void setUserLogin(String userLogin) {this.userLogin = userLogin;}

	/**
	 * Get the user password
	 * @return the user password
	 */
	public String getUserPass() {return userPass;}

	/**
	 * Set the user password
	 * @param userPass the user password
	 */
	public void setUserPass(String userPass) {this.userPass = userPass;}
	
	/**
	 * Get the user nicename
	 * @return the user nicename
	 */
	public String getUserNicename() {return userNicename;}

	/**
	 * Set the user nicename
	 * @param userNicename the user nicaname
	 */
	public void setUserNicename(String userNicename) {this.userNicename = userNicename;}

	/**
	 * Get the user email
	 * @return the user email
	 */
	public String getUserEmail() {return userEmail;}

	/**
	 * Set the user email
	 * @param userEmail the user email
	 */
	public void setUserEmail(String userEmail) {this.userEmail = userEmail;}

	/**
	 * Get the user url
	 * @return the user url
	 */
	public String getUserUrl() {return userUrl;}

	/**
	 * Set the user url
	 * @param userUrl the user url
	 */
	public void setUserUrl(String userUrl) {this.userUrl = userUrl;}

	/**
	 * Get the registration date
	 * @return the registration date
	 */
	public Timestamp getUserRegistered() {return userRegistered;}

	/**
	 * Set the registration date
	 * @param userRegistered the registration date
	 */
	public void setUserRegistered(Timestamp userRegistered) {this.userRegistered = userRegistered;}

	/**
	 * Get the activation key
	 * @return the activation key
	 */
	public String getUserActivationKey() {return userActivationKey;}

	/**
	 * Set the activation key
	 * @param userActivationKey the activation key
	 */
	public void setUserActivationKey(String userActivationKey) {this.userActivationKey = userActivationKey;}

	/**
	 * Get the user status
	 * @return the user status
	 */
	public int getUserStatus() {return userStatus;}

	/**
	 * Set the user status
	 * @param userStatus the user status
	 */
	public void setUserStatus(int userStatus) {this.userStatus = userStatus;}

	/**
	 * Get the user display name
	 * @return the display name
	 */
	public String getDisplayName() {return displayName;}

	/**
	 * Set the user display name
	 * @param displayName the display name
	 */
	public void setDisplayName(String displayName) {this.displayName = displayName;}

	/**
	 * Get a string rappresentation for the object
	 * @return a string rappresentation of the object
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
