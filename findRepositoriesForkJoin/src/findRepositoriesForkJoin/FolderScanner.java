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
			throw new ScanException("Chemin � scanner non valide (vide ou null)");
		
		System.out.println("Scan du dossier : " + path + " � la recherche du fichier portant l'extension "+ this.filter);
		
		//On liste maintenant le contenu du repertoire pour traiter les sous-dossiers
		try(DirectoryStream<Path> listing = Files.newDirectoryStream(path)){
			for(Path nom : listing) {
				if(Files.isDirectory(nom.toAbsolutePath())) {
					FolderScanner f = new FolderScanner(nom.toAbsolutePath(), this.filter);
					this.resultat = f.sequentialScan();
				}
			}
			
		}catch(IOException e) {e.printStackTrace();}

		//Maintenant, on filtre le contenu de ce m�me dossier sur le filtre d�fini
		try{
			Files.newDirectoryStream(path, this.filter).forEach( (x)->resultat++ );
		}catch(IOException e) { e.printStackTrace(); }
		
		return resultat;
	}
	/**
	 * M�thode que nous allons utiliser pour les traitements en mode parall�le.
	 * @throws ScanException
	 */
	public long parallelscan() throws ScanException{
		//List d'objet qui contiendra les sous-t�ches cr��es et lanc�es
		List<FolderScanner> list = new ArrayList<>();
		
		//Si le chemin n'est pas valide
		if(path == null || path.equals(""))
			throw new ScanException("Le chemin � scanner n'est pas valide (vide ou null");
		//Nous listons comme precedement le contenu
		try(DirectoryStream<Path> listing = Files.newDirectoryStream(path)){
			//On parcour le contenu
			for(Path nom : listing) {
				//S'il s'agit d'un dossier, on cr�er une sous t�che
				if(Files.isDirectory(nom.toAbsolutePath())) {
					//Nous cr�ons donc un nouvel Objet FolderScanner
					//Qui se chargera de scanner ce dossier
					FolderScanner f = new FolderScanner(nom, this.filter);
					//Nous l'ajoutons � la liste des t�ches en cours pour r�cup�rer le resultat plus tard
					list.add(f);
					//C'est cette instruction qui lance l'action en t�che de fond
					f.fork();
				}
			}
		}catch(IOException e) { e.printStackTrace();}
		
		//On compte maintenant les fichiers, correspondant au filtre, pr�sents dans ce dossier
		try {
			Files.newDirectoryStream(path, this.filter).forEach( (x)->resultat++ );
		}catch(IOException e) { e.printStackTrace(); }
		
		//Et, enfin, nous r�cuperons le resultat de toutes les t�ches de fond
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
