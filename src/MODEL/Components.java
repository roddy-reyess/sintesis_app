package MODEL;
public class Components {
	private String idComponent;
	private String tipus;
	private String descripcio;
	public Components(String idComponent, String tipus, String descripcio) {
		this.idComponent = idComponent;
		this.tipus = tipus;
		this.descripcio = descripcio;
	}
	public String getIdComponent() {
		return idComponent;
	}
	public void setIdComponent(String idComponent) {
		this.idComponent = idComponent;
	}
	public String getTipus() {
		return tipus;
	}
	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	public String getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	//en disseny
	public void afegirStockComponents(int nComponents, String idComponent) {
		
	}
}
