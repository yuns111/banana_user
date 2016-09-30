package banana_user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import banana_user.controller.Controllers;
import banana_user.domain.Music;

public class PlayListDao {

	public PlayListDao() {

	}

	//플레이리스트를 DB에서 받아오는 메서드
	public ArrayList<Music> playList(String loginID) {

		ArrayList<Music> musicInfo = new ArrayList<Music>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select m.musicnumber, m.title, m.singer from music m "
					+ "where m.musicnumber in (select p.musicnumber from playlist p where p.usernumber in "
					+ "(select u.usernumber from banana_user u where u.userID = ?))";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, loginID);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				Music music = new Music();
				music.setMusicNumber(rs.getInt("musicnumber"));
				music.setTitle(rs.getString("title"));
				music.setSinger(rs.getString("singer"));
				musicInfo.add(music);
				
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			if(rs != null) {
				
				try {rs.close();} catch (SQLException e) {e.printStackTrace();}
				
			}
			
			if(pstmt != null) {
				
				try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
				
			}

		}

		return musicInfo;

	}

	//플레이리스트의 한곡을 삭제하는 메서드
	public boolean deleteMusicOfList(int deleteMusicOfListNumber, String loginID) {
		
		boolean success = false;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			
			String sql = "delete from playlist p where p.musicnumber = ? and p.usernumber = (select u.usernumber from banana_user u where u.userid = ?)";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, deleteMusicOfListNumber);
			pstmt.setString(2, loginID);
			result = pstmt.executeUpdate();

			if(result != 0) {
				
				success = true;
				
			}

		} catch(SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			if(pstmt != null) {
				
				try {pstmt.close();} catch(SQLException e){e.printStackTrace();}
				
				catch (Exception e) {
					
					e.printStackTrace();
					
				}
				
			}
			
		}

		return success;
		
	}

	//플레이리스트 전체 곡을 삭제하는 메서드
	public boolean deletePlayList(String loginID) {
		
		boolean success = false;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			
			String sql = "delete playlist p where p.usernumber in (select u.usernumber from banana_user u where userid = ?)";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, loginID);
			result = pstmt.executeUpdate();

			if(result != 0) {
				
				success = true;
				
			}

		} catch(SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			if(pstmt != null) {
			
				try {pstmt.close();} catch(SQLException e) {e.printStackTrace();}
				
				catch (Exception e) {
					
					e.printStackTrace();
					
				}
				
			}
			
		}

		return success;
		
	}

}