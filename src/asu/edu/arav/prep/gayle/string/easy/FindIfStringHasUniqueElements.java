package asu.edu.arav.prep.gayle.string.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class FindIfStringHasUniqueElements {

    public static boolean isCharactersUnique(String str){
        Set<Character> charStore = new HashSet<Character>();
        for(int i = 0; i < str.length(); i++){
            if(charStore.contains(str.charAt(i))){
                return false;
            }
            charStore.add(str.charAt(i));
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isCharactersUnique("Aravammuuthan Lakshminaranyana"));
        System.out.println(isCharactersUnique("Hari"));
        System.out.println(isCharactersUnique("Bhavana"));
        System.out.println(isCharactersUnique("Priya"));
        System.out.println(isCharactersUnique("Tiwary"));
        System.out.println(isCharactersUnique("Naman"));
    }
}
