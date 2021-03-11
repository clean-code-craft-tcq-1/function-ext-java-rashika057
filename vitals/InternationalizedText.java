package vitals;

import java.util.*;

public class InternationalizedText {
	
String language;
String country;

public InternationalizedText(String language,String country) {
this.language = language;
this.country = country;
}

public String translate(String text) {
if (language.isEmpty() && country.isEmpty()) {
	language = new String("en");
	country = new String("US");
} 
Locale currentLocale;
ResourceBundle messages;
currentLocale = new Locale(language, country);
messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
return messages.getString(text);
}

public void generateMsg(String condName,boolean isHigh,boolean isWarning) {
String result = "";
if(isWarning)
result = result.concat(translate("warning") +": "+translate("approaching")+" ");
else
result = result.concat(translate("crossed") +" "); 
result = result.concat(translate("condName") +" ");
if(isHigh)
result = result.concat(translate("peak") +"!");
else
result = result.concat(translate("bottom") +"!");
System.out.println(result);
}

}

