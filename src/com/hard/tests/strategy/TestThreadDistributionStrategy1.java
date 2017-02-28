package com.hard.tests.strategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hard.enums.GetRecordsType;
import com.hard.services.RecordsService;
import com.hard.strategy.ThreadDistributionStrategy;
import com.hard.strategy.ThreadDistributionStrategy1;
import com.hard.threads.MyThread;

public class TestThreadDistributionStrategy1 {
	private ThreadDistributionStrategy threadDistributionStrategy1;
	
	@Before
	public void init() {
		List<File> files = new ArrayList<>();
		int countThread = 3;
		String data = "10:00:00";
		RecordsService recordsService = new RecordsService();
		StringBuilder recordsBuilder = new StringBuilder();
		GetRecordsType getRecordsType = GetRecordsType.getAllRecords;
		
		for (int i = 0; i < 7; i++)
			files.add(new File(""));
		
		threadDistributionStrategy1 = new ThreadDistributionStrategy1(files, countThread, data, recordsService, recordsBuilder, getRecordsType);
	}
	
	@After
	public void destroy() {
		threadDistributionStrategy1 = null;
	}
	
	@Test
	public void testExecute() {
		List<MyThread> myThread = threadDistributionStrategy1.execute();
		
		Assert.assertNotNull(myThread);
		
		Assert.assertEquals(myThread.size(), 3);
		
		Assert.assertEquals(myThread.get(0).getFiles().size(), 2);
		Assert.assertEquals(myThread.get(1).getFiles().size(), 2);
		Assert.assertEquals(myThread.get(2).getFiles().size(), 3);
	}
}