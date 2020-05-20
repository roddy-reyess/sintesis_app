package MODEL;

public class ArticleFinal{
	private String idArticle;
	private String descripció;
	private float preuxArticle;
	public ArticleFinal(String idArticle, String descripció, float preuxArticle) {
		this.idArticle = idArticle;
		this.descripció = descripció;
		this.preuxArticle = preuxArticle;
	}
	public ArticleFinal(String idArticle) {
		this.idArticle = idArticle;
	}
	public String getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(String idArticle) {
		this.idArticle = idArticle;
	}
	public String getDescripció() {
		return descripció;
	}
	public void setDescripció(String descripció) {
		this.descripció = descripció;
	}
	public float getPreuxArticle() {
		return preuxArticle;
	}
	public void setPreuxArticle(float preuxArticle) {
		this.preuxArticle = preuxArticle;
	}
	//en disseny
	public void afegirArticle(String idArticle, String descripcio, float preuxArticle) {
		
	}
	
}