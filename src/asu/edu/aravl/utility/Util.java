package asu.edu.aravl.utility;

public class Util {
    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }


    public static boolean isNumericWithSpaces(String strNumWithSpaces) {
        String[] strNum = strNumWithSpaces.split(" ");
        for(int i = 0; i < strNum.length; i++){
            if(!isNumeric(strNum[i])){
                return false;
            }
        }
        return true;
    }
}
