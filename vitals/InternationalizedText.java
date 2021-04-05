package vitals;
import java.util.Locale;
import java.util.ResourceBundle;  

public class InternationalizedText {
    
public static String translate(String text) {
Locale locale = new Locale(Main.lang.getLanguage(), Main.lang.getCountry());
ResourceBundle bundle = ResourceBundle.getBundle("MessagesBundle",locale);  
return bundle.getString(text);
}

public static void generateMsg(String condName,String breached) {
String result = "";
if(breached.contains("approaching")) {
result = result.concat(translate("warning") +": "+translate("approaching")+" ");
}
else {
result = result.concat(translate("crossed") +" "); 
}
result = result.concat(translate(condName) +" ");
if(breached.contains("high")) {
result = result.concat(translate("peak") +"!");
}
else {
result = result.concat(translate("bottom") +"!");
}
printResult(result);
}

private static void printResult(String result){
	System.out.println(result);
}

}

