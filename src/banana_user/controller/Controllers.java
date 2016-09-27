package banana_user.controller;

public class Controllers {
	
	private static ProgramController programController;
<<<<<<< HEAD
	private static UserController userController;
=======
	private static LoginController loginController;
>>>>>>> refs/remotes/yuns111/master
	
	public Controllers() {
		
		programController = new ProgramController();
<<<<<<< HEAD
		userController = new UserController();
=======
		loginController = new LoginController();
>>>>>>> refs/remotes/yuns111/master
		
	}
	
	public static ProgramController getProgramController() {

		return programController;

	}
	
	public static UserController getUserController() {
		
		return userController;
		
	}

<<<<<<< HEAD
}
=======
	public static LoginController getLoginController() {
		return loginController;
	}
}
	
>>>>>>> refs/remotes/yuns111/master
