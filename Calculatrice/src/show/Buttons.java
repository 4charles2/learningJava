package show;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;

public class Buttons extends JButton {
	
	private static final long serialVersionUID = 1L;
	
	public List<Buttons> lButtons = new LinkedList<Buttons>();
	
	public Buttons() {};
	
	public Buttons(String str) {
		super(str);
	}
	/**
	 * Prend le nombre de boutons à créer
	 * @param nb
	 */
	public void ListButtons(int nb) {
		for(int i = 0; i < nb; i++)
			lButtons.add(new Buttons(Integer.toString(i)));
	}
	public void ListButtons(String str) {
		lButtons.add(new Buttons(str));
	}
}