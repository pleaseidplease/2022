package co.edu.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStreamExample {

	public static void main(String[] args) {
	
		read();
	}
	
	public static void read() {
		try {
			FileReader reader=new FileReader("src/co/edu/io/ByteStreamExample.java");
			
			try {
				while(true) {
					int bytes=reader.read();
					if(bytes==-1) {
						break;
					}
					System.out.print((char)bytes);
				}
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("complete");
	}

	
	
	public static void write() {
		// 문자기반 스트림 생성 Reader/Writer.
		Scanner scn = new Scanner(System.in);
		try {
			FileWriter fw = new FileWriter("C:/Temp/addr.txt");
			while (true) {
				System.out.println(">> ");
				String temp = scn.nextLine();
				if (temp.equals("quit")) {
					break;
				}
				fw.write(temp + "\n");
			}
			fw.close();
			scn.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("complete");

	}
}
