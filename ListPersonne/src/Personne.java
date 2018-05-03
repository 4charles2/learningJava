
public class Personne {
	String name;
	int age;
	public Personne(int age, String name) {
		this.age = age;
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return "#Nom : " + this.getName() + " - âge : " + this.getAge();
	}
}
