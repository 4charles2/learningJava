/**
 * 
 */
package learningVoiture;

/**
 * @author charles
 *
 */
public class VoitureSansPermis extends Voiture {
	public VoitureSansPermis() {}
	
	public VoitureSansPermis(String pMarque, String pModele, String pEnergy, int pCheveaux) {
		super(pMarque, pModele, pEnergy, pCheveaux);
	}
	
	public String toString() {
		return super.toString() + "\n\t\tqui roule sans permis !";
		
	}
}
