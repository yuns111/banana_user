package banana_user.controller;

public class Controllers {

	private static ProgramController programController;
	private static UserController userController;
	private static LoginController loginController;

	public Controllers() {

		programController = new ProgramController();
		userController = new UserController();
		loginController = new LoginController();
<<<<<<< HEAD
		
=======
>>>>>>> refs/remotes/yuns111/master
	}

	public static ProgramController getProgramController() {

		return programController;

	}

	public static UserController getUserController() {

		return userController;

	}

<<<<<<< HEAD
=======

>>>>>>> refs/remotes/yuns111/master
	public static LoginController getLoginController() {
		return loginController;
	}
}
