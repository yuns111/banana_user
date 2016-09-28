package banana_user.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import banana_user.controller.Controllers;
import banana_user.domain.Ticket;

public class TicketSelectListView {

	private Scanner keyboard;

	public TicketSelectListView() {

		keyboard = new Scanner(System.in);

	}

	public void printTicketAllList(ArrayList<Ticket> tickeyList) {

		boolean exit = true;
		int ticketBuyNum = 0;
		
		System.out.println("\n[이용권목록 보기]");
		System.out.println("번호\t이용권명\t\t가격\t이용기간");

		if(tickeyList.size() == 0) {

			new AlertView().alert("이용권이 없습니다.");	

		} else {

			for(int i = 0 ; i < tickeyList.size() ; i++) {
				System.out.print(tickeyList.get(i).getTicketNumber() + "\t");
				System.out.print(tickeyList.get(i).getTicketName() + "\t");
				System.out.print(tickeyList.get(i).getPrice() + "\t");
				System.out.println(tickeyList.get(i).getExpriationDate());
			}
		}

		while(exit){
			try{		
				//구매할 상품 선택받는 메뉴
				System.out.print("\n구매할 이용권번호 입력 : ");
				ticketBuyNum=keyboard.nextInt();
				exit = false;

			} catch(InputMismatchException e){
				System.out.println("숫자를 입력하세요.");
				keyboard = new Scanner(System.in);
			}
		}

		System.out.print("구매 하시겠습니까?(y or anypresskey) : ");
		char select=keyboard.next().charAt(0);

		if(select=='y'||select=='Y'){
			Controllers.getTicketController().requestTicketBuy(ticketBuyNum);
		}

		//메뉴로 돌아가기 
	}


}