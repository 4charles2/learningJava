package zArmy;

import comportement.*;
import soin.Operation;

public class Chirurgien extends Personnage {

  public Chirurgien() {
	  this.soin = new Operation();
  }
  public Chirurgien(EspritCombatif pCombat, Deplacement pDeplacement, Soin pSoin) {
	  super(pCombat, pDeplacement, pSoin);
  }

}