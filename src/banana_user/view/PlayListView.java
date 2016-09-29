package banana_user.view;

import java.util.InputMismatchException;
import java.util.ResourceBundle.Control;
import java.util.Scanner;

import banana_user.controller.Controllers;

public class PlayListView {

	Scanner keyboard;

	public PlayListView() {
		keyboard = new Scanner(System.in);
	}

	public void playListMenuView(){

		//목록 뜨기

		System.out.println("[플레이리스트]");
		System.out.println("1.선택곡 재생 2.선택곡 삭제 3.모든곡 삭제");
		int selectPlayListMenu = keyboard.nextInt();

		if(selectPlayListMenu == 1){
			Controllers.getPlayListController().goToSelectPlayMusicView();
		} else if(selectPlayListMenu == 2){
			Controllers.getPlayListController().goToDeleteMusicView();
		} else if(selectPlayListMenu == 3){
			Controllers.getPlayListController().goToDeletePlayListView();
		} else {
			try {} catch (InputMismatchException e) {} finally {
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}

	public void playMusicView(){
		System.out.println("[곡 선택]");
		System.out.println("곡번호를 입력하세요.");
		int playMusicNumber = keyboard.nextInt();


	}

	public void delecteMusicOfListView(){
		System.out.println("[곡 선택]");
		System.out.println("곡번호를 입력하세요.");
		int deleteMusicOfListNumber = keyboard.nextInt();
		boolean success = Controllers.getPlayListController().requestDeleteMusicOfList(deleteMusicOfListNumber);
		
		if(success){
			System.out.println("삭제하였습니다.");
		} else {
			System.out.println("삭제에 실패하였습니다.");
		}


	}


	public void deletePlayListView(){
		System.out.println("정말 플레이리스트내 모든 곡을 삭제하시겠습니까?(y/press any key)");
		char question = keyboard.next().charAt(0);

		if(question == 'y'){
			//삭제 컨트롤러 호출

			boolean success = false;
			if(success){
				System.out.println("삭제가 완료되었습니다.");
			} else {
				System.out.println("삭제에 실패하였습니다.");
			}
		} else {
			//이전 화면으로 연결
		}
	}

}