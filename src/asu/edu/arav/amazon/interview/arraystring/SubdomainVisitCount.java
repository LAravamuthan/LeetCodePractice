package asu.edu.arav.amazon.interview.arraystring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/subdomain-visit-count/
 */
public class SubdomainVisitCount {

    /**
     * @algo Array - ArrayString
     * @time-complexity - O(n*no.ofDomain)
     * @space-complexity - O(n*no.ofDomain)
     */

    public List<String> subdomainVisits(String[] cpdomains) {

        List<String> res = new ArrayList<String>();
        if (cpdomains == null || cpdomains.length == 0) {
            return res;
        }

        Map<String, Integer> domainCount = new HashMap<String, Integer>();

        for (String domain : cpdomains) {

            String[] countDomain = domain.split(" ");
            String[] domainParts = countDomain[1].split("\\.");

            int count = Integer.parseInt(countDomain[0]);

            StringBuilder domainsBuilder = new StringBuilder();
            for (int i = domainParts.length - 1; i >= 0; i--) {
                if (i < domainParts.length - 1) {
                    domainsBuilder.insert(0,".");
                }
                domainsBuilder.insert(0, domainParts[i]);
                domainCount.put(domainsBuilder.toString(),
                        domainCount.getOrDefault(domainsBuilder.toString(), 0) + count);
            }
        }
        for (String domain : domainCount.keySet()) {
            res.add(domainCount.get(domain) + " " +  domain);
        }
        return res;
    }

    public static void main(String[] args) {
        SubdomainVisitCount sDVC = new SubdomainVisitCount();
        sDVC.subdomainVisits(new String[]{"9001 discuss.leetcode.com"});
    }
}
