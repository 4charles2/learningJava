/**
 * 
 */
package modulesPerso;

/**
 * <h1>Math Perso</h1>
 * Contient toutes les classes créer personnelement manipulant les nombres 
 * <h2>Liste Dans l'ordre de placement dans la classe</h2>
 * <ol>
 * 	<li>arrondi</li>
 * </ol>
 * 
 * @author charles
 *
 */
public class MathPerso {
	/**
	 * Return arrondi des deux paramètres
	 * @see MathPerso
	 * @param A Double
	 * @param B int
	 * @return double
	 */
	public static double arrondi(double A, int B) {
		return (double) ((int) (A * Math.pow(10, B) + .5)) / Math.pow(10, B);
	}
}
