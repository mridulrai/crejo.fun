/**
 * 
 */
package com.org.crejo.models;

/**
 * @author Mridul
 *
 */
public class User {
	
	private String userName;
	private String emailID;
	private UserType userType;
	private Integer reviewCount = 0; 
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the emailID
	 */
	public String getEmailID() {
		return emailID;
	}
	/**
	 * @param emailID the emailID to set
	 */
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	/**
	 * @return the reviewCount
	 */
	public int getReviewCount() {
		return reviewCount;
	}
	/**
	 * @param reviewCount the reviewCount to set
	 */
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

}
