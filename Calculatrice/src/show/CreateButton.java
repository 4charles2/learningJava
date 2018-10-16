package show;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;

public class CreateButton extends JButton {
	
	private static final long serialVersionUID = 1L;
	
	public List<CreateButton> lButtons = new LinkedList<CreateButton>();
	
	public CreateButton() {
		super();
	}
	
	public CreateButton(String str) {
		super(str);
	}
	/**
	 * Prend le nombre de boutons à créer
	 * @param nb
	 */
	public void ListButtons(int nb) {
		for(int i = nb; i >= 0; i--)
			lButtons.add(new CreateButton(Integer.toString(i)));
	}
	public void ListButtons(String str) {
		lButtons.add(new CreateButton(str));
	}
}