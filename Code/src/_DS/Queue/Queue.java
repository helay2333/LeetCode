package _DS.Queue;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Green写代码
 * @date 2022-04-16 21:37
 */
public class Queue<E> {
    private List<E> list = new LinkedList<>();
    public int size(){
        return list.size();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public void enQueue(E element){
        list.add(element);
    }
    public E deQueue(){

        return list.remove(0);
    }
    public E front(){
        return list.get(0);
    }
}
