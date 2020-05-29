package MODEL;

public class MovimentsArticles {
	
	private int idMov;
	private String idArticle;
	private String tipusMoviment;
	private int quantitat;
		
	public MovimentsArticles(int idMov) {
		this.idMov = idMov;
	}
	
	public MovimentsArticles(int idMov, String idArticle, String tipusMoviment, int quantitat) {
		this.idMov = idMov;
		this.idArticle = idArticle;
		this.tipusMoviment = tipusMoviment;
		this.quantitat = quantitat;
	}

	public MovimentsArticles(String idArticle, String tipusMoviment, int quantitat) {
	
		this.idArticle = idArticle;
		this.tipusMoviment = tipusMoviment;
		this.quantitat = quantitat;
	}

	public int getIdMov() {
		return idMov;
	}

	public void setIdMov(int idMov) {
		this.idMov = idMov;
	}

	public String getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(String idArticle) {
		this.idArticle = idArticle;
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

}
