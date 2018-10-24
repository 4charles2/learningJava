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
				System.out.println("Retrait effectué sur le compte de " + cb.getName() + " par " + this.name);
				//System.out.println("Il vous reste = " + cb.getSolde());
			}
			cb.retraitArgent(4);
		}
		System.out.println("\n\nVotre solde après cette journée de solde réalise par !" + this.name);
		System.out.println("Il vous reste = " + cb.getSolde() + "\t M. " + cb.getName());
	}

}
