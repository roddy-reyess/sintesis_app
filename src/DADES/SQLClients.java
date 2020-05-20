package DADES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import MODEL.*;

public class SQLClients {
	Connection co = null;

	Statement sentencia = null;

	String nombreTabla;

	String cif, nom, cognom;
	int telefon;
	ArrayList<Client> clients;

	int ID;


	public void conectar() {

		try {

			Class.forName("org.sqlite.JDBC");

			co = DriverManager.getConnection("jdbc:sqlite:muntatge.db");

			System.out.println("Connexió exitosa a la base de dades");

		} catch (Exception e) {

			System.out.println("Error al conectar amb la base de dades");

		}

	}


	public void insertaClients(Client c) throws SQLException {
		//AÑADIR CLIENTE Y TRATAMIENTO DE OBJETO
	
		String sqlInsert = "INSERT INTO Clients(cifClient, nomClient, cognomClient, telefon) "

		            	+ "VALUES("+"\""+ c.getIdClient() + "\""+"," +"\"" + c.getNom() + "\"" + "," + "\"" + c.getCognom() +"\""+"," + c.getTelefon()+");";

		

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


	public ArrayList<Client> consultaClients(String nomTaula) throws SQLException {

		conectar();

		sentencia = co.createStatement();

		String consultaSql = "SELECT * FROM " + nomTaula + ";";
		this.clients = new ArrayList<Client>();

		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);
			

			while (rs.next()) {
				
				this.clients.add(new Client(rs.getString("cifClient"), rs.getString("nomClient"), rs.getString("cognomClient"), rs.getInt("telefon")));

			}

			rs.close();

			sentencia.close();

			co.close();
			
			

		} catch (Exception e) {

			System.out.println("Consulta no executada");
			
		}
		
		return this.clients;


	}
	public void actualitzaClient(Client cli) {
		
		String sqlUpdate = "UPDATE Clients SET "
		+ "telefon="+ cli.getTelefon()+
		 ", nomClient="+ "\""+cli.getNom()+"\""+", cognomClient="+"\""+cli.getCognom()+"\""+" WHERE cifClient="+"\""+cli.getIdClient()+"\""+";";
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
	public void esborraClient(Client cli) {
		
		String sqlDelete = "DELETE FROM Clients WHERE cifClient="+"\""+cli.getIdClient()+"\""+";";
		
		try {
			conectar();
			
			sentencia = co.createStatement();
			sentencia.executeUpdate(sqlDelete);
			sentencia.close();
			
			co.close();
			
			System.out.println("Registre esborrat");
		} catch (Exception e) {
			System.out.println("No s'ha pogut esborrar el registre, siusplau posa un id valid");
		}
	}
}
