package banana_user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.ResourceBundle.Control;
=======
>>>>>>> refs/remotes/origin/musicSelect

import banana_user.controller.Controllers;
import banana_user.domain.Music;

public class MusicDao {
	
	public MusicDao() {
<<<<<<< HEAD
		
	}
	
	//음원 목록
	public ArrayList<Music> musicSelectAll() {
		
		ArrayList<Music> musicList = new ArrayList<Music>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select musicNumber, title, singer, lyrics from music";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Music music = new Music();
				music.setMusicNumber(rs.getInt("musicNumber"));
				music.setTitle(rs.getString("title"));
				music.setSinger(rs.getString("singer"));
				music.setLyrics(rs.getString("lyrics"));
				musicSelectAll().add(music);
=======
	
	}
	
	public Music selectOneMusic(int musicNumber){
		
		Music selectedMusic = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		//선택번호가 0이면 노래를 안들을 것임
		if(musicNumber==0){
			
			selectedMusic = new Music();
			selectedMusic.setMusicNumber(0);
			return selectedMusic;
		}
		
		String sql = "select * from Music where musicNumber = " + musicNumber;
		
		try {
			
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				
				selectedMusic = new Music();
				selectedMusic.setMusicNumber(rs.getInt(1));
				selectedMusic.setTitle(rs.getString(2));
				selectedMusic.setSinger(rs.getString(3));
				selectedMusic.setLyrics(rs.getString(4));
				selectedMusic.setEmotionNumber(rs.getInt(5));
				selectedMusic.setPlayingCount(rs.getInt(6));
				
			} else {
				selectedMusic = new Music();
				selectedMusic.setMusicNumber(-1);
>>>>>>> refs/remotes/origin/musicSelect
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
<<<<<<< HEAD
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			} if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		
		return musicSelectAll();
		
=======
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		
		return selectedMusic;
>>>>>>> refs/remotes/origin/musicSelect
	}

}
