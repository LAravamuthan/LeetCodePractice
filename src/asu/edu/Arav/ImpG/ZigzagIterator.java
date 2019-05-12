package asu.edu.Arav.ImpG;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class ZigzagIterator {

    public Queue<Integer> finalIntegerList = new LinkedList<Integer>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {


        boolean first = true;
        Iterator<Integer> list1Iterator = v1.iterator();
        Iterator<Integer> list2Iterator = v2.iterator();

        while(list1Iterator.hasNext() && list2Iterator.hasNext()){
            if(first){
                finalIntegerList.add(list1Iterator.next());
                first = false;
            }else{
                finalIntegerList.add(list2Iterator.next());
                first = true;
            }
        }
        while(list1Iterator.hasNext()){
            finalIntegerList.add(list1Iterator.next());
        }
        while(list2Iterator.hasNext()){
            finalIntegerList.add(list2Iterator.next());
        }
    }

    public int next() {
        return finalIntegerList.remove();
    }

    public boolean hasNext() {
        return finalIntegerList.size() > 0;
    }
}
