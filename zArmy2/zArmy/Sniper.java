package zArmy;

import combat.CombatPistolet;
import comportement.*;

public class Sniper extends Personnage {
	public Sniper() {
		this.combat = new CombatPistolet();
	};
	public Sniper(EspritCombatif pCombat, Deplacement pDeplacement, Soin pSoin) {
		  super(pCombat, pDeplacement, pSoin);
	  }
}