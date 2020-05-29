package MODEL;

public class MovimentsComponents {
	
	private int idMov;
	private String idComponent;
	private String tipusMoviment;
	private int quantitat;
	
	public MovimentsComponents(int idMov) {
		
		this.idMov = idMov;
	}

	public MovimentsComponents(int idMov, String idComponent, String tipusMoviment, int quantitat) {
		
		this.idMov = idMov;
		this.idComponent = idComponent;
		this.tipusMoviment = tipusMoviment;
		this.quantitat = quantitat;
	}

	public MovimentsComponents(String idComponent, String tipusMoviment, int quantitat) {
		this.idComponent = idComponent;
		this.tipusMoviment = tipusMoviment;
		this.quantitat = quantitat;
	}

	public int getIdMov() {
		return idMov;
	}

	public void setIdMov(int idMov) {
		this.idMov = idMov;
	}

	public String getIdComponent() {
		return idComponent;
	}

	public void setIdComponent(String idComponent) {
		this.idComponent = idComponent;
	}

	public String getTipusMoviment() {
		return tipusMoviment;
	}

	public void setTipusMoviment(String tipusMoviment) {
		this.tipusMoviment = tipusMoviment;
	}

	public int getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}
	
	

	@Override
	public String toString() {
		return "MovimentsComponents [idMov=" + idMov + ", idComponent=" + idComponent + ", tipusMoviment="
				+ tipusMoviment + ", quantitat=" + quantitat + "]";
	}
	
}