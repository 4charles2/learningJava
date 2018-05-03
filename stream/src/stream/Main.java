package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<Personne> listP = Arrays.asList(
					new Personne(1.80, (double)70, "A", "Nicolas", Couleur.BLEU),
					new Personne(1.56, (double)50, "B", "Nicole", Couleur.VERRON),
					new Personne(1.75, (double)65, "C", "Germain", Couleur.VERT),
					new Personne(1.68, (double)50, "D", "Michel", Couleur.ROUGE),
					new Personne(1.96, (double)65, "E", "Cyrille", Couleur.BLEU),
					new Personne(2.10, (double)120, "F", "Denis", Couleur.ROUGE),
					new Personne(1.90, (double)90, "G", "Olivier", Couleur.VERRON)
				);
		
		Stream<Personne> sp = listP.stream();
		sp.forEach(System.out::println);
		//LE stream à été consommer par forEach
		//On ne pourra plus exercer d'action dessus après sans devoir en recréer un
		Stream.iterate(1, (x) -> x + 1).limit(10).forEach(System.out::println);
		
		//Recréation du stream car l'ancien à été consomer
		sp = listP.stream();
		sp.filter(x -> x.getPoids() > 50)
			.forEach(System.out::println);
		//La même opération mais on ne conservant que les données qui nous interesse
		sp = listP.stream();
		sp.filter((x) -> x.getPoids() > 50)
				.map(x -> x.getPrenom() + " qui pese : " + x.getPoids())
				.forEach(System.out::println);
		
		System.out.println("\n Addition de tous les poids trier : ");
		sp = listP.stream();
		Double sum = sp.filter(x -> x.getPoids() > 50)
				.map(x -> x.getPoids())
				.reduce(0.0d, (x,y) -> x+y);
		System.out.println(sum);
		
		System.out.println("\n Après le filtre et le map et reduce");
		sp = listP.stream();
		
		Optional<Double> reduce = sp .filter(x -> x.getPoids() > 250)
									.map(x->x.getPoids())
									.reduce((x,y) -> x+y);
		if(reduce.isPresent())
			System.out.println(reduce);
		else
			System.out.println("Aucun aggrégat de poids...");
		//Permet de gérer le cas d'erreur en renvoyant 0.0 si isPresent() == false
		System.out.println(reduce.orElse(0.0));
		//count compte le nombre d'elements restant après les opérations précédentes
		sp = listP.stream();
		long count = sp .filter(x -> x.getPoids() > 50)
					.map(x -> x.getPoids())
					.count();
		System.out.println("Nombre d'éléments : " + count);
		
		String fileName = "C:/Users/charles/eclipse-workspace/JAVA/stream/dictionnaire.txt";
		//Files.lines(Paths.get(fileName)
		try(Stream<String> sf = Files.lines(Paths.get(fileName))){
			sf.forEach(System.out::println);
		}catch(IOException e) {
			e.getMessage();
			e.getCause();
			e.printStackTrace();
		}
	}
}
