package vitals;

import javafx.util.Pair;

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
    
    static float calcWarningLevel(float max) {
    	return (5*max)/100;
    }
    
    static String valueInWarningRange(Pair<Float, Float> pair,float value) {
    	String result = valueInRange(pair.getKey(),pair.getValue(),value);
    	float warningLevel = calcWarningLevel(pair.getValue());
    	if(result.equals(BMS.NORMAL)) {
    	if(value <= (pair.getKey()+warningLevel)) {
    		return BMS.IS_WARNING_LOW;
    	}
    	else if(value >= (pair.getValue()-warningLevel)) {
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
