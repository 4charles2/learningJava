package main;

public class RunImpl implements Runnable {
	
	private CompteEnBanque cb;
	private String name;
	
	public RunImpl(CompteEnBanque cb, String name) {
		this.cb = cb;
		this.name = name;
	}
	
	public void run() {
		for(int i = 0; i < 25; i++) {
			if(cb.getSolde() > 0) {
				
				cb.retraitArgent(2);
				System.out.println("Retrait effectu� sur le compte de " + cb.getName() + " par " + this.name);
				//System.out.println("Il vous reste = " + cb.getSolde());
			}
			cb.retraitArgent(4);
		}
		System.out.println("\n\nVotre solde apr�s cette journ�e de solde r�alise par !" + this.name);
		System.out.println("Il vous reste = " + cb.getSolde() + "\t M. " + cb.getName());
	}

}
