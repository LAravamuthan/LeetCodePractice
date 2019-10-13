import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {



	public static String compressedString(String message) {

		StringBuilder result = new StringBuilder();
		int countChar = 1;
		for(int i = 0; i < message.length(); i++) {
			if(i == message.length() -1 || message.charAt(i)!= message.charAt(i+1)) {
				if(countChar == 1) {
					result.append(message.charAt(i));
				}else {
					result.append(message.charAt(i));
					result.append(countChar);
					countChar = 1;
				}
			}else {
				countChar++;
			}
		}
		return result.toString();	
	}
}
