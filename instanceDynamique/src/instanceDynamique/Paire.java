package instanceDynamique;

public class Paire {
	private String value1;
	private String value2;
	public Paire() {
		this.value1 = null;
		this.value2 = null;
		System.out.println("Instanciation !");
	}
	/**
	 * @param value1
	 * @param string
	 */
	public Paire(String value1, String value2) {		
		this.setValue1(value1);
		this.setValue2(value2);
		System.out.println("Instanciation avec paramètre !");
	}
	/**
	 * @return the value1
	 */
	public String getValue1() {
		return value1;
	}
	/**
	 * @param value1 the value1 to set
	 */
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	/**
	 * @return the value2
	 */
	public String getValue2() {
		return value2;
	}
	/**
	 * @param value2 the value2 to set
	 */
	public void setValue2(String value2) {
		this.value2 = value2;
	}
	
	public String toString() {
		return "Je suis un objet qui à pour valeur " + this.value1 + " est " + this.value2;
	}
	
}
