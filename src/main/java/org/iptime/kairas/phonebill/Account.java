package org.iptime.kairas.phonebill;

public class Account {
	private int numberOfLines;
	private int minutesUsed;
	private String planType;
	
	private Account(){
		//hide empty constructor
	}
	
	public Account(String aPlanType, int aMinutesUsed, int aNumberOfLines){
		planType = aPlanType;
		minutesUsed = aMinutesUsed;
		numberOfLines = aNumberOfLines;
	}
	
	public int numberOfLines(){
		return numberOfLines;
	}

	public int minutesUsed(){
		return minutesUsed;
	}

	public String planType(){
		return planType;
	}
}
