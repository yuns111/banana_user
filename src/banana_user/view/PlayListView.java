package banana_user.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import banana_user.controller.Controllers;
import banana_user.domain.Music;

public class PlayListView {

	Scanner keyboard;

	public PlayListView() {
		keyboard = new Scanner(System.in);
	}


	//플레이리스트 뷰와 메뉴로 이어지게
	public void playListView(){

		System.out.println("[플레이리스트]");

		ArrayList<Music> musicInfo = Controllers.getPlayListController().requestPlayList();
		System.out.println("음원번호\t노래제목\t가수");

		for(int i = 0; i< musicInfo.size();i++){
			System.out.print(musicInfo.get(i).getMusicNumber()+"\t");
			System.out.print(musicInfo.get(i).getTitle()+"\t");
			System.out.println(musicInfo.get(i).getSinger()+"\t");

		}

		Controllers.getPlayListController().goToPlayListMenuView();
	}

	//플레이리스트의 메뉴뷰
	public void playListMenuView(){

		while(true){
			System.out.println("1.선택곡 재생 2.선택곡 삭제 3.모든곡 삭제 4.이전 화면");
			int selectPlayListMenu = keyboard.nextInt();

			if(selectPlayListMenu == 1){
				Controllers.getPlayListController().goToSelectPlayMusicView();
			} else if(selectPlayListMenu == 2){
				Controllers.getPlayListController().goToDeleteMusicView();
			} else if(selectPlayListMenu == 3){
				Controllers.getPlayListController().goToDeletePlayListView();
			} else if(selectPlayListMenu == 4){
				Controllers.getMenuController().requestShowMenu();
			} else {
				try {} catch (InputMismatchException e) {} finally {
					System.out.println("잘못입력하셨습니다.");
				}
			}
		}
	}

	//플레이리스트곡 재생
	public void playMusicView(){
		System.out.println("[곡 선택]");
		System.out.println("곡번호를 입력하세요.");
		int playMusicNumber = keyboard.nextInt();

		Controllers.getMusicController().requestMusicSelectOne(playMusicNumber);


	}

	//플레이리스트 목록 중 하나 삭제
	public void delecteMusicOfListView(){
		System.out.println("[곡 선택]");
		System.out.println("곡번호를 입력하세요.");
		int deleteMusicOfListNumber = keyboard.nextInt();
		boolean success = Controllers.getPlayListController().requestDeleteMusicOfList(deleteMusicOfListNumber);

		if(success){
			System.out.println("삭제하였습니다.");
			Controllers.getPlayListController().goToPlayListView();
		} else {
			System.out.println("삭제에 실패하였습니다.");
			Controllers.getPlayListController().goToPlayListView();
		}


	}

	//플레이리스트 전체 삭제
	public void deletePlayListView(){
		System.out.println("정말 플레이리스트내 모든 곡을 삭제하시겠습니까?(y/press any key)");
		char question = keyboard.next().charAt(0);

		if(question == 'y'){

			boolean success = Controllers.getPlayListController().requestDeletePlayList();

			if(success){
				System.out.println("삭제가 완료되었습니다.");
				Controllers.getPlayListController().goToPlayListView();
			} else {
				System.out.println("삭제에 실패하였습니다.");
				Controllers.getPlayListController().goToPlayListView();
			}
		} else {
			Controllers.getPlayListController().goToPlayListView();
		}
	}

}