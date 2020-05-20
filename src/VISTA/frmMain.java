package VISTA;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


public class frmMain extends JFrame implements ActionListener{
	private JFrame frame;
	private JMenu menu;
	private JMenuItem item1, item2;
	public frmMain(){ 
		//Creació de la pantalla principal
		this.frame = new JFrame();
	    JMenuBar menuBar = new JMenuBar();
	    setJMenuBar(menuBar);
	    this.menu = new JMenu("Accedir a");
	    menuBar.add(menu);
	    this.item1 = new JMenuItem("Gestió de Clients");
	    this.menu.add(this.item1);
	    this.item1.addActionListener(this);
	    this.item2 = new JMenuItem("Gestió de Comandes");
	    this.menu.add(this.item2);
	    this.item2.addActionListener(this);
	    
	     //should be done after all components are added
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==this.item1) {
			frmClients c1 = null;
			try {
				c1 = new frmClients();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			c1.setSize(800,600);
			
			ImageIcon logoi = new ImageIcon("resources/018_320_door_exit_logout-512.png");
			Image logo = logoi.getImage();
			c1.setIconImage(logo);
			c1.setVisible(true);
		}
		if (e.getSource() == this.item2) {
			frmComandes c2 = null;
			try {
				try {
					c2 = new frmComandes();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SAXException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			c2.setSize(800,600);
			
			ImageIcon logoi = new ImageIcon("resources/018_320_door_exit_logout-512.png");
			Image logo = logoi.getImage();
			c2.setIconImage(logo);
			c2.setVisible(true);
		}
	}
	public static void main(String[] args) {
		frmMain form = new frmMain();
		form.setSize(800,600);
		form.setTitle("Prueba");
	    ImageIcon logoi = new ImageIcon("resources/018_320_door_exit_logout-512.png");
	    Image logo = logoi.getImage();
	    form.setIconImage(logo);
		form.setVisible(true);
	}
}
