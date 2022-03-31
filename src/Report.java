public class Report {
	
	public Seat seatRp;
	
	public String outputTop;
	
	public String outputData;
	
	public String outputFinal;
	
	private String output;
	
//	public Report() {
//		
//		//seatRp = null;
//	}
//	
//	public void setSeat(Seat seat) {
//		seatRp = seat;
//	}
	
	public String reportTop() {
		String outputTop = "";
		
//		output = String.format("test1");
//		output += String.format("test2");
		
		outputTop = String.format("%31s %11s %12s\n", "Tickets Sold", "Price", "Total" );
		outputTop += String.format("%29s %9s %8s\n", "------------", "-----", "-----" );
		
		return outputTop;
	}
	
	
	public String reportData(Seat seat) {
		String outputData = "";
		
		outputData += String.format("%-21s %-17d $%-10.2f $% -7.2f\n", seat.getId(), seat.getTicketSold(), seat.getPrice(), seat.getTotal());		

		return outputData;
	}
	
	public String reportFinal(Seat seat) {
		String outputFinal = "";
		
		outputFinal += ("Total Sales: " + "$" + seat.getFinalTotal());
		
		return outputFinal;
	}
	
	public String reportConcat() {
		
		output = outputTop + outputData + outputFinal;
				
		return output;
	}
	
	
}
