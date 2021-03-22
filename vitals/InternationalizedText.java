package vitals;

import java.util.*;

public class InternationalizedText {
	
	static Map<String, String> localeMap = new HashMap<>();
    
    InternationalizedText(){
    	localeMap.put("en", "US");
    	localeMap.put("de", "DE");
    }

public static String translate(String text,String language,String country) {
Locale currentLocale;
ResourceBundle messages;
currentLocale = new Locale(language, country);
messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
return messages.getString(text);
}

public static void generateMsg(String condName,String breached, String language) {
String result = "";
if(breached.contains("approaching")) {
result = result.concat(translate("warning", language, getCountry(language)) +": "+translate("approaching", language, getCountry(language))+" ");
}
else {
result = result.concat(translate("crossed", language, getCountry(language)) +" "); 
}
result = result.concat(translate(condName, language, getCountry(language)) +" ");
if(breached.contains("high")) {
result = result.concat(translate("peak", language, getCountry(language)) +"!");
}
else {
result = result.concat(translate("bottom",language, getCountry(language)) +"!");
}
printResult(result);
}

private static void printResult(String result){
	System.out.println(result);
}

private static String getCountry(String language) {
	return localeMap.get(language);
}

}

