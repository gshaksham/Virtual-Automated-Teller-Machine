package ATM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class ATM_SYS {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	
	
	private JButton jbtnBalance;

	public boolean pin1activate;
	//public boolean pin2activate;
	//public boolean pin3activate;

	public double pin1Balance = 0;
	//public double pin2Balance = 20000;
	//public double pin3Balance = 531245;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATM_SYS window = new ATM_SYS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ATM_SYS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("                                                                                                                                                                                         WELCOME TO J&K BANK");
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(502, 32, 798, 429);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Interest rate   =  2%");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(49, 34, 264, 38);
		panel.add(lblNewLabel_1);
		
//		textField_1 = new JTextField();
//		textField_1.setBounds(274, 42, 110, 35);
//		panel.add(textField_1);
//		textField_1.setColumns(10);
//		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(274, 94, 110, 35);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Number of Years");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(49, 86, 215, 38);
		panel.add(lblNewLabel_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(274, 148, 110, 35);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Amount of loan");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1_2.setBounds(49, 145, 191, 38);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Monthly payment");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1_2_1.setBounds(49, 197, 220, 38);
		panel.add(lblNewLabel_1_2_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(274, 200, 110, 35);
		panel.add(textField_4);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Total payment");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1_2_2.setBounds(49, 257, 191, 38);
		panel.add(lblNewLabel_1_2_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(274, 265, 110, 35);
		panel.add(textField_5);
		
		JTextArea textArea= new JTextArea();
		textArea.setBounds(394,34,380,266);
		panel.add(textArea);
		
		JButton loanBTN = new JButton("Loan");
		loanBTN.setEnabled(false);
		loanBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double annualInterestRate = 2;
				double monthlyInterestRate = annualInterestRate / 1200;
				int numbersOfYears = Integer.parseInt(textField_2.getText());
				double loanAmount = Double.parseDouble(textField_3.getText());
				//------------------------------------------------------------------------------
				double monthlyPayment = loanAmount * monthlyInterestRate /(1-1 /Math.pow(1 + monthlyInterestRate, numbersOfYears*12));
				String imonthlyPayment;
				imonthlyPayment =Double.toString(monthlyPayment);
				imonthlyPayment = String.format("%.2f", monthlyPayment);
				textField_4.setText(imonthlyPayment);
				//------------------------------------------------------------------------------
				double totalPayment = monthlyPayment * numbersOfYears * 12;
				String itotalPayment;
				itotalPayment = String.format("%.2f",totalPayment);
				textField_5.setText(itotalPayment);
			}
		});
		loanBTN.setFont(new Font("Tahoma", Font.BOLD, 13));
		loanBTN.setBounds(62, 340, 125, 46);
		panel.add(loanBTN);
		
		JButton receiptBTN = new JButton("Receipt");
		receiptBTN.setEnabled(false);
		receiptBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String annualInterestRate = String.format(textField_1.getText());
				String numberOfYears = String.format(textField_2.getText());
				String loanAmount = String.format(textField_3.getText());
				
				String monthlyPayment = String.format(textField_4.getText());
				String totalPayment = String.format(textField_5.getText());
				//===================================================================
				int refs=1325 + (int) (Math.random()*4238);
				
				//===================================================================
				Calendar timer = Calendar.getInstance();
				timer.getTime();
				SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
				tTime.format(timer.getTime());
				SimpleDateFormat Tdate = new SimpleDateFormat("dd-MM-yyyy");
				Tdate.format(timer.getTime());
				//===================================================================jtxtReceipt
				textArea.append("\tLoan Management Systems\n"+
				"Reference:\t\t\t" + refs +
				"\n ============================================\t" +
				"\nInterest Rate:\t\t\t"+2+
				"\nRepayment Years:\t\t"+numberOfYears+
				"\nAmount Of Loan:\t\t"+" "+loanAmount+
				"\nMonthly Payment:\t\t"+ monthlyPayment +
				"\nTotal Payment:\t\t\t"+totalPayment+
				"\n ============================================\t" +
				"\nDate: "+ Tdate.format(timer.getTime()) +
				"\t\tTime: "+ tTime.format(timer.getTime())+
				"\n\n\t\tThank You\n" +
				"\n\n\t\tMade by Shaksham Gupta\n");
			}
		});
		receiptBTN.setFont(new Font("Tahoma", Font.BOLD, 13));
		receiptBTN.setBounds(227, 340, 120, 46);
		panel.add(receiptBTN);
		
		JButton resetBTN = new JButton("Reset");
		resetBTN.setEnabled(false);
		resetBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textArea.setText(null);
				
			}
		});
		resetBTN.setFont(new Font("Tahoma", Font.BOLD, 13));
		resetBTN.setBounds(393, 340, 120, 46);
		panel.add(resetBTN);
		
		JButton exitBTN = new JButton("Exit");
		exitBTN.setEnabled(false);
		exitBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "ATM systems", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		exitBTN.setFont(new Font("Tahoma", Font.BOLD, 13));
		exitBTN.setBounds(550, 340, 120, 46);
		panel.add(exitBTN);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 32, 122, 136);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		jbtnBalance = new JButton("");
		jbtnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ipin1Balance;
				ipin1Balance = String.format("%.2f",pin1Balance);
				textField.setText(ipin1Balance);
			}
		});
		jbtnBalance.setEnabled(false);
		jbtnBalance.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/lArrow.png")));
		jbtnBalance.setBounds(10, 11, 89, 46);
		panel_1.add(jbtnBalance);
		
		JButton jbtnWithdrawal = new JButton("");
		jbtnWithdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double withdrawalpin1 = Integer.parseInt(textField.getText());
				
					if(withdrawalpin1 <= pin1Balance) {
						pin1Balance = pin1Balance - withdrawalpin1;
						textField.setText("");
					}
					else {
						textField.setText("Insufficient Money!");}
					
				
			
		}});
		jbtnWithdrawal.setEnabled(false);
		jbtnWithdrawal.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/lArrow.png")));
		jbtnWithdrawal.setBounds(10, 79, 89, 46);
		panel_1.add(jbtnWithdrawal);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(173, 255, 47));
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1.setBounds(148, 32, 186, 136);
		frame.getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Dialog", Font.BOLD, 13));
		lblBalance.setBounds(10, 11, 82, 36);
		panel_1_1.add(lblBalance);
		lblBalance.setVisible(false);
		
		JLabel lblLoan = new JLabel("Loan \r\n");
		lblLoan.setFont(new Font("Dialog", Font.BOLD, 13));
		lblLoan.setBounds(104, 11, 82, 36);
		panel_1_1.add(lblLoan);
		lblLoan.setVisible(false);
		
		JLabel lblWithdrawal = new JLabel("Withdrawal");
		lblWithdrawal.setFont(new Font("Dialog", Font.BOLD, 13));
		lblWithdrawal.setBounds(10, 74, 82, 36);
		panel_1_1.add(lblWithdrawal);
		lblWithdrawal.setVisible(false);
		
		JLabel lblDeposit = new JLabel("Deposit");
		lblDeposit.setFont(new Font("Dialog", Font.BOLD, 13));
		lblDeposit.setBounds(104, 74, 82, 36);
		panel_1_1.add(lblDeposit);
		lblDeposit.setVisible(false);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(new Color(173, 255, 47));
		textField.setBounds(10, 43, 166, 20);
		panel_1_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1_1.setBounds(344, 32, 122, 136);
		frame.getContentPane().add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JButton jbtnLoan = new JButton("");
		jbtnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitBTN.setEnabled(true);
				resetBTN.setEnabled(true);
				loanBTN.setEnabled(true);
				receiptBTN.setEnabled(true);
			}
		});
		jbtnLoan.setEnabled(false);
		jbtnLoan.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/rArrow.png")));
		jbtnLoan.setBounds(23, 11, 89, 46);
		panel_1_1_1.add(jbtnLoan);
		
		JButton jbtnDeposit = new JButton("");
		jbtnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double depositepin1 = Integer.parseInt(textField.getText());
				pin1Balance = pin1Balance + depositepin1;
				textField.setText("");
				
			}
		});
		jbtnDeposit.setEnabled(false);
		jbtnDeposit.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/rArrow.png")));
		jbtnDeposit.setBounds(23, 79, 89, 46);
		panel_1_1_1.add(jbtnDeposit);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1_2.setBounds(10, 179, 456, 282);
		frame.getContentPane().add(panel_1_1_2);
		panel_1_1_2.setLayout(null);
		
		JButton jbtn3 = new JButton("");
		jbtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = textField.getText() + "3";
				textField.setText(Enternumber);
			}
		});
		jbtn3.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/three.png")));
		jbtn3.setBounds(237, 40, 89, 46);
		panel_1_1_2.add(jbtn3);
		
		JButton jbtn1 = new JButton("");
		jbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = textField.getText() + "1";
				textField.setText(Enternumber);
			}
		});
		jbtn1.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/one.png")));
		jbtn1.setBounds(39, 40, 89, 46);
		panel_1_1_2.add(jbtn1);
		
		JButton jbtn2 = new JButton("");
		jbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = textField.getText() + "2";
				textField.setText(Enternumber);
			}
		});
		jbtn2.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/two.png")));
		jbtn2.setBounds(138, 40, 89, 46);
		panel_1_1_2.add(jbtn2);
		
		JButton jbtnCancel = new JButton("");
		jbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnBalance.setEnabled(false);
				jbtnLoan.setEnabled(false);
				jbtnWithdrawal.setEnabled(false);
				jbtnDeposit.setEnabled(false);
				
				lblLoan.setVisible(false);
				lblBalance.setVisible(false);
				lblWithdrawal.setVisible(false);
				lblDeposit.setVisible(false);
			}
		});
		jbtnCancel.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/cancel.png")));
		jbtnCancel.setBounds(336, 40, 89, 46);
		panel_1_1_2.add(jbtnCancel);
		
		JButton jbtn4 = new JButton("");
		jbtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = textField.getText() + "4";
				textField.setText(Enternumber);
			}
		});
		jbtn4.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/four.png")));
		jbtn4.setBounds(39, 97, 89, 46);
		panel_1_1_2.add(jbtn4);
		
		JButton jbtn5 = new JButton("");
		jbtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = textField.getText() + "5";
				textField.setText(Enternumber);
			}
		});
		jbtn5.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/five.png")));
		jbtn5.setBounds(138, 97, 89, 46);
		panel_1_1_2.add(jbtn5);
		
		JButton jbtn6 = new JButton("");
		jbtn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = textField.getText() + "6";
				textField.setText(Enternumber);
			}
		});
		jbtn6.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/six.png")));
		jbtn6.setBounds(237, 97, 89, 46);
		panel_1_1_2.add(jbtn6);
		
		JButton jbtnClear = new JButton("");
		jbtnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		jbtnClear.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/clear.png")));
		jbtnClear.setBounds(336, 97, 89, 46);
		panel_1_1_2.add(jbtnClear);
		
		JButton jbtn9 = new JButton("");
		jbtn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = textField.getText() + "9";
				textField.setText(Enternumber);
			}
		});
		jbtn9.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/nine.png")));
		jbtn9.setBounds(237, 155, 89, 46);
		panel_1_1_2.add(jbtn9);
		
		JButton jbtn7 = new JButton("");
		jbtn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = textField.getText() + "7";
				textField.setText(Enternumber);
			}
		});
		jbtn7.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/seven.png")));
		jbtn7.setBounds(39, 155, 89, 46);
		panel_1_1_2.add(jbtn7);
		
		JButton jbtn8 = new JButton("");
		jbtn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = textField.getText() + "8";
				textField.setText(Enternumber);
			}
		});
		jbtn8.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/eight.png")));
		jbtn8.setBounds(138, 155, 89, 46);
		panel_1_1_2.add(jbtn8);
		
		JButton jbtnEnter = new JButton("");
		jbtnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pin1 = Integer.parseInt(textField.getText());
				
				
				if (pin1 == 1234) {
					jbtnBalance.setEnabled(true);
					jbtnLoan.setEnabled(true);
					jbtnWithdrawal.setEnabled(true);
					jbtnDeposit.setEnabled(true);
					
					lblLoan.setVisible(true);
					lblBalance.setVisible(true);
					lblWithdrawal.setVisible(true);
					lblDeposit.setVisible(true);
					
					
					textField.setText("");
					pin1activate = true;

				}
				else {
					textField.setText("Invalid");
				}
			}
		});
		jbtnEnter.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/enter.png")));
		jbtnEnter.setBounds(336, 154, 89, 46);
		panel_1_1_2.add(jbtnEnter);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/empty.png")));
		btnNewButton_1_1_1.setBounds(39, 212, 89, 46);
		panel_1_1_2.add(btnNewButton_1_1_1);
		
		JButton jbtn0 = new JButton("");
		jbtn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = textField.getText() + "0";
				textField.setText(Enternumber);
			}
		});
		jbtn0.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/zero.png")));
		jbtn0.setBounds(138, 212, 89, 46);
		panel_1_1_2.add(jbtn0);
		
		JButton btnNewButton_4_1 = new JButton("");
		btnNewButton_4_1.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/empty.png")));
		btnNewButton_4_1.setBounds(237, 212, 89, 46);
		panel_1_1_2.add(btnNewButton_4_1);
		
		JButton btnNewButton_3_1_1 = new JButton("");
		btnNewButton_3_1_1.setIcon(new ImageIcon(ATM_SYS.class.getResource("/ATM/empty.png")));
		btnNewButton_3_1_1.setBounds(336, 212, 89, 46);
		panel_1_1_2.add(btnNewButton_3_1_1);
	}
}
