import banana_user.controller.Controllers;

public class Main {

	public static void main(String[] args) {
		
		new Controllers();

		Controllers.getUserController().requestRegisterUser();
		Controllers.getMusicController().requestSelectAllMusic();
		Controllers.getMusicController().requestSelectAllMusic();
		Controllers.getUserController().requestRegisterUser();
		
	}

}
