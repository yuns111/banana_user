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

	public void requestTicketAllList(){
		//티켓 DAO
		ArrayList<Ticket> ticket=ticketDao.selectList();

		TicketSelectListView ticketAllListView =new TicketSelectListView();
		ticketAllListView.printTicketAllList(ticket);
	}

	public void requestTicketBuy(int ticketBuyNum){

		boolean success = ticketDao.buyOneTicket(ticketBuyNum);
		AlertView alertView = new AlertView();

		if(success){
			alertView.alert("결제 완료");
		} else{
			alertView.alert("이미 구매한 이용권이 있습니다");
		}

	}

}
