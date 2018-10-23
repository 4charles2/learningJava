package thread;

public class secondThread extends Thread{
	Thread t;
	public secondThread(String name) {
		super(name);
		System.out.println("status du thread " + name + " = " + this.getState());
		this.start();
		System.out.println("statut du thread " + name + " = " + this.getState());
	}
	
	public secondThread(String name, Thread t) {
		super(name);
		this.t = t;
		System.out.println("statut du thread " + name + " = " + this.getState());
		this.start();
		System.out.println("status du thread " + name + " = " + this.getState());
	}
	public void run() {
		for(int i=0; i < 10; i++)
			System.out.println("Le nom du Thread " + this.getName() + " and Status " + this.getState());
		if(t != null)
			System.out.println("Le statut de " + t.getName() + "pendant le Thread de " + this.getName() + " = " + t.getState());
	}
	public void setThread(Thread t) {
		this.t = t;
	}
}
