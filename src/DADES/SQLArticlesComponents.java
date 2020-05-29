package DADES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import MODEL.*;

public class SQLArticlesComponents {

	Connection co = null;
	Statement sentencia = null;
	
	public void conectar() {

		try {

			Class.forName("org.sqlite.JDBC");

			co = DriverManager.getConnection("jdbc:sqlite:muntatge.db");

			System.out.println("Connexió exitosa a la base de dades");

		} catch (Exception e) {

			System.out.println("Error al conectar amb la base de dades");

		}

	}
	
	public void insertaComposicio (ArticleFinal article, Components component) {
		String sqlStatement = "INSERT INTO ArticlesComponents(idArticle, idComponent, quantitat) VALUES(\"" + article.getIdArticle() + "\", \"" + component.getIdComponent() + "\", " + component.getQuantitat() + ");";
		
		try {
			conectar();
			sentencia = co.createStatement();
			sentencia.executeUpdate(sqlStatement);
			
			sentencia.close();
			co.close();
			
			System.out.println("Base de dades actualitzada correctament");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al insertar les dades.");
		}
	}
	
	public ArrayList<Components> SelectComponents(ArticleFinal article){
		
		String sqlStatement = "SELECT idComponent, quantitat FROM ArticlesComponents WHERE idArticle=\"" + article.getIdArticle()+ "\";";
		ArrayList<Components> resultQuery = new ArrayList<Components>();
		
		try {
			conectar();
			sentencia = co.createStatement();
			
			ResultSet rs = sentencia.executeQuery(sqlStatement);
			
			while (rs.next()) {
				resultQuery.add(new Components(rs.getString("idComponent"), rs.getInt("quantitat")));
			}
			
			rs.close();
			sentencia.close();
			co.close();
			
			System.out.println("DADES ACONSEGUIDES");
	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al accedir a les dades");
		}
		return resultQuery;
	}
	
}
