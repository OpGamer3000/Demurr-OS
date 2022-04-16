package core.main;

import java.util.Scanner;
import core.utlis.*;

public class Main {
	
	public static String current_dir = "./disk/";
	public static Scanner usr_in = new Scanner(System.in);
	public static String commands[] = {"mak", "rm", "cd", "home", "pwd", "mkdir", "rmdir", "ls", "exit"};
	
	public static void main(String[] args) {
		println("Initliasing...");
		// objects
		Cmd_handler cmd = new Cmd_handler();
		
		// ...................................
		// variables
		String input = "";
		// ...................................
		
		println("Started!");
		println("to get help type 'help'");
		
		//main loop for execution
		while (true) {
			print(current_dir + " ~ ");
			input = usr_in.nextLine();
			String[] command = input.split("\\s+");
			
			cmd.inter(command);
		}
	}

	private static void print(String str) {
		System.out.print(str);

	}

	private static void println(String str) {
		System.out.println(str);
	}
}
