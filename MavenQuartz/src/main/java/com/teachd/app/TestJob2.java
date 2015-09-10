package com.teachd.app;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class TestJob2 implements Job {
	public void execute(JobExecutionContext arg0) {
		System.out.println("TestJob2.execute() is Executed... : " + new Date());
	}
}
