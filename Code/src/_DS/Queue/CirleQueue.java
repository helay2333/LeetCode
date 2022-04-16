package _DS.Queue;

/**
 * @author Green写代码
 * @date 2022-04-16 23:05
 */
public class CirleQueue <E>{
    private int size;
    private E[] elements;
    private int front = 0;//队头下标
    public CirleQueue(){
        elements = (E[]) new Object[10];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void enQueue(E element){
        elements[(front+size)%elements.length] = element;
    }
    public E deQueue(){
        E frontEle = elements[front];
        elements[front] = null;
        front = (front+1)%elements.length;//保证指向队头
        size--;
        return frontEle;
    }
    public E front(){
        return elements[front];
    }
}
