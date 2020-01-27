package asu.edu.arav.amazon.interview.arraystring;

import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project Naveego
 */
public class Naveego {

    public final static String[] DIRECTIONS = {"NORTH", "SOUTH", "EAST", "WEST"};

    public static String[] dirReduc(String[] arr) {
        if (arr == null || arr.length == 0) {
            return new String[]{};
        }
        Stack<String> st = new Stack<String>();
        for (int i = 0; i < arr.length; i++) {
            if(!st.isEmpty() && isDirectionsComplementary(arr[i], st.peek())){
                st.pop();
            }else{
                st.push(arr[i]);
            }
        }
        return st.stream().toArray(String[]::new);
    }


    public static boolean isDirectionsComplementary(String dir1, String dir2) {
        /* if the dir 1 and dir 2 are complementary return true*/
        if (dir1.equals(DIRECTIONS[0])) {
            return dir2.equals(DIRECTIONS[0]);
        } else if (dir1.equals(DIRECTIONS[1])) {
            return dir2.equals(DIRECTIONS[0]);
        } else if (dir1.equals(DIRECTIONS[2])) {
            return dir2.equals(DIRECTIONS[3]);
        } else {
            return dir2.equals(DIRECTIONS[2]);
        }
    }

    public static void main(String [] args){
        dirReduc(new String[]{"EAST", "NORTH", "WEST", "SOUTH"});
    }
}
