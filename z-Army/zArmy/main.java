package zArmy;
/**
 * 
 */

/**
 * @author charles
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			  Personnage[] tPers = {new Guerrier(), new Chirurgien(), new Civil(), new Sniper(), new Medecin()};
			  String[] tArmes = {"pistolet", "pistolet", "couteau", "fusil à pompe", "couteau"}; 

			  for(int i = 0; i < tPers.length; i++){
			    System.out.println("\nInstance de " + tPers[i].getClass().getName());
			    System.out.println("*****************************************");
			    tPers[i].combattre();
			    tPers[i].setArmes(tArmes[i]);
			    tPers[i].combattre();
			    tPers[i].deplacement();
			    tPers[i].soigner();
			  }		
			  Personnage[] tPers1 = {new Guerrier(), new Chirurgien(), new Civil(), new Sniper(), new Medecin()};

			  for(Personnage p : tPers1){
			    System.out.println("\nInstance de " + p.getClass().getName());
			    System.out.println("***************************************");
			    p.combattre();
			    p.deplacement();
			  }		
	}

}
