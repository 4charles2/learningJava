package main;

public class testThread {

	public static void main(String agrs[]) {
		CompteEnBanque cb = new CompteEnBanque("charles");
		Thread t = new Thread(new RunImpl(cb, "maman"));
		Thread t2 = new Thread(new RunImpl(cb, "femme"));
		t.start();
		t2.start();
	}
}