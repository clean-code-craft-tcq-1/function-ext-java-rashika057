package vitals;
import java.util.EnumMap;

public class Main{
  
	static LocaleLang lang;
	public static void main(String[] args) {
		lang = LocaleLang.DE;
    	EnumMap<BMSFactors,Float> paramVal=new EnumMap<>(BMSFactors.class);
    	paramVal.put(BMSFactors.TEMP, 43f);
    	paramVal.put(BMSFactors.SOC, 70f);
    	paramVal.put(BMSFactors.CHARGE_RATE, 0.7f);
        assert(BMSConditionValidator.batteryIsOk(paramVal) == Boolean.TRUE);
        paramVal.put(BMSFactors.TEMP, 50f);
    	paramVal.put(BMSFactors.SOC, 85f);
    	paramVal.put(BMSFactors.CHARGE_RATE, 0.0f);
        assert(BMSConditionValidator.batteryIsOk(paramVal) == Boolean.FALSE);
    }
}
