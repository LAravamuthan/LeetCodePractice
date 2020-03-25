package asu.edu.arav.amazon.interview.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {

    /* lets try a approach and see */

    // the algorithm would be like this
    // remove or add each bracket and try to proceed forward
    // if number of removal if less than global minimum when we reach the end note that down
    // as a possible answer

    Set<String> ansSet = new HashSet<String>();
    int minRemoval = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        dfsBackTracking1(s, 0, 0, 0, new StringBuilder());
        return new ArrayList<>(ansSet);
    }

    // when will the expression be valid when the values of left bracket and right brackets are same
    // is this a sufficient condition - no (what about inversions)
    // so we have take care of it in a special way
    // dont have right bracket option it self
    // increment or decrement left bracket only

    public void dfsBackTracking(String s, int leftBrackets, int currentIdx, int removedCount, StringBuilder expressionSoFar) {
        if (currentIdx == s.length()) {
            if(leftBrackets == 0 && minRemoval >= removedCount){
                if (minRemoval > removedCount) {
                    minRemoval = removedCount;
                    ansSet.clear();
                }
                ansSet.add(expressionSoFar.toString());
            }
            return;
        }
        if(removedCount > minRemoval){
            return;
        }
        if (s.charAt(currentIdx) != '(' && s.charAt(currentIdx) != ')') {
            // if the current character is not a bracket just include character and go ahead
            // why a new String builder every time, tht is to make make one branch does not effect the other
            StringBuilder expressionWithInclusion = new StringBuilder(expressionSoFar);
            expressionWithInclusion.append(s.charAt(currentIdx));
            dfsBackTracking(s, leftBrackets, currentIdx + 1, removedCount, expressionWithInclusion);
        }

        // lets include the current bracket
        else if (s.charAt(currentIdx) == '(') {

            StringBuilder expressionWithInclusion = new StringBuilder(expressionSoFar);
            expressionWithInclusion.append(s.charAt(currentIdx));
            dfsBackTracking(s, leftBrackets + 1, currentIdx + 1, removedCount, expressionWithInclusion);
            // exclusion of current idx
            dfsBackTracking(s, leftBrackets, currentIdx + 1, removedCount + 1, new StringBuilder(expressionSoFar));

        } else if (s.charAt(currentIdx) == ')') {
            // include the currentCharacter, it is not the same for left bracket, it has to have open left bracket to
            // be considered to be included
            if (leftBrackets > 0) {
                StringBuilder expressionWithInclusion = new StringBuilder(expressionSoFar);
                expressionWithInclusion.append(s.charAt(currentIdx));
                dfsBackTracking(s, leftBrackets - 1, currentIdx + 1, removedCount, expressionWithInclusion);
            }
            // exclusion of current idx
            dfsBackTracking(s, leftBrackets, currentIdx + 1, removedCount + 1, new StringBuilder(expressionSoFar));
        }
    }

    public void dfsBackTracking1(String s, int leftBrackets, int currentIdx, int removedCount, StringBuilder expressionSoFar) {
        if (currentIdx == s.length()) {
            if(leftBrackets == 0 && minRemoval >= removedCount){
                if (minRemoval > removedCount) {
                    minRemoval = removedCount;
                    ansSet.clear();
                }
                ansSet.add(expressionSoFar.toString());
            }
            return;
        }
        if(removedCount > minRemoval){
            return;
        }
        if (s.charAt(currentIdx) != '(' && s.charAt(currentIdx) != ')') {
            // if the current character is not a bracket just include character and go ahead
            // why a new String builder every time, tht is to make make one branch does not effect the other
            expressionSoFar.append(s.charAt(currentIdx));
            dfsBackTracking(s, leftBrackets, currentIdx + 1, removedCount, expressionSoFar);
            expressionSoFar.deleteCharAt(expressionSoFar.length() - 1);
        }

        // lets include the current bracket
        else if (s.charAt(currentIdx) == '(') {

            expressionSoFar.append(s.charAt(currentIdx));
            dfsBackTracking(s, leftBrackets + 1, currentIdx + 1, removedCount, expressionSoFar);
            expressionSoFar.deleteCharAt(expressionSoFar.length() - 1);
            // exclusion of current idx
            dfsBackTracking(s, leftBrackets, currentIdx + 1, removedCount + 1, expressionSoFar);

        } else if (s.charAt(currentIdx) == ')') {
            // include the currentCharacter, it is not the same for left bracket, it has to have open left bracket to
            // be considered to be included
            if (leftBrackets > 0) {
                expressionSoFar.append(s.charAt(currentIdx));
                dfsBackTracking(s, leftBrackets - 1, currentIdx + 1, removedCount, expressionSoFar);
                expressionSoFar.deleteCharAt(expressionSoFar.length() - 1);
            }
            // exclusion of current idx
            dfsBackTracking(s, leftBrackets, currentIdx + 1, removedCount + 1, expressionSoFar);
        }
    }

    public static void main(String[] args){
        RemoveInvalidParentheses RIP = new RemoveInvalidParentheses();
        System.out.println(RIP.removeInvalidParentheses("()())()"));
    }

}
