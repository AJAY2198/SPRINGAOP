package com.ajcode.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Expect heavy traffic";
	}

	public String getFortune(boolean tripWire) {
		
		if(tripWire) {
			throw new RuntimeException("Bad Fortune Hit");
		}
			return getFortune();
		
	}
	
}
