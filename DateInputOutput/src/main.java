import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class main {

	public static void main(String[] args) {
		DataOutputStream dos = null;
		DataInputStream dis = null;
		long startTime = System.currentTimeMillis();
		try {
			dos = new DataOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(
							new File("data2.txt"))));
			dos.writeByte(65);
			dos.writeChar('D');
			dos.writeInt(20000);
			dos.writeLong(132465L);
			dos.writeDouble(156.78);
			dos.writeFloat(8456.45f);
			dos.writeBoolean(true);
			dos.writeShort(2);
			dos.close();
			
			dis = new DataInputStream(
					new BufferedInputStream(
						new FileInputStream(
							new File("data2.txt"))));
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			System.out.println(dis.readInt());
			System.out.println(dis.readLong());
			System.out.println(dis.readDouble());
			System.out.println(dis.readFloat());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readShort());
			dis.close();
			System.out.println("Temps d'éxecution : " + (System.currentTimeMillis() - startTime));
			
		}catch(FileNotFoundException e) {
			System.out.println("Exception leve !");
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				dos.close();
				dis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
