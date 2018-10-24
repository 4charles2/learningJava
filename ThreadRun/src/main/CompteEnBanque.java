package main;

public class CompteEnBanque {
	private int solde = 100;
	private String name;
	
	public CompteEnBanque(String name) {
		this.name = name;
	}
	public synchronized void retraitArgent(int retrait) {
		this.solde -= retrait;
		System.out.println("Solde : " + this.solde);
	}
	public int getSolde() {
		if(this.solde < 0)
			System.out.println("Vous etes à découvert");
		
		return this.solde;
	}
	public String getName() {
		return this.name;
	}
}