package com.companionly.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class MoodTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoodTrackerApplication.class, args);
	}

}
