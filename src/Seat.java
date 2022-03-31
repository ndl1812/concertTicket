public class Seat {
	
	// Data member
	private String id;
	private int ticketSold;
	private float price;
	private float total;
	private float finalTotal;
	
	// ----------------------------------- constructor
	public Seat(String seatId) {
		id = seatId;
		ticketSold = 0;
		price = 0;
		total = 0;
	}
	
	// ------------------------------------ get / set
	
	// Seat A, B, or C
	public String getId() {
		return id;
	}
	
	// tickets sold
	public int getTicketSold() {
		return ticketSold;
	}
	
	public void setTicketSold(int newTicketSold) {
        ticketSold = newTicketSold;
    }
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float newPrice) {
        price = newPrice;
	}
	
	public float getTotal() {
		return total;
	}
	
	public void setTotal(float newTotal) {
	    total  = newTotal;
	}
	
	public float getFinalTotal() {
		return finalTotal;
	}
	
	public void setFinalTotal(float newFinalTotal) {
        finalTotal = newFinalTotal;
	}
    
    
        
	
	
	
	
	

}
