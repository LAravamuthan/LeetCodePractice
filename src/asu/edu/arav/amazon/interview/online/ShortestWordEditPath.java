package asu.edu.arav.amazon.interview.online;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class ShortestWordEditPath {

    static boolean[] seenWord;
    static int shortestPath = Integer.MAX_VALUE;

    static int shortestWordEditPath(String source, String target, String[] words) {
        seenWord = new boolean[words.length];
        return shortestWordEditPath(source, target, words, 0);
    }

    static int shortestWordEditPath(String source, String target, String[] words, int depth) {
        if(depth > words.length){
            return -1;
        }
        if (source.equals(target)) {
            return depth;
        }
        int result = -1;
        boolean found = false;
        for (int i = 0; i < words.length; i++) {
            if (seenWord[i] == true) {
                continue;
            }
            if (isOnlyOneCharacterAway(source.toCharArray(), words[i].toCharArray())) {
                seenWord[i] = true;
                result = shortestWordEditPath(words[i], target, words, depth + 1);
                if(result != -1){
                    shortestPath = Math.min(result, shortestPath);
                    found = true;
                }
                seenWord[i] = false;
            }
        }
        return found?shortestPath:-1;
    }

    static boolean isOnlyOneCharacterAway(char[] charA1, char[] charA2) {
        int unMatchedCount = 0;
        if (Math.abs(charA1.length - charA2.length) > 0) {
            return false;
        }
        int i = 0, j = 0;
        while (i != charA1.length && j != charA2.length) {
            if (charA1[i] != charA2[j]) {
                unMatchedCount++;
            }
            i++;
            j++;
            if (unMatchedCount > 1) {
                break;
            }
        }
        return unMatchedCount > 1 ? false : true;
    }

    public static void main(String[] args) {
        shortestWordEditPath("bit", "dog", new String[] {"but", "put", "big", "pot", "pog", "dog", "lot"} );
    }
}
