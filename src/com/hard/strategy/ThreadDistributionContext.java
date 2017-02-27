package com.hard.strategy;

import java.util.List;

import com.hard.threads.MyThread;

public class ThreadDistributionContext {
	private ThreadDistributionStrategy strategy;
	
	public ThreadDistributionContext(ThreadDistributionStrategy strategy) {
		this.strategy = strategy;
	}
	
	public ThreadDistributionStrategy getStrategy() {
		return strategy;
	}
	
	public void setStrategy(ThreadDistributionStrategy strategy) {
		this.strategy = strategy;
	}
	
	public List<MyThread> execute() {
		return strategy.execute();
	}
}