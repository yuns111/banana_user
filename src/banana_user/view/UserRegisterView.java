package banana_user.view;

import java.util.Scanner;

import banana_user.controller.Controllers;
import banana_user.domain.User;

public class UserRegisterView {

	private Scanner keyboard;

	public UserRegisterView() {

		keyboard = new Scanner(System.in);

	}

	//회원 정보를 입력하는 화면
	public void userRegister() {
		
		User user = null;
		String userId = null;
		String userPassword = null;
		String userName = null;
		String userGender = null;
		String userPhoneNumber = null;
		
		System.out.println("\n[회원 등록 모드]");
		
		System.out.print("회원 아이디 : ");
		userId = keyboard.next();
		System.out.print("회원 암호 : ");
		userPassword = keyboard.next();
		System.out.print("회원 이름 : ");
		userName = keyboard.next();
		System.out.print("회원 성별(M/F) : ");
		userGender = keyboard.next();
		System.out.print("휴대전화 번호 : ");
		userPhoneNumber = keyboard.next();

		user = new User(userId, userPassword, userName, userGender, userPhoneNumber);

		Controllers.getUserController().responseRegisterUser(user);

	}

}