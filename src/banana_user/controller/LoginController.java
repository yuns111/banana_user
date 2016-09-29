package banana_user.controller;
import banana_user.dao.LoginDao;
import banana_user.domain.Login;
import banana_user.view.AlertView;
import banana_user.view.LoginView;

public class LoginController {

	LoginDao loginDao;

	public LoginController() {
		loginDao = new LoginDao();
	}

	//로그인 요청
	public void requestLogin(){

		//view
		LoginView loginView = new LoginView();
		loginView.LoginView();

	}

	//로그인 응답
	public void responseLogin(Login login){

		//dao 
		boolean success = loginDao.insert(login);
		AlertView alertView = new AlertView();

		if(success){
			alertView.alert("로그인을 성공했습니다.");
		} else{
			alertView.alert("id 또는 password가 틀렸습니다.");
			Controllers.getLoginController().requestLogin();
		}
		
		Controllers.getMenuController().requestShowMenu();

	}

	//로그아웃 요청
	public void requestLogout(){

		boolean success = loginDao.delete();
		AlertView alertView = new AlertView();

		if(success){
			alertView.alert("로그아웃을 성공했습니다.");
		} 
	}

	//로그인체크여부
	public boolean requestLoginYN(){
		
		boolean success = loginDao.select();
		return success;
		
		/*AlertView alertView = new AlertView();

		if(success){
			alertView.alert("로그인한 사용자가 있습니다.");
		} else{
			alertView.alert("로그인한 사용자가 없습니다.");
		}
		*/
	}

	//로그인 한 사용자조회
}
