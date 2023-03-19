package com.ajcode.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	
	
	public boolean addMemeber() {
		
		System.out.println(getClass()+": adding membership account");
		return true;
	}
	public boolean doWork() {
		System.out.println(getClass()+ " : dowork()");
		return true;
	}
}
