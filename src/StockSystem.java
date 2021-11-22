import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;


public class StockSystem extends JFrame implements ActionListener {
	
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu employeeMenu = new JMenu("Employees");
	private JMenu contactMenu = new JMenu("Contact Information");
	private JMenu openingHours = new JMenu("Opening Hours");
	private JMenuItem createEmployeeItem = new JMenuItem("Create Employee");
	private JMenuItem contactMenuItem = new JMenuItem("Contact Information");	
	private JMenuItem openingHoursItem = new JMenuItem("View Opening Hours");
	private JTable employeeTable = new JTable();
	private JScrollPane scrollPane = new JScrollPane(employeeTable);
	private ImageIcon image1;
	private JLabel label1;

	
	private static	JLabel userLabel;
	private static JTextField userText;
	private static JLabel success;
	private static	JLabel passwordLabel;
	private static	JPasswordField passwordText;
	private static	JButton button;
	
	JButton customer = new JButton("Customer");
	JButton stock = new JButton("Stock");
	JButton order = new JButton("order");
	
	
	public static void LoginSystem() {
		
        Scanner scan = new Scanner(System.in);
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
			frame.setSize(350,250);
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			frame.add(panel);
			frame.setLocationRelativeTo(null);
			panel.setLayout(null);
			
			
			userLabel = new JLabel("User");
			userLabel.setBounds(10,20,80,25);
			panel.add(userLabel);
			
			userText = new JTextField(20);
			userText.setBounds(100,20,165,25);
			panel.add(userText);
			
			passwordLabel = new JLabel("password");
			passwordLabel.setBounds(10,50,80,25);
			panel.add(passwordLabel);
			
			passwordText = new JPasswordField();
			passwordText.setBounds(100,50,165,25);
			panel.add(passwordText);
			
			JLabel success = new JLabel("");
			success.setBounds(10,110,300,25);
			panel.add(success);
			
			button = new JButton("Login");
			button.setBounds(10,80,80,25);
			button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String user = userText.getText();
						String password = passwordText.getText();
						
						
						if(user.equals("Supervalu") && password.equals("brian")) {
							success.setText("Login succesful");
							StockSystem window = new StockSystem("Supervalu");
							frame.setVisible(false);
						}
						else 
							{
							success.setText("Login unsuccesful");
							success.setForeground(Color.RED);
							}
					}
			});
			panel.add(button);
			frame.setVisible(true);		
	}
			
	public StockSystem(String title) {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		
		panel.add(customer);
		panel.add(stock);
		panel.add(order);
		
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
	}
	

	public static void main(String[] args) {
		String systemLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(systemLookAndFeelClassName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LoginSystem();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
