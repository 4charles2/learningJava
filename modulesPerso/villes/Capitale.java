/**
 * 
 */
package villes;

import java.util.Objects;
import controlException.NbHabitException;

/**
 * @since Ville
 * @author charles
 */
public class Capitale extends Ville {
	
	private String monument;
	
	public Capitale() {
		super();
		monument = "aucun";
	}
	/**
	 * constructeur de la classe Capitale
	 * extend Ville
	 * 
	 * @param pName
	 * param de la classe mère
	 * @param pNbPeople
	 * param de la classe mère
	 * @param pCountry
	 * param de la classe mère
	 * @param pMonument
	 * param de Capitale
	 */
	public Capitale(String pName, int pNbPeople, String pCountry, String pMonument) throws NbHabitException{
		super(pName, pNbPeople, pCountry);
		 this.setMonument(pMonument);
	}
	/**
	 * return le nom du monument
	 * @return String monument
	 */
	public String getMonument() {
		return this.monument;
	}
	/**
	 * return la description de la capitale
	 * @return String description 
	 */
	public String toString() {
		return super.toString() + 
			"\n\t Sont monument est " + this.monument;
	}
	public void setMonument(String pMonument) {
		this.monument = pMonument;
	}
	/* 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.getCategory(), this.getNbPeople(), this.getCountry(), this.getName(), this.getMonument());
	}
}
