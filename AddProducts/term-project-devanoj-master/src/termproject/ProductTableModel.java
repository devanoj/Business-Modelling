package termproject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProductTableModel extends AbstractTableModel {

	private List<Product> products;
	private String[] columnNames= {"Product Name", "Quantity", "Price", "Expiry Date"};
	
	public ProductTableModel(List<Product> products) {
		this.products = products;
	}
	
	

	@Override
	public int getRowCount() {
		
		
		return products.size();
	}
	
	@Override
	public int getColumnCount() {
	
		return columnNames.length;
	}

	@Override
	public String getColumnName(int column) {
		
		return columnNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Product product = products.get(rowIndex);
		String result = null;
		switch(columnIndex) {
		case 0:
			result = product.getName();
			break;
		
		case 1:
			result = product.getquantity();
			break;
	
		case 2:
			result = Integer.toString(product.getprice());
			break;
		case 3:
			result = product.getexpiryDate();
			break;
}
		return result;
}

}
