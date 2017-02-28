package com.hard.threads;

import java.io.File;
import java.util.List;

import com.hard.enums.GetRecordsType;
import com.hard.services.RecordsService;

public class MyThread extends Thread {
	private List<File> files;
	private String data;
	private RecordsService recordsService;
	private StringBuilder recordsBuilder = new StringBuilder();
	private GetRecordsType getRecordsType;
	
	private StringBuilder statisticBuilder = new StringBuilder();
	
	public MyThread(List<File> files, String data, RecordsService recordsService, StringBuilder recordsBuilder, GetRecordsType getRecordsType) {
		this.files = files;
		this.data = data;
		this.recordsService = recordsService;
		this.recordsBuilder = recordsBuilder;
		this.getRecordsType = getRecordsType;
	}
	
	public List<File> getFiles() {
		return files;
	}
	
	public void setFiles(List<File> files) {
		this.files = files;
	}
	
	public StringBuilder getStatistic() {
		return statisticBuilder;
	}
	
	public void setCount(StringBuilder statisticBuilder) {
		this.statisticBuilder = statisticBuilder;
	}
	
	@Override
	public void run() {
		for (File file : files) {
			List<String> records = null;
			
			switch (getRecordsType) {
			case getAllRecords:
				records = recordsService.getAllRecords(file);
				break;
			case getAllRecordsByDate:
				records = recordsService.getAllRecordsByDate(file, data);
				break;
			case getAllRecordsByDateGreater:
				records = recordsService.getAllRecordsByDateGreater(file, data);
				break;
			case getAllRecordsByDateLess:
				records = recordsService.getAllRecordsByDateLess(file, data);
				break;
			case getAllRecordsByDateRange:
				records = recordsService.getAllRecordsByDateRange(file, data);
				break;
			case getAllRecordsByUsername:
				records = recordsService.getAllRecordsByUsername(file, data);
				break;
			case getAllRecordsByMessage:
				records = recordsService.getAllRecordsByMessage(file, data);
			case getAllRecordsByUsernameDateRange:
				records = recordsService.getAllRecordsByUsernameDateRange(file, data);
				break;
			default:
				records = recordsService.getAllRecords(file);
				break;
			}
			
			for (String record : records) {
				System.out.println(record);
				recordsBuilder.append(record).append("\n");
			}
			
			statisticBuilder
				.append("file: ")
				.append(file.getAbsolutePath())
				.append("\n")
				.append("total count records: ")
				.append(records.size())
				.append("\n")
				;
		}
	}
}