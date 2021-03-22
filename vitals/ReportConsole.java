package vitals;

import java.util.Map;

public class ReportConsole implements Reporter {	

	@Override
	public void report(Map<String, String> breachedParamList) {
		breachedParamList.keySet().forEach(i -> Main.printMessage(i,breachedParamList.get(i)));
	}
	}
