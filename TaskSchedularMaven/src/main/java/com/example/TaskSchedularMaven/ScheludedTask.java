package com.example.TaskSchedularMaven;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheludedTask {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(cron = "1 * * * * ?" )
	public void taskRun() {
		System.out.println("Schedular run:"+dateFormat.format(new Date()));
	}
	
//	@Scheduled(fixedDelay =30000)
//	public void demoServiceMethod () {... }
//	 
//	@Scheduled(fixedRate=30000)
//	public void demoServiceMethod () {... }
//	 
//	@Scheduled(cron="0 0 * * * *")
//	public void demoServiceMethod () {... }
}
