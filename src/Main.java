import banana_user.controller.Controllers;

public class Main {

	public static void main(String[] args) {
		
		new Controllers();

		Controllers.getMusicController().requestSelectAllMusic();
		Controllers.getMenuController().requestShowMenu();
	}

}
