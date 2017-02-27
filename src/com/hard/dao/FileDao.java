package com.hard.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDao {
	public List<File> getAllFiles(String path) {
		List<File> files = new ArrayList<>();
		
		File folder = new File(path);
		
		File[] listOfFiles = folder.listFiles();
		
		for (File file : listOfFiles)
			files.add(file);
		
		return files;
	}
	
	public File getFile(String path) {
		return new File(path);
	}
	
	public void addFile(File file) {
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateFile(File file) {
		File fileOld = new File(file.getAbsolutePath());
		fileOld.delete();
		
		addFile(file);
	}
	
	public void deleteFile(File file) {
		file.delete();
	}
}