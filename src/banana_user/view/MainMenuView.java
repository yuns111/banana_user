package banana_user.view;

import java.util.Scanner;

import banana_user.controller.Controllers;

public class MainMenuView {

	private Scanner keyboard;

	public MainMenuView() {

		keyboard = new Scanner(System.in);

	}

	public void showMainMenu(){

		//로그인체크여부
		boolean loginYN =Controllers.getLoginController().requestLoginYN();
		int menuTypeNumber = 0;

		if(loginYN == false){
			System.out.print("\n[1.로그인   2.회원가입  3.노래듣기  4.노래검색  0.프로그램 종료] : ");
			menuTypeNumber = keyboard.nextInt();

		} else{
			System.out.print("\n[1.로그아웃   2.마이페이지  3.노래듣기  4.노래검색  5.감정선택  6.이용권구매  7.플레이리스트 0.프로그램 종료] :");
			menuTypeNumber = keyboard.nextInt();
		}

		switch(menuTypeNumber){
		case 1:
			if(loginYN == false){			
				Controllers.getLoginController().requestLogin();
			} else {
				Controllers.getLoginController().requestLogout();
			}
			break;
		case 2:
			if(loginYN == false){
				Controllers.getUserController().requestRegisterUser();
			} else {
				Controllers.getUserController().requestUserMypage();
			}
			break;
		case 3:
			Controllers.getMusicController().requestSelectAllMusic();
			Controllers.getMusicController().requestCallMusicSelectOneView();
			break;
		case 4:
			//노래 검색 구현 예정
			break;
		case 5:
			//감정 선택 구현 예정
			break;
		case 6:
			if(loginYN == false){
				System.out.println("메뉴를 다시 선택해 주세요.");
			} else {						
				Controllers.getTicketController().requestTicketAllList();
			}
			break;
		case 7:
			if(loginYN == false){
				System.out.println("메뉴를 다시 선택해 주세요.");
			} else {						
				//플레이리스트 구현 예정
			}
			break;
		case 0:
			Controllers.getProgramController().requestExitProgram();
			break;
		default :
			System.out.println("메뉴를 다시 선택해 주세요.");
		}

	}
}
