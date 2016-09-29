package banana_user.view;

import java.util.ArrayList;
import java.util.Scanner;
import banana_user.domain.Music;


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

	//메인메뉴로 가는 음원 목록
	public void musicSelectAll(ArrayList<Music> musicList) {

		System.out.println("\n[음원 목록 보기]");

		if(musicList.size() == 0) {
			new AlertView().alert("음원이 없습니다.");
		} else {
			System.out.println("순위\t음원번호\t노래제목\t\t가수");	
			
			for(int i = 0; i < musicList.size(); i++) {
				System.out.print(i+1+"\t");
				System.out.print(musicList.get(i).getMusicNumber() + "\t");
				System.out.print(musicList.get(i).getTitle() + "\t\t");
				System.out.println(musicList.get(i).getSinger());
			}
		}
	}
	
	//노래 재생전 나오는 음원 목록
	public void musicSelectForListening(ArrayList<Music> musicList) {

		System.out.println("\n[음원 목록 보기]");

		if(musicList.size() == 0) {
			new AlertView().alert("음원이 없습니다.");
		} else {
			System.out.println("순위\t음원번호\t노래제목\t\t가수");	
			for(int i = 0; i < musicList.size(); i++) {
				System.out.print(i+1+"\t");
				System.out.print(musicList.get(i).getMusicNumber() + "\t");
				System.out.print(musicList.get(i).getTitle() + "\t\t");
				System.out.println(musicList.get(i).getSinger());
			}
		}
		Controllers.getMusicController().requestCallMusicSelectOneView();
	}
}
