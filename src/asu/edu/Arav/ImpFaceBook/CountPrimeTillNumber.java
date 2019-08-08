package asu.edu.Arav.ImpFaceBook;

public class CountPrimeTillNumber {
    public int countPrimes(int n) {
        int countOfPrimes = 0;

        boolean[] isNotPrime = new boolean[n];

        for (int i = 2; i * i < n; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                isNotPrime[j] = true;
            }
        }


        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i]) {
                countOfPrimes++;
            }
        }
        return countOfPrimes;
    }
}
