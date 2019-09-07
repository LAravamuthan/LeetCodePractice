package asu.edu.arav.impgoogle;

import asu.edu.aravl.utility.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class NestedIterator implements Iterator<Integer> {

    public Queue<Integer> integerList = new LinkedList<Integer>();

    public void filltheQueueWithNestedIntegers(List<NestedInteger> nestedList) {
        for (NestedInteger nI : nestedList) {
            if (nI.isInteger()) {
                integerList.add(nI.getInteger());
            } else {
                filltheQueueWithNestedIntegers(nI.getList());
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        filltheQueueWithNestedIntegers(nestedList);
    }

    @Override
    public Integer next() {
        return integerList.remove();
    }

    @Override
    public boolean hasNext() {
        return integerList.size()>0;
    }
}
