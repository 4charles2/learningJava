package modulesPerso;

public class texte {
	static void parcourirTab(String[] str) {
		for(String ChStr : str) {
			System.out.println(ChStr);
		}
	}
	static String toString(String[] str ) {
		System.out.println("Méthode toString() !\n------------");
		String retour = "";
		
		for(String ChStr : str) {
			retour += ChStr;
		}
		return retour;
	}
}
