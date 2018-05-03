/**
 * 
 */
package enumeration;

/**
 * @author charles
 *
 */
public class ClassEnum {

	public static final int PARAM1 = 1;
	public static final int PARAM2 = 2;
	
	public void fait(Langage lang) {
		if (lang.equals(Langage.JAVA)) {
			show("you learn the java");
		}else if (lang.equals(Langage.JAVASCRIPT)){
			show("love JavaScript");
		}else {
			show("Sinon aimez le langage " + lang);
		}
	}
	public static void show(String str) {
		System.out.println(str);
	}

}
