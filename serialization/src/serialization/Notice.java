package serialization;

import java.io.Serializable;

public class Notice extends Game{
	
	private String langue;
	
	public Notice() {
		this.langue = "Français";
	}
	public Notice(String pLang) {
		this.setLangue(pLang);
	}
	public String toString() {
		return "La langue de la notice " + this.langue;
	}
	/**
	 * @return the langue
	 */
	public String getLangue() {
		return langue;
	}
	/**
	 * @param langue the langue to set
	 */
	public void setLangue(String langue) {
		this.langue = langue;
	}
}
