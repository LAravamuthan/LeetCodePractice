package asu.edu.AravL.easy;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class Squart {
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int start = 1;
        int last = x;
        int ans = 0;
        while (start <= last) {
            int mid = (start + last) / 2;
            if (mid == x/mid) {
                return mid;
            } else if (mid < x/mid) {
                ans = mid;
                start = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return ans;
    }
    public static int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        if(x < 4){
            return 1;
        }
        int start = 2;
        int ans = 2;
        while (start * start < x) {
            if (start * start == x) {
                return start;
            } else if (start * start < x) {
                ans = start;
            }
            start++;
        }
        return ans;
    }

    public static int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        if(x < 4){
            return 1;
        }
        int start = 2;
        int ans = 2;
        while (start < x) {
            if (start * start == x) {
                return start;
            } else if (start * start < x) {
                ans = start;
                start *= start;
            }
        }
        return ans;
    }

    public static int mySqrt3(int x) {
        if(x == 0){
            return 0;
        }
        long i = x;
        while(i > x/i){
            i = (i + (x/i))/2;
        }
        return (int)i;
    }

    public static void main(String[] args){
        System.out.println(mySqrt3(2147483647));
    }
}
