package DADES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import MODEL.*;

public class SQLArticles {
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
	public float getPriceArticles(ArticleFinal a) throws SQLException {
		conectar();
		sentencia = co.createStatement();
		float price = 0;
		String sqlSelect = "SELECT preuXArticle FROM ArticlesFinals WHERE idArticle = '"+ a.getIdArticle() + "';";
		try {
			
			
			ResultSet rs = sentencia.executeQuery(sqlSelect);
			price = rs.getFloat(1);
			
			
			rs.close();
			sentencia.close();
			co.close();
			
	
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Consulta no executada");
		}
		return price;
	}
	public ArrayList<ArticleFinal> selectArticles() throws SQLException{
		conectar();
		sentencia = co.createStatement();
		String sqlStatement = "SELECT * FROM ArticlesFinals;";
		ArrayList<ArticleFinal> resultQuery = new ArrayList<ArticleFinal>();
		
		try {
			
			ResultSet rs = sentencia.executeQuery(sqlStatement);
			while (rs.next()) {
				resultQuery.add(new ArticleFinal(rs.getString("idArticle"), rs.getString("descripcio"), rs.getFloat("preuXArticle")));
				
			}
			
			rs.close();
			
		}catch (Exception e){
			
			System.out.println("Consulta no executada");
		
		}finally {

			sentencia.close();
			co.close();
		}
		
		return resultQuery;
	}
	public void insertaArticle(ArticleFinal article) throws SQLException {
		String sqlStatement = "INSERT INTO ArticlesFinals(idArticle, descripcio, preuXArticle) VALUES(\""+ article.getIdArticle() + "\", \"" + article.getDescripció() + "\", " + article.getPreuxArticle() +");";
		try {
			conectar();
			sentencia = co.createStatement();
			sentencia.executeUpdate(sqlStatement);
			
			
			
			System.out.println("Base de dades actualitzada correctament");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR AL INSERTAR DADES");
		}finally {
			sentencia.close();
			co.close();
		}
	}
}
