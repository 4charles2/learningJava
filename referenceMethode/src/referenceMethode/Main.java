package referenceMethode;

import java.util.function.Consumer;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class Main {

	public static void main(String[] args) {
		
		ToDoubleFunction<String> stringToDoubleLambda = (s) -> Double.parseDouble(s);
		ToDoubleFunction<String> stringToDoubleRef = Double::parseDouble;
		System.out.println(stringToDoubleLambda.applyAsDouble("2.4567"));
		System.out.println(stringToDoubleRef.applyAsDouble("15.789"));
		
		//Utilisation d'une référence à une méthode d'instance(println)
		//de l'instance out de la class system
		Consumer<String> stringPrinterLambda = (s) -> System.out.println(s);
		Consumer<String> stringPrinterRef = System.out::println;
		
		System.out.print("avec Lambda : ");
		stringPrinterLambda.accept("show text ! ");
		System.out.print("avec Reference : ");
		stringPrinterRef.accept("show text ! ");
		
		//Utilisation d'un constructeur 
		//L'interface functionnel devient une fabrique de int
		ToIntFunction<String> testNew = Integer::new;
		Integer i = testNew.applyAsInt("12345");
		System.out.println("New Integer Creates : " + i.getClass() + i);
	}

}
