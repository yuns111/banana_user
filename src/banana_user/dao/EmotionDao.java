package banana_user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import banana_user.controller.Controllers;
import banana_user.domain.Emotion;

public class EmotionDao {
	
	public EmotionDao() {
		
	}
	
	public ArrayList<Emotion> selectAllEmotion() {
		
		ArrayList<Emotion> emotionList = new ArrayList<Emotion>();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from emotion";
		
		try {
			
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Emotion emotion = new Emotion();
				
				emotion.setEmotionNumber(rs.getInt(1));
				emotion.setEmotionName(rs.getString(2));
				
				emotionList.add(emotion);
				
			}
			
		} catch (SQLException e) {
			
			System.out.println("감정리스트 호출시 오류가 있습니다.");
			e.printStackTrace();
			
		} finally {
			
			if(stmt != null) {
				
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
				
			}
			
			if(rs != null) {
				
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
				
			}
			
		}
		
		return emotionList;
		
	}

}