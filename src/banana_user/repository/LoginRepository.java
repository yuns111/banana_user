package banana_user.repository;
import banana_user.domain.Login;

public class LoginRepository {

	private static Login login;

	public LoginRepository() {
		login = new Login();
	}

	public static Login getLogin() {
		return login;
	}
	
}