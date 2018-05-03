package lambdas;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		//(a, b) -> {System.out.println("Je suis une lamdas qui retourne l'addition de paramètre"); return a + b};
		//Avec une class anonyme
		Dialoguer d = new Dialoguer() {
			public void parler(String question) {
				System.out.println("Vous avez demander " + question);
			}
		};
		
		d.parler("Quel temps fait-il aujourd'hui.");
		//Avec une lambdas
		Dialoguer d2 = (s)->{ System.out.println("Votre question : " + s); };
		d2.parler("Were is the Kitchen ?");
		
		AnonymClass maClass = new AnonymClass();
		
		maClass.testAnonymMethod();
		
		//Polymorphe de la méthode avec une class anonyme
		maClass = new AnonymClass(){
				public void testAnonymMethod() {
					System.out.println("Texte Modifier !");
				};
		};
		
		maClass.testAnonymMethod();
		
		//Avec une surcharge de la méthode
		maClass = new AnonymClass(){
			public void testAnonymMethod(String str) {
				System.out.println("Texte Modifier !" + str);
			}
	};
	
	maClass.testAnonymMethod("Avec une surcharge");
	maClass.testAnonymMethod();
	}
}
