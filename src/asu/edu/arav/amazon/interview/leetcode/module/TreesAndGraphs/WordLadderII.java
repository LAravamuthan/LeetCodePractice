package asu.edu.arav.amazon.interview.leetcode.module.TreesAndGraphs;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/word-ladder-ii/
 */
public class WordLadderII {
    static String endWord1;
    static List<List<String>> ansList = new ArrayList<>();
    static int minStep = Integer.MAX_VALUE;
    static Set<String> wordSet = new HashSet<String>();
    static Set<String> seenWords = new HashSet<String>();
    static Map<String, List<String>> parentChildsMap = new HashMap<>(); // TO be filled when we do BFS with Parent being the key & list of childs being the value

    // the approach tried so far appararently doesnt work // good luck with convincing the Interviewer

    public static Set<String> getNextPossibleChilds(String node) {
        Set<String> nextPossibleChilds = new HashSet<>();
        for (int k = 0; k < node.length(); k++) {
            char[] charNode = node.toCharArray();
            // changing each character of the word at a time to form new words
            for (int j = 'a'; j < 'a' + 26; j++) {
                if (node.charAt(k) == (char) j) { // making the sure the new child word is not same as the
                    // current node word
                    continue;
                } else {
                    charNode[k] = (char) j;
                    String child = new String(charNode);
                    // the word we want to be the child of the current node  is the one which is not
                    // already seen and should be present in the overall dictionary
                    if (!nextPossibleChilds.contains(child) && wordSet.contains(child)) {
                        nextPossibleChilds.add(child);
                        //seenWords.add(child);
                    }
                }
            }
        }
        return nextPossibleChilds;
    }


    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        for (String word : wordList) {
            wordSet.add(word);
        }
        endWord1 = endWord;
        // below conditions are obvious
        if (beginWord.length() != endWord.length() || !wordSet.contains(endWord)) {
            return ansList;
        }

        Deque<String> queue = new ArrayDeque<>();

        queue.add(beginWord);

        // consider the root element that is the beginNode to be counted as 1
        int distanceTravelled = 1;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            // this for loop is very important as this makes sure that we process all the childs
            // at the same time if  they are at same level
            for (int i = 0; i < queueSize; i++) {
                String node = queue.poll();
                if (node.equals(endWord)) { // current node is the target word return the steps travelled so far
                    minStep = distanceTravelled;
                    break;
                }
                for (String child : getNextPossibleChilds(node)) {
                    if (!seenWords.contains(child)) {
                        queue.add(child);
                        seenWords.add(child);
                    }
                    List<String> childs = parentChildsMap.getOrDefault(node, new ArrayList<String>());
                    childs.add(child);
                    parentChildsMap.put(node, childs);
                }
            }
            distanceTravelled++;
        }
        seenWords.clear();
        if (minStep == Integer.MAX_VALUE) {
            return ansList;
        }

        // beginWord == endWord , beginWord as a list is the anslist
        if (beginWord == endWord) {
            List<String> l = new ArrayList<String>();
            l.add(beginWord);
            ansList.add(l);
            return ansList;
        }

        List<String> l = new ArrayList<>();
        doDfsSearch(1, beginWord, l);
        return ansList;
    }

    public static void doDfsSearch(int stepsSofar, String currentWord, List<String> ancestorWords) {
        if (stepsSofar > minStep) {
            return;
        }
        ancestorWords.add(currentWord);
        if (currentWord.equals(endWord1)) {
            if (stepsSofar < minStep) {
                minStep = stepsSofar;
                ansList.clear();
                ansList.add(ancestorWords);
                return;
            }
            ansList.add(ancestorWords);
            return;
        }
        seenWords.add(currentWord);
        for (String child : parentChildsMap.getOrDefault(currentWord, new ArrayList<>())) {
            if (!seenWords.contains(child))
                doDfsSearch(stepsSofar + 1, child, new ArrayList<>(ancestorWords));
        }
        // once all of its cildren are seen it can be part of some other path
        seenWords.remove(currentWord);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        /*list.add("ted");
        list.add("tex");
        list.add("red");
        list.add("tax");
        list.add("tad");
        list.add("den");
        list.add("rex");
        list.add("pee");*/

        list.add("hot");
        list.add("dog");

        System.out.println(findLadders2("hot", "dog", list));
    }

    // let us try bi directional BFS and DFS approach and find the best solution we can conjure
    // they all found a solution by stroing the children in hashMap will try that in my
    // previously submitted solution --- even this did not work but do not get disheartened Mr. Arav
    // we have one more solution for this

    public static boolean isPossible = false;

    public static List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result =  new ArrayList<>();
        // all these are failure checks
        if(beginWord == null || endWord == null || beginWord.length() != endWord.length() ||  wordList == null || beginWord.equals(endWord)){
            return result;
        }
        Set<String> wordDict = new HashSet<>();
        // make word Dict for fast retirval
        for(String word: wordList){
            wordDict.add(word);
        }
        if(!wordDict.contains(endWord)){
            return result;
        }
        Map<String, List<String>> parentChlidsMap = new HashMap<String, List<String>>();
        Set<String> forward = new HashSet<>();Set<String> backward = new HashSet<>();
        forward.add(beginWord);backward.add(endWord);
        // DO Bi BFS for reduced sample space creation
        biBFS(forward, backward, wordDict, true, parentChlidsMap);
        if(!isPossible){
            return result;
        }
        List<String> path = new ArrayList<String>();
        // starting from beginWord path starts from beginWord, and we add node before doing dfs on it
        path.add(beginWord);
        dFS(result, path, beginWord, endWord, parentChlidsMap);
        return result;
    }


    public static List<String> getNextChilds(String node, Set<String> wordDict, Set<String> backward) {
        List<String> nextPossibleChilds = new ArrayList<>();
        for (int k = 0; k < node.length(); k++) {
            char[] charNode = node.toCharArray();
            // changing each character of the word at a time to form new words
            for (int j = 'a'; j < 'a' + 26; j++) {
                if (node.charAt(k) == (char) j) { // making the sure the new child word is not same as the
                    // current node word
                    continue;
                } else {
                    charNode[k] = (char) j;
                    String child = new String(charNode);
                    // the word we want to be the child of the current node  is the one which is not
                    // already seen and should be present in the overall dictionary
                    if (wordDict.contains(child) || backward.contains(child)) {
                        nextPossibleChilds.add(child);
                    }
                }
            }
        }
        return nextPossibleChilds;
    }

    // steps to do in this are as follows
    // compare sizes of forward and backward sets
    // if forward is not small reverse f and b call the same method use
    // is Forward pointer take care of the forward direction -- remove forward and backward sets from wordDict
    // why to remove them ? they not the node we need to find newly now


    public static void biBFS(Set<String> forward, Set<String> backword, Set<String> wordDict, boolean isForward, Map<String, List<String>> parentChildsMap) {

        if (forward.size() > backword.size()) {
            biBFS(backword, forward, wordDict, !isForward, parentChildsMap);
        }
        wordDict.removeAll(forward);
        wordDict.removeAll(backword);
        Set<String> nextForward = new HashSet<String>();
        // iterate over the forward Set, for each string find childs possible
        // if the child is in backward connection has been established
        // if the child is in the word dict but not in backward then
        // it is candidate for next forward Set
        for (String frontierStr : forward) {
            for (String child : getNextChilds(frontierStr, wordDict, backword)) {

                String key = isForward ? frontierStr : child;
                String val = isForward ? child : frontierStr;

                if (backword.contains(child)) {
                    isPossible = true; // the important point here is even though we reached end here we need elements at
                    // forward as all of them would be candidate for shortest path once this loop ends we can break
                    List<String> childs = parentChildsMap.getOrDefault(key, new ArrayList<>());
                    childs.add(val);
                    parentChildsMap.put(key, childs);
                }

                if (wordDict.contains(child)) {
                    nextForward.add(child);
                    List<String> childs = parentChildsMap.getOrDefault(key, new ArrayList<>());
                    childs.add(val);
                    parentChildsMap.put(key, childs);
                }
            }
        }
        // if the possiblilty of the reaching the target is not yet found
        // do BFS more cool right
        if (!isPossible){
            biBFS(nextForward, backword, wordDict, isForward, parentChildsMap);
        }
    }

    // check whether word is the target if yes add that to the result and return
    // if not iterate the all the childs obtained by reduced search area obtained
    // in BFS done before for each child add the path and remove after its all child traversal
    // no need to hold the step count as due the reduced sample space obtained by doing BFS which
    // always takes the word from forward direction to end points
    public static void dFS(List<List<String>> result, List<String> path, String currentWord, String targetWord,  Map<String, List<String>> parentChildsMap){
        if(currentWord.equals(targetWord)){
            result.add(new ArrayList<String>(path));
            return;
        }
        for(String child : parentChildsMap.getOrDefault(currentWord, new ArrayList<>())){
            path.add(child);
            dFS(result, path, child, targetWord, parentChildsMap);
            path.remove(path.size() - 1);
        }
    }
    public static List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result =  new ArrayList<>();
        // all these are failure checks
        if(beginWord == null || endWord == null || beginWord.length() != endWord.length() ||  wordList == null || beginWord.equals(endWord)){
            return result;
        }
        Set<String> wordDict = new HashSet<>();
        // make word Dict for fast retirval
        for(String word: wordList){
            wordDict.add(word);
        }
        if(!wordDict.contains(endWord)){
            return result;
        }
        Map<String, List<String>> parentChlidsMap = new HashMap<String, List<String>>();
        Set<String> forward = new HashSet<>();Set<String> backward = new HashSet<>();
        // DO Bi BFS for reduced sample space creation
        bFS(beginWord, endWord, wordDict, parentChlidsMap);
        if(!isPossible){
            return result;
        }
        List<String> path = new ArrayList<String>();
        // starting from beginWord path starts from beginWord, and we add node before doing dfs on it
        path.add(beginWord);
        dFS(result, path, beginWord, endWord, parentChlidsMap);
        return result;
    }
    public static void bFS(String beginWord, String endWord, Set<String> wordDict, Map<String, List<String>> parentChlidsMap){

        Set<String> levelElements = new HashSet<>();
        levelElements.add(beginWord);
        while(!levelElements.isEmpty() && !isPossible){
            wordDict.removeAll(levelElements);
            Set<String> nextLevelElements = new HashSet<>();
            for(String word : levelElements){
                for(String child : getNextChilds(word, wordDict)){
                    nextLevelElements.add(child);
                    List<String> childs = parentChlidsMap.getOrDefault(word, new ArrayList<>());
                    childs.add(child);
                    parentChlidsMap.put(word, childs);
                    if(child.equals(endWord)){
                        isPossible = true;
                    }
                }
            }
            levelElements = nextLevelElements;
        }
    }

    public static List<String> getNextChilds(String node, Set<String> wordDict) {
        List<String> nextPossibleChilds = new ArrayList<>();
        for (int k = 0; k < node.length(); k++) {
            char[] charNode = node.toCharArray();
            // changing each character of the word at a time to form new words
            for (int j = 'a'; j < 'a' + 26; j++) {
                if (node.charAt(k) == (char) j) { // making the sure the new child word is not same as the
                    // current node word
                    continue;
                } else {
                    charNode[k] = (char) j;
                    String child = new String(charNode);
                    // the word we want to be the child of the current node  is the one which is not
                    // already seen and should be present in the overall dictionary
                    if (wordDict.contains(child)) {
                        nextPossibleChilds.add(child);
                    }
                }
            }
        }
        return nextPossibleChilds;
    }

}
