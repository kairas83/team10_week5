package org.iptime.kairas.phonebill;

public class Calculator {
	private static final int PLAN_AMMOUNT = 2;
	private static final int GOLD = 0;
	private static final int SILVER = 1;
	private double totalCost;
	private String totalCostFormular;
	private Plan[] plans;
	private Account account;
	
	public Calculator(){
		plans = new Plan[PLAN_AMMOUNT];
		plans[GOLD] = new Gold();
		plans[SILVER] = new Silver();
	}
	
	public void setAccount(Account aAccount){
		account = aAccount;
	}
	
	public void run(){
		if(planIsGold()){
			calculate(account.minutesUsed(), account.numberOfLines(), plans[GOLD]);
		}
		else if(planIsSilver()){
			calculate(account.minutesUsed(), account.numberOfLines(), plans[SILVER]);
		}
		else{
			saveEmptyValue();
		}
	}
	
	private void saveEmptyValue() {
		totalCost = 0;
		totalCostFormular = "";
	}

	private boolean planIsGold(){
		if("gold".equalsIgnoreCase(account.planType())){
			return true;
		}
		return false;
	}
	
	private boolean planIsSilver(){
		if("silver".equalsIgnoreCase(account.planType())){
			return true;
		}
		return false;
	}
	
	public void calculate(int minutes, int numberOfLines, Plan plan){
		if(minutes <= plan.includedMinutes()){
			totalCost = plan.basicMonthlyRate();
			totalCostFormular = Double.toString(plan.basicMonthlyRate());
		}
		else {
			double excessMinutesCost = (minutes - plan.includedMinutes()) * plan.ratePerExcessMinute();
			totalCost = plan.basicMonthlyRate() + excessMinutesCost;
			String excessMinutesFormula =  " + (" + Integer.toString(minutes - plan.includedMinutes()) + "*" + Double.toString(plan.ratePerExcessMinute()) + ")";
			totalCostFormular = Double.toString( plan.basicMonthlyRate() ) + excessMinutesFormula;
		}		
		if(numberOfLines < Plan.LINE_AMOUNT_FOR_FAMILY_DISCOUNT){
			totalCost += (numberOfLines-1) * plan.ratePerAdditionalLine();
			totalCostFormular += " + (" + Integer.toString(numberOfLines-1) + "*" + Double.toString(plan.ratePerAdditionalLine()) + ")";
		}
		else {
			totalCost += (Plan.LINE_AMOUNT_FOR_FAMILY_DISCOUNT -2) * plan.ratePerAdditionalLine() + (numberOfLines - Plan.LINE_AMOUNT_FOR_FAMILY_DISCOUNT + 1) * Plan.RATE_OF_FAMILY_DISCOUNT;
			totalCostFormular += " + (" + Integer.toString(Plan.LINE_AMOUNT_FOR_FAMILY_DISCOUNT -2) + "*" + Double.toString(plan.ratePerAdditionalLine()) + ") + (" + Integer.toString(numberOfLines - Plan.LINE_AMOUNT_FOR_FAMILY_DISCOUNT + 1) + "*" + Double.toString(Plan.RATE_OF_FAMILY_DISCOUNT) + ")";
		}
	}
	
	public double totalCost()
	{
		return totalCost;
	}
	
	public String totalCostFormular()
	{
		return totalCostFormular;
	}
}
