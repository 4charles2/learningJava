package nioSerialization;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class main {

	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileChannel fc = null;
		
		try {
			fis = new FileInputStream(new File("dictionnaire.txt"));
			bis = new BufferedInputStream(fis);
			
			long startTime= System.currentTimeMillis();
			
			while(bis.read() != -1);
			
			System.out.println("Temps d'éxecution pour la lecture du fichier avec BufferedInputStream " + (System.currentTimeMillis() - startTime) + "ms.");
			bis.close();
			
			fis = new FileInputStream(new File("dictionnaire.txt"));
			fc = fis.getChannel();
			
			startTime = System.currentTimeMillis();
			
			int size = (int)fc.size();
			//On créer un buffer de la taille necessaire
			ByteBuffer byBuf = ByteBuffer.allocate(size);
			
			fc.read(byBuf);
			byBuf.flip();
			System.out.println("Temps d'éxecution pour la lecture du fichier avec fileChannel " + (System.currentTimeMillis() - startTime) + "ms.");
			
			byte arrByte[] = byBuf.array();
			for(byte bit : arrByte)
				System.out.print((char)bit);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bis.close();
				fc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
