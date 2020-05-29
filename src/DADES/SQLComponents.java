package DADES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import MODEL.*;

public class SQLComponents {
	
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
	
	public ArrayList<Components> selectComponents() throws SQLException {
		
		conectar();
		sentencia = co.createStatement();
		String sqlStatement = "SELECT * FROM Components";
		ArrayList<Components> resultQuery = new ArrayList<Components>();
		
		try {
			
			ResultSet rs = sentencia.executeQuery(sqlStatement);
			while (rs.next()) {
				resultQuery.add(new Components(rs.getString("idComponent"), rs.getString("tipus"), rs.getString("descripcio"), rs.getInt("quantitat")));
				
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
	
	public void updateComponent(Components component) throws SQLException {
		String sqlStatement = "UPDATE Components SET "
				+ "tipus=\"" + component.getTipus() + "\", "
				+ "descripcio=\"" + component.getDescripcio() + "\", "
				+ "quantitat=" + component.getQuantitat()
				+ " WHERE idComponent=\"" + component.getIdComponent() + "\";";
		
		try {
			
			conectar();
			
			sentencia = co.createStatement();
			sentencia.executeUpdate(sqlStatement);
			
			
			
			System.out.println("Base de dades actualitzada correctament");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("No s'ha pogut Actualitzar la taula");
		}finally {

			sentencia.close();
			co.close();
		}
		
	}
	
	public void insertComponent(Components component) throws SQLException {
		
		String sqlStatement = "INSERT INTO Components(idComponent, tipus, descripcio, quantitat) VALUES(\"" + component.getIdComponent() + "\", \"" + component.getTipus() + "\", \"" + component.getDescripcio() + "\", " + component.getQuantitat() + ");";
		
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
	public Components especificSelect(Components c) {
		String sqlStatement = "SELECT * FROM Components WHERE idComponent=\"" + c.getIdComponent() + "\";";
		Components aux = null;
		try {
			conectar();
			sentencia = co.createStatement();
			
			ResultSet rs = sentencia.executeQuery(sqlStatement);
			aux = new Components(rs.getString("idComponent"), rs.getString("tipus"), rs.getString("tipus"), rs.getInt("quantitat"));
			
			rs.close();
			sentencia.close();
			co.close();
			
			System.out.println("DADES ACONSEGUIDES");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("treh");
		}
		return aux;
		
	}
}
