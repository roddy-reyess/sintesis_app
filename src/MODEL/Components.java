package MODEL;
public class Components {
	private String idComponent;
	private String tipus;
	private String descripcio;
	private int quantitat;

	public Components(String idComponent, String tipus, String descripcio, int quantitat) {
		
		this.idComponent = idComponent;
		this.tipus = tipus;
		this.descripcio = descripcio;
		this.quantitat = quantitat;
	}
	
	public Components(String idComponent, int quantitat) {
	
		this.idComponent = idComponent;
		this.quantitat = quantitat;
	}
	
	public Components(String idComponent) {
		
		this.idComponent = idComponent;
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

	public int getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}
	public void sumaQuantitat(int quantitat) {
		this.quantitat += quantitat;
	}

	@Override
	public String toString() {
		return "Components [idComponent=" + idComponent + ", tipus=" + tipus + ", descripcio=" + descripcio
				+ ", quantitat=" + quantitat + "]";
	}
	
}
