package nioII;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class main {

	public static void main(String[] args) {
		Path path = Paths.get("dictionnaire.txt");
		System.out.println(path.getFileName());
		System.out.println(path.getParent());
		System.out.println(path.toAbsolutePath());
		System.out.println(Files.isDirectory(path));
		System.out.println(Files.exists(path));

		Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();
		
		for(Path chemin : roots) {
			System.out.println(chemin);
			//On peut ajouter un filtre à notre listing par exemple pour afficher que les fichiers *.txt
			try(DirectoryStream<Path> listing = Files.newDirectoryStream(chemin)){
				parcourPath(listing);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void parcourPath(DirectoryStream<Path> listing) {
		int i = 0;
		for(Path nom : listing) {
			System.out.print("\t\t" + (Files.isDirectory(nom) ? nom+"/" : nom));
			if(Files.isDirectory(nom))
				try {
					parcourPath(Files.newDirectoryStream(nom));
				} catch (IOException e) {
					e.printStackTrace();
				}
			if((i%4) == 0)
				System.out.println("");
			i++;
		}
	}

}
