package banana_user.controller;

import java.util.ArrayList;

import banana_user.dao.MusicDao;
import banana_user.domain.Music;
import banana_user.view.AlertView;
import banana_user.view.MusicPlayingView;
import banana_user.view.MusicSelectView;

public class MusicController {
	
	private MusicDao musicDao;
	
	public MusicController() {
		musicDao = new MusicDao();
	}
	
	//음원목록출력
	public void requestSelectAllMusic() {
		
		ArrayList<Music> musicList = musicDao.musicSelectAll();
		
		MusicSelectView musicSelectView = new MusicSelectView();
		musicSelectView.musicSelectAll(musicList);
	}
	
	
	//음원선택 뷰 호출
	public void requestCallMusicSelectOneView(){
		
		//하나 선택 입력받을 뷰(0입력시 재생안함)
		MusicSelectView selectOne = new MusicSelectView();		
		selectOne.musicSelectOneView();
		
	}
	
	public void requestMusicSelectOne(int musicNumber){
		
		//dao에서 선택한 음원 정보 추출
		Music selectedMusic = musicDao.selectOneMusic(musicNumber);
		
		if(selectedMusic.getMusicNumber() == 0) {
			
			Controllers.getMenuController().requestShowMenu();
			
		} else if(selectedMusic.getMusicNumber() < 0) {
			
			new AlertView().alert("해당하는 노래가 없습니다.");
			
		} else {
			//노래 재생 메서드 호출
			requestPlayingMusic(selectedMusic);
		}
		
	}
	
	//노래재생
	public void requestPlayingMusic(Music selectedMusic){
		
		//dao에서 로그인판별,이용권구매여부 판별
		int success = musicDao.playMusic(selectedMusic);
		
		MusicPlayingView playView = new MusicPlayingView();
		//값이 true면 view에서 노래 출력
		if(success == 0){
			//비로그인상태 비로그인상태입니다 1분재생 -> 비로그인 메뉴
			playView.unLoginPlaying(selectedMusic);
			
		} else if(success == 1){
			//현재 이용권이 없습니다 1분재생 ->로그인메뉴
			playView.noTicketPlaying(selectedMusic);
			
		} else {
			
			playView.musicPlaying(selectedMusic);
		}
		
		Controllers.getMenuController().requestShowMenu();
	}

}
