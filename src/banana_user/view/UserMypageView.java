package banana_user.view;

import java.util.Scanner;

import banana_user.controller.Controllers;
import banana_user.domain.User;

public class UserMypageView {

	private Scanner keyboard;

	public UserMypageView() {

		keyboard = new Scanner(System.in);

	}

	public void userMypage(User user) {

		System.out.println("\n[마이 페이지 모드]");

		System.out.println("회원번호\t회원id\t회원이름\t휴대전화 번호\t보유 이용권");

		System.out.print(user.getUserNumber() + "\t");
		System.out.print(user.getUserId() + "\t");
		System.out.print(user.getUserName() + "\t");
		System.out.print(user.getUserPhoneNumber() + "\t\t");
		System.out.println(user.getTicketName());
		

		Controllers.getUserController().requestUserMypageSub();

	}

	public void userMypageSub() {

		while(true) {

			System.out.print("\n[1.회원정보수정  2.이용권 구매정보  3.회원탈퇴  9.메인메뉴  0.프로그램 종료] : ");

			int selectedMenu = keyboard.nextInt();

			switch (selectedMenu) {
			case 1:
				Controllers.getUserController().requestUpdateUser();
				break;
			case 2:
				Controllers.getTicketController().requestPurchaseTicketAll();
				break;
			case 3:
				Controllers.getUserController().requestDeleteUser();
				break;
			case 9:
				Controllers.getMenuController().requestShowMenu();
				break;
			case 0:
				Controllers.getProgramController().requestExitProgram();
				break;
			default:
				System.out.println("메뉴를 다시 선택해 주세요.");
			}
		}

	}
}