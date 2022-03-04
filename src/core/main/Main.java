package core.main;

import java.util.Scanner;
import core.utlis.FileSystem;

public class Main {

	public static void main(String[] args) {
		println("Initliasing...");
		// objects
		Scanner usr_in = new Scanner(System.in);
		FileSystem fs = new FileSystem();
		Runtime program = Runtime.getRuntime();
		// ...................................
		// variables
		String input = "";
		String current_dir = ".\\disk\\";
		String tmp_dir = ".\\disk\\";
		// ...................................
		println("Started!");
		println("to get help type 'help'");
		while (true) {
			print(current_dir + " ~");
			input = usr_in.nextLine();
			String[] command = input.split("\\s+");
			// echo command
			if (command[0].equals("echo")) {
				for (int i = 1; i < command.length; i++) {
					print(command[i] + " ");
				}
				print("\n");
				// file make command
			} else if (command[0].equals("mak")) {

				fs.mak(command, current_dir);

			} else if (command[0].equals("rm")) {

				fs.rm(command, current_dir);

			} else if (command[0].equals("cd")) {
				//lol
			} else if (command[0].equals("test")) {
				
				tmp_dir = System.getProperty("user.dir");
				println(tmp_dir);
				
			} else if (command[0].equals("home")) {
				
				current_dir = ".\\disk\\";
				
			} else if (command[0].equals("pwd")) {
				
				println(current_dir);
				
			} else if (command[0].equals("mkdir")) {
				
				fs.mkdir(command, current_dir);
				
			} else if (command[0].equals("help")) {
				show_help();
			} else if (command[0].equals("exit")) {
				break;
			}
			
			else {
				println("no command found");
			}
		}
		usr_in.close();
		program.exit(0);

	}

	private static void print(String str) {
		System.out.print(str);

	}

	private static void println(String str) {
		System.out.println(str);
	}
	
	private static void show_help() {
		System.out.println("Here are some list of commands:-\necho\nmak\nrm\ncd\nhome\npwd\nmakdir\nhelp");
	}

}
