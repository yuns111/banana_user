package banana_user.controller;

public class Controllers {

	private static ProgramController programController;
	private static UserController userController;
	private static LoginController loginController;
	private static EmotionController emotionController;
	private static MusicController musicController;
	private static MenuController menuController;
	
	private static TicketController ticketController;

	public Controllers() {

		programController = new ProgramController();
		userController = new UserController();
		loginController = new LoginController();
		emotionController = new EmotionController();
		musicController = new MusicController();
		ticketController = new TicketController();
		menuController = new MenuController();
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

	public static MusicController getMusicController() {
		
		return musicController;
	}
	
	
	public static TicketController getTicketController() {
		return ticketController;
	}

	public static MenuController getMenuController() {
		return menuController;
	}	

}
