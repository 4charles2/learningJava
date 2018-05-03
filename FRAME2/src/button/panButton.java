package button;

import java.awt.Dimension;
import java.util.Collection;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class panButton {
	private Hashtable<String,MeButton> lButtons = new Hashtable<String,MeButton>();
	
	public panButton() {
		lButtons.put("exit",new MeButton("Exit"));
		lButtons.put("stop",new MeButton("Stop"));
		lButtons.put("go",new MeButton("Go"));
		

		
		lButtons.forEach((x,y)->setView(y));
	}
	private void setView(MeButton elmt) {
		elmt.setBorder(BorderFactory.createRaisedBevelBorder());
		elmt.setMaximumSize(new Dimension(50, 50));
	}
	public Collection<MeButton> getlButtons(){
		return this.lButtons.values();
	}
}
