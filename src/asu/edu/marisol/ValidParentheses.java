package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ValidParentheses {

    /**
     * This approach is the simplest I know.
     * @time-complexity - O (n)
     * @space-complexity - O (n)
     */
    public boolean isValid(String s) {
        Map<Character, Character> mappings = new HashMap<>();
        mappings.put('}', '{');
        mappings.put(']', '[');
        mappings.put(')', '(');
        Stack<Character> characterStack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (mappings.containsKey(ch)) {
                char top = characterStack.empty() ? '!' : characterStack.pop();
                if (mappings.get(ch) != top) return false;
            } else {
                characterStack.add(ch);
            }
        }

        return characterStack.isEmpty();
    }

    /**
     * Improved version of using Dequeue, and no mapping involved.
     * @time-complexity - O (n)
     * @space-complexity - O (n)
     */
    public boolean isValid2(String s) {
        Deque<Character> characterStack = new ArrayDeque();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '}':
                    if (characterStack.isEmpty() || characterStack.pop() != '{') return false;
                    break;
                case ']':
                    if (characterStack.isEmpty() || characterStack.pop() != '[') return false;
                    break;
                case ')':
                    if (characterStack.isEmpty() || characterStack.pop() != '(') return false;
                    break;
                default:
                    characterStack.push(ch);
            }
        }
        return characterStack.isEmpty();
    }
}
