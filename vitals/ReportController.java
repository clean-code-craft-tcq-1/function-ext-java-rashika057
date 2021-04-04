package vitals;

import java.util.Map;

public class ReportController implements Reporter {

	@Override
	public void report(Map<String, String> breachedParamList) {
		breachedParamList.keySet().forEach(i -> voiceMessageToDriver(i,breachedParamList.get(i)));
	}

	private void voiceMessageToDriver(String paramName, String condition) {
		//sending message to driver ---> i + ' '+condition
		System.out.println("voice message to driver sent");
	}

}
