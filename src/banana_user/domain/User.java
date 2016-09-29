package banana_user.domain;

public class User {

	private int userNumber;
	private String userId;
	private String userPassword;
	private String userName;
	private String userGender;
	private String userPhoneNumber;
	private String ticketName;
	
	public User() {
		
	}
	
	//회원 등록에 필요
	public User(String userId, String userPassword, String userName, String userGender, String userPhoneNumber) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userGender = userGender;
		this.userPhoneNumber = userPhoneNumber;
	}
	
	//회원 수정에 필요
	public User(String userPassword, String userName, String userGender, String userPhoneNumber) {
		this.userPassword = userPassword;
		this.userName = userName;
		this.userGender = userGender;
		this.userPhoneNumber = userPhoneNumber;
	}
	
	//회원 조회에 필요(마이페이지)
	public User(int userNumber, String userId, String userName, String userPhoneNumber, String ticketName) {
		this.userNumber = userNumber;
		this.userId = userId;
		this.userName = userName;
		this.userPhoneNumber = userPhoneNumber;
		this.ticketName = ticketName;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	
}