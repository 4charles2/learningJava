/**
 * 
 */
package serialization;

import java.io.Serializable;

/**
 * @author charles
 *
 */
public class Game implements Serializable {
	private String nom, style;
	private double prix;
	private Notice notice;
	
	public Game() {}

	/**
	 * @param nom
	 * @param style
	 * @param prix
	 */
	public Game(String nom, String style, double prix) {
		this.setNom(nom);
		this.setPrix(prix);
		this.setStyle(style);
		this.setNotice();
	}
	//Les mutateurs
	public void setNotice(Notice pLang){
		this.notice = pLang;
	}
	public void setNotice() {
		this.notice = new Notice();
	}
	public Notice getNotice() {
		return notice;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * @param style the style to set
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String toString() {
		return "Nom du jeu " + this.getNom() + " style de jeu " + this.getStyle() + " Pour le prix de : " + this.getPrix() + 
				"\n sa notice est en " + this.getNotice();
	}
	public static void show(String str) {
		System.out.println(str);
	}
}
