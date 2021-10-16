package com.example.TaskSchedularMaven;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheludedTask {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
 // 
//	@Scheduled(cron = "3 * * * * ?" )
//	public void taskRun() {
//		System.out.println("Schedular run:"+dateFormat.format(new Date()));
//	}
	
	@Scheduled(fixedDelay =3000)
	public void demoServiceMethod1() {System.out.println("Schedular run:"+dateFormat.format(new Date()));}
//	 
//	@Scheduled(fixedRate=30000)
//	public void demoServiceMethod () {... }
//	 
	@Scheduled(cron="0 5 21 * * *")
	public void demoServiceMethod () {
		System.out.println("NEW Schedular run:"+dateFormat.format(new Date()));
	}
	
	

//These are valid formats for cron expressions:
//
//1.	0 0 * * * * = the top of every hour of every day.
//2.	*/10 * * * * * = every ten seconds.
//3. 	0 0 8-10 * * * = 8, 9 and 10 o'clock of every day.
//4.	0 0 6,19 * * * = 6:00 AM and 7:00 PM every day.
//5.	0 0/30 8-10 * * * = 8:00, 8:30, 9:00, 9:30, 10:00 and 10:30 every day.
//6.	0 0 9-17 * * MON-FRI = on the hour nine-to-five weekdays
//7. 	0 0 0 25 12 ? = every Christmas Day at midnight
//	
//The pattern is:	second, minute, hour, day, month, weekday
//So your answer is:	0 0 0 * * *	


	
	
}
