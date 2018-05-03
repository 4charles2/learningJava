/**
 * 
 */
package generecite;

/**
 * @author charles
 *
 */
public class Solo<T> {

	private T valeur;
	public Solo() {
		this.valeur = null;
	}
	public Solo(T pValeur) {
		this.setvaleur(pValeur);
	}
	private void setvaleur(T valeur) {
		this.valeur = valeur;
	}
	public T getvaleur() {
		return valeur;
	}
	public static void show(Object str) {
		System.out.println(str.toString());
	}
}
