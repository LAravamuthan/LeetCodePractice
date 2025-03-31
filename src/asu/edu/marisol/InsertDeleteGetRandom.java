package asu.edu.marisol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {

    private List<Integer> list;
    private Map<Integer, Integer> dict;
    private Random random;

    /**
     * Array and Hashmap implementation.
     *
     * @time-complexity - O(1)
     * @space-complexity - O(N) - size of the list.
     */
    public InsertDeleteGetRandom() {
        this.dict = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (this.dict.containsKey(val)) return false;

        this.dict.put(val, this.list.size());
        this.list.add(this.list.size(), val);
        return true;
    }

    public boolean remove(int val) {
        if (!this.dict.containsKey(val)) return false;

        int lastElement = this.list.get(this.list.size() - 1);
        int idx = this.dict.get(val);
        this.dict.put(lastElement, idx);
        this.list.set(idx, lastElement);
        this.dict.remove(val);
        this.list.remove(this.list.size() - 1);
        return true;
    }

    public int getRandom() {
        return this.list.get(this.random.nextInt(this.list.size()));
    }
}
