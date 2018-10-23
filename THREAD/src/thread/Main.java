package thread;

public class Main {

	public static void main(String[] args) {
		secondThread t = new secondThread("A");
		secondThread t2 = new secondThread(" B", t);
		secondThread t3 = new secondThread("C", t2);
		secondThread t4 = new secondThread("D", t3);
		secondThread t5 = new secondThread("E", t4);
		secondThread t6 = new secondThread("F", t5);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Status du Thread " + t.getName() + " = " + t.getState());
		System.out.println("Statut du thread " + t2.getName() + " = " + t2.getState());
		System.out.println("Statut du thread " + t2.getName() + " = " + t3.getState());
		System.out.println("Statut du thread " + t2.getName() + " = " + t4.getState());
		System.out.println("Statut du thread " + t2.getName() + " = " + t5.getState());
		System.out.println("Statut du thread " + t2.getName() + " = " + t6.getState());
	}
}
