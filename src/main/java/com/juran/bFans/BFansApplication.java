package com.juran.bFans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//开启定时功能
@EnableScheduling
public class BFansApplication {
	public static void main(String[] args) {
		SpringApplication.run(BFansApplication.class, args);
	}
}
