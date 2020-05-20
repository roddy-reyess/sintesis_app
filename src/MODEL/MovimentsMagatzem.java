package MODEL;
public class MovimentsMagatzem {
	private int idMoviments;
	private String idArticle;
	private String idComponent;
	private int idMagatzem;
	private int quantitatMoguda;
	private int fila;
	private int columna;
	private int pis;
	private int[][][] ubicacio;
	
	public MovimentsMagatzem(int idMoviments, String idArticle, String idComponent, int idMagatzem, int quantitatMoguda,
			int fila, int columna, int pis, int[][][] ubicacio) {
		this.idMoviments = idMoviments;
		this.idArticle = idArticle;
		this.idComponent = idComponent;
		this.idMagatzem = idMagatzem;
		this.quantitatMoguda = quantitatMoguda;
		this.fila = fila;
		this.columna = columna;
		this.pis = pis;
		this.ubicacio = ubicacio;
	}

	public int getIdMoviments() {
		return idMoviments;
	}

	public void setIdMoviments(int idMoviments) {
		this.idMoviments = idMoviments;
	}

	public String getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(String idArticle) {
		this.idArticle = idArticle;
	}

	public String getIdComponent() {
		return idComponent;
	}

	public void setIdComponent(String idComponent) {
		this.idComponent = idComponent;
	}

	public int getIdMagatzem() {
		return idMagatzem;
	}

	public void setIdMagatzem(int idMagatzem) {
		this.idMagatzem = idMagatzem;
	}

	public int getQuantitatMoguda() {
		return quantitatMoguda;
	}

	public void setQuantitatMoguda(int quantitatMoguda) {
		this.quantitatMoguda = quantitatMoguda;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public int getPis() {
		return pis;
	}

	public void setPis(int pis) {
		this.pis = pis;
	}

	public int getUbicacio() {
		return ubicacio[this.fila][this.columna][this.pis];
	}

	public void setUbicacio(int[][][] ubicacio) {
		this.ubicacio = ubicacio;
	}
	//els següents metodes estan en disseny
	public int stockTotal() {
		
		return 0;
	}
	
	public int contarStockArticles(String idArticle) {
		return 0;
	}
	public int contarStockComponents(String idComponents) {
		return 0;
	}
	public void restarStockArticles(int numaRestar, String idArticle) {
		
	}
}
