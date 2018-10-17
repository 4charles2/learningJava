package matrix;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import show.Background;
import show.CreateButton;
import show.Fenetre;
import show.PanelStaple;

public class Dashboard{
	static final String BEGIN_TEXT = "<html><H1 style='padding: 10px; font-size: 50px'>";
	static final String AFTER_TEXT = "</H1></html>";
	
	PanelStaple LCDScreen = new PanelStaple();
	Background back = new Background();
	
	public Dashboard() {
	
		Fenetre show = new Fenetre("Maticalc", 500, 600);
		
		JPanel container = new JPanel();
		LCDScreen.setSize(new Dimension(500, 100));
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
		LCDScreen.setLayout(null);
		
		JLabel showLCD = new JLabel(BEGIN_TEXT+"0"+AFTER_TEXT);
		showLCD.setBounds(0, 0, 490, 100);
		showLCD.setVerticalAlignment(SwingConstants.CENTER);
		showLCD.setHorizontalAlignment(SwingConstants.RIGHT);
		showLCD.setBackground(Color.darkGray);
		LCDScreen.add(showLCD);

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
		JButton resetButton = new JButton("C");
		resetButton.setPreferredSize(new Dimension(420, 80));
		back.add(resetButton);
		back.add(stapleButtons);
	}
	
	public class numberInput implements ActionListener{
		
	}
}