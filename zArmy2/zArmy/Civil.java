package zArmy;

import comportement.*;

public class Civil extends Personnage {
	public Civil() {}
	public Civil(EspritCombatif pCombat, Deplacement pDeplacement, Soin pSoin) {
		super(pCombat, pDeplacement, pSoin);
	}
}