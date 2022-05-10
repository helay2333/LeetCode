package _DS.PriorityQueue;

import java.util.List;

/**
 * @author Green写代码
 * @date 2022-05-08 12:59
 */
public class PriorityQueue<E> {
    public int size;
    public int size(){
        return size;
    }
    public List<E> list;
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public void clear() {

    }
    public void enQueue(E element) {
        list.add(element);
    }

}
