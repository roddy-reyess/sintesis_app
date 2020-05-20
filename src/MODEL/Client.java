package MODEL;

public class Client{
	private String idClient;
	private String nom;
	private String cognom;
	private int telefon;
	
	public Client(String idClient, String nom, String cognom, int telefon){
		this.idClient = idClient;
		this.nom = nom;
		this.cognom = cognom;
		this.telefon = telefon;
	}
	public Client(String idClient, int telefon) {
		this.idClient = idClient;
		this.telefon = telefon;
	}
	public Client(String idClient) {
		this.idClient = idClient;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom() {
		return cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}
	
	//en disseny
	
	@Override
	public String toString() {
		return "\nClient [cifClient= " + idClient + ", nom i cognom: " + nom + " " + cognom + ", telefon:" + telefon + "]";
	}

	public void ferComanda() {
		
	}


	
}