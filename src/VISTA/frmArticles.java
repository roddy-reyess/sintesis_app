package VISTA;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DADES.SQLArticles;
import DADES.SQLArticlesComponents;
import DADES.SQLMovimentsArticle;
import MODEL.ArticleFinal;
import MODEL.Components;
import MODEL.MovimentsArticles;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

public class frmArticles extends JDialog {
	private JTable table;
	private JTable table_1;
	SQLArticles sqlArticles;
	SQLArticlesComponents sqlAC;
	SQLMovimentsArticle sqlMoviments;
	ArticleFinal aSel;
	DefaultTableModel model = null;
	DefaultTableModel model1 = null;
	DefaultTableModel model2 = null;
	private JTable table_2;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public frmArticles() {
		setBounds(100, 100, 800, 600);
		sqlArticles = new SQLArticles();
		sqlAC = new SQLArticlesComponents();
		sqlMoviments = new SQLMovimentsArticle();
		getContentPane().setLayout(null);
		model = new DefaultTableModel();
		model1 = new DefaultTableModel();
		model2 = new DefaultTableModel();
		TableConstruct();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 36, 776, 157);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 205, 776, 157);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(model1);
		scrollPane_1.setViewportView(table_1);
		showTable();
		JLabel lblArticles = new JLabel("Articles");
		lblArticles.setBounds(350, 12, 70, 15);
		getContentPane().add(lblArticles);
		
		JButton btnNouArticle = new JButton("Nou Article");
		btnNouArticle.setBounds(635, 538, 117, 25);
		getContentPane().add(btnNouArticle);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(12, 374, 776, 157);
		getContentPane().add(scrollPane_1_1);
		
		table_2 = new JTable();
		table_2.setModel(model2);
		scrollPane_1_1.setViewportView(table_2);
		
		JButton btnAtualitzaRegistres = new JButton("Actualitza Registres");
		btnAtualitzaRegistres.setBounds(428, 538, 195, 25);
		getContentPane().add(btnAtualitzaRegistres);
		btnAtualitzaRegistres.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				showTable();
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount() == 1) {
					aSel = new ArticleFinal (table.getValueAt(table.getSelectedRow(), 0).toString(), table.getValueAt(table.getSelectedRow(), 1).toString(), Float.parseFloat(table.getValueAt(table.getSelectedRow(), 2).toString()));
					showTable1(aSel);
					showTable2(aSel);
				}
			}
		});
		btnNouArticle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frmNouArticle nou;
				try {
					nou = new frmNouArticle();
					nou.setSize(800, 600);
					nou.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}
	public void TableConstruct() {
		String[] columnes = {"idArticle", "descripcio", "preuXAricle"};
		model.setColumnIdentifiers(columnes);
		String[] columnes1 = {"idArticle", "idComponent", "quantitat"};
		model1.setColumnIdentifiers(columnes1);
		String[] columnes2 = {"idMov", "idArticles", "tipusMoviment", "quantitat"};
		model2.setColumnIdentifiers(columnes2);
	}
	public void showTable() {
		model.setRowCount(0);
		
		try {
			for (ArticleFinal article : sqlArticles.selectArticles()) {
				model.addRow(new Object[] {article.getIdArticle(), article.getDescripció(), article.getPreuxArticle()});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void showTable1(ArticleFinal article) {
		model1.setRowCount(0);
		for (Components component : sqlAC.SelectComponents(article)) {
			model1.addRow(new Object[] {article.getIdArticle(), component.getIdComponent(), component.getQuantitat()});
		}
	}
	
	public void showTable2 (ArticleFinal article) {
		model2.setRowCount(0);
		
		for(MovimentsArticles moviment : sqlMoviments.selectMovxCom(article)) {
			model2.addRow(new Object[] { moviment.getIdMov(), moviment.getIdArticle(), moviment.getTipusMoviment(), moviment.getQuantitat() });
		}
	
	}
	
}
