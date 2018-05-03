package gateauChocolat;

public class main {

	public static void main(String[] args) {
		Patisserie myGateau = 	new Chocolat(
									new Caramel(
										new Biscuit(
											new Chocolat(
												new Gateau()))));
		System.out.println(myGateau.preparer());
	}
}
