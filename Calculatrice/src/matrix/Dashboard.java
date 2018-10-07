package matrix;

import show.Background;
import show.Fenetre;

public class Dashboard{
	public Dashboard() {
		Fenetre show = new Fenetre("Maticalc", 500, 600);
		Background back = new Background();
		show.setContentPane(back);
	}
}