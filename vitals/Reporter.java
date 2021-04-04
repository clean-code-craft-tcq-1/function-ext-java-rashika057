package vitals;

import java.util.Map;

public interface Reporter {
	
	void report(Map<String, String> params);
}
