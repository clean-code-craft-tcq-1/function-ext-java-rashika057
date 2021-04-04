package vitals;


import java.util.Map;
import java.util.stream.Collectors;

public class BreachedBMSParamConsolidator {
	
	Map<String, String> params;
	
	Reporter reporter;
	
	BreachedBMSParamConsolidator(Map<String, String> hmap,Reporter reporter){
	this.params = hmap;
	this.reporter = reporter;
	}
	
	void consolidateBreachedParamForReporting(){
		Map<String, String> breachedParams = this.params.entrySet().stream().filter(i -> !i.getValue().equals(BMSConditionValidator.NORMAL)).collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
		this.reporter.report(breachedParams);
	}
	
	}
