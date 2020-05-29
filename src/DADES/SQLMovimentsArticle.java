package DADES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import MODEL.*;

public class SQLMovimentsArticle {
	Connection co = null;
	Statement sentencia = null;
	
	public void conectar(){
		
		try {

			Class.forName("org.sqlite.JDBC");

			co = DriverManager.getConnection("jdbc:sqlite:muntatge.db");

			System.out.println("Connexió exitosa a la base de dades");

		} catch (Exception e) {

			System.out.println("Error al conectar amb la base de dades");

		}
		
	}
	
	public void insertaMoviment(MovimentsArticles moviment) {
		
		String sqlStatement = "INSERT INTO MovimentsArticles(idArticle, tipusMoviment, quantitat) VALUES(\"" + moviment.getIdArticle() + "\", \"" + moviment.getTipusMoviment() + "\", "+ moviment.getQuantitat() +");";
		
		try {
			conectar();
			sentencia = co.createStatement();
			sentencia.executeUpdate(sqlStatement);
			
			sentencia.close();
			co.close();
			
			System.out.println("Base de dades actualitzada correctament");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR AL INSERTAR DADES");
		}
	}
	
	public ArrayList<MovimentsArticles> selectMovxCom (ArticleFinal moviment){
		String sqlStatement = "SELECT * FROM MovimentsArticles WHERE idArticle=\"" + moviment.getIdArticle() + "\";";
		ArrayList<MovimentsArticles> resultQuery = new ArrayList<MovimentsArticles>();
		
		try {
			conectar();
			sentencia = co.createStatement();
			
			ResultSet rs = sentencia.executeQuery(sqlStatement);
			while (rs.next()) {
				resultQuery.add(new MovimentsArticles(rs.getInt("idMov"), rs.getString("idArticle"), rs.getString("tipusMoviment"), rs.getInt("quantitat")));
				
			}
		
			rs.close();
			sentencia.close();
			co.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR AL REBRE LES DADES");
		}
		return resultQuery;
	}
}
