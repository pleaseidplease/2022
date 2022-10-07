package co.edu.api;

import java.io.IOException;

public class BypteToStringExample {
	public static void main(String[] args) throws IOException  {
//		byte[] bytes= {72,101,108,108,111,32,74,97,118,97};
//		String str1=new String(bytes);
//		System.out.println(str1);
//		String str2=new String(bytes,6,4);
//		System.out.println(str2);
		
		byte[] bytes=new byte[100];
		System.out.print("입력: ");
		int readByteNo=System.in.read(bytes);
		String str=new String(bytes,0,readByteNo-2);
		System.out.println(str);
	}
	
	String subject="자바 프로그래밍";
	char charValue=subject.charAt(3); 
}
