package zArmy;

import comportement.*;
import deplacement.Marcher;
import soin.AucunSoin;
import soin.Pacifiste;
/**
 * 
 * @author charles
 *
 */
public abstract class Personnage {

  protected EspritCombatif combat = new Pacifiste();

  protected Deplacement deplacement = new Marcher();

  public Soin soin = new AucunSoin();

  public Personnage() {
	  
  }
  /**
   * contruct class personnage
   * @param pCombat
   * @param pDeplacement
   * @param pSoin
   */
  public Personnage(EspritCombatif pCombat, Deplacement pDeplacement, Soin pSoin) {
	  this.combat = pCombat;
	  this.deplacement = pDeplacement;
	  this.soin = pSoin;
  }
  public void seDeplacer() {
	  deplacement.deplacer();
  }

  public void combattre() {
	combat.combat();  
  }

  public void soigner() {
	  soin.soigner();
  }
  public void description() {
	  System.out.println("\n\tJe suis " + this.getClass().getName());
	  this.seDeplacer();
	  this.combattre();
	  this.soigner();
  }
/**
 * @param combat the combat to set
 */
public void setCombat(EspritCombatif combat) {
	this.combat = combat;
}
/**
 * @param deplacement the deplacement to set
 */
public void setDeplacement(Deplacement deplacement) {
	this.deplacement = deplacement;
}
/**
 * @param soin the soin to set
 */
public void setSoin(Soin soin) {
	this.soin = soin;
}

}