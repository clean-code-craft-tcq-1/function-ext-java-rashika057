package vitals;
import java.util.Map;

public class ReportConsole implements Reporter {	
	
	@Override
	public void report(Map<String, String> breachedParamList) {
		breachedParamList.keySet().forEach(i -> printMessage(i,breachedParamList.get(i)));
	}

	private void printMessage(String param, String result) {
		InternationalizedText.generateMsg(param, result);
	}
	}