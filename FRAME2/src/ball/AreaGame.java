package ball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class AreaGame extends JPanel{
	private int posX = 0;
	private int posY = 0;
	
	private List<Ball> balls = new ArrayList<Ball>();
	/**
	 * Creer l'air de jeu avec une balle
	 */
	public AreaGame() {
		balls.add(new Ball(0,0));
	}
	/**
	 * Creer l'air de jeu avec le nombre de balle en parametre
	 * @param nbBall
	 */
	public AreaGame(int nbBall) {
		for(int i = 0; i < nbBall; i++)
			balls.add(new Ball(this.getWidth(), this.getHeight()));
	}
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g.setColor(Color.gray);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2.setColor(Color.RED);
		balls.forEach((x)->{x.mvtBall(g,  this.getWidth(), this.getHeight());});
//		balls.forEach((x)->{x.smach(balls);});
		//TODO	pour degrader sur la balle a réglé
		//    g2.setPaint(new GradientPaint(0, 0, Color.black, 10,10,Color.WHITE, true));
	}
	public int getPosX() {
		return this.posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return this.posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}     
}
