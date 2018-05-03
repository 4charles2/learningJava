package generecite;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		Solo<Integer> me = new Solo<Integer>(21);
		int leet = me.getvaleur();
		Solo.show(leet);
		Duo<Integer, String> Hf = new Duo<Integer, String>(78, "mon Petit");
		int H = Hf.getValeur1();
		String f = Hf.getValeur2();
		Solo.show(H);
		Solo.show(f);
		Solo.show("-------------Generecite sur List---------------");
		Solo.show("-------------List de String ---------------");
		List<String> Ilist = new ArrayList<String>();
		Ilist.add("premiere chaine");
		Ilist.add("second List");
		Ilist.add("tree List");
		Ilist.add("four List");
		Ilist.add("five List");
		for(String str : Ilist)
			Solo.show(str);
		Solo.show("-------------List de float---------------");
		List<Float> listFloat = new ArrayList<Float>();
		listFloat.add(16.54f);
		listFloat.add(48.65f);
		listFloat.add(76.313f);
		for(Float nb : listFloat)
			Solo.show(nb);
	} 

}
