/**
 * 
 */
package learningVoiture;

/**
 * @author charles
 *
 */
public class Voiture {

	private String marque;
	private String modele;
	private String energy;
	private int cheveaux;
	
	public Voiture() {
		
	}
	public Voiture(String pMarque, String pModele, String pEnergy, int pCheveaux) {
		this.setCheveaux(pCheveaux);
		this.setEnergy(pEnergy);
		this.setMarque(pMarque);
		this.setModele(pModele);
	}
	
	@Override
	public String toString() {
		return "une " + this.getMarque() + " modèle " + this.getModele() + " qui roule en " + this.getEnergy() + " et qui à " + this.getCheveaux() + " cheveaux.";
	}
	//---------------------------------------------
	//--------------------Setters------------------
	//---------------------------------------------
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public void setCheveaux(int cheveaux) {
		this.cheveaux = cheveaux;
	}
	public void setEnergy(String energy) {
		this.energy = energy;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	//---------------------------------------------
	//--------------------Getters------------------
	//---------------------------------------------
	public String getMarque() {
		return marque;
	}
	public int getCheveaux() {
		return cheveaux;
	}
	public String getEnergy() {
		return energy;
	}
	public String getModele() {
		return modele;
	}
}
