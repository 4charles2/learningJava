
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Fenetre();
	}
	
	private JPanel container = new JPanel();
	private JPanel containeButton = new JPanel();
	private Panneau pan = new Panneau();
	private MyButton go = new MyButton("Go");
	private JButton stop = new JButton("Stop");
	private JLabel label = new JLabel("My Game");
	
	private Boolean animated = true;
	private Boolean backX = false, backY = false;
	private int x = pan.getPosX(), y = pan.getPosY();
	
	 private Thread t;
	
	public Fenetre() {
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		container.setLayout(new BorderLayout());
		
		Font police = new Font("AR CENA", Font.BOLD, 16);
		
		label.setFont(police);
		label.setForeground(Color.BLUE);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		go.addActionListener(new listenerGo());
		go.setEnabled(false);
		stop.addActionListener(new  listenerStop());
		
		containeButton.add(this.go);
		containeButton.add(this.stop);
		
		container.add(this.containeButton, BorderLayout.SOUTH);
		container.add(label, BorderLayout.NORTH);
		container.add(this.pan,BorderLayout.CENTER);
		
		
		
		this.setContentPane(container);
		this.setVisible(true);

		go();
	}
	public class listenerMeButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
//			label.setText("Nb de click : " + ++this.compteur);
			label.setText("Vous avez sur le boutton 1");
		}
	}
	public class listenerGo implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			animated = true;
			go.setEnabled(false);
			stop.setEnabled(true);
			go();
		}
	}
	
	class listenerStop implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			animated = false;
			go.setEnabled(true);
			stop.setEnabled(false);
		}
	}
	private void go() {
		

		// Dans cet exemple, j'utilise une boucle while
		// Vous verrez qu'elle fonctionne très bien
		while (animated) {
			// Si la coordonnée x est inférieure à 1, on avance
			if (x < 1)
				backX = false;
			// Si la coordonnée x est supérieure à la taille du Panneau moins la taille du rond, on recule
			if (x > pan.getWidth() - 50)
				backX = true;
			// Idem pour l'axe y
			if (y < 1)
				backY = false;
			if (y > pan.getHeight() - 50)
				backY = true;

			// Si on avance, on incrémente la coordonnée
			// backX est un booléen, donc !backX revient à écrire
			// if (backX == false)
			if (!backX)
				pan.setPosX(++x);
			// Sinon, on décrémente
			else
				pan.setPosX(--x);
			// Idem pour l'axe Y
			if (!backY)
				pan.setPosY(++y);
			else
				pan.setPosY(--y);

			// On redessine notre Panneau
			pan.repaint();
			// Comme on dit : la pause s'impose ! Ici, trois millièmes de seconde
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public class BoutonListener implements ActionListener{
	    public void actionPerformed(ActionEvent arg0) {
	      animated = true;
	      t = new Thread(new PlayAnimation());
	      t.start();
	      go.setEnabled(false);
	      stop.setEnabled(true);
	    }
	  }

	  class Bouton2Listener  implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	      animated = false;       
	      go.setEnabled(true);
	      stop.setEnabled(false);
	    }
	  }
	  class PlayAnimation implements Runnable{
		    public void run() {
		      go();                   
		    }               
		  }      
}
