package VISTA;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import DADES.SQLComponents;
import DADES.SQLMovimentsComponents;
import MODEL.Components;
import MODEL.MovimentsComponents;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class frmComponents extends JDialog {
	private JTable table;
	DefaultTableModel model = null;
	DefaultTableModel model1 = null;
	public SQLComponents sqlComponents;
	public SQLMovimentsComponents sqlMoviments;
	public ArrayList<Components> llistaComponents;
	public ArrayList<MovimentsComponents> llistaMoviments;
	public Components cSel;
	public MovimentsComponents mSel;
	private JTable table_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public frmComponents() {
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 36, 776, 225);
		getContentPane().add(scrollPane);
		sqlComponents = new SQLComponents();
		sqlMoviments = new SQLMovimentsComponents();

		model = new DefaultTableModel();
		model1 = new DefaultTableModel();
	
		table = new JTable();
		scrollPane.setViewportView(table);
		table_construct();
		try {
			showTable1();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(model);
		
		JLabel lblComponents = new JLabel("Components");
		lblComponents.setBounds(360, 9, 97, 15);
		getContentPane().add(lblComponents);
		
		JButton btnAfegeix = new JButton("Afegeix");
		
		btnAfegeix.setBounds(586, 538, 155, 25);
		getContentPane().add(btnAfegeix);
		btnAfegeix.setEnabled(false);
		btnAfegeix.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(Integer.parseInt(textField.getText()) > 0) {
					cSel.sumaQuantitat(Integer.parseInt(textField.getText()));
					System.out.println(cSel);
					
					try {
						sqlComponents.updateComponent(cSel);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					sqlMoviments.insertaMoviment(new MovimentsComponents(cSel.getIdComponent(), "ENTRADA", Integer.parseInt(textField.getText())));
					System.out.println(cSel.toString());
					try {
						showTable1();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					showTable2(cSel);
					textField.setText("");
					textField.setEditable(false);
					btnAfegeix.setEnabled(false);
				}
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 289, 776, 225);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(model1);
		
		textField = new JTextField();
		textField.setToolTipText("Num. Components");
		textField.setBounds(360, 535, 188, 25);
		getContentPane().add(textField);
		textField.setEditable(false);
		textField.setColumns(10);
		
		JLabel lblMovimentsComponents = new JLabel("Moviments Components");
		lblMovimentsComponents.setBounds(329, 273, 188, 15);
		getContentPane().add(lblMovimentsComponents);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount() == 1) {
					cSel = new Components(table.getValueAt(table.getSelectedRow(), 0).toString(), table.getValueAt(table.getSelectedRow(), 1).toString(), table.getValueAt(table.getSelectedRow(), 2).toString(), Integer.parseInt(table.getValueAt(table.getSelectedRow(), 3).toString()));
					showTable2(cSel);
					textField.setEditable(true);
					textField.setText("0");
					btnAfegeix.setEnabled(true);
				}
			}
		});
	}
	public void table_construct() {
		String[] columnes = {"idComponent", "tipus", "descripcio", "quantitat"};
		model.setColumnIdentifiers(columnes);
		String[] columnes1 = {"idMov", "idComponent", "tipusMoviment", "quantitat"};
		model1.setColumnIdentifiers(columnes1);
	}
	
	public void showTable1() throws SQLException {
		model.setRowCount(0);
		
		for (Components component : sqlComponents.selectComponents()) {
			model.addRow(new Object[] { component.getIdComponent(), component.getTipus(), component.getDescripcio(), component.getQuantitat()});
		}
		
	}
	public void showTable2(Components component) {
		if (sqlMoviments.selectMovxCom(component).size() == 0) {
			
			JOptionPane.showMessageDialog(null, "Per aquest component encara no hi han moviments.");
			
		}else {
			model1.setRowCount(0);
			
			for (MovimentsComponents moviment : sqlMoviments.selectMovxCom(component)){
				model1.addRow(new Object[] { moviment.getIdMov(), moviment.getIdComponent(), moviment.getTipusMoviment(), moviment.getQuantitat()});
			}
		}
		
	}
}