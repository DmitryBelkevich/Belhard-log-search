package com.hard.strategy;

import java.util.List;

import com.hard.threads.MyThread;

public interface ThreadDistributionStrategy {
	public List<MyThread> execute();
}