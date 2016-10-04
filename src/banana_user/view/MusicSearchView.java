package banana_user.view;

import java.util.ArrayList;
import java.util.Scanner;
import banana_user.domain.Music;


import banana_user.controller.Controllers;

public class MusicSearchView {

	private Scanner keyboard;

	public MusicSearchView() {

		keyboard = new Scanner(System.in);

	}

	public void musicSearchView() {

		System.out.print("검색할 제목을 입력해 주세요 : ");
		String title = keyboard.next();

		Controllers.getMusicController().responseSearchMusic(title);

	}

	//메인메뉴로 가는 음원 목록
	public void printSearchMusicList(ArrayList<Music> searchMusicList) {

		System.out.println("\n[음원 목록 보기]");

		if(searchMusicList.size() == 0) {

			new AlertView().alert("음원이 없습니다.");

			Controllers.getMenuController().requestShowMenu();

		} else {

			System.out.println("음원번호\t노래제목\t\t가수");	

			for(int i = 0; i < searchMusicList.size(); i++) {
				
				System.out.print(searchMusicList.get(i).getMusicNumber() + "\t");
				String title = searchMusicList.get(i).getTitle();
				
				if(title.length() >= 6) {
					
					title = title.substring(0, 5);
					title = title + "...";
					
				} else {
					
					title = title + "\t";
					
				}
				
				System.out.print(title + "\t");
				System.out.println(searchMusicList.get(i).getSinger());
				
			}
			
		}

		Controllers.getMusicController().requestCallMusicSelectOneView(searchMusicList);

	}

}