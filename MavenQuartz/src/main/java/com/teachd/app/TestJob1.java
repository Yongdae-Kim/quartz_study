package com.teachd.app;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class TestJob1 implements Job {
	public void execute(JobExecutionContext arg0){
		System.out.println("TestJob1.execute() is Executed... : " + new Date());
	}
}
