package asu.edu.arav.amazon.interview.unioufind;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/accounts-merge/
 */
public class AccountsMerge {

    /**
     * @alg DFS - Union Find
     * @time-complexity - to be done online
     * @space-complexity - recursion stack space
     */
    int[] parent = null;

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    public List<List<String>> accountsMerge1(List<List<String>> accounts) {
        parent = new int[10001];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToId = new HashMap<>();
        int id = 0;
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name.isEmpty()) {
                    name = email;
                    continue;
                }
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                }
                union(emailToId.get(email), emailToId.get(account.get(1)));
                emailToName.put(email, name);
            }
        }
        // parent Id - compents for it
        Map<Integer, List<String>> parComp = new HashMap<>();
        for (String email : emailToId.keySet()) { // can iterate on emailToName keys too
            int index = find(emailToId.get(email));
            List<String> components = parComp.getOrDefault(index, new ArrayList<>());
            components.add(email);
            parComp.put(index, components);
        }
        List<List<String>> res = new ArrayList<>();
        for (int parIdx : parComp.keySet()) {
            List<String> components = parComp.get(parIdx);
            Collections.sort(components);
            components.add(0, emailToName.get(components.get(0)));
            res.add(components);
        }
        return res;
    }
}
