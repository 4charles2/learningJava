/**
 * 
 */
package enumeration;

/**
 * @author charles
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassEnum fake = new ClassEnum();
		fake.fait(Langage.JAVA);
		fake.fait(Langage.JAVASCRIPT);
		fake.fait(Langage.PHP);
		
		for (Langage lang : Langage.values()) {
			if (Langage.JAVA.equals(lang)) {
				System.out.println("J'aime le " + lang);
				lang.getEditor();
			}else {
				System.out.println(lang);
				lang.getEditor();
			}
		}
	}

}
