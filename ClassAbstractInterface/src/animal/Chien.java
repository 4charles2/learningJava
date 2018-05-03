package animal;

public class Chien extends Canin implements rintintin{
	
	public Chien(String color, int poids) {
		this.couleur = color;
		this.poids = poids;
	}

	
	public Chien() {
	}
	public void crier() {
		show("houaf houaf");
	}
	public void faireLeBeau() {
		show("Je fais le beau sur une patte");
	}
	public void faireCalin() {
		show("Je te fait de gros calin");
	}
	public void faireLechouille() {
		show("Je te lechouille partout");
	}
	
}