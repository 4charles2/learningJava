package java8;

public interface Pondre extends Reproduction{
	public static void description() {
		Reproduction.description();
		System.out.println("Redefinie dans Pondre.java");
	}
	default void reproduire() {
		System.out.println("\tJe ponds des oeufs !");
	}
}
