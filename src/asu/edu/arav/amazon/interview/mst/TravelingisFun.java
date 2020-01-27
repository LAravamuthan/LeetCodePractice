package asu.edu.arav.amazon.interview.mst;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://www.hackerrank.com/contests/hack-it-to-win-it-paypal/challenges/q4-traveling-is-fun/problem
 */
public class TravelingisFun {

    int[] parent = null;

    public void union(int city1, int city2) {
        int parentCity1 = find(city1);
        int parentCity2 = find(city2);
        if (parentCity1 != parentCity2) {
            if (parentCity1 < parentCity2) {
                parent[city2] = parentCity1;
            } else {
                parent[city1] = parentCity2;
            }
        }
    }

    public int find(int city) {
        if (parent[city] == city) {
            return city;
        }
        parent[city] = find(parent[city]); // path compression
        return parent[city];
    }

    public boolean findGcd(int num1, int num2, int g) {
        if (num1 < g) {
            return false;
        }
        if (num2 == 0) {
            return num1 > g;
        }
        return findGcd(num2, num1 % num2, g);
    }

    int[] connectedCities(int n, int g, int[] originCities, int[] destinationCities) {
        // Complete this function
        if (n < 1 || originCities == null || destinationCities == null ||
                originCities.length == 0 || destinationCities.length == 0) {
            return new int[0];
        }
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int maxCity = Integer.MIN_VALUE;
        for(int i = 0; i < originCities.length; i++){
            maxCity = Math.max(maxCity, originCities[i]);
            maxCity = Math.max(maxCity, destinationCities[i]);
        }

        for (int i = g+1; i < maxCity; i++) {
            for (int j = i + g; j <= maxCity; j++) {
                if(parent[i] != parent[j]){
                    if (findGcd(i, j, g)) {
                        union(i, j);
                    }
                }
            }
        }

        int[] res = new int[originCities.length];
        for (int i = 0; i < originCities.length; i++) {
            res[i] = find(originCities[i]) == find(destinationCities[i]) ? 1 : 0;
        }

        return res;
    }

    int[] connectedCities2(int n, int g, int[] originCities, int[] destinationCities) {
        // Complete this function
        if (n < 1 || originCities == null || destinationCities == null ||
                originCities.length == 0 || destinationCities.length == 0) {
            return new int[0];
        }
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }


        for(int i = g + 1; i * 2 <= n; i++){
            int tmp = i;
            while(tmp <= n){
                if (parent[tmp] < parent[i]){
                    parent[i] = parent[tmp];
                }else{
                    parent[tmp] = parent[i];
                }
                tmp += i;
            }
        }

        int[] res = new int[originCities.length];
        for (int i = 0; i < originCities.length; i++) {
            res[i] = find(originCities[i]) == find(destinationCities[i]) ? 1 : 0;
        }

        return res;
    }
}
