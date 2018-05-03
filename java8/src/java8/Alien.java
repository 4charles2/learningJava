package java8;

public class Alien implements Pondre, Mitose{
	
	public void reproduire() {
		System.out.println("Je suis un alien est : ");
		Pondre.super.reproduire();
		Mitose.super.reproduire();
	}
}
