package animal;

public class Chat extends Felin {
	
	public Chat(String color, int poids) {
		this.couleur = color;
		this.poids = poids;
	}
	public void crier() {
		show("Miaou Miaou");
	}
}