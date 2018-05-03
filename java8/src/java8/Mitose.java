package java8;

public interface Mitose extends Reproduction{
	public static void description() {
		Reproduction.description();
		System.out.println("Redefinie dans Mitose.java");
	}
	default void reproduire() {
		System.out.println("\tJe me divise ! ");
	}
}
