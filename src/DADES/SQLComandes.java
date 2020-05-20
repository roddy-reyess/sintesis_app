package DADES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import MODEL.*;

public class SQLComandes {
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

	public void insertaComandes(Comanda comanda) throws SQLException{
		String sqlInsert = "INSERT INTO Comandes(idComanda, idClient, preuTotal, estat) " + "VALUES(\"" + comanda.getIdComanda() + "\", \"" + comanda.getIdClient() + "\", "+ comanda.getPreu() + ", \"" + comanda.getEstat()+"\");";
		try {

			conectar();

			sentencia = co.createStatement();

			sentencia.executeUpdate(sqlInsert);

			sentencia.close();

			 co.close();

			System.out.println("Dades inserides");

		} catch (Exception e) {

			System.out.println("Error, no s'han pogut inserir les dades en la taula");

		}
	}
	public ArrayList<Comanda> consultaComandes() throws SQLException{
		
		conectar();
		
		sentencia = co.createStatement();
		
		String consultaSql = "SELECT * FROM Comandes;";
		ArrayList<Comanda> comandes = new ArrayList<Comanda>();

		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);
			

			while (rs.next()) {
				
				comandes.add(new Comanda(rs.getString("idComanda"), rs.getString("idClient"), rs.getFloat("preuTotal"), rs.getString("estat")));

			}

			rs.close();

			sentencia.close();

			co.close();
			
			

		} catch (Exception e) {

			System.out.println("Consulta no executada");
			
		}
		return comandes;
	}
	public ArrayList<Comanda> ConsultaComandesObertes() throws SQLException{

		conectar();
		
		sentencia = co.createStatement();
		
		String consultaSql = "SELECT * FROM Comandes WHERE estat = \"B\";";
		ArrayList<Comanda> comandes = new ArrayList<Comanda>();
		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);
			

			while (rs.next()) {
				
				comandes.add(new Comanda(rs.getString("idComanda"), rs.getString("idClient"), rs.getFloat("preuTotal"), rs.getString("estat")));

			}

			rs.close();

			sentencia.close();

			co.close();
			
			

		} catch (Exception e) {

			System.out.println("Consulta no executada");
			
		}
		return comandes;
	}
	
	public ArrayList<Comanda> ConsultaComandesEnProces() throws SQLException{

		conectar();
		
		sentencia = co.createStatement();
		
		String consultaSql = "SELECT * FROM Comandes WHERE estat = \"C\";";
		ArrayList<Comanda> comandes = new ArrayList<Comanda>();
		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);
			

			while (rs.next()) {
				
				comandes.add(new Comanda(rs.getString("idComanda"), rs.getString("idClient"), rs.getFloat("preuTotal"), rs.getString("estat")));

			}

			rs.close();

			sentencia.close();

			co.close();
			
			

		} catch (Exception e) {

			System.out.println("Consulta no executada");
			
		}
		return comandes;
	}
	public ArrayList<Comanda> ConsultaComandesTancades() throws SQLException{

		conectar();
		
		sentencia = co.createStatement();
		
		String consultaSql = "SELECT * FROM Comandes WHERE estat = \"T\";";
		ArrayList<Comanda> comandes = new ArrayList<Comanda>();
		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);
			

			while (rs.next()) {
				
				comandes.add(new Comanda(rs.getString("idComanda"), rs.getString("idClient"), rs.getFloat("preuTotal"), rs.getString("estat")));

			}

			rs.close();

			sentencia.close();

			co.close();
			
			

		} catch (Exception e) {

			System.out.println("Consulta no executada");
			
		}
		return comandes;
	}
	public void actualitzaComanda(Comanda cli) {
		
		String sqlUpdate = "UPDATE Comandes SET "
							+ "idClient = \'"+ cli.getIdClient()+"\', preuTotal = "+cli.getPreu()
							+ ", estat = "+"\'"+cli.getEstat()+"\'"+" WHERE idComanda = "+"\'"+cli.getIdComanda()+"\'"+";";
		try {
			conectar();
			
			sentencia = co.createStatement();
			sentencia.executeUpdate(sqlUpdate);
			sentencia.close();
			
			co.close();
			
			System.out.println("Taula actualitzada amb éxit");
			
		} catch (Exception e) {
			System.out.println("No s'ha pogut Actualitzar la taula");
		}
	}
}
