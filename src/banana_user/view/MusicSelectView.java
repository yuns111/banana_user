package banana_user.view;

import java.util.Scanner;

import banana_user.controller.Controllers;

public class MusicSelectView {

	private Scanner keyboard;

	public MusicSelectView() {

		keyboard = new Scanner(System.in);
	}
	
	public void musicSelectOneView(){
		
		System.out.print("음원번호로 선택해주세요 : ");
		int musicNumber = keyboard.nextInt();
		
		Controllers.getMusicController().requestMusicSelectOne(musicNumber);
		
	}


}
