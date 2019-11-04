package asu.edu.arav.amazon.interview.design;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/design-search-autocomplete-system/
 */
public class DesignSearchAutocompleteSystem {

    public static void main(String[] args){

        String [] s = {"i love you","island","iroman","i love leetcode"};
        int [] counts = {5,3,2,2};
        AutocompleteSystemPrc a = new AutocompleteSystemPrc(s, counts);
        System.out.println(a.input('i'));
        System.out.println(a.input(' '));
        System.out.println(a.input('a'));
        System.out.println(a.input('#'));
    }




}
