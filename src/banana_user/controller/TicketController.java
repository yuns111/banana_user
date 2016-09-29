package banana_user.controller;

import java.util.ArrayList;

import banana_user.dao.TicketDao;
import banana_user.domain.Ticket;
import banana_user.view.AlertView;
import banana_user.view.TicketSelectListView;

public class TicketController {

	private TicketDao ticketDao;

	public TicketController(){
		ticketDao=new TicketDao();
	}

	//티켓 리스트 보기
	public void requestTicketAllList(){
		
		ArrayList<Ticket> ticket=ticketDao.selectList();

		TicketSelectListView ticketAllListView =new TicketSelectListView();
		ticketAllListView.printTicketAllList(ticket);
	}

	//티켓 구매 하기
	public void requestTicketBuy(int ticketBuyNum){

		boolean success = ticketDao.buyOneTicket(ticketBuyNum);
		AlertView alertView = new AlertView();

		if(success){
			alertView.alert("결제 완료");
		} else{
			alertView.alert("이미 구매한 이용권이 있습니다");
		}
		
		Controllers.getMenuController().requestShowMenu();

	}
	
	//구매 티켓 이력 보기
	public void requestPurchaseTicketAll(){
		
		ArrayList<Ticket> tickets = ticketDao.purchaseTicketAll();
		
		TicketSelectListView ticketAllListView = new TicketSelectListView();
		ticketAllListView.printPurchaseTicketAllList(tickets);
		
	}

}
