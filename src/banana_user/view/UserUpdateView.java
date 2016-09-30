package banana_user.view;

import java.util.Scanner;

import banana_user.controller.Controllers;
import banana_user.domain.User;

public class UserUpdateView {

	private Scanner keyboard;

	public UserUpdateView() {

		keyboard = new Scanner(System.in);

	}

	public void userUpdate() {

		User user = null;
		String userPassword = null;
		String userName = null;
		String userGender = null;
		String userPhoneNumber = null;
		
		System.out.println("\n[회원 수정 모드]");

		System.out.print("변경할 비밀번호 : ");
		userPassword = keyboard.next();
		System.out.print("변경할 이름 : ");
		userName = keyboard.next();
		System.out.print("변경할 성별(M/F) : ");
		userGender = keyboard.next();
		System.out.print("변경할 휴대전화 번호 : ");
		userPhoneNumber = keyboard.next();
		
		user = new User(userPassword, userName, userGender, userPhoneNumber);
	
		Controllers.getUserController().responseUpdateUser(user);
		
	}

}