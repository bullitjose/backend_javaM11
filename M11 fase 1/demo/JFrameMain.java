package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameMain extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPaneMain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMain frame = new JFrameMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDemo = new JMenu("Articulos");
		menuBar.add(mnDemo);
		
		JMenuItem mntmTableDecoracion = new JMenuItem("Decoracion");
		mntmTableDecoracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrameDecoracion f=new JInternalFrameDecoracion();
				f.setVisible(true);
				desktopPaneMain.add(f);
			}
		});
		mnDemo.add(mntmTableDecoracion);
		
		JMenuItem mntmTableArbol = new JMenuItem("Arboles");
		mntmTableArbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrameArboles f=new JInternalFrameArboles();
				f.setVisible(true);
				desktopPaneMain.add(f);
			}
		});
		mnDemo.add(mntmTableArbol);
		
		JMenuItem mntmTableFlores = new JMenuItem("Flores");
		mntmTableFlores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrameFlores f=new JInternalFrameFlores();
				f.setVisible(true);
				desktopPaneMain.add(f);
			}
		});
		mnDemo.add(mntmTableFlores);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPaneMain = new JDesktopPane();
		contentPane.add(desktopPaneMain, BorderLayout.CENTER);
	}
}
