package learningVoiture;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		List<Voiture> maGive = new ArrayList<Voiture>();
		
		List<VoitureSansPermis> voitureSP = new ArrayList<VoitureSansPermis>();
				
		maGive.add(new Voiture("Citroen", "DS3", "Essence", 135));
		maGive.add(new Voiture("Peugeot", "3008", "Essence", 165));
		maGive.add(new VoitureSansPermis("peugeot", "Flamby","Essence", 5));
		
		voitureSP.add(new VoitureSansPermis("OXAM", "Yogourt", "Melange", 5));
		afficher(maGive);
		afficher(voitureSP);
		
		System.out.println("--------------------------------------------------------------------------\n"+
					       "------------------Gestion des voitures dans le garage : ------------------\n" +
					       "--------------------------------------------------------------------------");
		
		Garage myGarage = new Garage();
		myGarage.add(maGive);
		myGarage.add(voitureSP);
		
		myGarage.storeShow();
	}
	public static void afficher(List<? extends Voiture> ourGive) {
		for(Voiture Car : ourGive)
			System.out.println("La nouvelle voiture est " + Car + "\n");
	}
}
