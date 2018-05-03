package animal;

abstract class Animal {

	protected String couleur;
	protected int poids;
	
	protected void manger() {
		show("je mange de la viande");
	}

	protected void boire() {
		show("Je bois de l'eau");
	}

	abstract void deplacement();

	abstract void crier();
	
	protected static void show(String str) {
		System.out.println(str);
	}
	
	public String toString() {
		return "Je suis un " + this.getClass() + " de couleur " + this.getCouleur() + " et je pese " + this.getPoids() + "Kg";
	}
	/**
	 * @return the poids
	 */
	public int getPoids() {
		return poids;
	}

	/**
	 * @param poids the poids to set
	 */
	public void setPoids(int poids) {
		this.poids = poids;
	}

	/**
	 * @return the couleur
	 */
	public String getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

}