package com.ajcode.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.ajcode.aopdemo.Account;

@Component("AddAccount")
public class AccountDAO {
	private String name;
	private String serviceCode;

	public String getName() {
		System.out.println(getClass()+ " : getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+ " : setName()");
		this.name = name;
	}

	

	public String getServiceCode() {
		System.out.println(getClass()+ " : getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+ " : setServiceCode()");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account account,boolean a) {
		System.out.println(getClass()+ ": doing my db work: adding an account");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+ " : dowork()");
		return true;
	}

}
