package asu.edu.arav.impfacebook.arraystring;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class IPAddressValidate {

    private static final String IP4ADDRESS_PATTERN =
            "((([1-9]?|1\\d|2[0-4])\\d|25[0-5])\\.){3}(([1-9]?|1\\d|2[0-4])\\d|25[0-5])";

    private static final String IP6ADDRESS_PATTERN =
            "(?i)([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";

    private static final Pattern IPV4_PATTERN =
            Pattern.compile(IP4ADDRESS_PATTERN);


    private static final Pattern IPV6_PATTERN =
            Pattern.compile(IP6ADDRESS_PATTERN);


    public static boolean isIPv4Address(final String input) {
        return IPV4_PATTERN.matcher(input).matches();
    }

    public static boolean isIPv6Address(final String input) {
        return IPV6_PATTERN.matcher(input).matches();
    }

    public List<String> checkIPs(List<String> ip_array) {
        List<String> result = new ArrayList<String>();
        for (String s : ip_array) {
            result.add(validIPAddress(s));
        }
        return result;
    }

    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) {
            return "Neither";
        }
        String result = null;

        if (isIPv4Address(IP)) {
            result = "IPv4";
        } else if (isIPv6Address(IP)) {
            result = "IPv6";
        } else {
            result = "Neither";
        }
        return result;
    }

}
