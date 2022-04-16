package core.utlis;
import core.main.Main;

public class Cmd_handler {
	public void inter(String[] command) {
		FileSystem fs = new FileSystem();
		Runtime program = Runtime.getRuntime();
		
		
		
		if(command[0].equals("echo")) {
			
			for(int i = 1; i < command.length; i++) {
				System.out.println(command[i] + " ");
			}
			
			System.out.println("\n");
			
		} else if(command[0].equals("mak")) {
			
			fs.mak(command, Main.current_dir);
			
		} else if(command[0].equals("rm")) {
			
			fs.rm(command, Main.current_dir);
			
		} else if(command[0].equals("cd")) {
			
			String sucess = fs.cd(command, Main.current_dir);
			if(sucess != "ERR") {
				Main.current_dir = sucess;
			}
			
		} else if(command[0].equals("home")) {
			
			Main.current_dir = "./disk/";
			
		} else if(command[0].equals("pwd")) {
			
			System.out.println(Main.current_dir);
			
		} else if(command[0].equals("mkdir")) {
			
			fs.mkdir(command, Main.current_dir);
			
		} else if(command[0].equals("rmdir")) {
			
			fs.rmdir(command, Main.current_dir);
			
		} else if(command[0].equals("ls")) {
			
			fs.ls(Main.current_dir);
		} else if(command[0].equals("help")) {
			
			show_help();
			
		} else if(command[0].equals("exit")) {
			
			Main.usr_in.close();
			fs = null;
			Main.usr_in = null;
			
			program.exit(0);
		}
		
		else if(command[0].equals("test")) {
			System.out.println(System.getProperty("user.id"));
		}
	}
	
	private void show_help() {
		try {
			int i = 0;
			while(true) {
				System.out.println(Main.commands[i]);
				i++;
			}
		} catch(Exception e) {
			return;
		}
	}
}
