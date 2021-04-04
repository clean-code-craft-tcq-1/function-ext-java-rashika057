package vitals;

import java.util.HashMap;
import java.util.stream.IntStream;

public class Main {
  

	public static void main(String[] args) {
    	HashMap<BMSFactors,Float> paramVal=new HashMap<>();
    	paramVal.put(BMSFactors.TEMP, 25f);
    	paramVal.put(BMSFactors.SOC, 70f);
    	paramVal.put(BMSFactors.CHARGE_RATE, 0.7f);
        assert(BMSConditionValidator.batteryIsOk(paramVal) == Boolean.TRUE);
        paramVal.put(BMSFactors.TEMP, 50f);
    	paramVal.put(BMSFactors.SOC, 85f);
    	paramVal.put(BMSFactors.CHARGE_RATE, 0.0f);
        assert(BMSConditionValidator.batteryIsOk(paramVal) == Boolean.FALSE);
    }
}
