package _DS.Queue;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Green写代码
 * @date 2022-04-16 22:46
 */
public class Deque<E> {
    private List<E> list = new LinkedList<>();
    public int size(){
        return 0;
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    //队尾添加
    public void enQueueRear(E element){
        list.add(element);
    }
    //出队头部
    public E deQueueFront(){
        return list.remove(0);
    }
    public void enQueueFront(E element){
        list.add(0,element);
    }
    public E deQueueRear(){
        return list.remove(list.size() - 1);
    }
    public E front(){
        return list.get(0);
    }
    public E rear(){
        return list.get(list.size() - 1);
    }
}
