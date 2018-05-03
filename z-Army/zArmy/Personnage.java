package zArmy;

public abstract class Personnage {
	protected String armes = "", chaussures = "", sacDeSoin = "";
  public void deplacement() {
	  show("Je me deplace à pied");
  };

  public void combattre() {
	  show("Je ne combat pas .");
  };
  public void soigner() {
	  show("Je ne soigne pas.");
  }
  
  protected static void show(String str) {
	  System.out.println(str);
  }

/**
 * @param armes the armes to set
 */
protected void setArmes(String armes) {
	this.armes = armes;
}

/**
 * @param chaussures the chaussures to set
 */
protected void setChaussures(String chaussures) {
	this.chaussures = chaussures;
}

/**
 * @param sacDeSoin the sacDeSoin to set
 */
protected void setSacDeSoin(String sacDeSoin) {
	this.sacDeSoin = sacDeSoin;
}

}