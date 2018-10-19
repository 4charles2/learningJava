package matrix;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;
import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
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
	JLabel showLCD = new JLabel(BEGIN_TEXT+"0"+AFTER_TEXT);
	
	private boolean calcul = false;
	private String nb1 = "";
	private String result = "";
	private String operator = "";
	
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
		GridLayout glOp = new GridLayout(5, 1);
		
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
		ListButtons.ListButtons("*");
		ListButtons.ListButtons("-");
		ListButtons.ListButtons("+");
		ListButtons.ListButtons(".");
		ListButtons.ListButtons("=");
		
		ListButtons.lButtons.forEach((temp)->{
			temp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			if(temp.getText().matches("[1-9]")) {
				temp.setPreferredSize(new Dimension(100, 80));
				temp.addActionListener(new numberInput());
				numberButton.add(temp);
			}else if( temp.getText() == "=") {
				temp.setPreferredSize(new Dimension(210, 80));
				temp.addActionListener(new resultInput());
				lastLigneNumber.add(temp);	
			}else if(temp.getText().equals("0")) {
				temp.setPreferredSize(new Dimension(100, 80));
				temp.addActionListener(new numberInput());
				lastLigneNumber.add(temp);
			}else {
				temp.setPreferredSize(new Dimension(80, 60));
				temp.addActionListener(new operatorInput());
				operatorButton.add(temp);
			}
		});
		
		JButton resetButton = new JButton("C");
		resetButton.addActionListener(new resetInput());
		resetButton.setPreferredSize(new Dimension(420, 80));
		
		containNumber.add(numberButton, BorderLayout.CENTER);
		containNumber.add(lastLigneNumber, BorderLayout.SOUTH);
		
		stapleButtons.add(containNumber);
		stapleButtons.add(operatorButton);
		
		back.add(resetButton);
		back.add(stapleButtons);
	}
	private void calculNumber(String operator) {
		try {
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("js");
			result = engine.eval(nb1 + operator + result).toString();
			}catch(ScriptException e) {
				e.printStackTrace();
			}
	}
	class numberInput implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			
			nb1 += arg0.getActionCommand();
			showLCD.setText(BEGIN_TEXT+nb1+AFTER_TEXT);
		}
	}
	class operatorInput implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (calcul)
				calculNumber(operator);
			
			calcul = true;
			nb1 = (nb1 == "") ? "0" : nb1;
			result = (result == "") ? nb1 : result;
			operator = arg0.getActionCommand();
			nb1 = "";
		}
	}
	class resultInput implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			showLCD.setText(BEGIN_TEXT+result+AFTER_TEXT);
			calcul = false;
		}
	}
	class resetInput implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			showLCD.setText(BEGIN_TEXT+"0"+AFTER_TEXT);
			nb1 = "";
			result = "";
			calcul = false;
		}		
	}
}