package matrix;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import show.Background;
import show.Buttons;
import show.Fenetre;
import show.PanelStaple;

public class Dashboard{
	public Dashboard() {
		Fenetre show = new Fenetre("Maticalc", 500, 600);
		
		PanelStaple staple = new PanelStaple();
		Background back = new Background();
		JPanel stapleButtons = new JPanel();
		Buttons ListButtons = new Buttons();
		
		staple.setPreferredSize(new Dimension(500, 100));
		
		stapleButtons.setLayout(new GridLayout(3,4));
		ListButtons.ListButtons(10);
		stapleButtons.add(ListButtons.lButtons.get(1));
		back.add(stapleButtons);
			
		show.setLayout(new BorderLayout());
		show.getContentPane().add(staple, BorderLayout.NORTH);
		show.getContentPane().add(back, BorderLayout.CENTER);
		
	}
}