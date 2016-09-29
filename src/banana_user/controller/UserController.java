package banana_user.controller;

import banana_user.dao.UserDao;
import banana_user.domain.User;
import banana_user.view.AlertView;
import banana_user.view.UserMypageView;
import banana_user.view.UserRegisterView;
import banana_user.view.UserUpdateView;

public class UserController {

	private UserDao userDao;

	public UserController() {

		userDao = new UserDao();

	}

	//회원 등록(가입) 요청을 처리하는 메서드
	public void requestRegisterUser() {

		UserRegisterView userRegisterView = new UserRegisterView();
		userRegisterView.userRegister();		

	}

	//회원가입 응답
	public void responseRegisterUser(User user) {

		//Dao에서 등록
		AlertView alertView = new AlertView();
		boolean success = userDao.insertRegisterUser(user);

		if(success) {
			alertView.alert("회원가입을 축하합니다!");
		} else {
			alertView.alert("중복된 id가 존재합니다.");
		}
		
		Controllers.getMenuController().requestShowMenu();

	}

	//회원 수정 요청을 처리하는 메서드
	public void requestUpdateUser() {

		UserUpdateView userUpdateView = new UserUpdateView();
		userUpdateView.userUpdate();

	}

	//회원 수정 응답
	public void responseUpdateUser(User user) {

		//Dao 통해 수정
		AlertView alertView = new AlertView();
		boolean success = userDao.updateUserInfo(user);

		if(success) {
			alertView.alert("회원정보 수정 성공");
		} else {
			alertView.alert("회원정보 수정 실패");
		}

	}

	//회원 탈퇴 요청을 처리하는 메서드
	public void requestDeleteUser() {

		//Dao 통해 삭제
		AlertView alertView = new AlertView();
		boolean success = userDao.deleteUser();

		//회원 탈퇴 후 자동 로그아웃
		//Controllers.getLoginController().requestLogout();

		if(success) {
			alertView.alert("회원삭제 성공");
		} else {
			alertView.alert("회원삭제 실패");
		}

	}

	//회원정보 보기 요청을 처리하는 메서드
	public void requestUserMypage() {
	
		User user = userDao.mypageUserInfo();
		
		UserMypageView userMypageView = new UserMypageView();
		userMypageView.userMypage(user);
		
	}
	
	//마이페이지 서브메뉴 요청을 처리하는 메서드
	public void requestUserMypageSub() {
		
		UserMypageView userMypageView = new UserMypageView();
		userMypageView.userMypageSub();
		
	}

}
