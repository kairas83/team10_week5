package org.iptime.kairas.phonebill;

public class Gold extends Plan{
	static final String PLAN_TYPE = "Gold";
	static final double BASIC_MONTHLY_RATE = 49.95;
	static final double RATE_PER_ADDITIONAL_LINE = 14.50;
	static final double RATE_PER_EXCESS_MINUTE = 0.45;
	static final int INCLUDED_MINUTES = 1000;
	
	public Gold(){
		super(PLAN_TYPE, BASIC_MONTHLY_RATE, RATE_PER_ADDITIONAL_LINE, RATE_PER_EXCESS_MINUTE, INCLUDED_MINUTES);
	}
}