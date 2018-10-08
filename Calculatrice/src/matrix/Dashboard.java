package matrix;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import show.Background;
import show.Buttons;
import show.Fenetre;
import show.PanelStaple;

public class Dashboard{
	
	
	private JPanel stapleButtons = new JPanel();
	
	
	public Dashboard() {
		Fenetre show = new Fenetre("Maticalc", 500, 600);
		PanelStaple LCDScreen = new PanelStaple();
		Background back = new Background();
		
		LCDScreen.setPreferredSize(new Dimension(500, 100));
		
		this.opButtons();
		
		back.add(stapleButtons);
			
		show.setLayout(new BorderLayout());
		show.getContentPane().add(LCDScreen, BorderLayout.NORTH);
		show.getContentPane().add(back, BorderLayout.CENTER);
		
	}
	private void opButtons() {
		JPanel numberButton = new JPanel();
		JPanel operatorButton = new JPanel();
		
		Buttons ListButtons = new Buttons();
		GridLayout gl = new GridLayout(3,4);
		GridLayout glOp = new GridLayout(1, 5);
		
		stapleButtons.setOpaque(false);
		numberButton.setOpaque(false);
		operatorButton.setOpaque(false);
		
		glOp.setHgap(5);
		glOp.setVgap(5);
		gl.setHgap(5);
		gl.setVgap(5);
		
		
		stapleButtons.setLayout(gl);
	
		
		ListButtons.ListButtons(9);
		ListButtons.ListButtons(".");
		ListButtons.ListButtons("=");
		
		ListButtons.lButtons.forEach((temp)->{
				temp.setPreferredSize(new Dimension(100, 80));
				numberButton.add(temp);
		});
		
		
		
	}
}