package vitals;

public class BMSConditionValidator {
	static String valueInRange(float min,float max,float value) {
    	if(value < min) {
            return BMS.IS_LOW;
        }
    	else if(value > max) {
            return BMS.IS_HIGH;
        }
    	return BMS.NORMAL;
    }
    
       
    static String valueInWarningRange(float lowLevel, float highLevel,float value) {
    	String result = valueInRange(lowLevel,highLevel,value);
    	if(result.equals(BMS.NORMAL)) {
    		float warningLevel = (5*highLevel)/100;
    		if(value <= (lowLevel+warningLevel)) {
    			return BMS.IS_WARNING_LOW;
    		}
    		else if(value >= (highLevel-warningLevel)) {
    			return BMS.IS_WARNING_HIGH;
    		}
    	}
    	else {
    		return result; 
    	}
    	return BMS.NORMAL;
    }
    
    static String check(String chargeTemparatureHigh, String chargeTemparatureLow) {
		if(chargeTemparatureHigh.equals(BMS.IS_HIGH)) {
		return BMS.IS_HIGH;
		}
		else if(chargeTemparatureLow.equals(BMS.IS_LOW)) {
			return BMS.IS_LOW;
		}
		return BMS.NORMAL;
	}
}
