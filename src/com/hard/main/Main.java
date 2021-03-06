package com.hard.main;

import java.io.File;
import java.util.List;

import com.hard.enums.GetRecordsType;
import com.hard.services.FileService;
import com.hard.services.RecordsService;
import com.hard.strategy.ThreadDistributionContext;
import com.hard.strategy.ThreadDistributionStrategy1;
import com.hard.threads.MyThread;

public class Main {
	public static void main(String[] args) {
		/**
		 * input params:
		 * rules for RegExp:
		 * 
		 * - Single filter parameters:
		 * getAllRecordsByDate | getAllRecordsByDateGreater | getAllRecordsByDateLess
		 * data - "12:00:00"
		 * 
		 * GetRecordsType.getAllRecordsByDateRange
		 * data - "12:00:07-13:00:06"
		 * 
		 * - Grouping filter parameters:
		 * GetRecordsType.getAllRecordsByUsernameDateRange;
		 * data - "12:00:05-13:00:06 [user1]"
		 */
		String path = "c:/Belhard/000/logs";		// log-files folder
		String data = "12:00:05-13:00:06 [user1]";	// input param
		int countThreads = 3;						// count of threads
		String outputFile = "c:/output.txt";		// output file
		GetRecordsType getRecordsType = GetRecordsType.getAllRecordsByUsernameDateRange;
		
		FileService fileService = new FileService();
		RecordsService recordsService = new RecordsService();
		
		StringBuilder recordsBuilder = new StringBuilder();
		List<File> files = fileService.getAllFiles(path);
		
		/**
		 * ��������� ��������������� ������������� ������ �� �������:
		 * ��������: �� ���� ������� ������ �� 5-�� ������, � ���������� ������� ������ 3.
		 * �� ������ ������� ������ �������, ������ �� ������� �������������� ������������: { 2 �����, 2 �����, 1 ���� }
		 * ���� ������� ���������� ������� ������, ��� ���������� ������, �� ������ ��������� �� ���������
		 * � ���������� ������� ������ ������ ���������� ������
		 */
		ThreadDistributionContext context = new ThreadDistributionContext(new ThreadDistributionStrategy1(files, countThreads, data, recordsService, recordsBuilder, getRecordsType));
		
		List<MyThread> threads = context.execute();
		
		/**
		 * run threads
		 */
		for (MyThread thread : threads)
			thread.start();
		
		for (MyThread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * output file of all founded records and total statistic
		 */
		recordsBuilder.append("\nTotal statistic:\n\n");
		for (MyThread thread : threads) {
			recordsBuilder
				.append(thread.getName() + " has handled:\n")
				.append(thread.getStatistic())
				.append("\n")
				;
		}
		System.out.println(recordsBuilder);
		recordsService.addRecords(new File(outputFile), recordsBuilder.toString());
	}
}