package controlException;

/**
 * @author charles
 *
 */
public class NbHabitException extends Exception{ 
	  public NbHabitException(){
		  super("Vous essayez d'instancier une classe Ville avec un nombre d'habitants n�gatif !");
	  }  
	  public NbHabitException(int pNbre) {
		  super("Vous essayer d'instancier une classe ville avec un nombre d'habitant n�gatif ! \n\t" + pNbre);
	  }
	}