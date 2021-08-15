package demo;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Product;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class JInternalFrameTable extends JInternalFrame {

	private List<Product> listProduct = new ArrayList<Product>();
	private JTable tableProduct;
	private JTextField textFieldId;
	private JTextField textFieldName;
	private JTextField textFieldPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInternalFrameTable frame = new JInternalFrameTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void FillData() {

		listProduct.add(new Product("p1","name1",100));
		listProduct.add(new Product("p2", "name 2", 300));
		listProduct.add(new Product("p3", "name 3", 200));
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("id");
		defaultTableModel.addColumn("name");
		defaultTableModel.addColumn("price");
		for (Product product : listProduct) {
			defaultTableModel.addRow(new Object[] { product.getId(), product.getName(), product.getPrice() });
			tableProduct.setModel(defaultTableModel);
		}

	}
private void FillData2() {

		
		
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("id");
		defaultTableModel.addColumn("name");
		defaultTableModel.addColumn("price");
		for (Product product : listProduct) {
			defaultTableModel.addRow(new Object[] { product.getId(), product.getName(), product.getPrice() });
			tableProduct.setModel(defaultTableModel);
		}

	}

	/**
	 * Create the frame.
	 */
	public JInternalFrameTable() {
		setClosable(true);
		setTitle("Fill data to Table");
		setResizable(true);
		setMaximizable(true);
		setBounds(100, 100, 533, 449);
		getContentPane().setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(26, 11, 445, 193);
		getContentPane().add(scrollPane_1);

		tableProduct = new JTable();
		tableProduct.addMouseListener(new MouseAdapter() {
		
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int currentRow=tableProduct.getSelectedRow();
				textFieldId.setText(tableProduct.getValueAt(currentRow, 0).toString());
				textFieldName.setText(tableProduct.getValueAt(currentRow, 1).toString());
				textFieldPrice.setText(tableProduct.getValueAt(currentRow, 2).toString());
				
				
			}
			
			
			
			
		});
		scrollPane_1.setViewportView(tableProduct);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacion del articulo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(26, 215, 319, 154);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 24, 46, 14);
		panel.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(82, 21, 205, 20);
		panel.add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 49, 46, 14);
		panel.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(82, 46, 205, 20);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 74, 46, 14);
		panel.add(lblPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(82, 71, 205, 20);
		panel.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldId.setText("");
				textFieldName.setText("");
				textFieldPrice.setText("");
				
				
			}
		});
		btnLimpiar.setBounds(82, 102, 89, 23);
		panel.add(btnLimpiar);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String id=textFieldId.getText();
				String precioString=textFieldPrice.getText();
				double precio=Double.parseDouble(precioString);
				String name=textFieldName.getText();
				listProduct.add(new Product(id,name,precio));
				FillData2();
			}
		});
		btnGrabar.setBounds(198, 102, 89, 23);
		panel.add(btnGrabar);
		
		FillData();

	}
}
