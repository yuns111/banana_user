package banana_user.controller;

import java.util.ArrayList;

import banana_user.dao.MusicDao;
import banana_user.domain.Music;
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
	
	
	//음원선택
	
	//노래재생
	

}
