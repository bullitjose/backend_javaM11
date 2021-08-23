package com.floristeria.main;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.floristeria.clases.Arbol;
import com.floristeria.clases.Decoracion;
import com.floristeria.clases.Flor;
import com.floristeria.clases.Floristeria;
import com.floristeria.clases.Ticket;
import com.floristeria.clases.Decoracion.Tipo;
import com.floristeria.interfaz.FloristeriasDAOImpl;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Menu {

	JFrame frmFloristeria;

	FloristeriasDAOImpl floristeriasDAOImpl = new FloristeriasDAOImpl();
	private JTextField nombreF;

	private JLabel lblHayFlores;
	private JButton btnCrearFlor;
	private JTextField nombreArbolText;
	private JTextField precioArbolText;
	private JTextField alturaArbolText;
	private JTextField nombreFlorText;
	private JTextField precioFlorText;
	private JTextField colorFlorText;

	private JComboBox listArboles;
	private JComboBox listFlores;
	private JPanel deleteArbol;
	private JComboBox listArbol;
	private JComboBox listFlor;
	private JPanel deleteFlores;
	private JComboBox listFloress;
	private JComboBox listTiendas_1;
	private JLabel lblListFloristerias;
	private JPanel addCompra;
	private JComboBox listArboles_1;
	private JComboBox listFlores_1;
	private JComboBox listDecoracion_1;
	private JComboBox listDecoracion;
	private JPanel ticketCompra;
	private JTextPane textTicket;
	private JTextPane textTicketsFloristerias;
	private JComboBox listTiendas_2;
	private String tienda_2;
	private Floristeria floristeria_2;
	private JTextArea textArea;
	private JTextArea textArea2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmFloristeria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void switchPanels(JPanel panel, JLayeredPane layered) {
		JLayeredPane layeredPane = layered;
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();

	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFloristeria = new JFrame();
		frmFloristeria.setFont(new Font("Dialog", Font.PLAIN, 25));
		frmFloristeria.setTitle("Floristeria");
		frmFloristeria.setBounds(100, 100, 500, 400);
		frmFloristeria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFloristeria.getContentPane().setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 103, 466, 250);
		frmFloristeria.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		JPanel menu = new JPanel();
		layeredPane.add(menu, "name_239833156203700");
		menu.setLayout(null);

		JPanel crearArbol = new JPanel();
		layeredPane.add(crearArbol, "name_109074705148300");
		crearArbol.setLayout(null);

		JPanel crearFlor = new JPanel();
		crearFlor.setLayout(null);
		layeredPane.add(crearFlor, "name_112415716425200");

		JLabel lblHayArboles = new JLabel("No hay Arboles");
		lblHayArboles.setBounds(50, 20, 100, 20);
		menu.add(lblHayArboles);

		JButton btnCrearArbol = new JButton("Crear Arbol");
		btnCrearArbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * panelArbol.createContents(); panelArbol.open();
				 * panelArbol.datosFloristeriasDAOImpl(floristeriasDAOImpl);
				 */

				switchPanels(crearArbol, layeredPane);

			}
		});
		btnCrearArbol.setBounds(150, 20, 120, 21);
		btnCrearArbol.setVisible(false);
		menu.add(btnCrearArbol);

		hayArbol(lblHayArboles, btnCrearArbol);

		JLabel lblHayFlores = new JLabel("No hay Flores");
		lblHayFlores.setBounds(50, 60, 100, 20);
		menu.add(lblHayFlores);

		JButton btnCrearFlor = new JButton("Crear Flor");
		btnCrearFlor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(crearFlor, layeredPane);
			}
		});
		btnCrearFlor.setBounds(150, 60, 120, 21);
		btnCrearFlor.setVisible(false);
		menu.add(btnCrearFlor);

		hayFlor(lblHayFlores, btnCrearFlor);

		JButton btnEliminarArbol = new JButton("Eliminar Arbol");
		btnEliminarArbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				listArbol.removeAllItems();
				listArbol.addItem("Seleciona un Arbol");

				listaArboles(listArbol, null);

				switchPanels(deleteArbol, layeredPane);
			}
		});
		btnEliminarArbol.setBounds(300, 20, 120, 21);
		menu.add(btnEliminarArbol);

		JButton btnEliminarFlor = new JButton("Eliminar Flor");
		btnEliminarFlor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				listFloress.removeAllItems();
				listFloress.addItem("Seleciona una Flor");

				listaFlores(listFloress, null);

				switchPanels(deleteFlores, layeredPane);

			}
		});
		btnEliminarFlor.setBounds(300, 60, 120, 21);
		menu.add(btnEliminarFlor);

		JButton btnCompra = new JButton("Compra");
		btnCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				listTiendas_1.removeAllItems();
				listTiendas_1.addItem("Seleciona una Floristeria");
				
				listArboles_1.removeAllItems();
				listArboles_1.addItem("Seleciona un Arbol");
				

				listFlores_1.removeAllItems();
				listFlores_1.addItem("Seleciona una Flor");
				

				listDecoracion_1.removeAllItems();
				listDecoracion_1.addItem("Seleciona una Decoraci�n");
				

				lisFloristerias(listTiendas_1);

				switchPanels(addCompra, layeredPane);

			}
		});
		btnCompra.setBounds(300, 150, 120, 21);
		menu.add(btnCompra);

		/******************************************************/

		JPanel addFloristeria = new JPanel();
		layeredPane.add(addFloristeria, "name_239918571007100");
		addFloristeria.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 10, 50, 20);
		addFloristeria.add(lblNombre);

		nombreF = new JTextField();
		nombreF.setBounds(70, 10, 150, 20);
		addFloristeria.add(nombreF);
		nombreF.setColumns(10);

		JLabel lblArbol = new JLabel("Arboles");
		lblArbol.setBounds(10, 40, 50, 20);
		addFloristeria.add(lblArbol);

		listArboles = new JComboBox();
		listArboles.addItem("Seleciona un Arbol");
		listArboles.setBounds(70, 40, 150, 20);
		addFloristeria.add(listArboles);

		JLabel lblFlor = new JLabel("Flores");
		lblFlor.setBounds(10, 80, 50, 20);
		addFloristeria.add(lblFlor);

		listFlores = new JComboBox();
		listFlores.addItem("Seleciona una Flor");
		listFlores.setBounds(70, 80, 150, 20);
		addFloristeria.add(listFlores);

		JLabel lblDecoracion = new JLabel("Decoracion");
		lblDecoracion.setBounds(10, 120, 50, 20);
		addFloristeria.add(lblDecoracion);

		listDecoracion = new JComboBox();
		listDecoracion.addItem("Seleciona una Decoraci�n");
		listDecoracion.setBounds(70, 120, 150, 20);
		addFloristeria.add(listDecoracion);

		JButton btnEnviar = new JButton("Nueva Floristeria");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nombre = nombreF.getText();
				String arbol = listArboles.getSelectedItem().toString();
				String flor = listFlores.getSelectedItem().toString();
				String decoracion = listDecoracion.getSelectedItem().toString();
				Floristeria floristeria = floristeriasDAOImpl.getFloristeria(nombre);
				
				if(floristeriasDAOImpl.getFloristeria(nombre)==null) {
					floristeriasDAOImpl.addFloristeria(nombre, arbol, flor, decoracion);
				}else if(arbol != "Seleciona un Arbol") {
					
					Arbol ar= floristeriasDAOImpl.getArbol(arbol);
					
					floristeria.addArbol(ar);
					
					}else if(flor != "Seleciona una Flor") {
					
						Flor fl = floristeriasDAOImpl.getFlor(flor);
						
						floristeria.addFlor(fl);
					
						}else if(decoracion != "Seleciona una Decoraci�n") {
							
							listDecoracion.removeAllItems();
							listDecoracion.addItem("Ya hay un tipo Decoraci�n");
							
						}

				

				nombreF.setText("");

			}
		});
		btnEnviar.setBounds(300, 150, 120, 21);
		addFloristeria.add(btnEnviar);

		/****************************************************************************/

		JPanel deleteFloristeria = new JPanel();
		layeredPane.add(deleteFloristeria, "name_239977716288000");
		deleteFloristeria.setLayout(null);

		lblListFloristerias = new JLabel("Floristerias");
		lblListFloristerias.setBounds(10, 40, 66, 20);
		deleteFloristeria.add(lblListFloristerias);

		JComboBox listFloristerias = new JComboBox();
		listFloristerias.setBounds(10, 70, 150, 20);
		deleteFloristeria.add(listFloristerias);

		JButton btnDeleteFloristeria = new JButton("Borrar Floristeria");
		btnDeleteFloristeria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nombre = listFloristerias.getSelectedItem().toString();

				if (nombre != "No hay Floristerias") {
					Floristeria floristeria = floristeriasDAOImpl.getFloristeria(nombre);
					floristeriasDAOImpl.deleteFloristeria(floristeria);
				}

				lisFloristerias(listFloristerias);

			}
		});
		btnDeleteFloristeria.setBounds(300, 150, 120, 21);
		deleteFloristeria.add(btnDeleteFloristeria);

		JPanel listaFloristerias = new JPanel();
		layeredPane.add(listaFloristerias, "name_251326527998000");
		listaFloristerias.setLayout(null);

		JTextPane textFloristerias = new JTextPane();
		textFloristerias.setBounds(10, 10, 446, 230);
		
		textArea2 = new JTextArea(17,40);
		textArea2.setWrapStyleWord(true);
		textArea2.setLineWrap(true);
		textArea2.setBounds(10, 154, 446, 85);
		textArea2.setEditable(false);
		
		
		JScrollPane scroll2 = new JScrollPane(textArea2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll2.setLocation(0, 0);
		scroll2.setSize(466, 250);
		
		listaFloristerias.add(scroll2);

		JLabel lblNombreArbol = new JLabel("Nombre");
		lblNombreArbol.setBounds(20, 20, 45, 20);
		crearArbol.add(lblNombreArbol);

		nombreArbolText = new JTextField();
		nombreArbolText.setBounds(80, 20, 120, 20);
		crearArbol.add(nombreArbolText);
		nombreArbolText.setColumns(10);

		JLabel lblPrecioArbol = new JLabel("Precio");
		lblPrecioArbol.setBounds(20, 60, 45, 20);
		crearArbol.add(lblPrecioArbol);

		precioArbolText = new JTextField();
		precioArbolText.setColumns(10);
		precioArbolText.setBounds(80, 60, 120, 20);
		crearArbol.add(precioArbolText);

		JLabel lblAlturaArbol = new JLabel("Altura");
		lblAlturaArbol.setBounds(20, 100, 45, 20);
		crearArbol.add(lblAlturaArbol);

		alturaArbolText = new JTextField();
		alturaArbolText.setColumns(10);
		alturaArbolText.setBounds(80, 100, 120, 20);
		crearArbol.add(alturaArbolText);

		JTextPane textAddArbol = new JTextPane();
		textAddArbol.setBounds(10, 148, 446, 92);
		crearArbol.add(textAddArbol);

		JButton btnLimpiar = new JButton("Limpiar campos");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombreArbolText.setText("");
				precioArbolText.setText("");
				alturaArbolText.setText("");
			}
		});
		btnLimpiar.setBounds(320, 20, 120, 21);
		crearArbol.add(btnLimpiar);

		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nombre = nombreArbolText.getText();
				String precioString = precioArbolText.getText();
				double precio = Double.parseDouble(precioString);
				String alturaString = alturaArbolText.getText();
				double altura = Double.parseDouble(alturaString);

				floristeriasDAOImpl.addArbol(nombre, precio, altura);

				nombreArbolText.setText("");
				precioArbolText.setText("");
				alturaArbolText.setText("");

				Arbol arbol = floristeriasDAOImpl.getArbol(nombre);

				textAddArbol.setText(arbol.toString());

			}
		});
		btnGrabar.setBounds(320, 60, 120, 21);
		crearArbol.add(btnGrabar);

		JLabel lblNombreFlor = new JLabel("Nombre");
		lblNombreFlor.setBounds(20, 20, 45, 20);
		crearFlor.add(lblNombreFlor);

		nombreFlorText = new JTextField();
		nombreFlorText.setColumns(10);
		nombreFlorText.setBounds(80, 20, 120, 20);
		crearFlor.add(nombreFlorText);

		JLabel lblPrecioFlor = new JLabel("Precio");
		lblPrecioFlor.setBounds(20, 60, 45, 20);
		crearFlor.add(lblPrecioFlor);

		precioFlorText = new JTextField();
		precioFlorText.setColumns(10);
		precioFlorText.setBounds(80, 60, 120, 20);
		crearFlor.add(precioFlorText);

		JLabel lblColorFlor = new JLabel("Color");
		lblColorFlor.setBounds(20, 100, 45, 20);
		crearFlor.add(lblColorFlor);

		colorFlorText = new JTextField();
		colorFlorText.setColumns(10);
		colorFlorText.setBounds(80, 100, 120, 20);
		crearFlor.add(colorFlorText);

		JTextPane textAddFlor = new JTextPane();
		textAddFlor.setBounds(10, 148, 446, 92);
		crearFlor.add(textAddFlor);

		JButton btnLimpiar_1 = new JButton("Limpiar campos");
		btnLimpiar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				nombreFlorText.setText("");
				precioFlorText.setText("");
				colorFlorText.setText("");

			}
		});
		btnLimpiar_1.setBounds(320, 20, 120, 21);
		crearFlor.add(btnLimpiar_1);

		JButton btnGrabar_1 = new JButton("Grabar");
		btnGrabar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nombre = nombreFlorText.getText();
				String precioString = precioFlorText.getText();
				double precio = Double.parseDouble(precioString);
				String color = colorFlorText.getText();

				floristeriasDAOImpl.addFlor(nombre, precio, color);

				nombreFlorText.setText("");
				precioFlorText.setText("");
				colorFlorText.setText("");

				Flor flor = floristeriasDAOImpl.getFlor(nombre);

				textAddFlor.setText(flor.toString());

			}
		});
		btnGrabar_1.setBounds(320, 60, 120, 21);
		crearFlor.add(btnGrabar_1);

		deleteArbol = new JPanel();
		deleteArbol.setLayout(null);
		layeredPane.add(deleteArbol, "name_183456659512900");

		JLabel lblListArboles = new JLabel("Arboles");
		lblListArboles.setBounds(10, 40, 66, 20);
		deleteArbol.add(lblListArboles);

		listArbol = new JComboBox();
		listArbol.setBounds(10, 70, 150, 20);
		listArbol.addItem("Seleciona un Arbol");
		deleteArbol.add(listArbol);

		JButton btnDeleteArbol = new JButton("Borrar Arbol");
		btnDeleteArbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nombre = listArbol.getSelectedItem().toString();

				Arbol arbol = floristeriasDAOImpl.getArbol(nombre);

				floristeriasDAOImpl.deleteArbol(arbol);

				listArbol.removeAllItems();
				listArbol.addItem("Seleciona un Arbol");

				listaArboles(listArbol, null);

			}
		});
		btnDeleteArbol.setBounds(300, 150, 120, 21);
		deleteArbol.add(btnDeleteArbol);

		deleteFlores = new JPanel();
		deleteFlores.setLayout(null);
		layeredPane.add(deleteFlores, "name_185692343800600");

		JLabel lblListFlores = new JLabel("Flores");
		lblListFlores.setBounds(10, 40, 66, 20);
		deleteFlores.add(lblListFlores);

		listFloress = new JComboBox();
		listFloress.setBounds(10, 70, 150, 20);
		deleteFlores.add(listFloress);

		JButton btnDeleteFlor = new JButton("Borrar Flor");
		btnDeleteFlor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nombre = listFloress.getSelectedItem().toString();

				Flor flor = floristeriasDAOImpl.getFlor(nombre);

				floristeriasDAOImpl.deleteFlor(flor);

				listFloress.removeAllItems();
				listFloress.addItem("Seleciona una Flor");

				listaFlores(listFloress, null);

			}
		});
		btnDeleteFlor.setBounds(300, 150, 120, 21);
		deleteFlores.add(btnDeleteFlor);

	
		addCompra = new JPanel();
		addCompra.setLayout(null);
		layeredPane.add(addCompra, "name_210446944021000");

		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(10, 10, 50, 20);
		addCompra.add(lblNombre_1);

		listTiendas_1 = new JComboBox();
		listTiendas_1.setBounds(70, 10, 150, 20);
		addCompra.add(listTiendas_1);

		JLabel lblArbol_1 = new JLabel("Arboles");
		lblArbol_1.setBounds(10, 40, 50, 20);
		addCompra.add(lblArbol_1);

		listArboles_1 = new JComboBox();
		listArboles_1.setBounds(70, 40, 150, 20);
		addCompra.add(listArboles_1);

		JLabel lblFlor_1 = new JLabel("Flores");
		lblFlor_1.setBounds(10, 80, 50, 20);
		addCompra.add(lblFlor_1);

		listFlores_1 = new JComboBox();
		listFlores_1.setBounds(70, 80, 150, 20);
		addCompra.add(listFlores_1);

		JLabel lblDecoracion_1 = new JLabel("Decoracion");
		lblDecoracion_1.setBounds(10, 120, 50, 20);
		addCompra.add(lblDecoracion_1);

		listDecoracion_1 = new JComboBox();
		listDecoracion_1.setBounds(70, 120, 150, 20);
		addCompra.add(listDecoracion_1);

		JButton btnEnviar_1 = new JButton("Finalizar Compra");
		btnEnviar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String tienda_1 = listTiendas_1.getSelectedItem().toString();
				String arbolNombre_1 = listArboles_1.getSelectedItem().toString();
				String florNombre_1 = listFlores_1.getSelectedItem().toString();
				String decoracionNombre_1 = listDecoracion_1.getSelectedItem().toString();

				List<Arbol> arboles_1 = new ArrayList<Arbol>();
				List<Flor> flores_1 = new ArrayList<Flor>();

				Arbol arbol_1 = floristeriasDAOImpl.getArbol(arbolNombre_1);
				Flor flor_1 = floristeriasDAOImpl.getFlor(florNombre_1);
				Decoracion decoracion_1 = null;

				int id = floristeriasDAOImpl.getAllTicket().size();
				id++;

				if (arbolNombre_1 == "Seleciona un Arbol" || arbolNombre_1 == "No selecionar nada") {
					arboles_1.add(null);
					System.out.println("Nada");
				} else {
					arboles_1.add(arbol_1);
				}

				if (florNombre_1 == "Seleciona una Flor" || florNombre_1 == "No selecionar nada") {
					flores_1.add(null);
					System.out.println("Nada");
				} else {
					flores_1.add(flor_1);
				}

				if (decoracionNombre_1 == "Seleciona una Decoraci�n" || decoracionNombre_1 == "No selecionar nada") {
					decoracion_1 = null;
					System.out.println("Nada");
				} else {
					decoracion_1 = floristeriasDAOImpl.getDecoracion(Tipo.valueOf(decoracionNombre_1));
				}

				floristeriasDAOImpl.addTicket(id, tienda_1, arboles_1, flores_1, decoracion_1);

				listaTicket(textTicket, id++);
				switchPanels(ticketCompra, layeredPane);

			}
		});
		btnEnviar_1.setBounds(300, 150, 132, 21);
		addCompra.add(btnEnviar_1);
		
		JButton btnCargar = new JButton("Cargar Productos");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String tienda_1 = listTiendas_1.getSelectedItem().toString();

				Floristeria floristeria_1 = floristeriasDAOImpl.getFloristeria(tienda_1);

				listArboles_1.removeAllItems();
				listArboles_1.addItem("Seleciona un Arbol");
				listArboles_1.addItem("No selecionar nada");

				listFlores_1.removeAllItems();
				listFlores_1.addItem("Seleciona una Flor");
				listFlores_1.addItem("No selecionar nada");

				listDecoracion_1.removeAllItems();
				listDecoracion_1.addItem("Seleciona una Decoraci�n");
				listDecoracion_1.addItem("No selecionar nada");

				listaArboles(listArboles_1, floristeria_1);
				listaFlores(listFlores_1, floristeria_1);
				listaDecoracion(listDecoracion_1, floristeria_1);
				
			}
		});
		btnCargar.setBounds(244, 10, 150, 21);
		addCompra.add(btnCargar);

		ticketCompra = new JPanel();
		ticketCompra.setLayout(null);
		layeredPane.add(ticketCompra, "name_359368681648400");

		textTicket = new JTextPane();
		textTicket.setBounds(10, 10, 446, 230);
		ticketCompra.add(textTicket);

		JPanel ticketsFloristeria = new JPanel();
		ticketsFloristeria.setLayout(null);
		layeredPane.add(ticketsFloristeria, "name_573187151637400");

		JLabel lblListFloristerias_2 = new JLabel("Floristerias");
		lblListFloristerias_2.setBounds(0, 10, 66, 20);
		ticketsFloristeria.add(lblListFloristerias_2);

		listTiendas_2 = new JComboBox();
		listTiendas_2.setBounds(110, 11, 100, 20);
		
		ticketsFloristeria.add(listTiendas_2);
	
		
		listTiendas_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				listTiendas_2.removeAllItems();
				listTiendas_2.addItem("Seleciona una Floristeria");

				lisFloristerias(listTiendas_2);

				tienda_2 = listTiendas_2.getSelectedItem().toString();

			}
		});

		listTiendas_2.setBounds(70, 10, 150, 20);

		/*************************************************************************/

		JButton btnCargarTicketsFloristeria = new JButton("Cargar Tickets");
		btnCargarTicketsFloristeria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tienda_2 = listTiendas_2.getSelectedItem().toString();
				List<Ticket> tickets = floristeriasDAOImpl.getTickets(tienda_2);
				double num=0;
				
				for(Ticket t: tickets) {
					num+=t.valorTotal();
				}
				
				String total = Double.toString(num);
				textField.setText(total);
				
				listaTicketsFloristeria(textArea, tienda_2);
			}
		});
		btnCargarTicketsFloristeria.setBounds(366, 11, 100, 21);
		ticketsFloristeria.add(btnCargarTicketsFloristeria);

		textTicketsFloristerias = new JTextPane();
		textTicketsFloristerias.setBounds(10, 42, 446, 92);
		
		
		textArea = new JTextArea(17,40);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(10, 154, 446, 85);
		textArea.setEditable(false);
		
		
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setLocation(0, 41);
		scroll.setSize(466, 209);
		
		ticketsFloristeria.add(scroll);
		
		JLabel lblGanancias = new JLabel("Ganancias");
		lblGanancias.setBounds(230, 10, 50, 20);
		ticketsFloristeria.add(lblGanancias);
		
		textField = new JTextField();
		textField.setBounds(300, 12, 65, 20);
		ticketsFloristeria.add(textField);
		textField.setColumns(10);

		JButton btnAdd = new JButton("Crear Floristeria");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.out.println(floristeriasDAOImpl.getAllArbol().size());

				listArboles.removeAllItems();
				listArboles.addItem("Seleciona un Arbol");

				listFlores.removeAllItems();
				listFlores.addItem("Seleciona una Flor");

				listDecoracion.removeAllItems();
				listDecoracion.addItem("Seleciona una Decoraci�n");

				listaArboles(listArboles, null);
				listaFlores(listFlores, null);
				listaDecoracion(listDecoracion, null);

				switchPanels(addFloristeria, layeredPane);
			}
		});
		btnAdd.setBounds(161, 10, 150, 21);
		frmFloristeria.getContentPane().add(btnAdd);

		/********************************************************************/

		JButton btnList = new JButton("Listar Floristerias");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listaFloristeria(textArea2);
				switchPanels(listaFloristerias, layeredPane);
			}
		});
		btnList.setBounds(86, 42, 140, 21);
		frmFloristeria.getContentPane().add(btnList);

		JButton btnDelete = new JButton("Borrar Floristerias");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lisFloristerias(listFloristerias);
				switchPanels(deleteFloristeria, layeredPane);
			}
		});
		btnDelete.setBounds(161, 72, 150, 21);
		frmFloristeria.getContentPane().add(btnDelete);

		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				listArboles.removeAllItems();
				listArboles.addItem("Seleciona un Arbol");

				listFlores.removeAllItems();
				listFlores.addItem("Seleciona una Flor");

				listDecoracion.removeAllItems();
				listDecoracion.addItem("Seleciona una Decoraci�n");

				hayArbol(lblHayArboles, btnCrearArbol);
				hayFlor(lblHayFlores, btnCrearFlor);
				switchPanels(menu, layeredPane);
			}
		});
		btnHome.setBounds(391, 10, 85, 21);
		frmFloristeria.getContentPane().add(btnHome);

		JButton btnNewButton = new JButton("Tickets Floristeria");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				listTiendas_2.removeAllItems();
				listTiendas_2.addItem("Seleciona una Floristeria");

				lisFloristerias(listTiendas_2);

				switchPanels(ticketsFloristeria, layeredPane);
				
				/*listaFloristeria(textFloristerias);
				switchPanels(ticketsFloristeria, layeredPane);*/

			}
		});
		btnNewButton.setBounds(246, 42, 140, 21);
		frmFloristeria.getContentPane().add(btnNewButton);

	}

	public void listaArboles(JComboBox listArboles, Floristeria floristeria) {

		List<Arbol> arboles = new ArrayList<Arbol>();

		if (floristeria != null) {

			arboles = floristeria.getArboles();

		} else {
			arboles = floristeriasDAOImpl.getAllArbol();
		}

		for (int i = 0; i < arboles.size(); i++) {
			listArboles.addItem(arboles.get(i).getNombre());
		}

	}

	public void listaFlores(JComboBox listFlores, Floristeria floristeria) {

		List<Flor> flores = new ArrayList<Flor>();

		if (floristeria != null) {

			flores = floristeria.getFlores();

		} else {
			flores = floristeriasDAOImpl.getAllFlor();
		}

		for (int i = 0; i < flores.size(); i++) {
			listFlores.addItem(flores.get(i).getNombre());
		}

	}

	public void listaDecoracion(JComboBox listDecoracion, Floristeria floristeria) {

		Tipo[] tipos = Tipo.values();

		Decoracion decoraciones;

		if (floristeria != null) {

			decoraciones = floristeria.getDecoracion();

			listDecoracion.addItem(decoraciones.getTipoDeco());

		} else {

			for (int i = 0; i < tipos.length; i++) {
				listDecoracion.addItem(tipos[i].getTipo());
			}

		}

	}

	public void lisFloristerias(JComboBox listFloristerias) {

		List<Floristeria> floristerias = floristeriasDAOImpl.getAllFloristerias();

		System.out.println("TAMA�O: -" + floristerias.size());

		if (floristerias.size() == 0) {
			listFloristerias.removeAllItems();
			listFloristerias.addItem("Seleciona una Floristeria");
			listFloristerias.addItem("No hay Floristerias");
		} else {

			// listFloristerias.removeItemAt(1);
			listFloristerias.removeAllItems();
			listFloristerias.addItem("Seleciona una Floristeria");

			for (int i = 0; i < floristerias.size(); i++) {
				listFloristerias.addItem(floristerias.get(i).getNombre());
			}
		}

	}

	public void listaFloristeria(JTextArea textArea2) {

		String texto = "";
		List<Floristeria> floristerias = floristeriasDAOImpl.getAllFloristerias();

		if (floristerias.size() == 0) {
			texto = "No hay Floristerias, puedes empezar a crearlas";
		} else {

			for (Floristeria f : floristerias) {

				if (texto == "No hay Floristerias, puedes empezar a crearlas") {
					texto = f.toString();
				} else {
					texto += "\n" + f.toString();
				}

			}

		}

		System.out.println(texto);

		textArea2.setText("\n"+texto);

	}

	public void listaTicket(JTextPane textTicket, int id) {

		String texto = "";
		Ticket ticket = floristeriasDAOImpl.getTicket(id);

		if (ticket == null) {
			texto = "No hay Tickets de Compra";
		} else {

			texto = ticket.toString();

		}

		System.out.println(texto);

		textTicket.setText(texto);

	}

	/*public void listaTicketsFloristeria(JTextPane textTicketsFloristerias, String nombre) {

		String texto = "";
		List<Ticket> tickets = floristeriasDAOImpl.getTickets(nombre);

		if (tickets == null) {
			texto = "No hay Tickets de Compra";
		} else {

			texto = tickets.toString();

		}

		System.out.println(texto);

		textTicketsFloristerias.setText("\n"+texto);
		textArea.setText("\n"+texto);

	}*/
	public void listaTicketsFloristeria(JTextArea textArea, String nombre) {

		String texto = "";
		List<Ticket> tickets = floristeriasDAOImpl.getTickets(nombre);

		if (tickets == null) {
			texto = "No hay Tickets de Compra";
		} else {

			texto = tickets.toString();

		}

		System.out.println(texto);

		//textTicketsFloristerias.setText(texto);
		textArea.setText("\n"+texto);

	}
	public void hayArbol(JLabel lblHayArboles, JButton btnCrearArbol) {

		if (floristeriasDAOImpl.getAllArbol().size() == 0) {
			lblHayArboles.setText("No hay Arboles");
			btnCrearArbol.setVisible(true);
		} else {
			lblHayArboles.setText("Hay: " + floristeriasDAOImpl.getAllArbol().size() + " ->");
			btnCrearArbol.setVisible(true);
		}

	}

	public void hayFlor(JLabel lblHayFlores, JButton btnCrearFlor) {

		if (floristeriasDAOImpl.getAllFlor().size() == 0) {
			lblHayFlores.setText("No hay Flores");
			btnCrearFlor.setVisible(true);
		} else {
			lblHayFlores.setText("Hay: " + floristeriasDAOImpl.getAllFlor().size() + " ->");
			btnCrearFlor.setVisible(true);
		}

	}
}