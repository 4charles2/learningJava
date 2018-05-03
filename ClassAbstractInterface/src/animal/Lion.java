package animal;

public class Lion extends Felin {
	
	public Lion(String color, int poids) {
		this.couleur = color;
		this.poids = poids;
	}
	public void crier() {
		show("HouaaaAAArrr");
	}
}