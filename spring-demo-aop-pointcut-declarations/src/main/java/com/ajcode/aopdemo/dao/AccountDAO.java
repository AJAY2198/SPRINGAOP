package com.ajcode.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.ajcode.aopdemo.Account;

@Component("AddAccount")
public class AccountDAO {
	
	public void addAccount(Account account,boolean a) {
		System.out.println(getClass()+ ": doing my db work: adding an account");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+ " : dowork()");
		return true;
	}

}
