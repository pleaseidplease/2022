package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreamExample {
	public static void main(String[] args) {
		try {
			fileCopy();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//byte 단위로 읽고 쓰기.
	public static void fileCopy() throws IOException {
		FileInputStream fis=new FileInputStream("C:/Temp/origin.jpg");
		FileOutputStream fos=new FileOutputStream("C:/Temp/copy.jpg");
		
		
		byte[] buf=new byte[100];//100바이트의 속도로 전송해보기.
		
		
		long start=System.currentTimeMillis();
		System.out.println("현재시간은 "+start);
		while(true) {
			int bytes=fis.read(buf);//한바이트씩 읽기.	
			if(bytes==-1) {
				break;
			}
			fos.write(buf);
		}
		fos.close();
		fis.close();
		System.out.println("complete");
		long end=System.currentTimeMillis();
		System.out.println("끝난시간은 "+end);
		System.out.println("걸린시간은 "+(end-start));
	}
	
	
	public static void readBuf() throws IOException{
		InputStream is=new FileInputStream("C:/Temp/data2.dat");
		byte[] buf=new byte[2];
		while(true) {
			int bytes=is.read(buf);//배열에 선언된 크기만큼 읽어들임.
			if(bytes==-1) {
				break;
			}
			for(int i=0;i<bytes;i++) {
				System.out.println(buf[i]+" ");
			}
			System.out.println();
		}
		System.out.println("complete");
		
		is.close();
		
	}
	
	//throws:예외를 떠넘긴다.
	public static void writeBuf() throws IOException {
		byte[] arr=new byte[] {10,20,30};
		OutputStream os=new FileOutputStream("C:/Temp/data2.dat");
		os.write(arr);
		os.close();
		System.out.println("complete.");
	}
	
	
	public static void read() {
		try {
			InputStream is = new FileInputStream("C:/Temp/deta1.dat");
			while (true) {
				int bytes = is.read(); // byte 읽고 더이상 읽을 바이트 없으면 -1 값을 반환.
				if(bytes==-1) {
					break;
				}
				System.out.println(bytes);
			}
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("complete");
	}

	
	
	public static void write() {
		// 출력스트림(바이트)
		try {
			OutputStream os = new FileOutputStream("C:/Temp/deta1.dat");
			// write 메소드(byte b)
			byte a = 10;
			byte b = 20;
			os.write(a);
			os.write(b);

			// resource 반환.
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("complete");
	}
}