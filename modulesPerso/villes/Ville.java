package villes;

import java.util.Objects;
import controlException.NbHabitException;

/**
 * @author charles
 * 
 *
 */
public class Ville {
		
	//Variable de classe
	private static int nbInstances;
	
	//Variable d'instance
	private String name;
	private String country;
	private int nbPeople;
	private char category;
	/**
	 * constructeur sans parametre
	 * @see Ville
	 */
	public Ville() {
		System.out.println("Création d'une Ville !");
		name = "Inconnue";
		country = "Inconnu";
		nbPeople = 0;
		category = '?';
		nbInstances++;
	}
	/**
	 * constructeur de la class Ville
	 * avec les params suivants
	 * @param nomVille
	 * @param nbHabitants
	 * @param nomPays
	 * 
	 * 
	 * @return void
	 * 
	 * @see Ville
	 * 
	 * @author charles
	 */
	public Ville(String pNomVille, int pNbHabitants, String pNomPays) throws NbHabitException {
		
		if (pNbHabitants < 0) {	
			throw new NbHabitException(pNbHabitants);
		}else {
			System.out.println("Création d'une Ville avec paramètre !");
			name = pNomVille;
			country = pNomPays;
			this.setNbPeople(pNbHabitants);
			nbInstances++;
		}
	}
	public void compareVille(Ville v1) {
		String reponse[] = new String[2];
		if(this.getNbPeople() > v1.getNbPeople()) {
			reponse[0] = this.getName();
			reponse[1] = v1.getName();
		}
		else {
			reponse[0] = v1.getName();
			reponse[1] = this.getName();
		}
		System.out.println("La ville " + reponse[0] + " est plus grande que " + reponse[1]);
	}
	//Parcourir toutes les instances d'une classe
	/*
	 * public void parcours(){
		for(Ville ville : Self) {
			ville.getValeurs();
		}
	}
	*/
	/**
	 * <h2>Les mutateurs</h2>
	 * <cite>Modifie les variables de l'instance</cite> 
	 */

	private void setCategory() {
		int pNbPeople = getNbPeople();
		
		if (pNbPeople > 1000000) {
			category = 'E';
		}else {
			for (int index = 0; (pNbPeople/=10)>9;index++)
				category = (char) (60+index+4);
		}
	}
	public void setAll(String pName, int pNbPeople, String pCountry) {
		this.setName(pName);
		this.setNbPeople(pNbPeople);
		this.setCountry(pCountry);
		this.setCategory();
	}
	public void setNbPeople(int pNbPeople)
	{
		nbPeople = pNbPeople;
		this.setCategory();		
	}
	public void setName(String pName) {
		name = pName;
	}
	public void setCountry(String pCountry) {
		country = pCountry;
	}
	/**
	 * <h2>Les accesseurs</h2>
	 * <cite>Affiche toutes les variables de l'instance 
	 * une à une ligne par ligne</cite>
	 */
	public String toString() {
		return "\tLa Ville de : " + this.getName() + 
		" en " + this.getCountry() + 
		" contient " + this.getNbPeople() + 
		" habitant.\n\t Elle est donc de catégorie : " + this.getCategory();
	}
	public int getNbPeople() {
		return nbPeople;
	}
	public String getName() {
		return name;
	}
	public String getCountry() {
		return country;
	}
	public char getCategory() {
		return category;
	}
	public static int getNbInstances() {
		return nbInstances;
	}
	public static void show(String text) {
		System.out.println(text);
	}
	/* 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.category, this.nbPeople, this.country, this.name);
	}
	public boolean equals(Object obj) {
		  //On vérifie si les références d'objets sont identiques
		  if (this == obj)
		    return true;

		  //On s'assure que les objets sont du même type, ici de type Ville
		  if (getClass() != obj.getClass())
		    return false;
			
		  //Maintenant, on compare les attributs de nos objets
		  Ville other = (Ville) obj;

		  return Objects.equals(other.getCategory(), this.getCategory()) &&
			 Objects.equals(other.getName(), this.getName()) &&
			 Objects.equals(other.getNbPeople(), this.getNbPeople()) &&
			 Objects.equals(other.getCountry(), this.getCountry());
		}
}

