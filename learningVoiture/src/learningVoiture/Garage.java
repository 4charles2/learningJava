/**
 * 
 */
package learningVoiture;

import java.util.ArrayList;
import java.util.List;

/**
 * @author charles
 *
 */
public class Garage {

	private List<Voiture> giveList = new ArrayList<Voiture>();

	public void add(List<? extends Voiture> lists) {
		for(Voiture give : lists)
			this.giveList.add(give);
		System.out.println("Nouvelles liste de voiture ajouté aux garage !");
		
	}
	public void storeShow() {
		System.out.println("\t\t\n Le GARAGE contient les voitures : \n\n");
		for(Voiture give : this.giveList)
			System.out.println(give);
	}
}
