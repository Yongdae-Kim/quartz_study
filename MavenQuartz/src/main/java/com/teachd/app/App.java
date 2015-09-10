package com.teachd.app;

import java.text.ParseException;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class App {
	private SchedulerFactory schedFact;
	private Scheduler sched;

	public App() {
		try {
			// 스케쥴 생성후 시작
			schedFact = new StdSchedulerFactory();
			sched = schedFact.getScheduler();
			sched.start();

			// Job1 생성 (Parameter : 1.Job Name, 2.Job Group Name, 3.Job Class)
			JobDetail job1 = new JobDetail("job1", "group1", TestJob1.class);

			// Trigger1 생성 (Parameter : 1.Trigger Name, 2.Trigger Group Name,
			// 3.Cron Expression)
			CronTrigger trigger1 = new CronTrigger("trigger1", "group1",
					"0/5 * * * * ?");

			// 아래는 trigger 가 misfire 되었을 경우에 대한 처리를 설정한다.
			// trigger1.setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_DO_NOTHING);
			sched.scheduleJob(job1, trigger1);

			// Job2 생성후 등록
			JobDetail job2 = new JobDetail("job2", "group2", TestJob2.class);
			CronTrigger trigger2 = new CronTrigger("trigger2", "group2",
					"0 0/1 * * * ?");
			sched.scheduleJob(job2, trigger2);
			// Job2 삭제 (30초 후)
			// Thread.sleep(30000);
			// sched.deleteJob("job2", "group2");
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new App();
	}
}
