package modulesPerso;
import villes.*;
import controlException.NbHabitException;


/**
 * Permet de tester les modules créer .
 * Sorte de lib perso de classes.
 * 
 * 
 * @author charles
 *
 */
public class Main {
	public static void main(String[] args) {
		Ville villes[] = new Ville[8];
		
		createVille(villes);
		
		Ville.show("un Total de "+Ville.getNbInstances()+" Villes on été créer !");
	}
	//créer les instances de ville
	public static void createVille(Ville villes[]){
		int i = 0;
		villes[i] = new Ville();

		
		villes[++i] = instanciation("Nancy", 350_000, "France");
		villes[++i] = instanciation("dampierre sur linotte", 1000_000, "France");
		villes[++i] = instanciation("dombasle sur meurthe", 10_000, "France");
		
		villes[++i] = instanciation("dameleviere", -1000, "France");	
		
		villes[++i] = instanciation("Saint Nicolas de port", 7500, "France", "Basilique de saint Nicolas de port");
		villes[++i] = instanciation("Paris", 3_500_000, "France", "La tour effeil");
		villes[++i] = instanciation();
		
			
		
		for (int index = 0; index < Ville.getNbInstances()-1; index++) {
			villes[index].compareVille(villes[index+1]);
			Ville.show("\n"+villes[index]);
		}
			
		Ville.show("\n\t\t"+Ville.getNbInstances() + " Villes ont été créer.");
	}
	public static Ville instanciation(String pName, int pNbPeople, String pCountry) {
		try {
			//Créer les instances des Villes
			return new Ville(pName, pNbPeople, pCountry);
				
			}catch (NbHabitException e){
				System.out.println("\n\n\t\t" + e.getMessage() + "\n\n\n\t\t");
				return new Ville();
			}
		
	}
	public static Ville instanciation(String pName, int pNbPeople, String pCountry, String pCapital) {
		try {
			//Créer les instances des Villes
			return new Capitale(pName, pNbPeople, pCountry, pCapital);
				
			}catch (NbHabitException e){
				System.out.println("\n\n\t\t" + e.getMessage() + "\n\n\n\t\t");
				return new Ville();
			}
	}
	public static Ville instanciation(){
		return new Ville();
	}
}
