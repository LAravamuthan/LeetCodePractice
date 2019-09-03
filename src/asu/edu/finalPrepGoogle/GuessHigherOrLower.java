package asu.edu.finalPrepGoogle;

public class GuessHigherOrLower {
    public int guess(int t){
        return 0;
    }
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        while (lo < hi){
            int mid = (lo+hi)/2;
            if(guess(mid) == 0){
                return mid;
            }else if(guess(mid) == 1){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return -1;
    }
    public int guessNumber2(int n) {
        int lo = 1;
        int hi = n;
        while (lo <= hi){
            int mid1 = lo + (hi-lo)/3;
            int mid2 = hi - (hi-lo)/3;
            if(guess(mid1) == 0){
                return mid1;
            }
            else if(guess(mid2) == 0){
                return mid2;
            } else if(guess(mid1) == -1){
                hi = mid1 - 1;
            }else if (guess(mid2) == 1){
                lo = mid2 + 1;
            }else{
                lo = mid1 + 1;
                hi = mid2 - 1;
            }
        }
        return -1;
    }
}
