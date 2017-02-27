package com.hard.strategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.hard.enums.GetRecordsType;
import com.hard.services.RecordsService;
import com.hard.threads.MyThread;

/*
 * данная стратегия распределяет количество обрабатываемых файлов наиболее равномерно по потокам
 * т.е. { 10, 10, 9 } вместо { 14, 14, 1 }
 */
public class ThreadDistributionStrategy1 implements ThreadDistributionStrategy {
	private List<File> files;
	private int countThreads;
	private String data;
	private RecordsService recordsService;
	private StringBuilder recordsBuilder;
	private GetRecordsType getRecordsType;
	
	public ThreadDistributionStrategy1(List<File> files, int countThreads, String data, RecordsService recordsService, StringBuilder recordsBuilder, GetRecordsType getRecordsType) {
		this.files = files;
		this.countThreads = countThreads;
		this.data = data;
		this.recordsService = recordsService;
		this.recordsBuilder = recordsBuilder;
		this.getRecordsType = getRecordsType;
	}
	
	@Override
	public List<MyThread> execute() {
		int countFiles = files.size();
		
		if (countFiles <= countThreads) {
			countThreads = files.size();
		}
		
		int node = Math.round(countFiles / (float) countThreads);
		
		List<MyThread> threads = new ArrayList<>();
		
		for (int i = 0; i < countThreads; i++) {
			if (i <= countThreads - 2) {
				List<File> list = new ArrayList<>();
				for (int j = 0; j < node; j++)
					list.add(files.get(j + node * i));
				threads.add(new MyThread(list, data, recordsService, recordsBuilder, getRecordsType));
				
				countFiles -= node;
			} else {
				List<File> list = new ArrayList<>();
				for (int j = 0; j < countFiles; j++)
					list.add(files.get(j + node * i));
				threads.add(new MyThread(list, data, recordsService, recordsBuilder, getRecordsType));
			}
		}
		
		return threads;
	}
}