package banana_user.controller;

public class Controllers {

	private static ProgramController programController;
	private static UserController userController;
	private static LoginController loginController;
	private static EmotionController emotionController;
	
	public Controllers() {

		programController = new ProgramController();
		userController = new UserController();
		loginController = new LoginController();
		emotionController = new EmotionController();
	}

	public static ProgramController getProgramController() {

		return programController;

	}

	public static UserController getUserController() {

		return userController;

	}

	public static LoginController getLoginController() {
		return loginController;
	}

	public static EmotionController getEmotionController() {
		return emotionController;
	}
	
}
