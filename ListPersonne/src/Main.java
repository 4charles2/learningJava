import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.function.*;

public class Main {

	public static void main(String args[]) {
		List <Personne> lPers = Arrays.asList(
				new Personne(25, "toto"),
				new Personne(21, "TITI"),
				new Personne(18, "TATA"),
				new Personne(85, "MAMI")
			);
		List <String> listStr = new ArrayList<>();
		listStr.add("first elements");
		listStr.add("second elements");
		listStr.add("third elements");
		
		
		Predicate<Personne> predicate = (Personne p)->(p.getAge() > 20);
		for(Personne p : lPers)
			if(predicate.test(p))
				System.out.println(p.getName() + " à plus de 20 ans !");
		
		
		System.out.println("Les elements de la liste : " + listStr.get(1));
		
		Function<Personne, String> f1 = (Personne p)->p.getName();
		Function<Personne, Integer> f2 = (Personne p)->p.getAge();
		Function<Integer, Integer> f3 = (Integer a)-> a * 2;
		
		System.out.println("List des personne : " + lPers);
		System.out.println("List en String : " + transformToListString(lPers, f1));
		System.out.println("List en Int : " + transformToListInt(lPers, f2));
		System.out.println("traitement de la reponse de f2 en surchargeant la function : " + transformToListInt(lPers, f2.andThen(f3)));
		System.out.println("Meme traitement que le surcharge mais avec une pattern strategy et plus précisément une encapsulation : " + transformToListInt(lPers, f3.compose(f2)));
		
		List<String> listString = transformToListString(lPers, f1);
		List<Integer> listInteger = transformToListInt(lPers, f2);
		
		for(int index = 0 ; index < listString.size(); index++)
			System.out.println("Bonjour, Je m'appelle " + listString.get(index) + " et j'ai " + listInteger.get(index) + " ans");
		
		lPers.get(2).getName();
		
		//Function consumer va ajouter 13 ans aux personne
		System.out.println("Avant l'ajout des 13 années : " + lPers);
		Consumer<Personne> c = (Personne p)->p.setAge((p.getAge() + 13));
		for(Personne p : lPers)
			c.accept(p);
		
		System.out.println("Après l'ajout des 13 années : " + lPers);
		
		System.out.println("Faire un test par rapport à l'age des personnes : ");
		
		
	}
		public static List<String> transformToListString(List<Personne> pList, Function<Personne, String> pFunc) {
			List<String> lts = new ArrayList<>();
			
			for(Personne pers : pList)
				lts.add(pFunc.apply(pers));
			
			return lts;
		}
		public static List<Integer> transformToListInt(List<Personne> pList, Function<Personne, Integer> pFunc) {
			List<Integer> lts = new ArrayList<>();
			for(Personne pers : pList)
				lts.add(pFunc.apply(pers));
				
			return lts;
		}
}
