package VISTA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import DADES.SQLClients;
import MODEL.Client;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class frmClients extends JFrame implements ActionListener {

	private JPanel contentPane;
	private SQLClients sqlclient;
	private ArrayList<Client> clients;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JButton btnNouClient, btnEdita, btnEsborra, btnNewButton;
	public String cid, name, surname, phoneNumber;
	DefaultTableModel model = null;
	public boolean inserting;
	private JTable table;

	/**
	 * Launch the application


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmClients() throws SQLException {

		this.sqlclient = new SQLClients();
		model = new DefaultTableModel();
		table_construct();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 155);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCifclient = new JLabel("CifClient:");
		lblCifclient.setBounds(117, 33, 66, 15);
		panel.add(lblCifclient);
		
		textField = new JTextField();
		textField.setBounds(117, 60, 124, 19);
		panel.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel lblNomclient = new JLabel("nomClient:");
		lblNomclient.setBounds(253, 33, 94, 15);
		panel.add(lblNomclient);
		
		textField_1 = new JTextField();
		textField_1.setBounds(253, 60, 124, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		JLabel lblCognomclient = new JLabel("cognomClient:");
		lblCognomclient.setBounds(388, 33, 113, 15);
		panel.add(lblCognomclient);
		
		textField_2 = new JTextField();
		textField_2.setBounds(388, 60, 124, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setBounds(554, 33, 66, 15);
		panel.add(lblTelefon);
		
		textField_3 = new JTextField();
		textField_3.setBounds(521, 60, 124, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEditable(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 154, 800, 340);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 800, 340);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        table.setModel(model);
        update();

		
		btnNouClient = new JButton("Nou Client");
		btnNouClient.setBounds(85, 535, 114, 25);
		contentPane.add(btnNouClient);
		btnNouClient.addActionListener(this);
		
		btnEdita = new JButton("Edita");
		btnEdita.setBounds(320, 535, 85, 25);
		contentPane.add(btnEdita);
		btnEdita.setEnabled(false);
		btnEdita.addActionListener(this);
		
		btnEsborra = new JButton("Esborra");
		btnEsborra.setBounds(417, 535, 100, 25);
		contentPane.add(btnEsborra);
		btnEsborra.setEnabled(false);
		btnEsborra.addActionListener(this);
		
		btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(698, 535, 90, 25);
		contentPane.add(btnNewButton);
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(this);
		
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(final MouseEvent e) {
        		if (e.getClickCount() == 1) {
        			
        			  cid =  table.getValueAt(table.getSelectedRow(), 0).toString();
                      name = table.getValueAt(table.getSelectedRow(), 1).toString();
                      surname = table.getValueAt(table.getSelectedRow(), 2).toString();
                      phoneNumber = table.getValueAt(table.getSelectedRow(), 3).toString();
                      btnEdita.setEnabled(true);
                      btnEsborra.setEnabled(true);
        		}
        	}
       
        });
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNouClient) {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			btnNewButton.setEnabled(true);
			btnEdita.setEnabled(false);
			btnEsborra.setEnabled(false);
			textField.setEditable(true);
			textField_1.setEditable(true);
			textField_2.setEditable(true);
			textField_3.setEditable(true);
			inserting = true;
		}else if(e.getSource() == btnNewButton) {
			if(inserting) {
				JOptionPane.showMessageDialog(null, "Inserint Client");
				try {
					insert(new Client(textField.getText().toString(), textField_1.getText().toString(),textField_2.getText().toString(), Integer.parseInt(textField_3.getText().toString())));
					update();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Potser no has omplert tots els camps... o El telèfon que has posat no es un número");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Potser no has omplert tots els camps... o El telèfon que has posat no es un número");
				}
			}else if(!inserting) {
				JOptionPane.showMessageDialog(null, "Editant Client");
				try {
					edit(new Client(textField.getText().toString(), textField_1.getText().toString(),textField_2.getText().toString(), Integer.parseInt(textField_3.getText().toString())));
					update();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField.setEditable(false);
			textField_1.setEditable(false);
			textField_2.setEditable(false);
			textField_3.setEditable(false);
			btnNewButton.setEnabled(false);
			btnEdita.setEnabled(false);
			btnEsborra.setEnabled(false);
		}else if(e.getSource() == btnEdita) {
			btnNewButton.setEnabled(true);
			textField.setText(cid);
			textField_1.setText(name);
			textField_2.setText(surname);
			textField_3.setText(phoneNumber);
			textField_1.setEditable(true);
			textField_2.setEditable(true);
			textField_3.setEditable(true);
			inserting = false;
		}else if (e.getSource() == btnEsborra) {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog (null, "Estas segur de esborrar el registre?","Warning",dialogButton);
			if(dialogResult == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, "Esborrant Client");
				try {
					delete();
					update();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			btnEdita.setEnabled(false);
			btnEsborra.setEnabled(false);
		}
	}
	public void table_construct() {
		String[] columnes = {"cifClient", "nomClient", "cognomClient","telefon"};
		model.setColumnIdentifiers(columnes);
	}
	public void update() throws SQLException {
		model.setRowCount(0);
		for (Client client : sqlclient.consultaClients("Clients")) {
			model.addRow(new Object[]{client.getIdClient(), client.getNom(),client.getCognom(), client.getTelefon()});	
		}
	}
	public void edit(Client client) throws SQLException {
		sqlclient.actualitzaClient(client);
	}
	public void insert(Client client) throws SQLException {
		sqlclient.insertaClients(client);
	}
	public void delete() throws SQLException {
		sqlclient.esborraClient(new Client(cid));
	}
		
		
}
