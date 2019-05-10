import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static List<String> checkIPs(List<String> ip_array) {

		List<String> result = new ArrayList<String>();
		Pattern ip4 = Pattern.compile("^((2[0-5]\\d|[01]?\\d{0,2})\\.){3}(2[0-5]\\d|[01]?\\d{0,2})$");
		Pattern ip6 = Pattern.compile("^([\\da-f]{1,4}:){7}[\\da-f]{1,4}$");
		for (String s : ip_array) {
			Matcher m_ip4 = ip4.matcher(s);
			Matcher m_ip6 = ip6.matcher(s);
			if (m_ip4.find()) {
				result.add("IPv4");
			} else if (m_ip6.find()) {
				result.add("IPv4");
			} else {
				result.add("Neither");
			}
		}

		return result;
	}

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
