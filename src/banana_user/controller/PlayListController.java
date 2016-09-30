package banana_user.controller;

import java.util.ArrayList;

import banana_user.dao.PlayListDao;
import banana_user.domain.Music;
import banana_user.repository.LoginRepository;
import banana_user.view.PlayListView;

public class PlayListController {

	PlayListDao playListDao;
	
	//컨트롤러 생성자
	public PlayListController() {
		
		playListDao = new PlayListDao();
		
	}

	public void goToPlayListView() {
		
		PlayListView playListView = new PlayListView();
		playListView.playListView();
		
	}
	
	//플레이리스트메뉴뷰로 가는 메서드
	public void goToPlayListMenuView(ArrayList<Music> searchMusicList) {
		
		PlayListView playListView = new PlayListView();
		playListView.playListMenuView(searchMusicList);
		
	}
	
	//플레이리스트의 한곡 재생뷰로 가는 메서드
	public void goToSelectPlayMusicView(ArrayList<Music> searchMusicList) {

		PlayListView playListView = new PlayListView();
		playListView.playMusicView(searchMusicList);
		
	}

	//플레이리스트의 한곡 선택 삭제뷰로 가는 메서드
	public void goToDeleteMusicView() {

		PlayListView playListView = new PlayListView();
		playListView.delecteMusicOfListView();
		
	}

	//플레이리스트의 전체 삭제뷰로 가는 메서드
	public void goToDeletePlayListView() {

		PlayListView playListView = new PlayListView();
		playListView.deletePlayListView();
		
	}

	//플레이리스트를 보여주는 메서드
	public ArrayList<Music> requestPlayList() {
		
		String loginID = LoginRepository.getLogin().getLoginId();
		ArrayList<Music> musicInfo = playListDao.playList(loginID);
		
		return musicInfo;
		
	}

	//플레이리스트의 한 곡을 지우는 메서드
	public boolean requestDeleteMusicOfList(int deleteMusicOfListNumber) {
		
		boolean success = false;
		
		//dao로 번호 전달
		String loginID = LoginRepository.getLogin().getLoginId();
		success = playListDao.deleteMusicOfList(deleteMusicOfListNumber, loginID);
		
		return success;
		
	}

	//플레이리스트의 전체곡을 지우는 메서드
	public boolean requestDeletePlayList() {
		
		String loginID = LoginRepository.getLogin().getLoginId();
		boolean success = playListDao.deletePlayList(loginID);
		
		return success;
		
	}

}