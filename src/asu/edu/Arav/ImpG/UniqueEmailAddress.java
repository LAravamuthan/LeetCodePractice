package asu.edu.Arav.ImpG;

import java.util.HashSet;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class UniqueEmailAddress {
    public static int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueLocalNames = new HashSet<String>();
        HashSet<String> uniqueDomainNames = new HashSet<String>();
        int count = 0;


        for (int i = 0; i < emails.length; i++) {
            String[] names = emails[i].split("@");
            String[] localNames = names[0].split("\\+");
            if (!uniqueLocalNames.contains(localNames[0].replaceAll("\\.", ""))
                    || !uniqueDomainNames.contains(names[1])) {
                uniqueLocalNames.add(localNames[0].replaceAll("\\.", ""));
                uniqueDomainNames.add(names[1]);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] input = {"test.email+alex@leetcode.com", "test.email.leet+alex@code.com"};
        System.out.println(numUniqueEmails(input));
    }
}
