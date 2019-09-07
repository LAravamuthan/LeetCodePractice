package asu.edu.arav.impgoogle;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class IsPowerOf2 {
    public boolean isPowerOfTwo(int n) {
        while (n >= 1) {
            if(n == 1){
                return true;
            }
            if (n % 2 != 0) {
                break;
            } else
                n = n / 2;
        }
        return false;
    }
}
