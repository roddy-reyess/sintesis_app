package VISTA;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import MODEL.*;
import DADES.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Choice;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class frmComandes extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	DefaultTableModel model = null;
	DefaultTableModel model1 = null;
	Comanda cSel;
	LiniaComanda lcSel;
	private JTable table;
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private JTable table_1;
	private ArrayList<Comanda> comandes;
	private ArrayList<LiniaComanda> linies;
	ArrayList<Components> components;
	private SQLIniesComanda sqliniacomanda;
	private SQLComandes sqlcomanda;
	SQLArticlesComponents sqlArticles;
	SQLComponents sqlComponents;
	private XmlReader xmlread;
	JButton btnComprovarXml;
	private JTextField textField;
	/**
	 * Create the dialog.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws SQLException 
	 */
	public frmComandes()  throws ParserConfigurationException, SAXException, IOException, SQLException  {
		
		this.sqlcomanda = new SQLComandes();
		this.sqliniacomanda = new SQLIniesComanda();
		sqlArticles = new SQLArticlesComponents();
		sqlComponents = new SQLComponents();
		this.xmlread = new XmlReader();
		try {
			getComandes(xmlread);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("pepe");;
		}
		
		model = new DefaultTableModel();
		model1 = new DefaultTableModel();
		table_construct();
		table_construct1();
		
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 116, 800, 167);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		scrollPane_1.setBounds(0, 351, 800, 118);
		contentPanel.add(scrollPane_1);
		update_table();
		table.setModel(model);
	
		
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(model1);
		
		Choice choice = new Choice();
		choice.setBounds(119, 72, 213, 25);
		choice.add("Mostrar totes les comandes");
		choice.add("Filtrar per comandes tancades");
		choice.add("Filtrar per comandes obertes");
		choice.add("Filtrar per comandes en curs");
		contentPanel.add(choice);
		choice.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getItem().toString().equals("Mostrar totes les comandes")) {
					try {
						update_table();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else if (e.getItem().toString().equals("Filtrar per comandes tancades")) {
					try {
						specific_update(2);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if (e.getItem().toString().equals("Filtrar per comandes obertes")) {
					try {
						specific_update(0);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if (e.getItem().toString().equals("Filtrar per comandes en curs")) {
					try {
						specific_update(1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				model1.setRowCount(0);
			}
			
		});
		
		btnComprovarXml = new JButton("comprovar XML");
		btnComprovarXml.setBounds(450, 72, 173, 25);
		contentPanel.add(btnComprovarXml);
		btnComprovarXml.addActionListener(this);
		
		JLabel lblLniesDeComanda = new JLabel("Línies de Comanda");
		lblLniesDeComanda.setFont(new Font("Dialog", Font.BOLD, 25));
		lblLniesDeComanda.setBounds(286, 295, 282, 44);
		contentPanel.add(lblLniesDeComanda);
		
		JLabel lblComandes = new JLabel("Comandes");
		lblComandes.setFont(new Font("Dialog", Font.BOLD, 25));
		lblComandes.setBounds(319, 12, 159, 39);
		contentPanel.add(lblComandes);
		
		JSlider slider = new JSlider();
		slider.setBounds(297, 544, 200, 16);
		contentPanel.add(slider);
		slider.setEnabled(false);
		slider.setValue(0);
		
		JLabel lblLiniesServides = new JLabel("Linies Servides");
		lblLiniesServides.setBounds(337, 492, 182, 15);
		contentPanel.add(lblLiniesServides);
		
		textField = new JTextField();
		textField.setBounds(330, 513, 124, 19);
		contentPanel.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel label = new JLabel("+");
		label.setBounds(502, 544, 66, 15);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("-");
		label_1.setBounds(271, 545, 32, 15);
		contentPanel.add(label_1);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(473, 510, 114, 25);
		contentPanel.add(btnGuardar);
		btnGuardar.setEnabled(false);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount() == 1) {
					cSel = new Comanda(table.getValueAt(table.getSelectedRow(), 0).toString(), table.getValueAt(table.getSelectedRow(), 1).toString(), Float.parseFloat(table.getValueAt(table.getSelectedRow(), 2).toString()), table.getValueAt(table.getSelectedRow(), 3).toString());
					System.out.println(cSel);
					try {
						show_table1(new Comanda(table.getValueAt(table.getSelectedRow(), 0).toString()));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount() == 1) {
					lcSel = new LiniaComanda(
							table_1.getValueAt(table_1.getSelectedRow() , 0).toString(),
							table_1.getValueAt(table_1.getSelectedRow(), 1).toString(),
							table_1.getValueAt(table_1.getSelectedRow(), 2).toString(),
							Integer.parseInt(table_1.getValueAt(table_1.getSelectedRow(), 3).toString()),
							Integer.parseInt(table_1.getValueAt(table_1.getSelectedRow(), 4).toString()),
							Float.parseFloat(table_1.getValueAt(table_1.getSelectedRow(), 5).toString()),
							table_1.getValueAt(table_1.getSelectedRow(), 6).toString());
					System.out.println(lcSel);
					
					if (lcSel.getUnitatsxLinia() != lcSel.getUnitatsServides()) {
						slider.setEnabled(true);
						slider.setMaximum(lcSel.getUnitatsxLinia());
						slider.setMinimum(0);
						
						textField.setText(String.valueOf(lcSel.getUnitatsServides()));
						
						slider.setValue(lcSel.getUnitatsServides());
						
						btnGuardar.setEnabled(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Aquesta linia ja está servida!!");
					}
					
				}
			}
		});
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				
				if(slider.getValue() <= slider.getMaximum() || slider.getValue() >= slider.getMinimum()) {
					textField.setText(String.valueOf(slider.getValue()));
				}
				
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (slider.getValue() != lcSel.getUnitatsServides()) {
					int valor = slider.getValue();
					components = sqlArticles.SelectComponents(new ArticleFinal(lcSel.getIdArticle()));
					int counter = 0;
					for (Components c : components) {
						Components comparer = sqlComponents.especificSelect(c);
						if (comparer.getQuantitat() > c.getQuantitat()*valor) {
							counter++;
						}
					}
					System.out.println(counter);
					if (counter == 5) {
						SQLMovimentsComponents sqlMovCom = new SQLMovimentsComponents();
						SQLMovimentsArticle sqlMovAr = new SQLMovimentsArticle();
						
						for (Components c : components) {
							sqlMovCom.insertaMoviment(new MovimentsComponents(c.getIdComponent(), "SORTIDA", c.getQuantitat()*valor));
							Components aux = sqlComponents.especificSelect(c);
							try {
								sqlComponents.updateComponent(new Components(aux.getIdComponent(), aux.getTipus(), aux.getDescripcio(), aux.getQuantitat()-(c.getQuantitat()*valor)));
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						lcSel.setUnitatsServides(valor);
						sqlMovAr.insertaMoviment(new MovimentsArticles(lcSel.getIdArticle(), "ENTRADA", lcSel.getUnitatsServides()));
						System.out.println(lcSel.getUnitatsServides());
						if(lcSel.getUnitatsServides() != lcSel.getUnitatsxLinia()) {
							if (cSel.getEstat().equals("B")) {
								cSel.editarEstat("C");
							}
							if (lcSel.getEstat().equals("B")) {
								lcSel.editarEstat("C");
							}
							
						}else {
							lcSel.editarEstat("T");
							sqlMovAr.insertaMoviment(new MovimentsArticles(lcSel.getIdComanda(), "SORTIDA", lcSel.getUnitatsxLinia()));
							boolean allFinished = true;
							sqliniacomanda.actualitzaLinies(lcSel);
							try {
								for(LiniaComanda lc : sqliniacomanda.consultaLinies(cSel)) {
									if(!lc.getEstat().equals("T")) {
										allFinished = false;
									}
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (allFinished) {
								cSel.editarEstat("T");
							}else {
								cSel.editarEstat("C");
							}
						}
					}else {
						JOptionPane.showMessageDialog(null, "No hi han suficients components per satisfer la comanda.");
					}
				}
				sqlcomanda.actualitzaComanda(cSel);
				sqliniacomanda.actualitzaLinies(lcSel);
				btnGuardar.setEnabled(false);
				slider.setEnabled(false);
				slider.setValue(0);
				textField.setText("");
				try {
					update_table();
					show_table1(cSel);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnComprovarXml) {
			try {
				getComandes(xmlread);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				update_table();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void table_construct() {
		String[] columnes = {"idComanda", "idClient", "preuTotal", "estat"};
		model.setColumnIdentifiers(columnes);
	}
	public void table_construct1() {
		String[] columnes = {"idLiniaComanda", "idComanda", "idArticle", "unitats","unitats servides", "preu", "estat"};
		model1.setColumnIdentifiers(columnes);
	}
		
	public void getComandes(XmlReader xml) throws SQLException {
		
		this.comandes = xml.read();
		for (Comanda comanda : comandes) {
			for (LiniaComanda lc: comanda.getLiniesComanda()) {
				//System.out.println(lc);
				this.sqliniacomanda.insertaLiniaComanda(lc);
			}
			this.sqlcomanda.insertaComandes(comanda);
		}
		
	}
	
	public void update_table() throws SQLException {
		model.setRowCount(0);

		for (Comanda comanda : sqlcomanda.consultaComandes()) {
			model.addRow(new Object[] {comanda.getIdComanda(), comanda.getIdClient(), comanda.getPreu(), comanda.getEstat()});
		}
	}
	public void specific_update(int option) throws SQLException {
		model.setRowCount(0);
		if (option == 0) {
			for (Comanda comanda : sqlcomanda.ConsultaComandesObertes()) {
				model.addRow(new Object[] {comanda.getIdComanda(), comanda.getIdClient(), comanda.getPreu(), comanda.getEstat()});
			}
		}else if(option == 1) {
			for (Comanda comanda : sqlcomanda.ConsultaComandesEnProces()) {
				model.addRow(new Object[] {comanda.getIdComanda(), comanda.getIdClient(), comanda.getPreu(), comanda.getEstat()});
			}
		}else if(option == 2) {
			for (Comanda comanda : sqlcomanda.ConsultaComandesTancades()) {
				model.addRow(new Object[] {comanda.getIdComanda(), comanda.getIdClient(), comanda.getPreu(), comanda.getEstat()});
			}
		}
	}
	public void show_table1(Comanda aux) throws SQLException {
		model1.setRowCount(0);
		
		for (LiniaComanda lc : sqliniacomanda.consultaLinies(aux)) {
			model1.addRow(new Object[] {lc.getIdLiniaComanda(), lc.getIdComanda(),lc.getIdArticle(), lc.getUnitatsxLinia(), lc.getUnitatsServides(), lc.getPreuxLinia(), lc.getEstat()});
		}
	}
}