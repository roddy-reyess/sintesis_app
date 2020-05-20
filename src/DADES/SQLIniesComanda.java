package DADES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import MODEL.*;


public class SQLIniesComanda {
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
	public void insertaLiniaComanda(LiniaComanda lComanda) {
		
		//System.out.println(lComanda);
		String sqlInsert = "INSERT INTO LiniaComanda(idLiniaComanda, idComanda, idArticle, unitats, unitatsServides, preu, estat) VALUES(\"" + lComanda.getIdLiniaComanda() + "\", \"" + lComanda.getIdComanda() + "\", \"" + lComanda.getIdArticle() + "\", " + lComanda.getUnitatsxLinia()+", "+ lComanda.getUnitatsServides() + ", " + lComanda.getPreuxLinia()+", \""+ lComanda.getEstat()+"\");";
		
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
	
	public ArrayList<LiniaComanda> consultaLinies(Comanda comanda) throws SQLException{
		conectar();
		sentencia = co.createStatement();
		String consultaSql = "SELECT * FROM LiniaComanda WHERE idComanda= \""+ comanda.getIdComanda()+ "\";";
		ArrayList<LiniaComanda> lComanda = new ArrayList<LiniaComanda>();
		
		try {
			
			ResultSet rs = sentencia.executeQuery(consultaSql);
			
			while (rs.next()) {
				lComanda.add(new LiniaComanda(rs.getString("idLiniaComanda"), rs.getString("idComanda"), rs.getString("idArticle"), rs.getInt("unitats"), rs.getInt("unitatsServides"), rs.getFloat("preu"), rs.getString("estat")));
				
			}

			rs.close();
			sentencia.close();
			co.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Consulta no executada");
		}
		return lComanda;
	}
	
	public void actualitzaLinies(LiniaComanda line){
		String sqlUpdate = "UPDATE LiniaComanda SET " 
							+ "idComanda = \"" + line.getIdComanda() + "\", idArticle = \"" + line.getIdArticle()
							+ "\", unitats = " + line.getUnitatsxLinia() + ", unitatsServides = " + line.getUnitatsServides()
							+ ", preu = " + line.getPreuxLinia() + ", estat = \"" + line.getEstat()
							+ "\" WHERE idLiniaComanda = \"" + line.getIdLiniaComanda()+ "\";";
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
