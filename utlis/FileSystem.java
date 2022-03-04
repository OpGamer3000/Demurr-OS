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
			System.out.println("Please provide a filename");
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
			System.out.println("Please enter a file/directory name");
		}

		if (file_name.equals("disk")) {
			System.out.println("Permition denied\nReason: System reserved");
		} else {
			File file = new File(current_dir + file_name);
			flag = file.delete();
			if (flag) {
				System.out.println("Deleted file: " + file_name);
			} else {
				System.out.println("Coudnt delete the file");
			}
		}
	}

	public boolean cd(String command[], String tmp_dir, String current_dir) {
		try {
			tmp_dir = current_dir + command[1] + "\\";
		} catch (Exception e) {
			System.out.println("Please enter a dir name");
			return false;
		}

		try {
			File test_file = new File(tmp_dir + "\\test.tmp");
			test_file.createNewFile();
			test_file.delete();
			current_dir = tmp_dir;
			return true;
		} catch (Exception e) {
			System.out.println("There is no such directory!");
			return false;
		}
	}
	
	public void mkdir(String command[], String current_dir) {
		File dir = new File(current_dir + command[1]);
		flag = dir.mkdir();
		if(flag) {
			System.out.println("Folder created: " + command[1]);
		} else {
			System.out.println("error");
		}
		
		flag = false;
	}
}
