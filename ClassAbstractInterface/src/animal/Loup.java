package animal;

public class Loup extends Canin {
	
	public Loup(String color, int poids) {
		this.couleur = color;
		this.poids = poids;
	}
	
	public void crier() {
		show("Haouuuuuuuuuuuu");
	}
}