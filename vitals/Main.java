package vitals;

public class Main {
    public static void main(String[] args) {
    	InternationalizedText localeText=new InternationalizedText("de","DE");    	
    	BatteryManagementSystem bms =new BatteryManagementSystem(localeText);
        assert(bms.batteryIsOk(25, 70, 0.7f) == true);
        assert(bms.batteryIsOk(50, 85, 0.0f) == false);
        assert(bms.batteryIsOk(40, 60, 0.9f) == false);
        assert(bms.chargeTemparatureInRange(60) == false);
        assert(bms.dischargeTemparatureInRange(60) == true);
        assert(bms.socInRange(10) == false);
        assert(bms.chargeRateInRange(1.2f) == false);
    }
}
