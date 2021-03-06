package show;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelStaple extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		g.drawRect(0, 0, this.getWidth(), 200);
		try {
			Image img = ImageIO.read(new File("ecran.jpg"));
			g.drawImage(img,0, 0, this.getWidth(), 200, this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
