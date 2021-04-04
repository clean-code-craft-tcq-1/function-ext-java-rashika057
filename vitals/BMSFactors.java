package vitals;

public enum BMSFactors {
	TEMP("temp",0,45),
    SOC("soc",20,80),
    CHARGE_RATE("chargeRate",Float.NaN,0.8f);
    
	private String name;
	private float lowerLimit;
	private float higherLimit;
	
	private BMSFactors(String name, float lowerLimit, float higherLimit) {
        this.name = name;
        this.lowerLimit = lowerLimit;
        this.higherLimit = higherLimit;
    }

	public String getName() {
		return name;
	}

	public float getLowerLimit() {
		return lowerLimit;
	}

	public float getHigherLimit() {
		return higherLimit;
	}
  }
