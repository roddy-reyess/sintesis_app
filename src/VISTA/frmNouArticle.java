package VISTA;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DADES.SQLArticles;
import DADES.SQLArticlesComponents;
import DADES.SQLComponents;
import MODEL.ArticleFinal;
import MODEL.Components;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class frmNouArticle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtA;
	private JTextField textField;
	SQLArticles sqlArticle;
	SQLArticlesComponents sqlAC;
	SQLComponents sqlComponents;
	ArrayList<Components> components;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @throws SQLException 
	 */
	public frmNouArticle() throws SQLException {
		sqlAC = new SQLArticlesComponents();
		sqlArticle = new SQLArticles();
		sqlComponents = new SQLComponents();
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 800, 539);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNouArticle = new JLabel("Nou Article");
		lblNouArticle.setBounds(327, 12, 101, 15);
		contentPanel.add(lblNouArticle);
		
		JLabel lblIdarticle = new JLabel("idArticle");
		lblIdarticle.setBounds(81, 46, 70, 15);
		contentPanel.add(lblIdarticle);
		
		txtA = new JTextField();
		txtA.setText("A0000");
		txtA.setBounds(61, 65, 114, 19);
		contentPanel.add(txtA);
		txtA.setColumns(10);
		
		JLabel lblDescripci = new JLabel("Descripció");
		lblDescripci.setBounds(337, 46, 91, 15);
		contentPanel.add(lblDescripci);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(286, 67, 201, 61);
		contentPanel.add(textArea);
		
		JLabel lblPreuPerArticle = new JLabel("Preu per Article");
		lblPreuPerArticle.setBounds(604, 46, 127, 15);
		contentPanel.add(lblPreuPerArticle);
		
		textField = new JTextField();
		textField.setText("0.0");
		textField.setBounds(604, 65, 114, 19);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblComponentsPerLarticle = new JLabel("Components per l'article");
		lblComponentsPerLarticle.setBounds(275, 153, 189, 15);
		contentPanel.add(lblComponentsPerLarticle);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(61, 215, 114, 24);
		contentPanel.add(comboBox);
		
		JLabel lblCpu = new JLabel("CPU");
		lblCpu.setBounds(358, 220, 70, 15);
		contentPanel.add(lblCpu);
		
		JLabel lblIdcomponent = new JLabel("idComponent");
		lblIdcomponent.setBounds(74, 190, 101, 15);
		contentPanel.add(lblIdcomponent);
		
		JLabel lblTipus = new JLabel("tipus");
		lblTipus.setBounds(358, 190, 70, 15);
		contentPanel.add(lblTipus);
		
		JLabel lblQuantitat = new JLabel("quantitat");
		lblQuantitat.setBounds(625, 190, 70, 15);
		contentPanel.add(lblQuantitat);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(61, 251, 114, 24);
		contentPanel.add(comboBox_1);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(61, 287, 114, 24);
		contentPanel.add(comboBox_2);
		
		JLabel lblRam = new JLabel("RAM");
		lblRam.setBounds(358, 256, 70, 15);
		contentPanel.add(lblRam);
		
		JLabel label = new JLabel("1");
		label.setBounds(651, 220, 20, 15);
		contentPanel.add(label);
		
		JLabel lblPlacaBase = new JLabel("PLACA BASE");
		lblPlacaBase.setBounds(338, 292, 101, 15);
		contentPanel.add(lblPlacaBase);
		
		JComboBox<Integer> comboBox_3 = new JComboBox<Integer>();
		comboBox_3.setBounds(637, 251, 47, 24);
		comboBox_3.addItem(1);
		comboBox_3.addItem(2);
		comboBox_3.addItem(4);
		contentPanel.add(comboBox_3);
		
		JLabel label_1 = new JLabel("1");
		label_1.setBounds(651, 292, 20, 15);
		contentPanel.add(label_1);
		
		JComboBox<String> comboBox_2_1 = new JComboBox<String>();
		comboBox_2_1.setBounds(61, 323, 114, 24);
		contentPanel.add(comboBox_2_1);
		
		JLabel lblDiscDur = new JLabel("DISC DUR");
		lblDiscDur.setBounds(348, 328, 70, 15);
		contentPanel.add(lblDiscDur);
		
		JComboBox<Integer> comboBox_3_1 = new JComboBox<Integer>();
		comboBox_3_1.setBounds(637, 319, 47, 24);
		comboBox_3_1.addItem(1);
		comboBox_3_1.addItem(2);
		comboBox_3_1.addItem(4);
		contentPanel.add(comboBox_3_1);
		
		JComboBox<String> comboBox_2_1_1 = new JComboBox<String>();
		comboBox_2_1_1.setBounds(61, 359, 114, 24);
		contentPanel.add(comboBox_2_1_1);
		
		for (Components component : sqlComponents.selectComponents()) {
			if (component.getTipus().equals("CPU")) {
				comboBox.addItem(component.getIdComponent());
			}else if (component.getTipus().equals("RAM")) {
				comboBox_1.addItem(component.getIdComponent());
			}else if (component.getTipus().equals("PLACA BASE")) {
				comboBox_2.addItem(component.getIdComponent());
			}else if (component.getTipus().equals("DISC DUR")) {
				comboBox_2_1.addItem(component.getIdComponent());
			}else if (component.getTipus().equals("TARJETA GRÀFICA")) {
				comboBox_2_1_1.addItem(component.getIdComponent());
			}
		}
		
		JLabel lblTarjetaGrfica = new JLabel("TARJETA GRÀFICA");
		lblTarjetaGrfica.setBounds(323, 364, 127, 15);
		contentPanel.add(lblTarjetaGrfica);
		
		JLabel label_1_1 = new JLabel("1");
		label_1_1.setBounds(651, 364, 20, 15);
		contentPanel.add(label_1_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(173, 540, 450, 35);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			
			JButton btnGuarda = new JButton("Guarda");
			buttonPane.add(btnGuarda);
			btnGuarda.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (txtA.getText().equals("A0000") || textArea.getText().isEmpty() || textField.getText().equals("0.0")) {
						JOptionPane.showMessageDialog(null, "No pots crear aquest article, valors incorrectes!");
					}else {
						if(!isFloat(textField.getText())) {
							JOptionPane.showMessageDialog(null, "No pots crear aquest article, valors incorrectes!");
						}else {
							ArticleFinal article = new ArticleFinal(txtA.getText(), textArea.getText(), Float.parseFloat(textField.getText()));
							
							try {
								sqlArticle.insertaArticle(article);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println(comboBox.getSelectedItem().toString());
							sqlAC.insertaComposicio(article, new Components(comboBox.getSelectedItem().toString(), Integer.parseInt(label.getText())));
							sqlAC.insertaComposicio(article, new Components(comboBox_1.getSelectedItem().toString(), Integer.parseInt(comboBox_3.getSelectedItem().toString())));
							sqlAC.insertaComposicio(article, new Components(comboBox_2.getSelectedItem().toString(), Integer.parseInt(label_1.getText())));
							sqlAC.insertaComposicio(article, new Components(comboBox_2_1.getSelectedItem().toString(), Integer.parseInt(comboBox_3_1.getSelectedItem().toString())));
							sqlAC.insertaComposicio(article, new Components(comboBox_2_1_1.getSelectedItem().toString(), Integer.parseInt(label_1_1.getText())));
							JOptionPane.showMessageDialog(null, "Article Creat!");
							dispose();
						}
					}
					
					
				}
			});
			
		}
	}
	public boolean isFloat(String s) {
		try {
			Float.parseFloat(s);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
}
