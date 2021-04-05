package vitals;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class BMSConditionValidator {
	static final String IS_LOW = "low";
	static final String IS_HIGH = "high";
	static final String IS_WARNING = "approaching";
	static final String NORMAL = "Ok";
	
	static String valueInRange(float min,float max,float value) {
    	if(value < min) {
            return IS_LOW;
        }
    	else if(value > max) {
            return IS_HIGH;
        }
    	return NORMAL;
    }
    
       
    static String valueInWarningRange(float lowLevel, float highLevel,float value) {
    	String result = valueInRange(lowLevel,highLevel,value);
    	if(result.equals(NORMAL)) {
    		float warningLevel = (5*highLevel)/100;
    		result = valueInRange(lowLevel+warningLevel,highLevel-warningLevel,value);
    		return result.equals(NORMAL)? NORMAL : IS_WARNING + " " + result;
    	}
    	return result; 
    }
    
    static boolean batteryIsOk(EnumMap<BMSFactors,Float> paramVal) {
    	EnumMap<BMSFactors,String> paramResult=new EnumMap<>(BMSFactors.class);
    	paramVal.forEach((param,val) -> paramResult.put(param,BMSConditionValidator.valueInWarningRange(param.getLowerLimit(),param.getHigherLimit(),val))
    	);
    	consolidateAndReport(paramResult);
    	return isOk(paramResult);
    }

    private static boolean isOk(EnumMap<BMSFactors, String> paramResult) {
    	return paramResult.values().stream().allMatch(val -> val.equals(NORMAL) || val.contains(IS_WARNING));
	}
    
    private static void consolidateAndReport(EnumMap<BMSFactors, String> paramResult) {
    	Map<String, String> hmap = new HashMap<>(); 
    	paramResult.forEach((k,v) -> hmap.put(k.getName(),v));
        Reporter report=new ReportConsole();
        BreachedBMSParamConsolidator bmsConsolidator = new BreachedBMSParamConsolidator(hmap,report);
        bmsConsolidator.consolidateBreachedParamForReporting();
	}
}
