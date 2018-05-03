package revision;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * <style>
 * 		* {
 * 			font-family: cursive
 * 		}
 * 		h1 {
 * 			text-decoration: underline;
 * 			text-align: center;
 *			border: 0.1px solid black;
 *			padding: 5px;
 *			background-color: #481;
 * 		}
 * </style>
 * <h1>Les conversions Cast des variables </h1>
 * 	<H3> révision de la programmation : </H3>
 * <ul>
 * 		<li>int</li>
 *		<li>Byte</li>
 * 		<li>Short</li>
 * 		<li>Long</li>
 * 		<li>Float</li>
 * 		<li>Double</li>
 * 		<li>Char</li>
 * 		<li>Boolean</li>
 * 		<li>String</li>
 * </ul>
 * 
 * 
 * @since 1.0
 * @version 1.0
 * 
 * @author Tognol Charles
 * */

public class projet1 {
	private static int read;

	/*
	 * @param args
	 * 			arguments String[] en ligne de commandes 
	 */
	public static void main(String[] args) {
			
		String prenom;
		char reponse = 'O';
		Scanner sc = new Scanner(System.in);
		while (reponse == 'O')
		{
		  System.out.println("Donnez un prénom : ");
		  prenom = sc.nextLine();
		  System.out.println("Bonjour " +prenom+ ", comment vas-tu ?");                        
		  //Sans ça, nous n'entrerions pas dans la deuxième boucle
		  reponse = ' ';
		                        
		  //Tant que la réponse n'est pas O ou N, on repose la question
		  while(reponse != 'O' && reponse != 'N')
		  {
		    //On demande si la personne veut faire un autre essai
		    System.out.println("Voulez-vous réessayer ? (O/N)");
		    reponse = sc.nextLine().charAt(0);
		  }
		}
		System.out.println("Au revoir…");
		
	}
}
