package serialization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class main {

	public static void main(String[] args) {
		ObjectInputStream ois;
		ObjectOutputStream oos;
		
		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(
							new File("game.txt"))));
			
			oos.writeObject(new Game("Assassin Screed", "Aventure", 39.90));
			oos.writeObject(new Game("Civilization", "stratégie", 20.50));
			oos.writeObject(new Game("Tomb Rider", "Plateforme", 15.50));
			
			oos.close();
			
			ois = new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream(
								new File("game.txt"))));
			try {
				System.out.println("----------------------------------------------------------------");
				System.out.println("-------------------------Liste des Jeux-------------------------");
				System.out.println(ois.readObject());
				System.out.println(ois.readObject());
				System.out.println(ois.readObject());
				
				ois.close();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
