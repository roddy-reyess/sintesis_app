package MODEL;
public class OrdreFabricacio {
	private int idOf;
	private int idLiniaComanda;
	private String idArticle;
	private String estat;
	public OrdreFabricacio(int idOf, int idLiniaComanda, String idArticle, String estat) {
		super();
		this.idOf = idOf;
		this.idLiniaComanda = idLiniaComanda;
		this.idArticle = idArticle;
		this.estat = estat;
	}
	public int getIdOf() {
		return idOf;
	}
	public void setIdOf(int idOf) {
		this.idOf = idOf;
	}
	public int getIdLiniaComanda() {
		return idLiniaComanda;
	}
	public void setIdLiniaComanda(int idLiniaComanda) {
		this.idLiniaComanda = idLiniaComanda;
	}
	public String getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(String idArticle) {
		this.idArticle = idArticle;
	}
	public String getEstat() {
		return estat;
	}
	public void setEstat(String estat) {
		this.estat = estat;
	}
	//en disseny
	public void afegirStockArticle(int nouStock, String idArticle) {
		
	}
	public void restarStockComponent(int nouStock, String idComponents) {
		
	}

}
