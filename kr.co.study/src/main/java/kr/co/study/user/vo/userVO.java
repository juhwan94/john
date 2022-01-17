package kr.co.study.user.vo;

public class userVO {
	String userID;
	String userPW;
	
	public userVO() {
		// TODO Auto-generated constructor stub
	}

	public userVO(String userID, String userPW) {
		this.userID = userID;
		this.userPW = userPW;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	@Override
	public String toString() {
		return "userVO [userID=" + userID + ", userPW=" + userPW + "]";
	}
	

}
