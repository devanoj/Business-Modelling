package termproject;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;


import javax.swing.JFrame;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;



import net.miginfocom.swing.MigLayout;

public class MainWindow extends JFrame {
	
	
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("Add products");
	private JMenuItem newMenuItem = new JMenuItem("New");
	private List<Product> products = new ArrayList<>();
	private ProductTableModel tableModel = new ProductTableModel(products);
	private JTable productTable = new JTable(tableModel);
	private JScrollPane tableScrollPane = new JScrollPane(productTable);
	
	
	
	public MainWindow(String title) {
		super(title);
		this.setLayout(new MigLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		
		this.setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(newMenuItem);
		newMenuItem.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				ProductDialog dialog = new ProductDialog(MainWindow.this, "New Product", true);
				dialog.setVisible(true);
			}
			
			
		});
		
		tableScrollPane.setPreferredSize(new Dimension(400, 200));
		this.add(tableScrollPane, "wrap");
		
		
		
		
	}
	
	
	public void addProduct(Product product) {
		products.add(product);
		tableModel.fireTableDataChanged();
	}
	
	public void updateProduct(Product product, int index) {
		products.set(index, product);
		tableModel.fireTableRowsUpdated(index, index);
	}
	
	
	
	
	public static void main(String[] args) {
		String systemLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(systemLookAndFeelClassName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MainWindow window = new MainWindow("System_Name");
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
