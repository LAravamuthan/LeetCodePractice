package asu.edu.arav.ImpG;
import java.util.Iterator;
import java.util.List;


/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class ZigzagIterator1 {

    public Iterator<Integer> list1Iterator;
    public Iterator<Integer> list2Iterator;
    public boolean first = true;
    public boolean isToggleInvalid = false;


    public ZigzagIterator1(List<Integer> v1, List<Integer> v2) {
        list1Iterator = v1.iterator();
        list2Iterator = v2.iterator();
    }

    public int next() {
        if(!isToggleInvalid && first && list1Iterator.hasNext()){
            first = !first;
            return list1Iterator.next();
        }else if(!isToggleInvalid && !first && list2Iterator.hasNext()){
            first = !first;
            return list2Iterator.next();
        }else if(hasNext() && list1Iterator.hasNext()){
            return list1Iterator.next();
        }else if(hasNext() && list2Iterator.hasNext()){
            return list2Iterator.next();
        }else{
            return Integer.MIN_VALUE;
        }
    }

    public boolean hasNext() {
        return list1Iterator.hasNext() || list2Iterator.hasNext();
    }
}
