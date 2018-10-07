package show;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ComposantVisuel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, 500, 800);
	}
}