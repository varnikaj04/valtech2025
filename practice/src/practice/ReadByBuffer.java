package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadByBuffer {
	public static void main(String[] args) throws IOException {
		System.out.println("Enter a number: ");
//		int num = System.in.read();
		
//		InputStreamReader in = new InputStreamReader(System.in);
//		BufferedReader bf = new BufferedReader(in);
		
		Scanner sc = new Scanner(System.in);
		
//		int num = Integer.parseInt(bf.readLine());
		int num = sc.nextInt();
		System.out.println(num);		
//		System.out.println(num - 48);	without bufferedReader it reads ASCII values
	
//		bf.close();
	}
}
