package banana_user.domain;

public class Login {
	
	private String loginId;
	private String loginPassword;
	
	public Login() {
		
	}
	
	public Login(String loginId,String loginPassword) {
		this.loginId = loginId;
		this.loginPassword = loginPassword;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
		
}