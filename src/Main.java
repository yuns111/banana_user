import banana_user.controller.Controllers;

public class Main {

	public static void main(String[] args) {
		
		new Controllers();
<<<<<<< HEAD
		System.out.println("~~~");
	
=======
		Controllers.getLoginController().requestLogin();
		Controllers.getLoginController().requestLoginYN();
		Controllers.getLoginController().requestLogout();
		Controllers.getLoginController().requestLoginYN();


>>>>>>> refs/remotes/yuns111/master
	}

}
