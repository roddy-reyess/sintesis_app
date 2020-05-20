package DADES;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import MODEL.ArticleFinal;
import MODEL.Comanda;
import MODEL.LiniaComanda;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class XmlReader {
	File inputFile;
	DocumentBuilderFactory dbFactory;
	private int contador = 0;
	DocumentBuilder dBuilder;
	public Document doc;
	public NodeList nList;
	public NodeList nComandes;
	public Node nNode;
	public Element eElement;;
	public ArrayList<Comanda> comandes;
	private SQLArticles article;
	
	public XmlReader() throws ParserConfigurationException, SAXException, IOException {
		this.inputFile = new File("comandes.xml");
        this.dbFactory = DocumentBuilderFactory.newInstance();
        this.dBuilder = dbFactory.newDocumentBuilder();
        this.doc = this.dBuilder.parse(this.inputFile);
        this.doc.getDocumentElement().normalize();
        this.nList = null;      
        this.nComandes = this.doc.getElementsByTagName("comanda");      
        this.comandes = new ArrayList<Comanda>();
        article = new SQLArticles();

	}
	public ArrayList<Comanda> read() {

	      try {
		     
	    	 for (int i = 0; i < this.nComandes.getLength(); i++) {
	    		 if (this.nComandes.item(i).getNodeType() == Node.ELEMENT_NODE) {
	    			 this.eElement = (Element) this.nComandes.item(i);
	    			 this.nList = this.nComandes.item(i).getChildNodes();
	    			 this.nNode = this.nList.item(0);
	    			 ArrayList<LiniaComanda> liniesComanda = new ArrayList<LiniaComanda>();
	    			 for (int j = 0; j < nList.getLength(); j++) {				 
	    				 if (this.nList.item(j).getNodeType() == Node.ELEMENT_NODE) { 
	    					 Element eElement2 = (Element) this.nList.item(j);
	    			 
	    					 liniesComanda.add(new LiniaComanda(
	    							 this.eElement.getAttribute("idComanda") + "-" +((j/2)+1),
	    							 this.eElement.getAttribute("idComanda"),
	    							 eElement2.getElementsByTagName("codi").item(0).getTextContent(), 
    								 Integer.parseInt(eElement2.getElementsByTagName("unitats").item(0).getTextContent()) 
    								 ));
	    					 float preu = article.getPriceArticles(new ArticleFinal(liniesComanda.get(j/2).getIdArticle()));
	    					 
	    					 liniesComanda.get(j/2).setPreuxLinia(preu);
	    				}
	    					
	    			 }
	    			 if (this.eElement.hasAttribute("estatus") && this.eElement.getAttribute("estatus").equals("A")) {
	    				this.comandes.add(new Comanda(this.eElement.getAttribute("idComanda"), this.eElement.getAttribute("idclient"), "B", liniesComanda));
	    				this.comandes.get(contador).setPreu();
	    				
	    				contador++;
	    			 } 
	    		 }
	    	}  
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return this.comandes;
	}
	public void mostraObjecte() {
		System.out.println(this.comandes.toString());
			
	}
}



