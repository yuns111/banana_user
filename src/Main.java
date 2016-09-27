import banana_user.controller.Controllers;

public class Main {

	public static void main(String[] args) {
		
		new Controllers();
		Controllers.getLoginController().requestLogin();
		Controllers.getLoginController().requestLoginYN();
		Controllers.getLoginController().requestLogout();
		Controllers.getLoginController().requestLoginYN();


	}

}
