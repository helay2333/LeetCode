package _DS.Queue;

/**
 * @author Green写代码
 * @date 2022-04-16 23:37
 */
public class CirleDeque <E>{
    private int size;
    private E[] elements;
    private int front = 0;//队头下标
    public CirleDeque(){
        elements = (E[]) new Object[10];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void ensureCapacity(int capacity){
        if(elements.length >= capacity){
            return;
        }else{
            int newCapcity = elements.length + elements.length >>1;
            E[] newElement = (E[]) new Object[newCapcity];
            for(int i = 0; i < size; i++){
                newElement[i] = elements[(i+front)%elements.length];
            }
            elements = newElement;
        }
        front = 0;
    }
    //队尾添加
    public void enQueueRear(E element){
        ensureCapacity(size+1);
        elements[(front+size)%elements.length] = element;
        size++;
    }
    //出队头部
    public E deQueueFront(){
        E frontEle = elements[front];
        elements[front] = null;
        front = (front+1)%elements.length;//保证指向队头
        size--;
        return frontEle;
    }
    public void enQueueFront(E element){
        ensureCapacity(size+1);
        front = index(-1);
        elements[front] = element;
        size++;
    }
    private int index(int index){
        index += front;
        if(index < 0){
            return index + elements.length;
        }
        return index % elements.length;
    }
    public E deQueueRear(){
        int rearIndex = index(size - 1);
        E rear = elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return rear;
    }
    public E front(){
        return elements[front];
    }
    public E rear(){
        return elements[(front+size-1)%elements.length];
    }
}
