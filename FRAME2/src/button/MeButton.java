package button;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

public class MeButton extends JButton {
	private String text;
	public MeButton(String pTitle) {
		super(pTitle);
		this.text = pTitle;
		super.setSize(50, 50);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		GradientPaint gpBrown, gpDarkBrown, gpBlack, gpEnd;
		Color DarkBrown = new Color(75, 57, 50);
		Color Brown = new Color(138,67,3);
		
		gpBlack = new GradientPaint(0,0, Color.black, 0, 2, DarkBrown);
		gpDarkBrown = new GradientPaint(0,2, DarkBrown, 0, 25, Brown);
		gpBrown = new GradientPaint(0,30, Brown, 0, this.getHeight() - 2, DarkBrown);
		gpEnd = new GradientPaint(0, this.getHeight() - 2, DarkBrown, 0, this.getHeight(), Color.black);
		
		g2.setPaint(gpBlack);
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2.setPaint(gpDarkBrown);
		g2.fillRect(0, 3, this.getWidth(), this.getHeight());
		g2.setPaint(gpBrown);
		g2.fillRect(0,30, this.getWidth(), this.getHeight());
		g2.setPaint(gpEnd);
		g2.fillRect(0, this.getHeight() - 2, this.getWidth(), this.getHeight());
		g.setColor(Color.white);
		g.drawString(this.text,this.getWidth()/4, this.getHeight()/2 );
		//gpWhite = new GradientPaint();
		//	Ecrit du texte au coordonnées x y
		//		g.drawString("go", this.getWidth()/2, this.getHeight()/2);
	}
}
