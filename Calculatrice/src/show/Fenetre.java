package show;

import javax.swing.JFrame;


public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * Par default locationRelativeTo est true et default closeOperation est sur JFrame.EEXIT_ON_CLOSE
	 * alwaysOnTop est egalement regler sur true ainsi que setVisible
	 * 
	 * Peut être modifier via les méthode de classe 
	 * 
	 * setResizable et a false
	 * 
	 * @param pTitle
	 * @param pWidth
	 * @param pHeight
	 */
	public Fenetre(String pTitle, int pWidth, int pHeight) {
		title(pTitle);
		size(pWidth, pHeight);
		locationRelativeTo();
		defaultCloseOperation();
		alwaysOnTop(true);
		resizable(false);
		visible(true);
		
	}
	public void title(String pTitle) {
		this.setTitle(pTitle);
	}
	public void size(int pWidth,int pHeight) {
		this.setSize(pWidth, pHeight);
	}
	public void resizable(boolean b){
		this.setResizable(b);
	}
	public void locationRelativeTo(java.awt.Component b) {
		this.setLocationRelativeTo(b);
	}
	public void locationRelativeTo() {
		this.setLocationRelativeTo(null);
	}
	public void defaultCloseOperation() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void defaultCloseOperation(int Operation) {
		this.setDefaultCloseOperation(Operation);
	}
	public void alwaysOnTop(boolean b) {
		this.setAlwaysOnTop(b);
	}
	public void visible(boolean b) {
		this.setVisible(b);
	}
}
