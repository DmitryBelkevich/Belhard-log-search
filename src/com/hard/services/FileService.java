package com.hard.services;

import java.io.File;
import java.util.List;

import com.hard.dao.FileDao;

public class FileService {
	private FileDao fileDao = new FileDao();
	
	public List<File> getAllFiles(String path) {
		return fileDao.getAllFiles(path);
	}
	
	public File getFile(String path) {
		return fileDao.getFile(path);
	}
	
	public void addFile(File file) {
		fileDao.addFile(file);
	}
	
	public void updateFile(File file) {
		fileDao.updateFile(file);
	}
	
	public void deleteFile(File file) {
		fileDao.deleteFile(file);
	}
}