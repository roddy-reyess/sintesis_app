package MODEL;
public class LiniaComanda {
	private String idLiniaComanda;
	private String idComanda;
	private String idArticle;
	private int unitatsxLinia;
	private int unitatsServides;
	private String estat;
	private float preuxUnitat;
	private float preuxLinia;
	
	public LiniaComanda(String idLiniaComanda, String idComanda, String idArticle, int unitatsxLinia){
		this.idLiniaComanda = idLiniaComanda;
		this.idComanda = idComanda;
		this.idArticle = idArticle;
		this.unitatsxLinia = unitatsxLinia;
		this.unitatsServides = 0;
		this.estat = "B";
	}
	public LiniaComanda(String idLiniaComanda, String idComanda, String idArticle, int unitatsxLinia, int unitatsServides, float preutotal, String estat){
		this.idLiniaComanda = idLiniaComanda;
		this.idComanda = idComanda;
		this.idArticle = idArticle;
		this.unitatsxLinia = unitatsxLinia;
		this.unitatsServides = unitatsServides;
		this.preuxLinia = preutotal;
		this.estat = estat;
	}
	public LiniaComanda(String idLiniaComanda, String idComanda, String idArticle, int unitatsxLinia, float preutotal){
		this.idLiniaComanda = idLiniaComanda;
		this.idComanda = idComanda;
		this.idArticle = idArticle;
		this.unitatsxLinia = unitatsxLinia;
		this.preuxLinia = preutotal;

	}
	public LiniaComanda(String idLiniaComanda) {
		this.idLiniaComanda = idLiniaComanda;
	}
	public LiniaComanda(String idLiniaComanda, String estat) {
		
	}
	
	public String getIdLiniaComanda() {
		return idLiniaComanda;
	}
	public void setIdLiniaComanda(String idLiniaComanda) {
		this.idLiniaComanda = idLiniaComanda;
	}
	public String getIdComanda() {
		return idComanda;
	}
	public void setIdComanda(String idComanda) {
		this.idComanda = idComanda;
	}
	public String getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(String idArticle) {
		this.idArticle = idArticle;
	}
	public int getUnitatsxLinia() {
		return unitatsxLinia;
	}
	public void setUnitatsxLinia(int unitatsxLinia) {
		this.unitatsxLinia = unitatsxLinia;
	}

	public int getUnitatsServides() {
		return unitatsServides;
	}
	public void setUnitatsServides(int unitatsServides) {
		this.unitatsServides = unitatsServides;
	}
	
	public float getPreuxUnitat() {
		return preuxUnitat;
	}
	public void setPreuxUnitat(float preuxUnitat) {
		this.preuxUnitat = preuxUnitat;
	}
	public void setPreuxLinia(float price) {
		this.preuxLinia = this.unitatsxLinia * price;
	}
	
	public float getPreuxLinia() {
		return preuxLinia;
	}
	//en disseny
	public boolean comprovaStockArticle(String idArticle) {
		return true;
	}
	public boolean comprovaStockComponents(String idArticle) {
		return true;
	}
	public void editarEstat(String estat) {
		this.estat = estat;
	}
	public String getEstat() {
		return this.estat;
	}
	@Override
	public String toString() {
		return "LiniaComanda [idComanda=" + idComanda + ", idLiniaComanda=" + idLiniaComanda + ", idArticle="
				+ idArticle + ", unitatsxLinia=" + unitatsxLinia + ", unitatsServides=" + unitatsServides + ", estat="
				+ estat + ", preuxUnitat=" + preuxUnitat + "€, preuxLinia=" + preuxLinia + "€]\n";
	}
	
}