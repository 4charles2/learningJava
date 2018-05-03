package instanceDynamique;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
/**
 * 
 * @param args
 */
	public static void main(String[] args) {
	/**
	 * <h1>Instanciation Dynamique</h1>
	 * instanciation d'un object sans utilisé l'opérateur new.
	 * 	
	 */
		//CRéation d'un objet pair sans utiliser l'opérateur new;
		Paire laPaire = new Paire("ha", "hou");
		
		System.out.println(laPaire);
		
		String nom = Paire.class.getName();
		System.out.println("Nom de la class instancier " + nom);
		try{
			Class cl = Class.forName(nom);
			Object o = cl.newInstance();
			
			Class types[] = new Class[] {String.class, String.class};
			
			Constructor ct = cl.getConstructor(types);
			
			Object o2 = ct.newInstance(new String[]{"nb One", "nb Two"});
			
			Method m = cl.getMethod("toString", null);
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Invocation de la méthode : " + m.getName() + " sur O2 : "+ m.invoke(o2,null));
			System.out.println("Invocation de la méthode : " + m.getName() + " sur o : " + m.invoke(o, null));
		}catch(SecurityException | IllegalArgumentException | ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException  e) {
			e.printStackTrace();
		}
	}

}
