package collection;

import java.util.ListIterator;
import java.util.LinkedList;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;

public class main {

	public static void main(String[] args) {
		
		System.out.println("-------------------------ArrayList---------------------");
		    ArrayList al = new ArrayList();
		    al.add(12);
		    al.add("Une cha�ne de caract�res !");
		    al.add(12.20f);
		    al.add('d');
		                
		    for(int i = 0; i < al.size(); i++)
		    {
		      System.out.println("donn�e � l'indice " + i + " = " + al.get(i));
		    }               
		    	System.out.println("-------------------------LinkedList---------------------");
		List maList = new LinkedList();
		maList.add(1);
		maList.add("Fuck the World");
		maList.add(5);
		maList.add(15.56f);
		
		for(int i = 0; i < maList.size(); i++) {
			System.out.println("Valeur de l'�l�ment � l'index "+  i + " et sa valeur : " +  maList.get(i));
		}
		ListIterator iterator = maList.listIterator();
		
		while(iterator.hasNext())
			System.out.println(iterator.next());
		System.out.println("-------------------------HashTable---------------------");
		Hashtable hsTable = new Hashtable();
		hsTable.put(12, "Valeur de la c� 12");
		hsTable.put(21, "Valeur de cl� 21");
		hsTable.put(35, "Cl� 65");
		
		Enumeration e = hsTable.elements();
		while(e.hasMoreElements())
			System.out.println("�lement : " + e.nextElement());
		
		System.out.println("-------------------------Table HashSet---------------------");
		HashSet hs = new HashSet();
		
		hs.add(34);
		hs.add("element String");
		hs.add(15.56f);
		hs.add(null);
		
		Iterator it = hs.iterator();
		
		while(it.hasNext())
			System.out.println("Valeurs de l'�lement : " + it.next());
		
		System.out.println("Parcours avec un tableau d'objet qui contienne les elements de la HashSet : ");
		System.out.println("----------------------------------------------------------------------------");
		
		HashSet sh = new HashSet();
		sh.add(95);
		sh.add("Second HashSet");
		sh.add(95);
		sh.add(105);
		sh.add("Coucou petit colibrie");
		sh.remove("Second HashSet");
		Object [] obj = sh.toArray();
		for(Object o : obj)
			System.out.println(o);
		
		
			
	}
}
