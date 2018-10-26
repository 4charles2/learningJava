package dysplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends ParameterFenetre {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel container = new JPanel();
	private JComboBox<String> combo = new JComboBox<String>();
	private JLabel label = new JLabel("Une comboBox");
	
	public Fenetre() {
		super("Animation", 300, 300);
		
		container.setBackground(Color.white);
		
		container.setLayout(new BorderLayout());
		combo.setPreferredSize(new Dimension(100, 20));
		
		combo.addItem("Choix 1");
		combo.addItem("Choix 2");

		JPanel top = new JPanel();
		top.add(label);
		top.add(combo);
		container.add(top, BorderLayout.NORTH);
		
		this.setContentPane(container);
		super.setValideContent(container);
	}
}
