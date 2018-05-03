package animal;
/**
 * @author charles
 *
 */
public class main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal animaux[] = new Animal[5];
		animaux[0] = new Loup("Gris bleuté", 85);
		animaux[1] = new Chien("Beige", 35);
		animaux[2] = new Tigre("roux3Couleur", 95);
		animaux[3] = new Lion("Roux", 100);
		animaux[4] = new Chat("Blanc", 8);
		
		for (Animal ani : animaux) {
			Animal.show("\n\t"+ani.toString());
			ani.crier();
			ani.deplacement();
			ani.manger();
			ani.boire();
			
			if (ani instanceof Chien) {
				((Chien) ani).faireCalin();
				((Chien) ani).faireLeBeau();
				((Chien) ani).faireLechouille();
			}
			Animal.show("------------------------\n------------------------\n------------------------\n------------------------");
			rintintin r = new Chien();
			r.faireCalin();
			r.faireLeBeau();
			r.faireLechouille();
		}
		
	}
}
