package banana_user.controller;

public class Controllers {
<<<<<<< HEAD
	
	private static ProgramController programController;
	private static LoginController loginController;
	
	public Controllers() {
		
		programController = new ProgramController();
		loginController = new LoginController();
		
	}

	public static ProgramController getProgramController() {

		return programController;

	}

	public static LoginController getLoginController() {
		return loginController;
	}
	
