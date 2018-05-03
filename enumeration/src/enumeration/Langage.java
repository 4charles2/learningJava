/**
 * 
 */
package enumeration;

/**
 * @author charles
 *
 */
public enum Langage {
	JAVA ("langage JAVA", "Eclispe"),
	C ("langage C", "Code Bloc"),
	PHP ("langage PHP", "PS Pad"),
	JAVASCRIPT ("langage JavaScript", "Sublime Text");
	
	private String name = "";
	private String editor = "";
	Langage(String pName, String pEditor){
		this.name = pName;
		this.editor = pEditor;
	}
	
	public void getEditor() {
		System.out.println(this.editor);
	}
	public String toString(){
		return this.name;
	}

}
