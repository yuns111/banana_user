package banana_user.controller;

public class Controllers {
	
	private static ProgramController programController;
	private static UserController userController;
	
	public Controllers() {
		
		programController = new ProgramController();
		userController = new UserController();
		
	}
	
	public static ProgramController getProgramController() {

		return programController;

	}
	
	public static UserController getUserController() {
		
		return userController;
		
	}

}