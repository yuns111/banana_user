package banana_user.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import banana_user.controller.Controllers;

public class PlayListDao {

	public PlayListDao() {
		// TODO Auto-generated constructor stub
	}

	public void playMusic(int palyMusicNumber){//있을 것 같긴 함.

		
		
	}

	public boolean deleteMusicOfList(int deleteMusicOfListNumber){
		boolean success = false;
		PreparedStatement pstmt = null;
		int result = 0;

		try{
			String sql = "delete playlist where musicnumber= ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, deleteMusicOfListNumber);
			result = pstmt.executeUpdate();

			if(result != 0){
				success = true;
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null){
				try {pstmt.close();} catch(SQLException e){e.printStackTrace();}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return success;
	}

	public boolean deletePlayList(){
		boolean success = false;
		Statement stmt = null;
		int result = 0;

		try{
			String sql = "delete playlist";
			stmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			result = stmt.executeUpdate(sql);

			if(result != 0){
				success = true;
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(stmt != null){
				try {stmt.close();} catch(SQLException e){e.printStackTrace();}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return success;
	}

}