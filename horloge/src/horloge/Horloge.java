package horloge;

import java.util.ArrayList;
import java.util.Calendar;

public class Horloge implements Observable{
	private Calendar cal;
	private String hour = "";
	
	private ArrayList<Observateur>listObservateur = new ArrayList<Observateur>();
	
	public void run() {
		while(true) {
			cal = Calendar.getInstance();
			this.hour = this.cal.get(cal.HOUR_OF_DAY)
					+ " : " +
					( this.cal.get(cal.MINUTE) < 10 ? "0" + this.cal.get(cal.MINUTE): this.cal.get(cal.MINUTE))
					+ " : " +
					(this.cal.get(cal.SECOND) < 10 ? "0" + this.cal.get(cal.SECOND) : this.cal.get(cal.SECOND));
			this.updateObservateur();
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void addObservateur(Observateur obs) {
		this.listObservateur.add(obs);		
	}
	@Override
	public void updateObservateur() {
		for(Observateur obs : this.listObservateur)
			obs.update(this.hour);
	}
	@Override
	public void deleteObservateur() {
		this.listObservateur = new ArrayList<Observateur>();		
	}

}
