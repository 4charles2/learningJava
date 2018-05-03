
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

	public static void main(String[] args) {
		new Fenetre();
	}
	private JPanel container = new JPanel();
	private JPanel containeButton = new JPanel();
	private Panneau pan = new Panneau();
	private MyButton meButton = new MyButton("mon button");
	private JButton button = new JButton("2But");
	private JLabel label = new JLabel("Litle label");
	private int compteur = 0;
	public Fenetre() {
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setLayout(new BorderLayout());
		
		Font police = new Font("AR CENA", Font.BOLD, 16);
		
		label.setFont(police);
		label.setForeground(Color.BLUE);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		meButton.addActionListener(new listenerMeButton());
		button.addActionListener(new  listenerButton());
		
		containeButton.add(this.meButton);
		containeButton.add(this.button);
		
		container.add(this.containeButton, BorderLayout.SOUTH);
		container.add(label, BorderLayout.NORTH);
		container.add(this.pan,BorderLayout.CENTER);
		
		
		
		this.setContentPane(container);
		this.setVisible(true);

		go();
	}
	class listenerMeButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
//			label.setText("Nb de click : " + ++this.compteur);
			label.setText("Vous avez sur le boutton 1");
		}
	}
	class listenerButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
//			label.setText("Nb de click : " + ++this.compteur);
			label.setText("Vous avez sur le boutton 2");
		}
	}
	private void go() {
		// Les coordonnées de départ de notre rond
		int x = pan.getPosX(), y = pan.getPosY();
		// Le booléen pour savoir si l'on recule ou non sur l'axe x
		boolean backX = false;
		// Le booléen pour savoir si l'on recule ou non sur l'axe y
		boolean backY = false;

		// Dans cet exemple, j'utilise une boucle while
		// Vous verrez qu'elle fonctionne très bien
		while (true) {
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
}
