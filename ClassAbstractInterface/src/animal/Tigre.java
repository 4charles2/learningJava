package animal;

public class Tigre extends Felin {
	
	public Tigre(String color, int poids) {
		this.couleur = color;
		this.poids = poids;
	}
	
	
	
	public void crier() {
		show("GrrrrOOOaaa");
	}
}