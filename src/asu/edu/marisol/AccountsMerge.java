package asu.edu.marisol;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class AccountsMerge {


    /**
     * This is a real ringer, since it has to be approached in Graph way, lets see how it goes now.
     * Graph DFS approach this time around, lets go with it.
     *
     * @time-complexity - O (NK Log NK).
     * @space-complexity - O (NK).
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        this.visited = new ArrayList<>();
        this.adjEdges = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            String masterEmail = accounts.get(i).get(1);
            for (int j = 2; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                adjEdges.computeIfAbsent(masterEmail, k-> new ArrayList<>()).add(email);
                adjEdges.computeIfAbsent(email, k-> new ArrayList<>()).add(masterEmail);
            }
        }

        List<List<String>> mergedAccounts = new ArrayList<>();

        for (int i = 0; i < accounts.size(); i++) {
            String accountName = accounts.get(i).get(0);
            String email = accounts.get(i).get(1);
            if (!visited.contains(email)) {
                List<String> mergedAccount = new ArrayList<>();
                mergedAccount.add(accountName);
                dfs(mergedAccount, email);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }

        return mergedAccounts;
    }

    private List<String> visited;
    private Map<String, List<String>> adjEdges;

    private void dfs(List<String> mergedAccounts, String email) {
        if (this.visited.contains(email)) return;

        mergedAccounts.add(email);
        visited.add(email);
        for (String neighborEmail : adjEdges.getOrDefault(email, new ArrayList<>())) {
            dfs(mergedAccounts, neighborEmail);
        }
    }

    class DSU {
        int [] reps;
        int [] sizes;

        public DSU(int size) {
            this.reps = new int[size];
            this.sizes = new int[size];

            for (int i = 0; i < size; i++) {
                this.reps[i] = i;
                this.sizes[i] = 1;
            }
        }

        public int findRep(int x) {
            if (x == reps[x]) return x;

            // path compression awesome.
            return reps[x] = findRep(reps[x]);
        }

        public void unionBySize(int x, int y) {
            int repX = findRep(x);
            int repY = findRep(y);

            if (repX != repY) {
                if (sizes[repX] >= sizes[repY]) {
                    sizes[repX] += sizes[repY];
                    reps[repY] = repX;
                } else {
                    sizes[repY] += sizes[repX];
                    reps[repX] = repY;
                }
            }
        }
    }

    /**
     * Union-find approach, difficult to implement given it is something I am doing after long time.
     *
     * @time-complexity - O (NK Log NK).
     * @space-complexity - O (NK).
     */
    public List<List<String>> accountsMerge2(List<List<String>> accounts) {
        int accountsSize = accounts.size();
        DSU dsu = new DSU(accountsSize);

        Map<String, Integer> emailGroupMap = new HashMap<>();

        // email and its initial group, if there is cross group then we do unionBySize
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if (!emailGroupMap.containsKey(email)) emailGroupMap.put(email, i);
                else dsu.unionBySize(i, emailGroupMap.get(email));
            }
        }

        // Making group wise components, note do not make components with accountName, given different accounts can have
        // same name.
        Map<Integer, List<String>> groupToEmailMap = new HashMap<>();
        for (String email : emailGroupMap.keySet()) {
            int group = emailGroupMap.get(email);
            int rootGroup = dsu.findRep(group);
            groupToEmailMap.computeIfAbsent(rootGroup, k-> new ArrayList<>()).add(email);
        }

        // Making the final answer now
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int group : groupToEmailMap.keySet()) {
            List<String> mergedAccount = groupToEmailMap.get(group);
            Collections.sort(mergedAccount);
            mergedAccount.add(0, accounts.get(group).get(0));
            mergedAccounts.add(mergedAccount);
        }

        return mergedAccounts;
    }

}
