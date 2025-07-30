package asu.edu.marisol;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class InsertDeleteGetRandomDuplicates {

    List<Integer> list;
    Map<Integer, Set<Integer>> idxMap;
    Random rand = new Random();

    public InsertDeleteGetRandomDuplicates() {
        list = new ArrayList<>();
        idxMap = new HashMap<>();
    }

    public boolean insert(int val) {
        if (!idxMap.containsKey(val))
            idxMap.put(val, new HashSet<>());

        idxMap.get(val).add(list.size());
        list.add(val);
        return idxMap.get(val).size() == 1;
    }

    public boolean remove(int val) {
        if (!idxMap.containsKey(val) || idxMap.get(val).isEmpty()) return false;

        int deleteIdx = idxMap.get(val).iterator().next();
        idxMap.get(val).remove(deleteIdx);
        int last = list.get(list.size() - 1);
        list.set(deleteIdx, last);
        idxMap.get(last).add(deleteIdx);
        idxMap.get(last).remove(list.size() - 1);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

}
