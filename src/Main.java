import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main extends JFrame {
	
	private JPanel mainPanel;
	private JTextField txt2;
	private JTextField txt4;
	private JTextField txt3;
	private JTextField txt1;
	private JTextField txt5;
	private JTextField txt6;
	private JTextArea reportArea;
	private JButton btnCreate;
	
	private Seat seatA;
	private Seat seatB;
	private Seat seatC;
	
	private final String VALID_PATTERN_COUNT = "^[12345][0-9][0-9]|[1-9][0-9]|[0-9]$"; // ^ - starts, $ - ends (0-599)
	private final String VALID_PATTERN_PRICE = "^([1-9][0-9][0-9]|[1-9][0-9]|[0-9])\\.[0-9][0-9]$"; // 0.00$ - 999.99$
	
	// -------------------------------- constructor method
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 373, 500);
		setSize(370,500);
		setLocation(150,250);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(new TitledBorder(null, "Enter Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		inputPanel.setBounds(10, 11, 346, 116);
		mainPanel.add(inputPanel);
		inputPanel.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 0, 0);
		inputPanel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 0, 0);
		inputPanel.add(label);
		
		JLabel Count = new JLabel("Count");
		Count.setBounds(149, 21, 29, 14);
		Count.setVerticalAlignment(SwingConstants.TOP);
		inputPanel.add(Count);
		
		JLabel Price = new JLabel("Price ($)");
		Price.setBounds(240, 21, 40, 14);
		Price.setVerticalAlignment(SwingConstants.TOP);
		inputPanel.add(Price);
		
		JLabel SeatA = new JLabel("Seat A:");
		SeatA.setBounds(11, 43, 82, 14);
		SeatA.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(SeatA);
		
		txt1 = new JTextField();
		txt1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnCreate.setEnabled(true);

//				if (txt1 == null) {
//					btnCreate.setEnabled(false);
//				} else {
//					btnCreate.setEnabled(true);
//				}
			}
		});
		txt1.setBounds(149, 40, 86, 20);
		txt1.setHorizontalAlignment(SwingConstants.LEFT);
		inputPanel.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(240, 40, 86, 20);
		txt2.setHorizontalAlignment(SwingConstants.LEFT);
		inputPanel.add(txt2);
		txt2.setColumns(10);
		
		JLabel SeatB = new JLabel("Seat B:");
		SeatB.setBounds(11, 68, 81, 14);
		SeatB.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(SeatB);
		
		txt3 = new JTextField();
		txt3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnCreate.setEnabled(true);
				
//				if (txt3 == null) {
//					btnCreate.setEnabled(false);
//				} else {
//					btnCreate.setEnabled(true);
//				}
			}
		});
		txt3.setBounds(149, 65, 86, 20);
		txt3.setHorizontalAlignment(SwingConstants.LEFT);
		inputPanel.add(txt3);
		txt3.setColumns(10);
		
		txt4 = new JTextField();
		txt4.setBounds(240, 65, 86, 20);
		txt4.setHorizontalAlignment(SwingConstants.LEFT);
		inputPanel.add(txt4);
		txt4.setColumns(10);
		
		JLabel SeatC = new JLabel("Seat C:");
		SeatC.setBounds(11, 93, 82, 14);
		SeatC.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(SeatC);
		
		txt5 = new JTextField();
		txt5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnCreate.setEnabled(true);
				
//				if (txt5 == null) {
//					btnCreate.setEnabled(false);
//				} else {
//					btnCreate.setEnabled(true);
//				}
			}
		});
		txt5.setBounds(149, 90, 86, 20);
		txt5.setHorizontalAlignment(SwingConstants.LEFT);
		inputPanel.add(txt5);
		txt5.setColumns(10);
		
		txt6 = new JTextField();
		txt6.setBounds(240, 90, 86, 20);
		txt6.setHorizontalAlignment(SwingConstants.LEFT);
		inputPanel.add(txt6);
		txt6.setColumns(10);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setBorder(new TitledBorder(null, "Report", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		outputPanel.setBounds(10, 138, 346, 277);
		mainPanel.add(outputPanel);
		outputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTextArea reportArea = new JTextArea();
		reportArea.setRows(15);
		reportArea.setColumns(26);
		reportArea.setEditable(false);
		reportArea.setText("");
		outputPanel.add(reportArea);
		
		btnCreate = new JButton("Create Report");
		btnCreate.setBounds(74, 426, 101, 23);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCreate(e, reportArea);
			}
		});
		
		mainPanel.add(btnCreate);
		
		JButton btnReset = new JButton("Reset");
		mainPanel.add(btnReset);

		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onReset(e, reportArea);
			}
		});
		
		btnReset.setBounds(185, 426, 89, 23);
		
		
		btnCreate.setEnabled(false);
	}
	
	
	private void onCreate(ActionEvent e, JTextArea reportArea) {
    	seatA = new Seat("Seat A");
    	seatA.setTicketSold(Integer.parseInt(txt1.getText()));
    	seatA.setPrice(Float.parseFloat(txt2.getText()));
    	seatA.setTotal(Float.parseFloat(txt1.getText()) * (Float.parseFloat(txt2.getText())) );
    	seatA.setFinalTotal(seatA.getTotal());
    	
    	seatB = new Seat("Seat B");
    	seatB.setTicketSold(Integer.parseInt(txt3.getText()));
    	seatB.setPrice(Float.parseFloat(txt4.getText()));
    	seatB.setTotal((Float.parseFloat(txt3.getText())) * (Float.parseFloat(txt4.getText())) );
    	seatB.setFinalTotal((seatA.getFinalTotal()) + (seatB.getTotal()));
    	
    	seatC = new Seat("Seat C");
    	seatC.setTicketSold(Integer.parseInt(txt5.getText()));
    	seatC.setPrice(Float.parseFloat(txt6.getText()));
    	seatC.setTotal((Float.parseFloat(txt5.getText())) * (Float.parseFloat(txt6.getText())));
    	seatC.setFinalTotal((seatB.getFinalTotal()) + (seatC.getTotal()));
    	
    	Report report = new Report();
    	
    	String output;
    	
    	output = report.reportTop();
    	output += report.reportData(seatA);
    	output += report.reportData(seatB);
    	output += report.reportData(seatC);
    	output += report.reportFinal(seatC);
    	
    	reportArea.setText(output);
    	
    	String input1; // count
    	String input3; // count
    	String input5; // count
    	String input2; // price
    	String input4; // price
    	String input6; // price
    	
    	input1 = txt1.getText();
    	input3 = txt3.getText();
    	input5 = txt5.getText();
    	input2 = txt2.getText();
    	input4 = txt4.getText();
    	input6 = txt6.getText();
    	
    	if (input1.matches(VALID_PATTERN_COUNT) && input3.matches(VALID_PATTERN_COUNT) && input5.matches(VALID_PATTERN_COUNT) && input2.matches(VALID_PATTERN_PRICE) && input4.matches(VALID_PATTERN_PRICE) && input6.matches(VALID_PATTERN_PRICE)) {
    		reportArea.setText(output);
    		btnCreate.setEnabled(true);
    	} else {
    		btnCreate.setEnabled(false);
    		reportArea.setText("Please Try Again!");
    	}

    }
	
	private void onReset(ActionEvent e, JTextArea reportArea) {
    	txt1.setText("");
    	txt2.setText("");
    	txt3.setText("");
    	txt4.setText("");
    	txt5.setText("");
    	txt6.setText("");
    	reportArea.setText("");
    	txt1.requestFocusInWindow();
	}
    
	// -------------------------------- main method
	public static void main(String[] args) {
		Main ticketCalc = new Main();
		ticketCalc.setVisible(true);
	}
}
