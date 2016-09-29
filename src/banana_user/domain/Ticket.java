package banana_user.domain;

public class Ticket {

	private int ticketNumber;
	private String ticketName;
	private int price;
	private int expriationDate;
	private String startDate;
	private String endDate;

	public Ticket(){

	}
	
	public Ticket(String ticketName, int price, String startDate, String endDate) {
		super();
		this.ticketName = ticketName;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public String getTicketName() {
		return ticketName;
	}
	
	public int getPrice() {
		return price;
	}	

	public int getExpriationDate() {
		return expriationDate;
	}

	public void setExpriationDate(int expriationDate) {
		this.expriationDate = expriationDate;
	}
	
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
