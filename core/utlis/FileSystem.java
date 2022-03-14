package core.utlis;

import java.io.File;
import java.io.IOException;

public class FileSystem {
	// variables
	// ..........................................
	boolean flag;
	String file_name = "";
	boolean file_name_valid = false;
	// ..........................................
	public void mak(String command[], String current_dir) {
		try {
			file_name = command[1];
		} catch (Exception e) {
			System.out.println("Please provide a file name");
		}
		if (file_name.equals("")) {
			file_name_valid = false;
		} else {
			file_name_valid = true;
		}
		if (file_name_valid) {
			try {
				File file = new File(current_dir + file_name);
				flag = file.createNewFile();
				if (flag) {
					System.out.println("File made");
				} else {
					System.out.println("file already exists!");
				}
			} catch (IOException e) {
				System.out.print("error");
				e.printStackTrace();
			}
		}
		file_name_valid = false;
		flag = false;
	}

	public void rm(String command[], String current_dir) {
		try {
			file_name = command[1];
		} catch (Exception e) {
			System.out.println("Please provide a file name");
		}
		File file = new File(current_dir + file_name);
		
		if(file.isDirectory()) {
			System.out.println(file_name + " is a directory");
			return;
		}
		
		flag = file.delete();
		if (flag) {
			System.out.println("Deleted file: " + file_name);
		} else {
			System.out.println("that file dose not exist");
		}
	}

	public String cd(String command[], String current_dir) {
		String tmp_dir = "";
		try {
			tmp_dir = current_dir + command[1] + "/";
		} catch (Exception e) {
			System.out.println("Please provide a dir name");
			return "ERR";
		}
		
		if(command[1].equals("..") && !current_dir.equals("./disk/")) {
			String[] dir = current_dir.split("/");
			
			int i = 0;
			for(@SuppressWarnings("unused") String a : dir) {
				i++;
			}
			
			int i2 = 1;
			String finalStuf = ".";
			
			while((i-1) > i2) {
				finalStuf += "/" + dir[i2];
				
				i2++;
			}
			return finalStuf + "/";
		} else if(command[1].equals("..")) {
			return "ERR";
		}

		try {
			File test_file = new File(tmp_dir + "/test.tmp");
			test_file.createNewFile();
			test_file.delete();
			current_dir = tmp_dir;
			return current_dir;
		} catch (Exception e) {
			System.out.println("There is no such directory!");
			return "ERR";
		}
	}
	
	public void mkdir(String command[], String current_dir) {
		try {
			if(command[1].equals("disk")) {
				System.out.println("name \"disk\" is reserved by the system");
				return;
			}
		} catch(Exception e) {
			System.out.println("Please provide a folder name");
		}
		
		File dir = new File(current_dir + command[1]);
		flag = dir.mkdir();
		if(flag) {
			System.out.println("Folder created: " + command[1]);
		} else {
			System.out.println("error");
		}
		
		flag = false;
	}
	
	public void rmdir(String command[], String current_dir) {
		if(command[1].equals("disk")) {
			System.out.println("name \"disk\" is reserved by the system");
			return;
		}
		
		File file = new File(current_dir + command[1]);
		
		if(!file.isDirectory()) {
			System.out.println(command[1] + " is a file");
			return;
		}
		
		flag = file.delete();
		if (flag) {
			System.out.println("Deleted folder: " + command[0]);
		} else {
			System.out.println("that folder dosent exist");
		}
	}
	
	public void ls(String current_dir) {
		String [] files;
		File file = new File(current_dir);
		
		files = file.list();
		
		for(String fileName : files) {
			System.out.println(fileName);
		}
	}
}
