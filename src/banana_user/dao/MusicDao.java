package banana_user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle.Control;

import banana_user.controller.Controllers;
import banana_user.domain.Music;

public class MusicDao {
	
	public MusicDao() {
		
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
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			} if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		
		return musicSelectAll();
		
	}

}
