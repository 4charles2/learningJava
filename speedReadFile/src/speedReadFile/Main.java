package speedReadFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		long startTime = 0;
		Path sourcePath = Paths.get("dictionnaire.txt");
		
		try {
		
		//NEW BUFFERED READER
		startTime = System.currentTimeMillis();
		Files.newBufferedReader(sourcePath,StandardCharsets.ISO_8859_1)
			.lines()
			.forEach(System.out::println);
		long newBufferedReaderString = System.currentTimeMillis() - startTime;
		
		//STREAM STRING
		startTime = System.currentTimeMillis();
		Files.lines(sourcePath, StandardCharsets.ISO_8859_1)
				.forEach(System.out::println);
		long StreamStringTime = System.currentTimeMillis() - startTime;
		
		//ITERATOR STRING
		startTime = System.currentTimeMillis();
		Files.lines(sourcePath, StandardCharsets.ISO_8859_1)
				.iterator()
				.forEachRemaining(System.out::println);
		long iteratorStringTime = System.currentTimeMillis() - startTime;
		
		//READ ALL LINES
		startTime = System.currentTimeMillis();
		Files.readAllLines(sourcePath, StandardCharsets.ISO_8859_1).forEach(System.out::println);
		long readAllLines = System.currentTimeMillis() - startTime;
		
		//SPLIT ITERATOR
		startTime = System.currentTimeMillis();
		Files.lines(sourcePath, StandardCharsets.ISO_8859_1).spliterator().forEachRemaining(System.out::println);
		long splitIteratorTime = System.currentTimeMillis() - startTime;
		
		System.out.println("Temps d'éxecution pour a lecture du fichier avec SPLITiTERATOR : " + splitIteratorTime + " ms.");
		System.out.println("Temps d'éxecution pour a lecture du fichier avec readAllLines : " + readAllLines + " ms.");
		System.out.println("Temps d'éxecution pour a lecture du fichier avec newBufferedReadersString : " + newBufferedReaderString + " ms.");
		System.out.println("Temps d'éxecution pour a lecture du fichier avec StreamString : " + StreamStringTime + " ms.");
		System.out.println("Temps d'éxecution pour a lecture du fichier avec iteratorSTring : " + iteratorStringTime + " ms.");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
