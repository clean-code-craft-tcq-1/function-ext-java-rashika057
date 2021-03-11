package vitals;

public class Condition {
		private String name;
	    private float min;
	    private float max;
		public Condition(String name, float min,float max) {
			this.name = name;
			this.min = min;
			this.max = max;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public float getMin() {
			return min;
		}
		public void setMin(float min) {
			this.min = min;
		}
		public float getMax() {
			return max;
		}
		public void setMax(float max) {
			this.max = max;
		}	    
	    
}

