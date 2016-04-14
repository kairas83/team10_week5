package org.iptime.kairas.phonebill;

public abstract class Plan {
	static final int LINE_AMOUNT_FOR_FAMILY_DISCOUNT = 4;
	static final double RATE_OF_FAMILY_DISCOUNT = 5.00;
	
	private String planType;
	private double basicMonthlyRate;
	private double ratePerAdditionalLine;
	private double ratePerExcessMinute;
	private int includedMinutes;
	
	private Plan(){
		//hide empty constructor
	}
	
	public Plan(String aPlanType, double aBasicMonthlyRate, double aRatePerAdditionalLine, double aRatePerExcessMinute, int aIncludedMinutes){
		planType = aPlanType;
		basicMonthlyRate = aBasicMonthlyRate;
		ratePerAdditionalLine = aRatePerAdditionalLine;
		ratePerExcessMinute = aRatePerExcessMinute;
		includedMinutes = aIncludedMinutes;
	}
	
	public String planType(){
		return planType;
	}
	
	public double basicMonthlyRate(){
		return basicMonthlyRate;
	}
	
	public double ratePerAdditionalLine(){
		return ratePerAdditionalLine;
	}
	
	public double ratePerExcessMinute(){
		return ratePerExcessMinute;
	}
	
	public int includedMinutes(){
		return includedMinutes;
	}
}
