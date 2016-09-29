package banana_user.controller;
import banana_user.view.MainMenuView;

public class MenuController {
		
	public MenuController() {

	}
	
	public void requestShowMenu(){

		MainMenuView mainMenuView = new MainMenuView();
		mainMenuView.showMainMenu();
	}

}
