package asu.edu.arav.impfacebook.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n < 1) {
            return null;
        }
        if (n == 1) {
            return "1";
        }

        StringBuffer resultantString = new StringBuffer("11");

        for (int i = 2; i < n; i++) {
            StringBuffer tempString = new StringBuffer();
            int count = 1;
            for (int j = 1; j < resultantString.length(); j++) {
                if (resultantString.charAt(j - 1) == resultantString.charAt(j)) {
                    count++;
                } else {
                    tempString.append(count);
                    tempString.append(resultantString.charAt(j - 1));
                    count = 1;
                }
            }
            tempString.append(count);
            tempString.append(resultantString.charAt(resultantString.length()-1));
            resultantString = tempString;
        }
        return resultantString.toString();
    }
}
