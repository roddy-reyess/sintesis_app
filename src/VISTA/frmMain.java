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

/**
 * 
 * @author Sergi Reyes Pla
 * @version 1.8.4
 *
 */
public class frmMain extends JFrame implements ActionListener{
	/**
	 * Aquesta es la classe principal del projecte.
	 * 
	 */
	private JFrame frame;
	private JMenu menu;
	private JMenuItem item1, item2, item3, item4;
	
	/**
	 * Variables frame, menu i les variables item serveixen per crear la pantalla i els menus.
	 */
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
	    this.item3 = new JMenuItem("Gestió de Components");
	    this.menu.add(this.item3);
	    this.item3.addActionListener(this);
	    this.item4 = new JMenuItem("Gestió d'Articles");
	    this.menu.add(this.item4);
	    this.item4.addActionListener(this);
	    getContentPane().setLayout(null);
	    
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
			
			ImageIcon logoi = new ImageIcon("resources/SolarisSoftwareSolutions.png");
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
			
			ImageIcon logoi = new ImageIcon("resources/SolarisSoftwareSolutions.png");
			Image logo = logoi.getImage();
			c2.setIconImage(logo);
			c2.setVisible(true);
		}
		if (e.getSource() == this.item3) {
			frmComponents c3 = null;
			c3 = new frmComponents();
			c3.setSize(800,600);
			
			ImageIcon logoi = new ImageIcon("resources/SolarisSoftwareSolutions.png");
			Image logo = logoi.getImage();
			c3.setIconImage(logo);
			c3.setVisible(true);
		}
		if (e.getSource() == this.item4) {
			frmArticles c4 = null;
			c4 = new frmArticles();
			c4.setSize(800,600);

			ImageIcon logoi = new ImageIcon("resources/SolarisSoftwareSolutions.png");
			Image logo = logoi.getImage();
			c4.setIconImage(logo);
			c4.setVisible(true);
		}
	}
	public static void main(String[] args) {
		frmMain form = new frmMain();
		form.setSize(800,600);
		form.setTitle("Simple data Manager (DRAFT)");
	    ImageIcon logoi = new ImageIcon("resources/SolarisSoftwareSolutions.png");
	    Image logo = logoi.getImage();
	    form.setIconImage(logo);
		form.setVisible(true);
	}
}
