package zArmy;

import combat.CombatCouteau;
import comportement.*;

public class Guerrier extends Personnage {

  public Guerrier() {
	  this.combat = new CombatCouteau();
  }
  public Guerrier(EspritCombatif pCombat, Deplacement pDeplacement, Soin pSoin) {
	  super(pCombat, pDeplacement, pSoin);
  }

}