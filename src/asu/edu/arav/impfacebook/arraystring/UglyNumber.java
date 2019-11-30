package asu.edu.arav.impfacebook.arraystring;

public class UglyNumber {
    public boolean isUgly(int num) {
        int[] primeFactors = new int[]{2, 3, 5};

        while(num >1){
            boolean isPrimfactor = false;
            for(int i =0; i < primeFactors.length; i++){
                if(num % primeFactors[i]== 0){
                    num /= primeFactors[i];
                    isPrimfactor = true;
                    break;
                }
            }
            if(!isPrimfactor){
                break;
            }else if(num == 1){
                return true;
            }
        }
        return false;
    }
}
