package gateauChocolat;

public abstract class Couche extends Patisserie {
	protected Patisserie pat;
	protected String nom;
	
	public Couche(Patisserie P) {
		pat = P;
	}
	public String preparer() {
		String str = pat.preparer();
		return str + nom;
	}
}
