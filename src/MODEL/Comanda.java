package MODEL;

import java.util.ArrayList;
import java.util.Date;

public class Comanda {
	private String idComanda;
	private String idClient;
	private Date dataObertura;
	private Date dataTancament;
	public float preu;
	private String estat;
	private int nLinies;
	private ArrayList<LiniaComanda> liniesComanda;
	
	public Comanda(String idComanda, String idClient, String estatus, ArrayList<LiniaComanda> liniesComanda){
		this.idComanda = idComanda;
		this.idClient = idClient;
		this.liniesComanda = liniesComanda;
		this.estat = estatus;
	}
	public Comanda(String idComanda) {
		this.idComanda = idComanda;
	}
	public Comanda(String idComanda, String idClient, float preu, String estatus) {
		this.idComanda = idComanda;
		this.idClient = idClient;
		this.preu = preu;
		this.estat = estatus;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	
	public int getnLinies() {
		return this.nLinies;
	}

	public void setnLinies(int nLinies) {
		this.nLinies = nLinies;
	}
	

	public String getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(String idComanda) {
		this.idComanda = idComanda;
	}

	public Date getDataObertura() {
		return dataObertura;
	}

	public void setDataObertura(Date dataObertura) {
		this.dataObertura = dataObertura;
	}

	public Date getDataTancament() {
		return dataTancament;
	}

	public void setDataTancament(Date dataTancament) {
		this.dataTancament = dataTancament;
	}

	public float getPreu() {
		return preu;
	}

	public void setPreu() {
		for (int i = 0; i < liniesComanda.size(); i++) {
			this.preu += this.liniesComanda.get(i).getPreuxLinia();
		}
	}

	public String getEstat() {
		return estat;
	}
	public void editarEstat(String estat) {
		this.estat = estat;
	}

	public ArrayList<LiniaComanda> getLiniesComanda() {
		return liniesComanda;
	}

	public void setLiniesComanda(ArrayList<LiniaComanda> liniesComanda) {
		this.liniesComanda = liniesComanda;
	}

	@Override
	public String toString() {
		return "Comanda [idComanda=" + idComanda + ", idClient=" + idClient + ", dataObertura=" + dataObertura
				+ ", dataTancament=" + dataTancament + ", preu=" + preu + ", estat=" + estat + ", nLinies=" + nLinies
				+ ", \nliniesComanda=" + liniesComanda + "]\n";
	}



}
