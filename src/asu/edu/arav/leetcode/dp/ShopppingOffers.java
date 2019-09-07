package asu.edu.arav.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class ShopppingOffers {

    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int sum = 0;

        for (int i = 0; i < needs.size(); i++) {
            sum += price.get(i) * needs.get(i);
        }

        for (List<Integer> offer : special) {
            if (isValid(offer, needs)) {
                for (int i = 0; i < needs.size(); i++) {
                    needs.set(i, needs.get(i) - offer.get(i));
                }
                int interSum = shoppingOffers(price, special, needs);
                sum = Math.min(sum, interSum + offer.get(needs.size()));
                for (int i = 0; i < needs.size(); i++) {
                    needs.set(i, needs.get(i) + offer.get(i));
                }
            }
        }

        return sum;
    }

    public static boolean isValid(List<Integer> offer, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (offer.get(i) > needs.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> f = new ArrayList<Integer>();
        List<Integer> s = new ArrayList<Integer>();
        f.add(2);
        f.add(5);
        s.add(3);
        s.add(2);
        shoppingOffers(f, null, s);
    }
}
