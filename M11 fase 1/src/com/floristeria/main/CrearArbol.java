package com.floristeria.main;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.jface.layout.TableColumnLayout;

public class CrearArbol {

	protected Shell shell;
	private Text textNombre;
	private Text textPrecio;
	private Text textAltura;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CrearArbol window = new CrearArbol();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(620, 537);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Label lblNombre = new Label(shell, SWT.NONE);
		lblNombre.setBounds(25, 60, 55, 15);
		lblNombre.setText("Nombre");
		
		textNombre = new Text(shell, SWT.BORDER);
		textNombre.setBounds(89, 60, 307, 21);
		
		Label lblCrearArbol = new Label(shell, SWT.NONE);
		lblCrearArbol.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblCrearArbol.setFont(SWTResourceManager.getFont("Segoe UI Black", 12, SWT.BOLD));
		lblCrearArbol.setBounds(25, 10, 112, 27);
		lblCrearArbol.setText("Crear Arbol");
		
		Label lblPrecio = new Label(shell, SWT.NONE);
		lblPrecio.setBounds(25, 107, 55, 15);
		lblPrecio.setText("Precio");
		
		textPrecio = new Text(shell, SWT.BORDER);
		textPrecio.setBounds(89, 107, 76, 21);
		
		Label lblAltura = new Label(shell, SWT.NONE);
		lblAltura.setBounds(25, 152, 55, 15);
		lblAltura.setText("Altura");
		
		textAltura = new Text(shell, SWT.BORDER);
		textAltura.setBounds(89, 146, 76, 21);
		
		Button btnGrabar = new Button(shell, SWT.NONE);
		btnGrabar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				System.out.println("has clicado grabar");
				String nombre=textNombre.getText();
				String precioString=textPrecio.getText();
				double precio=Double.parseDouble(precioString);
				String alturaString=textAltura.getText();
				double altura=Double.parseDouble(alturaString);
				//TODO 
				//LLAMAR METODO CREAR ARBOL
				//addArbol(nombre,precio,altura);
			
				
				
			}
		});
		btnGrabar.setBounds(216, 196, 75, 25);
		btnGrabar.setText("Grabar");
		
		Button btnLimpiar = new Button(shell, SWT.NONE);
		
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				System.out.println("has clicado limpiar campos");
				textAltura.setText("");
				textNombre.setText("");
				textPrecio.setText("");
				
			}
		});
		
		btnLimpiar.setBounds(90, 196, 97, 25);
		formToolkit.adapt(btnLimpiar, true, true);
		btnLimpiar.setText("Limpiar campos");
		
		Button btnSalir = new Button(shell, SWT.NONE);
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(321, 196, 75, 25);
		formToolkit.adapt(btnSalir, true, true);
		btnSalir.setText("Salir");
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(73, 286, 521, 186);
		formToolkit.adapt(scrolledComposite);
		formToolkit.paintBordersFor(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		formToolkit.adapt(table);
		formToolkit.paintBordersFor(table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
;

	}
}
