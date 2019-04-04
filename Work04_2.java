package Algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Work04_2 {

	static int num = 0;
	private static Scanner keyboard;
	static IP_Info []info = new IP_Info[20000];

	public static void main(String[] args) {

		String command, word = null;
		while(true){

			System.out.print("$ ");
			keyboard = new Scanner(System.in);
			command = keyboard.next();
			if(command.equalsIgnoreCase("read")) {
				word = keyboard.next();
				read(word);
			}
			else if(command.equalsIgnoreCase("sort")) {
				word = keyboard.next();
				if(word.equalsIgnoreCase("-t"))
					t_sort();
				else if(word.equalsIgnoreCase("-ip"))
					ip_sort();
			}
			else if(command.equalsIgnoreCase("print")) {
				if(word.equalsIgnoreCase("-ip"))
					ip_print();
				else if(word.equalsIgnoreCase("-t"))
					t_print();
			}
			else if(command.equalsIgnoreCase("exit"))
				break;
		}

	}

	public static void read(String str) {

		try {
			Scanner	inFile = new Scanner(new File(str));
			String buffer = inFile.nextLine();

			while(inFile.hasNext()) {

				buffer = inFile.nextLine();

				int num1 = buffer.indexOf(",");
				int num2 = buffer.indexOf(",", num1 + 1);
				int num3 = buffer.indexOf(",", num2 + 1);

				info[num] = new IP_Info(buffer.substring(0, num1),buffer.substring(num1 + 2, num2),buffer.substring(num2 + 1, num3),buffer.substring(num3 + 1));			
				num++;
			}
			inFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("No file");
			System.exit(9);
		}
	}

	public static void t_sort() {
		Arrays.sort(info, 0, num);
	}

	public static void t_print() {
		for(int i = 0; i < num; i++) {
			System.out.println(info[i].Time);
			System.out.println("\tIP: " + info[i].IP);
			System.out.println("\tURL: " + info[i].URL);
			System.out.println("\tStatus: " + info[i].Status);
		}
	}

	public static void ip_sort() {
		Arrays.sort(info, new IP_InfoIPComparator());
	}

	public static void ip_print() {
		for(int i = 0; i < num; i++) {
			System.out.println(info[i].IP);
			System.out.println("\tTime: " + info[i].Time);
			System.out.println("\tURL: " + info[i].URL);
			System.out.println("\tStatus: " + info[i].Status);
		}

	}

}
