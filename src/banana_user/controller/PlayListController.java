package banana_user.controller;

import banana_user.dao.PlayListDao;
import banana_user.view.PlayListView;

public class PlayListController {

	PlayListDao playListDao;
	
	public PlayListController() {
		
		playListDao = new PlayListDao();
	}

	public void goToPlayListMenuView(){
		
		PlayListView playListView = new PlayListView();
		
	}
	
	public void goToSelectPlayMusicView(){

		PlayListView playListView = new PlayListView();
		playListView.playMusicView();
		
	}

	public void goToDeleteMusicView(){

		PlayListView playListView = new PlayListView();
		playListView.delecteMusicOfListView();
		
	}

	public void goToDeletePlayListView(){

		PlayListView playListView = new PlayListView();
		playListView.deletePlayListView();
		
	}

	public void requestPlayMusic(int playMusicNumber){

		//dao로 번호 전달

	}

	public boolean requestDeleteMusicOfList(int deleteMusicOfListNumber){
		boolean success = false;
		
		//dao로 번호 전달
		playListDao.deleteMusicOfList(deleteMusicOfListNumber);
		
		return success;
	}

	public boolean requestDeletePlayList(){
		boolean success = false;
		//dao의 삭제 메서드 호출과 성공값 받기
		playListDao.deletePlayList();
		
		return success;
	}

}
