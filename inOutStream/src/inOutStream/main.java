package inOutStream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class main {

	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileChannel fc = null;
		
		try {
			fis = new FileInputStream(new File("dictionnaire.txt"));
			bis = new BufferedInputStream(fis);
			
			long startTime= System.currentTimeMillis();
			byte bBuf[] = new byte[8];
			
			while (bis.read(bBuf) != -1) {
	            // On affiche ce qu'a lu notre boucle au format byte et au
	            // format char
	            for (byte bit : bBuf) {
	               System.out.print((char) bit);
	            }
	            
	            //Nous réinitialisons le buffer à vide
	            //au cas où les derniers byte lus ne soient pas un multiple de 8
	            //Ceci permet d'avoir un buffer vierge à chaque lecture et ne pas avoir de doublon en fin de fichier
	            bBuf = new byte[8];

	         }
			long inputTime = System.currentTimeMillis() - startTime;
			
			bis.close();
			
			startTime = System.currentTimeMillis();
			Path sourcePath = Paths.get("dictionnaire.txt");
			BufferedReader reader = Files.newBufferedReader(sourcePath,
					StandardCharsets.ISO_8859_1);
					String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			long newBufferedReaderString = System.currentTimeMillis() - startTime;
			reader.close();
			
			
			fis = new FileInputStream(new File("dictionnaire.txt"));
			fc = fis.getChannel();
			
			startTime = System.currentTimeMillis();
			
			int size = (int)fc.size();
			//On créer un buffer de la taille necessaire
			ByteBuffer byBuf = ByteBuffer.allocate(size);
			
			fc.read(byBuf);
			byBuf.flip();
						
			byte arrByte[] = byBuf.array();
			for(byte bit : arrByte)
				System.out.print((char)bit);
			
			long bufferedTime = System.currentTimeMillis() - startTime;
			
			SeekableByteChannel sbc = Files.newByteChannel(sourcePath,
					StandardOpenOption.READ);
			
			startTime = System.currentTimeMillis();
			
			int sizeSBC = (int)sbc.size();
			ByteBuffer buffer = ByteBuffer.allocate(sizeSBC);
			sbc.read(buffer);
			buffer.flip();
			
			
				for (byte bit : buffer.array())
		               System.out.print((char)bit);
			long SEEKABLEBYTECHANNEL = System.currentTimeMillis() - startTime;
			
			sbc.close();
			
			FileChannel fileChannel = FileChannel.open(sourcePath,
				StandardOpenOption.READ);
			
			startTime = System.currentTimeMillis();
			
			int sizeFileChannel = (int)fileChannel.size();
			ByteBuffer bufFileChannel = ByteBuffer.allocate(sizeFileChannel);
			fileChannel.read(bufFileChannel);
			buffer.flip();
			
			for(byte bit : bufFileChannel.array())
				System.out.print((char)bit);
			long fileChannelTime = System.currentTimeMillis() - startTime;
						
			Stream<String> tabString = Files.lines(sourcePath, StandardCharsets.ISO_8859_1);
			
			startTime = System.currentTimeMillis();
			
			
			tabString.forEach((x)->{System.out.println(x);});
			tabString.close();
			long StreamStringTime = System.currentTimeMillis() - startTime;
			
			Iterator<String> iteratorSTring = Files.lines(sourcePath, StandardCharsets.ISO_8859_1).iterator();
			startTime = System.currentTimeMillis();
			iteratorSTring.forEachRemaining((x) ->{System.out.println(x);});
			long iteratorStringTime = System.currentTimeMillis() - startTime;
			
			System.out.println("Temps d'éxecution pour a lecture du fichier avec iteratorSTring : " + iteratorStringTime + " ms.");
			System.out.println("Temps d'éxecution pour a lecture du fichier avec StreamString : " + StreamStringTime + " ms.");
			System.out.println("Temps d'éxecution pour a lecture du fichier avec fileChannel : " + fileChannelTime + " ms.");
			System.out.println("Temps d'éxecution pour a lecture du fichier avec SEEKABLEBYTECHANNEL : " + SEEKABLEBYTECHANNEL + " ms.");
			System.out.println("Temps d'éxecution pour a lecture du fichier avec newBufferedReadersString : " + newBufferedReaderString + " ms.");
			System.out.println("Temps d'éxecution pour la lecture du fichier avec CHANNEL : " + bufferedTime + " ms.");
			System.out.println("Temps d'éxecution pour la lecture du fichier avec BUFFER : " + inputTime + " ms.");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				bis.close();
				//fc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
