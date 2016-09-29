package banana_user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import banana_user.controller.Controllers;
import banana_user.domain.Ticket;
import banana_user.repository.LoginRepository;

public class TicketDao {

	public TicketDao(){

	}

	//전체 티켓
	public ArrayList<Ticket> selectList() {

		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		String sql = null;
		PreparedStatement pstmt  = null;
		ResultSet rs = null;

		try {
			sql = "select ticketNumber,ticketName,Price,expirationDate from Ticket order by ticketNumber";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				Ticket ticket = new Ticket();
				ticket.setTicketNumber(rs.getInt(1));
				ticket.setTicketName(rs.getString(2));
				ticket.setPrice(rs.getInt(3));
				ticket.setExpriationDate(rs.getInt(4));
				tickets.add(ticket);
			}

		} catch (SQLException e) {
			
			System.out.println("모든 티켓 조회중 예외가 발생했습니다.");
			
		} finally {
			
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}

		}

		return tickets;		

	}


	//티켓 구매
	public boolean buyOneTicket(int ticketBuyNum){

		String sql = null;
		PreparedStatement pstmt  = null;
		ResultSet rs = null;
		boolean success = false;
		int maxPurchaseNumber = 0;
		int userNumber = 0;
		int expirationDate=0;
		int ticketPrice=0;
		int result = 0;


		try{

			//티켓 넘버 가져오기
			sql = "select max(PURCHASENUMBER)+1 from purchaseTicket";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery(); 

			while(rs.next()){

				maxPurchaseNumber = rs.getInt(1);

				if(rs.wasNull()){
					maxPurchaseNumber = 1;
				}
			}

			//로그인한 계정 정보 가져오기
			sql = "select userNumber from banana_user where userid =?";
			pstmt=Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1,LoginRepository.getLogin().getLoginId());
			rs = pstmt.executeQuery();

			while(rs.next()){
				userNumber = rs.getInt(1);
			}

			//티켓에서 가져옴
			sql="select expirationDate, price from Ticket where ticketNumber=?";
			pstmt=Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1,ticketBuyNum);
			rs = pstmt.executeQuery();

			while(rs.next()){

				expirationDate=rs.getInt(1);
				ticketPrice=rs.getInt(2);
			}

			//날짜설정
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String startDate=sdf.format(now);

			Calendar cal = Calendar.getInstance();
			cal.setTime(now);
			cal.add(Calendar.DATE, expirationDate);
			String endDate = sdf.format(cal.getTime());

			//구매한 이력 체크 후 insert
			sql = "select * from PURCHASETICKET where usernumber =? and enddate >= sysdate";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);	
			pstmt.setInt(1, userNumber); //로그인이랑 합치기
			rs = pstmt.executeQuery();

			if(!(rs.next())){

				sql = "insert into purchaseTicket values(?,?,?,?,?,?)";
				pstmt=Controllers.getProgramController().getConnection().prepareStatement(sql);			
				pstmt.setInt(1,maxPurchaseNumber);
				pstmt.setInt(2,userNumber); //로그인이랑 합치기
				pstmt.setInt(3, ticketBuyNum);
				pstmt.setString(4,startDate); 
				pstmt.setString(5,endDate);
				pstmt.setInt(6,ticketPrice);
				result = pstmt.executeUpdate();

				if(result == 1){
					success = true;
				}
			}

		} catch(SQLException e){
			System.out.println("티켓 구매 중 예외가 발생하였습니다.");
		} 

		return success;
	}

	public ArrayList<Ticket> purchaseTicketAll() {

		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		String sql = null;
		PreparedStatement pstmt  = null;
		ResultSet rs = null;
		int userNumber = 0;

		try{

			sql = "select usernumber from banana_user where userId = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, LoginRepository.getLogin().getLoginId());
			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				userNumber = rs.getInt(1);
				
			}

			sql = "select ticketname, t.price, startdate, enddate from ticket t, purchaseticket p where t.TICKETNUMBER = p.TICKETNUMBER and p.USERNUMBER = ? order by purchasenumber desc";
			pstmt=Controllers.getProgramController().getConnection().prepareStatement(sql);	
			pstmt.setInt(1,userNumber);
			rs = pstmt.executeQuery();

			while(rs.next()) {

				String ticketName = rs.getString(1);
				int price = rs.getInt(2);
				String startDate = rs.getString(3);
				String endDate = rs.getString(4);
				Ticket ticket = new Ticket(ticketName, price, startDate, endDate);
				tickets.add(ticket);	
								
			}

		} catch(SQLException e){
			System.out.println("구매 티켓 이력 조회 중 예외가 발생하였습니다.");
		}

		return tickets;
	}
}
