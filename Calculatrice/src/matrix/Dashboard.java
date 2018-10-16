package matrix;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import show.Background;
import show.CreateButton;
import show.Fenetre;
import show.PanelStaple;

public class Dashboard{
	PanelStaple LCDScreen = new PanelStaple();
	Background back = new Background();
	
	public Dashboard() {
		
		Fenetre show = new Fenetre("Maticalc", 500, 600);
		
		JPanel container = new JPanel();
		LCDScreen.setPreferredSize(new Dimension(500, 100));
		
		showButtons();
		showScreen();
		
		container.setLayout(new BorderLayout());
		
		container.add(LCDScreen, BorderLayout.NORTH);
		container.add(back, BorderLayout.CENTER);
		
		show.setContentPane(container);
		show.validate();
	}
	private void showScreen() {
		
	}
	private void showButtons() {
		JPanel containNumber = new JPanel();
		JPanel stapleButtons = new JPanel();
		JPanel numberButton = new JPanel();
		JPanel operatorButton = new JPanel();
		JPanel lastLigneNumber = new JPanel();
		
		CreateButton ListButtons = new CreateButton();
		containNumber.setLayout(new BorderLayout());
		GridLayout gl = new GridLayout(3,3);
		GridLayout glOp = new GridLayout(4, 1);
		
		stapleButtons.setOpaque(false);
		containNumber.setOpaque(false);
		numberButton.setOpaque(false);
		operatorButton.setOpaque(false);
		lastLigneNumber.setOpaque(false);
		
		glOp.setHgap(10);
		glOp.setVgap(10);
		gl.setHgap(10);
		gl.setVgap(10);
		
		numberButton.setLayout(gl);
		operatorButton.setLayout(glOp);
		
		ListButtons.ListButtons(9);
		ListButtons.ListButtons("/");
		ListButtons.ListButtons("-");
		ListButtons.ListButtons("+");
		ListButtons.ListButtons(".");
		ListButtons.ListButtons("=");
		
		ListButtons.lButtons.forEach((temp)->{
			temp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			temp.setPreferredSize(new Dimension(100, 80));
			if(temp.getText().matches("[1-9]"))
				numberButton.add(temp);
			else if( temp.getText() == "=") {
				temp.setPreferredSize(new Dimension(210, 80));
				lastLigneNumber.add(temp);	
			}else if(temp.getText().equals("0")) {
				lastLigneNumber.add(temp);	
			}else
				operatorButton.add(temp);
		});
		containNumber.add(numberButton, BorderLayout.CENTER);
		containNumber.add(lastLigneNumber, BorderLayout.SOUTH);
		stapleButtons.add(containNumber);
		stapleButtons.add(operatorButton);
		back.add(stapleButtons);
	}
}