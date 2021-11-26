package termproject;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class ProductDialog extends JDialog {

	private JLabel nameLabel = new JLabel("Product Name");
	private JTextField nameTextField = new JTextField(20);
	private JLabel quantityLabel = new JLabel("Quantity");
	private JTextField quantityTextField = new JTextField(20);
	private JLabel priceLabel = new JLabel("Price");
	private JTextField priceTextField = new JTextField(20);
	private JLabel jobLabel = new JLabel("Expiry Date");
	private JTextField  expiryDateTextField= new JTextField(20);
	private JButton okButton = new JButton("OK");
	private JButton cancelButton = new JButton("cancel");
	private MainWindow parent;
	private Product product;
	private int index;
	
	

	public ProductDialog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		this.setLayout(new MigLayout());
		
		parent = (MainWindow)this.getParent();
		this.setLocationRelativeTo(parent);
		
		this.getContentPane().add(nameLabel);
		this.add(nameTextField, "wrap");
		
		this.add(quantityLabel);
		this.add(quantityTextField, "wrap");
		
		this.add(priceLabel);
		this.add(priceTextField, "wrap");
		
		this.add(jobLabel);
		this.add(expiryDateTextField, "wrap");
		
		this.add(okButton, "tag ok, skip 1, split 2");
		this.add(cancelButton, "tag cancel");
		this.pack();
		

		
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ProductDialog.this.setVisible(false);
				
			}
			
		});
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean allOK = true;
				
				String name = nameTextField.getText();
				String quantity = quantityTextField.getText();
				String priceAsString = priceTextField.getText();
				String expiryDate = expiryDateTextField.getText();
				
				
				
				
				int price=0;
				try {
					price = Integer.parseInt(priceAsString);
				} catch (NumberFormatException e1) {
					allOK = false;
					

					
				}
				if (allOK) {
				Product newProduct = new Product(name, quantity, price, expiryDate);
				
				if (product == null) {
					parent.addProduct(newProduct);
				}
				else {
					parent.updateProduct(newProduct, index);
				}
				
				ProductDialog.this.setVisible(false);
				
				}
				
			}
			
		});
		
	}
	
	public ProductDialog(Frame owner, String title, boolean modal, Product prdouct, int index) {
		this(owner, title, modal);
		this.product = product;
		this.index = index;
		nameTextField.setText(product.getName());
		quantityTextField.setText(product.getquantity());
		priceTextField.setText(Integer.toString(product.getprice()));
		expiryDateTextField.setText(product.getexpiryDate());

		
	}

}
