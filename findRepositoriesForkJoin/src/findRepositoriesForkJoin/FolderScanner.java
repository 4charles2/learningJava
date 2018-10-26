package findRepositoriesForkJoin;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderScanner extends RecursiveTask<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Path path = null;
	private String filter = "";
	private long resultat = 0;
	
	public FolderScanner() {}
	
	public FolderScanner(Path p, String f) {
		this.path = p;
		this.filter = f; 
	}
	
	/**
	 * Methode de scan en mode mono thread
	 * @throws ScanException
	 */
	public long sequentialScan() throws ScanException{
		if(path.equals("") || path == null)
			throw new ScanException("Chemin à scanner non valide (vide ou null)");
		
		System.out.println("Scan du dossier : " + path + " à la recherche du fichier portant l'extension "+ this.filter);
		
		//On liste maintenant le contenu du repertoire pour traiter les sous-dossiers
		try(DirectoryStream<Path> listing = Files.newDirectoryStream(path)){
			for(Path nom : listing) {
				if(Files.isDirectory(nom.toAbsolutePath())) {
					FolderScanner f = new FolderScanner(nom.toAbsolutePath(), this.filter);
					this.resultat = f.sequentialScan();
				}
			}
			
		}catch(IOException e) {e.printStackTrace();}

		//Maintenant, on filtre le contenu de ce même dossier sur le filtre défini
		try{
			Files.newDirectoryStream(path, this.filter).forEach( (x)->resultat++ );
		}catch(IOException e) { e.printStackTrace(); }
		
		return resultat;
	}
	/**
	 * Méthode que nous allons utiliser pour les traitements en mode parallèle.
	 * @throws ScanException
	 */
	public long parallelscan() throws ScanException{
		//List d'objet qui contiendra les sous-tâches créées et lancées
		List<FolderScanner> list = new ArrayList<>();
		
		//Si le chemin n'est pas valide
		if(path == null || path.equals(""))
			throw new ScanException("Le chemin à scanner n'est pas valide (vide ou null");
		//Nous listons comme precedement le contenu
		try(DirectoryStream<Path> listing = Files.newDirectoryStream(path)){
			//On parcour le contenu
			for(Path nom : listing) {
				//S'il s'agit d'un dossier, on créer une sous tâche
				if(Files.isDirectory(nom.toAbsolutePath())) {
					//Nous créons donc un nouvel Objet FolderScanner
					//Qui se chargera de scanner ce dossier
					FolderScanner f = new FolderScanner(nom, this.filter);
					//Nous l'ajoutons à la liste des tâches en cours pour récupérer le resultat plus tard
					list.add(f);
					//C'est cette instruction qui lance l'action en tâche de fond
					f.fork();
				}
			}
		}catch(IOException e) { e.printStackTrace();}
		
		//On compte maintenant les fichiers, correspondant au filtre, présents dans ce dossier
		try {
			Files.newDirectoryStream(path, this.filter).forEach( (x)->resultat++ );
		}catch(IOException e) { e.printStackTrace(); }
		
		//Et, enfin, nous récuperons le resultat de toutes les tâches de fond
		list.forEach( (x)->x.join() );
		
		return resultat;
	}
	@Override
	protected Long compute() {
		long resultat = 0;
		
		try {
			resultat = this.parallelscan();
		}catch (ScanException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
	public long getResultat() {
		return this.resultat;
	}
}
