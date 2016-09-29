package banana_user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import banana_user.controller.Controllers;
import banana_user.domain.User;
import banana_user.repository.LoginRepository;
import banana_user.view.AlertView;

public class UserDao {

	public UserDao() {

	}

	//회원 등록 Dao 메서드
	public boolean insertRegisterUser(User user) {

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		int result = 0;

		try {

			//회원의 아이디 중복 체크
			String newUserId = user.getUserId();
			String sql = "select * from banana_user where userId = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newUserId);
			rs = pstmt.executeQuery();

			if(rs.next()) { //회원 중 현재 가입하고자 하는 아이디가 있는 경우
				new AlertView().alert("중복된 id가 존재합니다.");
			} 

			pstmt.close();

			//회원가입
			sql = "insert into banana_user values(user_usernumber_seq.nextval, ?, ?, ?, ?, ?)";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);

			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserPhoneNumber());

			result = pstmt.executeUpdate(); // 1 : 회원 테이블에 insert 성공, 0 : 실패

			if(result != 0) {
				success = true;
			}

		} catch (SQLException e) {

			System.out.println("회원 등록중 예외가 발생했습니다.");
			e.printStackTrace();

		} finally {

			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}

		}

		return success;

	}

	//회원 수정 Dao 메서드
	public boolean updateUserInfo(User user) {

		boolean success = false;
		PreparedStatement pstmt = null;
		int result = 0;

		try {

			String sql = "update banana_user set userPassword = ?, userName = ?, userGender = ?, userPhoneNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUserPassword());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserGender());
			pstmt.setString(4, user.getUserPhoneNumber());

			result = pstmt.executeUpdate();

			if(result != 0) {
				success = true;
			}			

		} catch (SQLException e) {

			System.out.println("회원정보 수정중 예외가 발생했습니다.");
			e.printStackTrace();

		} finally {

			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}

		}

		return success;

	}

	//회원 삭제 Dao 메서드
	public boolean deleteUser() {

		boolean success = false;
		PreparedStatement pstmt = null;
		int result = 0;

		try {

			String sql = "delete from banana_user where userId = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, LoginRepository.getLogin().getLoginId());

			result = pstmt.executeUpdate();

			if(result != 0) {
				success = true;
			}		

		} catch (SQLException e) {

			System.out.println("회원삭제중 예외가 발생했습니다.");
			e.printStackTrace();

		} finally {

			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}

		}		

		return success;

	}

	//마이페이지
	public User mypageUserInfo() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		int userNumber = 0;

		try {

			String sql = "select usernumber from banana_user where userId = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, LoginRepository.getLogin().getLoginId());
			rs = pstmt.executeQuery();

			while(rs.next()) {
				userNumber = rs.getInt(1);
			}

			rs.close();
			pstmt.close();
			
			sql = "select usernumber, userid, username, userphonenumber from banana_user where usernumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, userNumber);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				user.setUserNumber(rs.getInt(1));
				user.setUserId(rs.getString(2));
				user.setUserName(rs.getString(3));
				user.setUserPhoneNumber(rs.getString(4));
			}
			
			sql = "select t.TICKETNAME from purchaseticket p, ticket t where PURCHASENUMBER= (select max(PURCHASENUMBER) from purchaseticket  where usernumber =?) and p.ticketnumber = t.ticketnumber";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, userNumber);
			rs = pstmt.executeQuery();

			if(rs.next()) {				
				user.setTicketName(rs.getString(1));
			} else{
				user.setTicketName("없음");
			}

		} catch (SQLException e) {

			System.out.println("회원조회중 예외가 발생했습니다.");
			e.printStackTrace();

		} finally {

			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}

		}

		return user;

	}

}