import zArmy.*;

import java.lang.reflect.Method;

import combat.CombatPistolet;
import comportement.*;
import deplacement.Courrir;

/**
 * @author charles
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Personnage armys[] = {new Civil(), new Chirurgien(), new Guerrier(), new Medecin(), new Sniper() };
		
		for(Personnage army : armys)
			army.description();
	
		System.out.println("\n\n");
		armys[2].combattre();
		armys[2].setCombat(new CombatPistolet());
		armys[2].combattre();
		
		//Cr�er un tableau des m�thodes existantent pour la class Personnage
		Method[] persoMethds = Personnage.class.getMethods();
		
		System.out.println("Il y a " + persoMethds.length + " m�thode dans la class " + Personnage.class.getName());
		for(Method persoMethd : persoMethds)
			System.out.println("Une m�thode de la class personnage " + persoMethd);
		
		armys[4].setSoin(new Soin() {
			public void soigner() { 
				System.out.println("Je mets des pansements et de la morphine");
			}
		});
		armys[4].soigner();
	}
	

}
