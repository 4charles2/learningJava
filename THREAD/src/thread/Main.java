package thread;

public class Main {

	public static void main(String[] args) {
		System.out.println("Le nom du Thread principal est " + Thread.currentThread().getName());
		secondThread t1 = new secondThread("thread one");
		secondThread t2 = new secondThread("thread two");
		secondThread t3 = new secondThread("thread tree");
		secondThread t4 = new secondThread("thread four");
		secondThread t5 = new secondThread("thread five");
		secondThread t6 = new secondThread("thread six");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}
