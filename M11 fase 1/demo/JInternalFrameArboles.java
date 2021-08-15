package demo;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import entities.Arbol;

import com.floristeria.clases.Arbol;

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

public class JInternalFrameArboles extends JInternalFrame {

	private List<Arbol> listArbol = new ArrayList<Arbol>();
	private JTable tableArbol;
	private JTextField textFieldId;
	private JTextField textFieldNombre;
	private JTextField textFieldPrecio;
	private JTextField textFieldAltura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInternalFrameArboles frame = new JInternalFrameArboles();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void FillData() {

		listArbol.add(new Arbol("p1","pino",1000,2.3));
		listArbol.add(new Arbol("p2", "olivo", 1300,3));
		listArbol.add(new Arbol("p3", "olivo enano", 2200,0.5));
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("id");
		defaultTableModel.addColumn("name");
		defaultTableModel.addColumn("price");
		for (Arbol product : listArbol) {
			defaultTableModel.addRow(new Object[] { product.getId(), product.getNombre(), product.getPrecio() });
			tableArbol.setModel(defaultTableModel);
		}

	}
	
private void FillData2() {

		
		
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("id");
		defaultTableModel.addColumn("Nombre");
		defaultTableModel.addColumn("Precio");
		defaultTableModel.addColumn("Altura");
		for (Arbol product : listArbol) {
			defaultTableModel.addRow(new Object[] { product.getId(), product.getNombre(), product.getPrecio() });
			tableArbol.setModel(defaultTableModel);
		}

	}

	/**
	 * Create the frame.
	 */
	public JInternalFrameArboles() {
		setClosable(true);
		setTitle("Listado de arboles");
		setResizable(true);
		setMaximizable(true);
		setBounds(100, 100, 533, 412);
		getContentPane().setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(26, 11, 445, 193);
		getContentPane().add(scrollPane_1);

		tableArbol = new JTable();
		tableArbol.addMouseListener(new MouseAdapter() {
		
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int currentRow=tableArbol.getSelectedRow();
				textFieldId.setText(tableArbol.getValueAt(currentRow, 0).toString());
				textFieldNombre.setText(tableArbol.getValueAt(currentRow, 1).toString());
				textFieldPrecio.setText(tableArbol.getValueAt(currentRow, 2).toString());
				
				
			}
			
			
			
			
		});
		scrollPane_1.setViewportView(tableArbol);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacion del articulo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(26, 215, 319, 161);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 24, 46, 14);
		panel.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(82, 21, 205, 20);
		panel.add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 49, 46, 14);
		panel.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(82, 46, 205, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 74, 46, 14);
		panel.add(lblPrecio);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(82, 71, 205, 20);
		panel.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldId.setText("");
				textFieldNombre.setText("");
				textFieldPrecio.setText("");
				textFieldAltura.setText("");
				
				
			}
		});
		btnLimpiar.setBounds(82, 129, 89, 23);
		panel.add(btnLimpiar);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			
				

				String id=textFieldId.getText();
				String precioString=textFieldPrecio.getText();
				double precio=Double.parseDouble(precioString);
				String alturaString=textFieldPrecio.getText();
				double altura=Double.parseDouble(alturaString);
				String name=textFieldNombre.getText();
				listArbol.add(new Arbol(id,name,precio,altura));
				FillData2();
			}
		});
		btnGrabar.setBounds(199, 129, 89, 23);
		panel.add(btnGrabar);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 100, 46, 14);
		panel.add(lblAltura);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setBounds(82, 97, 205, 20);
		panel.add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		FillData();

	}
}
