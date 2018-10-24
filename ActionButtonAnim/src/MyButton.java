import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class MyButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private Image img;
	public MyButton(String text) {
		super(text);
		this.nom = text;
		try {
			img = ImageIO.read(new File("blueButton.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		GradientPaint gd = new GradientPaint(0,0, Color.blue, 0, 20, Color.CYAN, true);
		g2D.setPaint(gd);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		g.setColor(Color.BLACK);
		g.drawString(this.nom, this.getWidth() / 2 - (this.getWidth()/ 2 /4), (this.getHeight() / 2) + 5);
	}
	/*@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		try {
		img = ImageIO.read(new File("greenButton.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		try {
			img = ImageIO.read(new File("blueButton.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		try {
			img = ImageIO.read(new File("yelowButton.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(arg0.getX() > 0 && arg0.getX() < this.getWidth() && arg0.getY() > 0 && arg0.getY() < this.getHeight() ) {
			
			try {
				img = ImageIO.read(new File("greenButton.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				img = ImageIO.read(new File("blueButton.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}			
		}
	}*/
	
}
