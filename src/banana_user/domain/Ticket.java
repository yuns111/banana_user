package banana_user.domain;

public class Ticket {

	private int ticketNumber;
	private String ticketName;
	private int price;
	private int expriationDate;
	
	public Ticket(){
		
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getExpriationDate() {
		return expriationDate;
	}

	public void setExpriationDate(int expriationDate) {
		this.expriationDate = expriationDate;
	}
	
}
