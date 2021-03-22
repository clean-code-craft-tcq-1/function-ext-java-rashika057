package vitals;

import javafx.util.Pair;

public class BMS {
	
	static final String IS_LOW = "is low";
	static final String IS_HIGH = "is high";
	static final String IS_WARNING_LOW = "is approaching low";
	static final String IS_WARNING_HIGH = "is approaching high";
	static final String NORMAL = "Ok";
	static final float TEMP_LOWER_LIMIT =  0;
	static final float TEMP_UPPER_LIMIT =  45;
	static final float SOC_LOWER_LIMIT =  20;
	static final float SOC_UPPER_LIMIT =  80;
	static final float CHARGE_RATE_UPPER_LIMIT =  0.8f;
	    
    static String chargeTemparatureWithinWarningRange(float tempVal) { 
    	return BMSConditionValidator.valueInWarningRange(new Pair<>(TEMP_LOWER_LIMIT, TEMP_UPPER_LIMIT) ,tempVal);
    }
		
	static String socWithinWarningRange(float socVal) {
    	return BMSConditionValidator.valueInWarningRange(new Pair <> (SOC_LOWER_LIMIT, SOC_UPPER_LIMIT),socVal);
    }
	 
    static String chargeRateWithinWarningRange(float chargeRateVal) {
    	return BMSConditionValidator.valueInWarningRange(new Pair <> (chargeRateVal, CHARGE_RATE_UPPER_LIMIT),chargeRateVal);
    }

	static String chargeTemparatureHigh(float tempVal) {
		return BMSConditionValidator.valueInRange(tempVal, TEMP_UPPER_LIMIT, tempVal);
    }
	
	static String chargeTemparatureLow(float tempVal) { 
    	return BMSConditionValidator.valueInRange(TEMP_LOWER_LIMIT, tempVal, tempVal);
    }
    
    static String socLow(float socVal) {
    	return BMSConditionValidator.valueInRange(SOC_LOWER_LIMIT, socVal, socVal);
    }
    
    static String socHigh(float socVal) {
    	return BMSConditionValidator.valueInRange(socVal, SOC_UPPER_LIMIT, socVal);
    }
       
    static String chargeRateHigh(float chargeRateVal) {
    	return BMSConditionValidator.valueInRange(chargeRateVal, CHARGE_RATE_UPPER_LIMIT, chargeRateVal);
    }    
}
