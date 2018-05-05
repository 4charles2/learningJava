package horloge;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fenetre extends JFrame{

	private JLabel label = new JLabel();
	private Horloge horloge;
	
	public Fenetre() {
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(200, 80);
		this.horloge = new Horloge();
		this.horloge.addObservateur(new Observateur() {
			public void update(String hour) {
				label.setText(hour);
			}
		});
		
		Font police = new Font("Snap ITC", Font.TRUETYPE_FONT, 20);
		this.label.setFont(police);
		this.label.setHorizontalAlignment(JLabel.CENTER);
		
		this.getContentPane().add(label, BorderLayout.CENTER);
		this.setVisible(true);
		this.horloge.run();
	}

	public static void main(String[] args) {
		Fenetre winds = new Fenetre();
		
	}

}
