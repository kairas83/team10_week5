package org.iptime.kairas.phonebill;

import org.junit.Ignore;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    
    public void testGoldMinuteOver1()
    {
    	Calculator calc = new Calculator();
    	calc.setAccount(new Account("gold",999,1));
    	calc.run();
    	assertEquals(49.95 ,calc.totalCost(), 0.05);
    }
    
    public void testGoldMinuteOver2(){
    	Calculator calc = new Calculator();
    	calc.setAccount(new Account("gold", 1000, 1));
    	calc.run();
    	assertEquals(49.95 ,calc.totalCost(), 0.05);
    }
    
    public void testGoldMinuteOver3(){
    	Calculator calc = new Calculator();
    	calc.setAccount(new Account("gold", 1001, 1));
    	calc.run();
    	assertEquals(50.40 ,calc.totalCost(), 0.05);
    }
    
    public void testGoldMinuteOver4(){
    	Calculator calc = new Calculator();
    	calc.setAccount(new Account("gold", 1010, 1));
    	calc.run();
    	assertEquals(54.45 ,calc.totalCost(), 0.05);
    }
    
    public void testSilverMinuteOver5(){
    	Calculator calc = new Calculator();
    	calc.setAccount(new Account("silver", 499, 1));
    	calc.run();
    	assertEquals(29.95 ,calc.totalCost(), 0.05);
    }
    
    public void testSilverMinuteOver6(){
    	Calculator calc = new Calculator();
    	calc.setAccount(new Account("silver", 500, 1));
    	calc.run();
    	assertEquals(29.95 ,calc.totalCost(), 0.05);
    }
    
    public void testSilverMinuteOver7(){
    	Calculator calc = new Calculator();
    	calc.setAccount(new Account("silver", 520, 1));
    	calc.run();
    	assertEquals(40.75 ,calc.totalCost(), 0.05);
    }
    
    public void testNumberOfGoldLines1(){
    	Calculator calc = new Calculator();
    	calc.setAccount(new Account("gold", 0, 2));
    	calc.run();
    	assertEquals(64.45 ,calc.totalCost(), 0.05);
    }
    
    public void testNumberOfGoldLines2(){
    	Calculator calc = new Calculator();
    	calc.setAccount(new Account("gold", 0, 3));
    	calc.run();
    	assertEquals(78.95 ,calc.totalCost(), 0.05);
    }
    
    public void testNumberOfGoldLines3(){
    	Calculator calc = new Calculator();
    	calc.setAccount(new Account("gold", 0, 4));
    	calc.run();
    	assertEquals(83.95 ,calc.totalCost(), 0.05);
    }
    
    public void testNumberOfSilverLines1(){
    	Calculator calc = new Calculator();
    	calc.setAccount(new Account("silver", 0, 4));
    	calc.run();
    	assertEquals(77.95 ,calc.totalCost(), 0.05);
    }
    
    public void testNumberOfSilverLines2(){
    	Calculator calc = new Calculator();
    	calc.setAccount(new Account("silver", 0, 5));
    	calc.run();
    	assertEquals(82.95 ,calc.totalCost(), 0.05);
    }
    
    public void testMakePlan(){
    	Plan plan = new Plan("Gold", 0, 0, 0, 0){};
    	assertEquals("Gold", plan.planType());
    	assertEquals(0.0, plan.basicMonthlyRate());
    	assertEquals(0.0, plan.ratePerAdditionalLine());
    	assertEquals(0.0, plan.ratePerExcessMinute());
    	assertEquals(0, plan.includedMinutes());	
    	}
    
    public void testMakeGoldPlan(){ 
    	Gold gold = new Gold();
    	assertEquals(Gold.PLAN_TYPE, gold.planType());
    	assertEquals(Gold.BASIC_MONTHLY_RATE, gold.basicMonthlyRate());
    	assertEquals(Gold.RATE_PER_ADDITIONAL_LINE, gold.ratePerAdditionalLine());
    	assertEquals(Gold.RATE_PER_EXCESS_MINUTE, gold.ratePerExcessMinute());
    	assertEquals(Gold.INCLUDED_MINUTES, gold.includedMinutes());
    }
    
    public void testMakeSilverPlan(){ 
    	Silver silver = new Silver();
    	assertEquals(Silver.PLAN_TYPE, silver.planType());
    	assertEquals(Silver.BASIC_MONTHLY_RATE, silver.basicMonthlyRate());
    	assertEquals(Silver.RATE_PER_ADDITIONAL_LINE, silver.ratePerAdditionalLine());
    	assertEquals(Silver.RATE_PER_EXCESS_MINUTE, silver.ratePerExcessMinute());
    	assertEquals(Silver.INCLUDED_MINUTES, silver.includedMinutes());	    	
    }
    
    public void testAccount(){
    	Account account = new Account("gold",1000,3);
    	assertEquals("gold", account.planType());
    	assertEquals(1000, account.minutesUsed());
    	assertEquals(3, account.numberOfLines());
    	
    }
}