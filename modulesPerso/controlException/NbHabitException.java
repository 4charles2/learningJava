package controlException;

/**
 * @author charles
 *
 */
public class NbHabitException extends Exception{ 
	  public NbHabitException(){
		  super("Vous essayez d'instancier une classe Ville avec un nombre d'habitants négatif !");
	  }  
	  public NbHabitException(int pNbre) {
		  super("Vous essayer d'instancier une classe ville avec un nombre d'habitant négatif ! \n\t" + pNbre);
	  }
	}