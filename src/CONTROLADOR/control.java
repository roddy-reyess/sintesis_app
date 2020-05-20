package CONTROLADOR;

import MODEL.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import DADES.*;


public class control {
	private SQLClients sqlC;
	public ArrayList<Client> clients;
	public control() {
		this.sqlC = new SQLClients();
	}
	public void control() throws ParserConfigurationException, SAXException, IOException, SQLException{
		/*XmlReader read = new XmlReader();
		SQLClients this.sqlC = new SQLClients();
		read.read();
		read.mostraObjecte();
		sqlC.insertaClients(new Client("14354678M", "Alan", "Army", 73343608));
		ArrayList<Client> clients = sqlC.consultaClients("Clients");
		System.out.println(clients.toString());
		sqlC.actualitzaClient(new Client("12345678A", 622143608));
		sqlC.esborraClient(new Client("14354678M"));
		clients = sqlC.consultaClients("Clients");
		System.out.println(clients.toString());*/
	}
	public ArrayList<Client> Select() {
		try {
			this.clients = this.sqlC.consultaClients("Clients");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.clients;
	}
}
