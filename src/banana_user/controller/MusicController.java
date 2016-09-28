package banana_user.controller;

import java.util.ArrayList;

import banana_user.dao.MusicDao;
import banana_user.domain.Music;
<<<<<<< HEAD
=======
import banana_user.view.AlertView;
>>>>>>> refs/remotes/origin/musicSelect
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
		
		if(selectedMusic.getMusicNumber() == 0){
			//메뉴로 돌아가기
			
		} else if(selectedMusic.getMusicNumber() < 0) {
			
			new AlertView().alert("해당하는 노래가 없습니다.");
			
		} else {
			//노래 재생 메서드 호출
		}
		
	}
	
	//노래재생
	

}
