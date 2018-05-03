package zArmy;

import comportement.*;
import soin.PremierSoin;

public class Medecin extends Personnage {

  public Medecin() {
	  this.soin = new PremierSoin();
  }
  public Medecin(EspritCombatif pCombat, Deplacement pDeplacement, Soin pSoin) {
	  super(pCombat, pDeplacement, pSoin);
  }

}