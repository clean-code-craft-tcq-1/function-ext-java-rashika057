package vitals;
public class BatteryManagementSystem {
	
InternationalizedText localeText;
	
	public BatteryManagementSystem(InternationalizedText localeText) {
		this.localeText = localeText;
	}
			
    boolean batteryIsOk(float temperature, float soc, float chargeRate) {
    	boolean isTempOk = chargeTemparatureInRange(temperature);
    	boolean issocOk = socInRange(soc);
    	boolean ischargeRateOk = chargeRateInRange(chargeRate);
    	return (isTempOk && issocOk && ischargeRateOk);        
    }
    
    boolean chargeTemparatureInRange(float tempVal) {  
    	Condition temperature = new Condition("temp",0,45);
    	return valueInRange(tempVal,temperature);
    }
    
    boolean dischargeTemparatureInRange(float tempVal) {  
    	Condition temperature = new Condition("dTemp",-20,60);
    	return valueInRange(tempVal,temperature);
    }
    
    boolean socInRange(float socVal) {
    	Condition soc = new Condition("soc",20,80);
    	return valueInRange(socVal,soc);
    }
    
    boolean chargeRateInRange(float chargeRateVal) {
    	Condition chargeRate = new Condition("chargeRate",0,0.8f);
    	return valueInRange(chargeRateVal,chargeRate);
    }
       
    boolean valueInRange(float value,Condition cond) {
    	float warningLevel = (5*cond.getMax())/100;
    	float warningLowLevel = cond.getMin()+warningLevel;
    	float warningHighLevel = cond.getMax()- warningLevel;
    	if(value < cond.getMin()) {
    		localeText.generateMsg(cond.getName(),false,false);
            return false;
        }
    	else if(value > cond.getMax()) {
    		localeText.generateMsg(cond.getName(),true,false);	
            return false;
        }
    	else if(value >= cond.getMin() && value <= warningLowLevel) {
    		localeText.generateMsg(cond.getName(),false,true);
    	}
    	else if(value >= warningHighLevel && value <= cond.getMax()) {
    		localeText.generateMsg(cond.getName(),true,true);
    	}
    	return true;
    }
}