package banana_user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import banana_user.controller.Controllers;
import banana_user.domain.Music;
import banana_user.repository.LoginRepository;

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
			String sql = "select musicNumber, title, singer, lyrics from music order by playingCount desc";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				
				Music music = new Music();
				music.setMusicNumber(rs.getInt("musicNumber"));
				music.setTitle(rs.getString("title"));
				music.setSinger(rs.getString("singer"));
				music.setLyrics(rs.getString("lyrics"));
				musicList.add(music);
				
			}
			
		} catch (SQLException e) {

		} finally {

			if(stmt != null) {
				
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
				
			}
			
			if(rs != null) {
				
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
				
			}	
			
		}

		return musicList;
		
	}

	public Music selectOneMusic(ArrayList<Music> searchMusicList, int musicNumber) {

		Music selectedMusic = null;
		Statement stmt = null;
		ResultSet rs = null;

		//선택번호가 0이면 노래를 안들을 것임
		if(musicNumber == 0) {
			
			selectedMusic = new Music();
			selectedMusic.setMusicNumber(0);
			return selectedMusic;
			
		}
		
		boolean inMusicList = false;
		
		for(int i = 0; i<searchMusicList.size(); i++) {
			
			if(searchMusicList.get(i).getMusicNumber() == musicNumber) {
				
				inMusicList = true;
				
			}
			
		}
		
		if(!inMusicList) {
			
			selectedMusic = new Music();
			selectedMusic.setMusicNumber(-1);
			return selectedMusic;
			
		}

		String sql = "select * from Music where musicNumber = " + musicNumber;

		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			if(rs.next()) {

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

		return selectedMusic;
		
	}

	public int playMusic(Music selectedMusic) {

		int success = 0;
		//0:비로그인상태  1:이용권구매안하거나 기간만료 2:이용권 유
		int userNumber=0;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String endDate = null;

		//재생하면 재생카운트 증가
		try {

			Controllers.getProgramController().getConnection().setAutoCommit(false);

			String sql = "update Music set PlayingCount = " + (selectedMusic.getPlayingCount() + 1)
					+" where musicNumber = " + selectedMusic.getMusicNumber();
			stmt = Controllers.getProgramController().getConnection().createStatement();

			stmt.executeUpdate(sql);


		} catch (SQLException e1) {
			
			e1.printStackTrace();
			
			try {
				
				Controllers.getProgramController().getConnection().rollback();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			} 
			
		}

		if(LoginRepository.getLogin().getLoginId() == null) {

			return success;

		} else {

			try {
				
				//현재 로그인된 유저 넘버 반환
				String sql = "select userNumber from banana_user where userId = '"
						+LoginRepository.getLogin().getLoginId()+"'";
				stmt = Controllers.getProgramController().getConnection().createStatement();

				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					
					userNumber = rs.getInt(1);
					
				}

				//로그인상태의 유저의 플레이리스트로 들어감
				try {
					
					String sql2 = "insert into playList values(?,?)";
					pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql2);
					pstmt.setInt(1, selectedMusic.getMusicNumber());
					pstmt.setInt(2, userNumber);
					pstmt.executeUpdate();
					
				} catch (SQLIntegrityConstraintViolationException e) {
					
					System.out.println("플레이리스트에서 존재하는 곡을 재생합니다.");
					
				}

			} catch (SQLException e) {

				e.printStackTrace();

				try {
					
					Controllers.getProgramController().getConnection().rollback();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
					
				} 
				
			}  finally {
				
				if(rs != null) {
					
					try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
					
				} if(stmt != null) {
					
					try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
					
				}

			}

			try {
				
				String sql = "select max(endDate) from purchaseTicket where userNumber = " + userNumber;
				stmt = Controllers.getProgramController().getConnection().createStatement();
				rs = stmt.executeQuery(sql);

				if(rs.next()) {
					endDate = rs.getString(1);
					
					if(rs.getString(1) == null) {
						
						success = 1;
						
					} else	{
						
						LocalDate end = LocalDate.parse(endDate);
						LocalDate currentDate = LocalDate.now();

						if(end.isAfter(currentDate)) {
							
							success = 2;
							
						}
						
					}
					
				}
				
				Controllers.getProgramController().getConnection().commit();
				
			} catch (SQLException e) {

				e.printStackTrace();

				try {
					
					Controllers.getProgramController().getConnection().rollback();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
					
				} 
				
			} finally {
				
				if(rs != null) {
					
					try { rs.close(); } catch (SQLException e1) { e1.printStackTrace(); }
					
				} if(stmt != null) {
					
					try { stmt.close(); } catch (SQLException e1) { e1.printStackTrace(); }
					
				}

			}
			
		}

		return success;
		
	}
	
	//감정별 음원 리스트
	public ArrayList<Music> emotionMusicSelect(int emotionNumber) {

		ArrayList<Music> emotionMusicList = new ArrayList<Music>();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select musicNumber, title, singer from music where emotionNumber = " + emotionNumber;
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				
				Music music = new Music();
				music.setMusicNumber(rs.getInt("musicNumber"));
				music.setTitle(rs.getString("title"));
				music.setSinger(rs.getString("singer"));
				emotionMusicList.add(music);
				
			}
			
		} catch (SQLException e) {

		} finally {

			if(stmt != null) {
				
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
				
			}
			
			if(rs != null) {
				
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
				
			}	
			
		}

		return emotionMusicList;
		
	}

	public ArrayList<Music> searchMusic(String title) {

		ArrayList<Music> musics = new ArrayList<Music>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			String sql = "select musicnumber, title, singer from music where title like '%'||?||'%' ";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				Music music = new Music();
				music.setMusicNumber(rs.getInt(1));
				music.setTitle(rs.getString(2));
				music.setSinger(rs.getString(3));
				musics.add(music);
				
			}

		} catch (SQLException e) {

			System.out.println("음원검색중 예외가 발생했습니다.");
			e.printStackTrace();

		} finally {

			if(rs != null) {
				
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
				
			}
			
			if(pstmt != null) {
				
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
				
			}

		}

		return musics;

	}

}